-------------------------------------------------------------------------------
-- I2C EEPROM Programmer EEPROM access
-------------------------------------------------------------------------------
-- This program is part of the SPARTCAM project and is aimed to
-- work with a Python script to write data to the configuration EEPROM
-------------------------------------------------------------------------------

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;

library work;
use work.all;
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
    data_valid : out std_logic;         -- Signal data_out is valid

    ready    : out   std_logic;  -- Signal other modules we are ready for new access
    
    -- Signals to the I2C controller
    i2c_slave_addr : out std_logic_vector (6 downto 0);  
    i2c_din : out std_logic_vector (7 downto 0);
    i2c_dout : in std_logic_vector (7 downto 0);
    i2c_send : out std_logic;
    i2c_rcv : out std_logic;
    i2c_hold : out std_logic;
    i2c_rdy : in std_logic;
    i2c_ack, i2c_nack : in std_logic);
    
end ee_access;


architecture a_ee_access of ee_access is
  -- State machine states
  type EE_W_STATE is (W_IDLE, W_ADDRH, W_ADDRL, W_DATA, W_WAIT, W_END);                 -- States for the write state machine
  type EE_R_STATE is (R_IDLE, R_ADDRH, R_ADDRL, R_RESTART, R_DATA, R_WAIT, R_END);      -- States for the write state machine

  -- Constants
  constant dev_address : std_logic_vector(6 downto 0) := "1010000";  -- I2C EEPROM device address
  
  -- module internal signals
  signal data_buffer : std_logic_vector(7 downto 0);  -- buffer to store read data (or data to write)

  -- State machines current states
  signal rd_current_state : EE_R_STATE := R_IDLE;  -- Read state machine current state
  signal wr_current_state : EE_W_STATE := W_IDLE;  -- Write state machine current state
  signal last_ack_r,last_ack_w : std_logic := '0';            -- Last value of i2c_ack
  signal state : unsigned(3 downto 0);
                                  
