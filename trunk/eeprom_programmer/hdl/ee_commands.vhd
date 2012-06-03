-------------------------------------------------------------------------------
-- I2C EEPROM Programmer commands interpreter
-------------------------------------------------------------------------------
-- This program is part of the SPARTCAM project and is aimed to
-- work with a Python script to write data to the configuration EEPROM
-------------------------------------------------------------------------------

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

library work;
use WORK.GENERIC_COMPONENTS.ALL ;

-- EEPROM command interpreter
entity ee_commands is
  generic (
    EEPROM_SIZE : integer := 128;       -- EEPROM size in Kbits
    MAX_BURST : integer := 8);          -- Maximum burst size (in bytes)
  
  port (
    clk          : in  std_logic;       -- System clock
    arazb        : in  std_logic;       -- Reset input

    data_in      : in  std_logic_vector(7 downto 0);  -- RS232 data in
    data_present : in  std_logic;       -- RS232 data are present
    data_read    : out std_logic;       -- Read data from then RS232 fifo
    
    data_out     : out std_logic_vector(7 downto 0);  -- Data out to the RS232
    data_write   : out std_logic;       -- Write signal to the RS232 transceiver

    SDA          : inout std_logic;     -- EEPROM SDA signal
    SCL          : inout std_logic;     -- EEPROM SCL signal
	 
    State        : out std_logic_vector(3 downto 0));

end ee_commands;

