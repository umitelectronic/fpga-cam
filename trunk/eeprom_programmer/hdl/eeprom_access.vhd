-------------------------------------------------------------------------------
-- I2C EEPROM Programmer EEPROM access
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

-- EEPROM I2C access handler
entity ee_access is
  
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
    ready    : out   std_logic;  -- Signal other modules we are ready for new access
    sda      : inout std_logic;         -- I2C data signal
    scl      : inout std_logic);        -- I2C clock signal

end ee_access;


architecture a_ee_access of ee_access is
  -- State machine states
  type EE_W_STATE is (W_IDLE, W_ADDRH, W_ADDRL, W_DATA, W_WAIT, W_END);                 -- States for the write state machine
  type EE_R_STATE is (R_IDLE, R_ADDRH, R_ADDRL, R_RESTART, R_DATA, R_WAIT, R_END);      -- States for the write state machine
  
  
  -- module internal signals
  signal data_buffer : std_logic_vector(7 downto 0);  -- buffer to store read data (or data to write)

  signal i2c_ack, i2c_nack, i2c_rdy : std_logic;                -- I2C module state signals
  signal i2c_din, i2c_dout : std_logic_vector(7 downto 0);      -- I2C data transfer
  signal i2c_slave_addr : std_logic_vector (6 downto 0);        -- I2C slave address
  signal i2c_send, i2c_rcv : std_logic;                         -- I2C commands

  -- State machines current states
  signal rd_current_state : EE_R_STATE := R_IDLE;  -- Read state machine current state
  signal wr_current_state : EE_W_STATE := W_IDLE;  -- Write state machine current state
  
begin  -- a_ee_access

  -- I2C master module : handle the communication with the bus
  i2c_m: i2c_master
    port map (
      arazb => arazb,
      clock => clk,
      slave_addr => i2c_slave_addr,
      data_in => i2c_din,
      data_out => i2c_dout,
      send => i2c_send,
      rcv => i2c_rcv,
      dispo => i2c_rdy,
      ack_byte => i2c_ack,
      nack_byte => i2c_nack,
      sda => sda,
      scl => scl);

  
  read_process: if READ_ENABLED generate
    -- purpose: Handle the data read state machine
    -- type   : sequential
    -- inputs : clk, arazb, rd, burst
    rd_proc: process (clk, arazb)
      variable next_state : EE_R_STATE := R_IDLE;  -- State machine next state
      variable start_addr : std_logic_vector(15 downto 0);  -- Start address for read access
    begin  -- process rd_proc
      if arazb = '0' then               -- asynchronous reset (active low)
        rd_current_state <= R_IDLE;
      elsif clk'event and clk = '1' then  -- rising clock edge
        next_state := rd_current_state;

        case rd_current_state is
          -- Idle state : the module waits for an instruction
          when R_IDLE =>
            if (rd = '1' and wr_current_state=W_IDLE) then
              next_state := R_ADDRH;
              start_addr := mem_addr;
            end if;

          -- Writting the high address
          when R_ADDRH =>
            
            
          when others => null;
        end case;
      end if;
    end process rd_proc;
  end generate read_process;


  ready <= '1' when (rd_current_state = R_IDLE  and
                     wr_current_state = W_IDLE) or
                    (rd_current_state = R_WAIT  or
                     wr_current_state = W_WAIT) else '0';

end a_ee_access;