begin  -- a_ee_access

  i2c_slave_addr <= dev_address;

  state <= to_unsigned(EE_R_STATE'pos(rd_current_state),4) +
            to_unsigned(EE_W_STATE'pos(wr_current_state),4);
  
  read_process: if READ_ENABLED='1' generate
    -- purpose: Handle the data read state machine
    -- type   : sequential
    -- inputs : clk, arazb, rd, burst
    rd_proc: process (clk, arazb)
      variable next_state : EE_R_STATE := R_IDLE;  -- State machine next state
      variable start_addr : std_logic_vector(15 downto 0);  -- Start address for read access
    begin  -- process rd_proc
      if arazb = '0' then               -- asynchronous reset (active low)
        rd_current_state <= R_IDLE;
        last_ack_r <= '0';
      elsif clk'event and clk = '1' then  -- rising clock edge
        next_state := rd_current_state;
        
        case rd_current_state is
          -- Idle state : the module waits for an instruction
          when R_IDLE =>
            i2c_din <= (others => 'Z');
            if (rd = '1' and wr_current_state=W_IDLE) then
              next_state := R_ADDRH;
              start_addr := mem_addr;
              i2c_din <= start_addr(15 downto 8);
            end if;

          -- Writting the high address
          when R_ADDRH =>
            -- send the high address
            if (last_ack_r = '0' and i2c_ack = '1') then
              next_state := R_ADDRL;
              i2c_din <= start_addr(7 downto 0);
            elsif i2c_nack='1' then
              next_state := R_END;
            end if;

          -- Writting the low address
          when R_ADDRL =>
            -- send the low address
            if (last_ack_r = '0' and i2c_ack='1') then
              i2c_din <= start_addr(7 downto 0); 
              next_state := R_RESTART;
            elsif i2c_nack='1' then
              next_state := R_END;
            end if;

          -- Restarting the I2C communication
          when R_RESTART =>
            if (i2c_rdy='1') then
              next_state := R_DATA;
            --elsif (i2c_nack='1') then
            --  next_state := R_IDLE;
            end if;

          -- Read one data
          when R_DATA =>
            if (i2c_ack='1' and last_ack_r='0') then
              next_state := R_WAIT;     
            elsif (i2c_nack='1') then
              next_state := R_END;
            end if;

          -- put the data out and get the others
          when R_WAIT =>
            data_out <= i2c_dout;
            if (rd='1' and i2c_nack='0' and burst='1' and i2c_ack='0') then
              next_state := R_DATA;
            elsif burst='0' or i2c_nack='1' then
              next_state := R_END;
            end if;

          -- Wait the read command to finish
          when R_END =>
            if rd='0' then
              next_state := R_IDLE;
            end if;

          -- Reset all wrong state to idle
          when others =>
            next_state := R_IDLE;
        end case;
        rd_current_state <= next_state;
        last_ack_r <= i2c_ack;          
      end if;
    end process rd_proc;

  end generate read_process;


  write_process: if WRITE_ENABLED='1' generate
    -- purpose: Handle the data write state machine
    -- type   : sequential
    -- inputs : clk, arazb, rd, burst
    wr_proc: process (clk, arazb)
      variable next_state : EE_W_STATE := W_IDLE;  -- State machine next state
      variable start_addr : std_logic_vector(15 downto 0);  -- Start address for read access
    begin  -- process wr_proc
      if arazb = '0' then               -- asynchronous reset (active low)
        wr_current_state <= W_IDLE;
        last_ack_w <= '0';
      elsif clk'event and clk = '1' then  -- rising clock edge
        next_state := wr_current_state;
        
        case wr_current_state is
          -- Idle state : the module waits for an instruction
          when W_IDLE =>
            i2c_din <= (others => 'Z');
            if (wr = '1' and rd_current_state=R_IDLE) then
              next_state := W_ADDRH;
              start_addr := mem_addr;
              i2c_din <= start_addr(15 downto 8);
            end if;

          -- Writting the high address
          when W_ADDRH =>
            -- send the high address
            if (last_ack_w = '0' and i2c_ack = '1') then
              next_state := W_ADDRL;
              i2c_din <= start_addr(7 downto 0);
            elsif i2c_nack='1' then
              next_state := W_IDLE;
            end if;

          -- Writting the low address
          when W_ADDRL =>
            -- send the low address
            if (last_ack_w = '0' and i2c_ack='1') then
              i2c_din <= data_in;
              next_state := W_DATA;
            elsif i2c_nack='1' then
              next_state := W_IDLE;
            end if;

          -- Read one data
          when W_DATA =>
            if (i2c_ack='1' and last_ack_w='0') then
              next_state := W_WAIT;     
            elsif (i2c_nack='1') then
              next_state := W_IDLE;
            end if;

          -- put the data out and get the others
          when W_WAIT =>
            if (wr='1' and i2c_nack='0' and burst='1') then
              i2c_din <= data_in;
              next_state := W_DATA;
            elsif burst='0' or i2c_nack='1' then
              next_state := W_END;
            end if;

          -- Wait the read command to finish
          when W_END =>
            if wr='0' then
              next_state := W_IDLE;
            end if;

          -- Reset all wrong state to idle
          when others =>
            next_state := W_IDLE;
        end case;
        wr_current_state <= next_state;
        last_ack_w <= i2c_ack;          
      end if;
    end process wr_proc;

    end generate write_process;
  
    -- Generate the rcv signal
    i2c_rcv <= '1' when  (rd_current_state = R_DATA) else '0';-- or rd_current_state = R_WAIT) else '0';
    -- Generate the send signal
    i2c_send <= '1' when ((wr_current_state=W_ADDRH or wr_current_state=W_ADDRL or wr_current_state=W_DATA) or --
                          --wr_current_state=W_WAIT) or
                          (rd_current_state=R_ADDRH or rd_current_state=R_ADDRL)) else '0'; --
    --and (i2c_ack = last_ack_r or i2c_ack=last_ack_w) else '0';
    
    -- Hold I2C master in pause while waiting next command
    i2c_hold <= '1' when (wr_current_state=W_WAIT)
                          or (rd_current_state=R_WAIT) else '0';
    
    -- Generate the data_valid signal
    data_valid <= '1' when (rd_current_state = R_WAIT) or
                  (wr_current_state = W_WAIT) else '0';

    ready <= '1' when (rd_current_state = R_IDLE  and
                       wr_current_state = W_IDLE) else '0';

end a_ee_access;
