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
    EEPROM_SIZE : integer := 128);      -- EEPROM size in Kbits
  
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

  type EE_STATE is (S_IDLE, S_START, COMMAND, S_DATA_READ, S_DATA_WRITE, S_STOP);                   -- Module states
  
  -- RS232 commands
  constant READ_DATA : std_logic_vector(7 downto 0) := "00000001";
  constant WRITE_DATA : std_logic_vector(7 downto 0) := "00000010";
  constant ACK_DATA : std_logic_vector(7 downto 0) := "01010101";  -- Acknowledge command (returned to computer)
  constant EOF_DATA : std_logic_vector(7 downto 0) := "00001111";  -- End Of Frame sent to the computer (after data count received)
  
  -- states
  signal current_state : EE_STATE := S_IDLE;  -- Module current state
  signal data_read_s, data_write_s : std_logic := '0';  -- Data read/write signal
  signal i2c_sda, i2c_scl : std_logic := 'Z';  -- I2C communication signals
begin  -- a_ee_commands

  SDA <= 'Z';
  SCL <= 'Z';

  data_read <= data_read_s;
  data_write <= data_write_s;
	
  State <= std_logic_vector(to_unsigned(EE_STATE'pos(current_state),4));

  -- purpose: This process handle the state machine to receive and send commands
  -- type   : combinational
  -- inputs : arazb, clk
  -- outputs: data_read, data_out, data_write
  StateMachine: process (arazb, clk)
    variable next_state : EE_STATE := S_IDLE;  -- next module state
    variable evolved : std_logic := '0';  -- The state machine evolved
  begin  -- process StateMachine
    -- Reset handler
    if (arazb = '0') then
      data_write_s <= '0';
      data_read_s <= '0';
      data_out <= (others => 'Z');
      next_state := S_IDLE;

    -- State machine evolution
    elsif (rising_edge(clk) and (data_present='1' or data_read_s='1' or data_write_s='1' or evolved='1')) then
      if (data_read_s = '1' or data_write_s='1' or evolved = '1') then
        data_read_s <= '0';
        next_state := current_state;
        
        case current_state is
          -- IDLE
          when S_IDLE =>
            if (data_in = "10101010") then
              next_state := S_START;
            end if;

          -- Start OK, reading the command
          when S_START =>
				if data_read_s='1' then
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
              next_state := S_IDLE;
            else
              data_out <= ACK_DATA;
              data_write_s <= '1';
            end if;

          when S_DATA_WRITE =>
            if (data_write_s = '1') then
              data_write_s <= '0';
              next_state := S_IDLE;
            else
              data_out <= ACK_DATA;
              data_write_s <= '1';
            end if;
            
          when others => next_state := S_IDLE;
        end case;

        -- Change the current state according to the transitions
        if current_state = next_state then
          evolved := '0';
        else
          evolved := '1';
        end if;
        current_state <= next_state;
      else
        data_read_s <= '1';
      end if;
    end if;
  end process StateMachine;
  

end a_ee_commands;