-- EEPROM programmer commands interpreter
architecture a_ee_commands of ee_commands is

  type EE_STATE is (S_IDLE, S_START, S_DATA_READ, S_DATA_WRITE, S_GET_ADDR, S_TRANSFER, S_WRITTING, S_READING, S_READ_DONE, S_STOP);                   -- Module states
  type EE_MODE is (M_IDLE, M_READ, M_WRITE);    -- Data transfer mode

  component ee_access
    generic (
      READ_ENABLED  : std_logic := '1';   -- Enable read access logic
      WRITE_ENABLED : std_logic := '1');  -- Enable write access logic

    port (
      arazb    : in    std_logic;         -- Module reset input
      clk      : in    std_logic;         -- Module clock
      mem_addr : in    std_logic_vector(15 downto 0);  -- transfer start address
      data_in  : in    std_logic_vector(7 downto 0);  -- Data feed input for write accesss
      wr       : in    std_logic;         -- Write command
      rd       : in    std_logic;         -- Read command
      burst    : in    std_logic;  -- Burst data access (hold on until the end of the burst
      data_out : out   std_logic_vector(7 downto 0);  -- Data feed out for read access
      data_valid : out std_logic;         -- Signal data_out is valid
    
      ready    : out   std_logic;  -- Signal other modules we are ready for new access
      sda      : inout std_logic;         -- I2C data signal
      scl      : inout std_logic);        -- I2C clock signal
  end component;

  
  -- I2C Constants
  constant I2C_DEV_ADDR : std_logic_vector(6 downto 0) := "1010000";  -- I2C EEPROM device address
  
  -- RS232 commands
  constant READ_DATA : std_logic_vector(7 downto 0) := "00000001";
  constant WRITE_DATA : std_logic_vector(7 downto 0) := "00000010";
  constant ACK_DATA : std_logic_vector(7 downto 0) := "01010101";  -- Acknowledge command (returned to computer)
  constant NACK_DATA : std_logic_vector(7 downto 0) := "11001100";  -- Not acknowledge, return an error
  constant EOF_DATA : std_logic_vector(7 downto 0) := "00001111";  -- End Of Frame sent to the computer (after data count received)
  
  
  -- states
  signal current_state : EE_STATE := S_IDLE;  -- Module current state
  signal data_read_s, data_write_s : std_logic := '0';  -- Data read/write signal

  signal current_mode : EE_MODE := M_IDLE;  -- Data transfer mode
  signal rw_base_address : std_logic_vector(15 downto 0);  -- Start address in EEPROM memory to start data transfer
  signal ee_write_data, ee_read_data : std_logic_vector(7 downto 0);  -- In/out data
  signal ee_burst, ee_data_valid, ee_ready : std_logic;
  signal ee_read, ee_write : std_logic := '0';
begin  -- a_ee_commands


  data_read <= data_read_s;
  data_write <= data_write_s;
	
  State <= std_logic_vector(to_unsigned(EE_STATE'pos(current_state),4));


  --ee_write <= '0';

  eeprom_access: ee_access
    port map (
      arazb      => arazb,
      clk        => clk,
      mem_addr   => rw_base_address,
      data_in    => ee_write_data,
      wr         => ee_write,
      rd         => ee_read,
      burst      => ee_burst,
      data_out   => ee_read_data,
      data_valid => ee_data_valid,
      ready      => ee_ready,
      sda        => sda,
      scl        => scl);

  
  -- purpose: This process handle the state machine to receive and send commands
  -- type   : combinational
  -- inputs : arazb, clk
  -- outputs: data_read, data_out, data_write
  StateMachine: process (arazb, clk)
    variable next_state : EE_STATE := S_IDLE;  -- next module state
    variable current_byte : integer range 0 to MAX_BURST := 0;  -- Byte counter
    variable data_valid_last : std_logic := '0';  -- Edge detection of ee_data_valid
  begin  -- process StateMachine
    -- Reset handler
    if (arazb = '0') then
      data_write_s <= '0';
      data_read_s <= '0';
      data_out <= (others => 'Z');
      next_state := S_IDLE;
      current_state <= S_IDLE;
      current_mode <= M_IDLE;
      ee_read <= '0';
      ee_write <= '0';
      ee_burst <= '0';
      
    -- State machine evolution
    elsif rising_edge(clk) then
   --   if (data_read_s = '1') then
   --     data_read_s <= '0';
      if (data_present = '1' and data_read_s='0') then
        data_read_s <= '1';
      end if;

      next_state := current_state;
       
      case current_state is
        -- IDLE
        when S_IDLE =>
          data_write_s <= '0';
          ee_read <= '0';
          ee_write <= '0';
          ee_burst <= '0';
          
          if (data_in="10101010" and data_read_s='1') then
            data_read_s <= '0';
            next_state := S_START;
          end if;

          -- Start OK, reading the command
        when S_START =>
          if data_read_s='1' then
            data_read_s <= '0'; 
            case data_in is
              when READ_DATA =>
                next_state := S_DATA_READ;
              when WRITE_DATA =>
                next_state := S_DATA_WRITE;
              when others =>
                next_state := S_IDLE;
            end case;
          end if;

        when S_DATA_READ =>
          if (data_write_s = '1') then
            data_write_s <= '0';
            current_mode <= M_READ;
            next_state := S_GET_ADDR;
            current_byte := 0;
          else
            data_out <= ACK_DATA;
            data_write_s <= '1';
          end if;

        when S_DATA_WRITE =>
          if (data_write_s = '1') then
            data_write_s <= '0';
            current_mode <= M_WRITE;
            next_state := S_GET_ADDR;
            current_byte := 0;
          else
            --data_read_s <= '0'; 
            data_out <= ACK_DATA;
            data_write_s <= '1';
          end if;



        when S_GET_ADDR =>
          if data_read_s='1' then
            data_read_s <= '0'; 
            case current_byte is
              when 0 =>
                rw_base_address(15 downto 8) <= data_in;
              when 1 =>
                rw_base_address(7 downto 0) <= data_in;
              when 2 =>
                if data_in < MAX_BURST then
                  ee_burst <= '1';
                  next_state := S_TRANSFER;  -- Start the data transfer
                  data_out <= ACK_DATA;  -- Acknowledge the command
                  data_write_s <= '1';
                  current_byte := to_integer(unsigned(data_in))-1;  -- With data_in
                  if current_mode = M_READ then
                    ee_read <= '1';
                  end if;
                else
                  next_state := S_IDLE;
                  data_out <= NACK_DATA;
                  data_write_s <= '1';
                end if;
                
              when others => null;
            end case;
            current_byte := current_byte +1 ;
          end if;
          
        when S_TRANSFER =>
          case current_mode is
            when M_READ  =>
              data_write_s<='0';
              if ee_data_valid = '1' and data_valid_last='0' then
                ee_read <= '0';
                next_state := S_READING;
                if current_byte = 1 then
                  ee_burst <= '0';
                end if;
              else
                ee_read <= '1';
              end if;
              
                      
            when M_WRITE =>
              data_write_s <= '0';
              
              if data_read_s = '1' then
                data_read_s <= '0'; 
                -- Insert data transfer here
                ee_write_data <= data_in;
                ee_write <= '1';
                current_byte := current_byte - 1;
              end if;
              
              if ee_write = '1' then
                next_state := S_WRITTING;
              end if;
              
            when others => null;
          end case;
          
        when S_WRITTING =>
          if ee_write='1' then
            ee_write <= '0';   
          end if;
          
          if ee_data_valid='1' and data_valid_last='0' then
            if current_byte > 0 then
              data_out <= ACK_DATA;
            else
              data_out <= EOF_DATA;
            end if;
            data_write_s <= '1';
          end if;

          if current_byte > 0 then
           if data_write_s='1' then
             data_write_s<='0';
             next_state := S_TRANSFER;
           end if;
          else
            if data_write_s ='1' then
              data_write_s <= '0';
              next_state := S_STOP;  
            end if;
            ee_burst <= '0';
          end if;
          
        when S_READING =>
          if data_write_s='1' then
            if (current_byte = 1) then
              data_out <= EOF_DATA;
              ee_burst <= '0';
              next_state := S_STOP;
            else
              data_write_s <= '0';
              current_byte := current_byte -1;
              next_state := S_READ_DONE;
            end if;
          else
            data_out <= ee_read_data;  -- When read data is valid, send it
            data_write_s <= '1';
          end if;
              
        when S_READ_DONE =>
          ee_read <= '1';
          if ee_data_valid = '0' then
            next_state := S_TRANSFER;
          end if;

        when S_STOP =>
          data_write_s<='0';
          ee_write <= '0';
          ee_read <= '0';
          ee_burst <= '0';
          if (ee_ready = '1') then
            next_state := S_IDLE;
          end if;
          
        when others => next_state := S_IDLE;
      end case;

        -- Change the current state according to the transitions
      current_state <= next_state;
      data_valid_last := ee_data_valid;
    end if;
  end process StateMachine;
  
--  ee_burst <= '1' when (current_state = S_TRANSFER or current_state = S_READING or current_state = S_WRITTING) else '0' ;
--  ee_read <= '1' when current_state = S_TRANSFER and current_mode=M_READ else '0';
--  ee_write <= '1' when current_state = S_TRANSFER and current_mode=M_WRITE else '0';
  

end a_ee_commands;
