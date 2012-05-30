-------------------------------------------------------------------------------
-- I2C EEPROM Programmer EEPROM access testbench
-------------------------------------------------------------------------------
-- This program is part of the SPARTCAM project and is aimed to
-- work with a Python script to write data to the configuration EEPROM
-------------------------------------------------------------------------------

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;

library work;
use WORK.GENERIC_COMPONENTS.ALL ;

use std.textio.all; --  Imports the standard textio package.

entity ee_access_testbench is
end ee_access_testbench;

architecture behavior of ee_access_testbench is

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


  -- signals
  signal clk : std_logic := '0';        -- System clock
  signal arazb : std_logic := '0';      -- Reset signal

  signal mem_addr : std_logic_vector(15 downto 0) := "0000000000000000";
  signal data_in, data_out : std_logic_vector(7 downto 0) := "10101010";
  signal wr,rd,burst : std_logic := '0';
  signal data_valid, ready : std_logic;
  signal sda, scl : std_logic := 'Z';
begin  -- behavior

  -- Instansiate eeprom_access
  uut: ee_access
    port map (
      clk        => clk,
      arazb      => arazb,
      mem_addr   => mem_addr,
      data_in    => data_in,
      wr         => wr,
      rd         => rd,
      burst      => burst,
      data_out   => data_out,
      data_valid => data_valid,
      ready      => ready,
      sda        => sda,
      scl        => scl);

  
  clk_gen: process
    begin
      wait for 100 ns;
      clk <= '1';
      wait for 100 ns;
      clk <= '0';      
    end process;
  
  -- purpose: Testbench process
  -- type   : combinational
  -- inputs : 
  -- outputs: 
  test: process
    variable l : line;
  begin  -- process
    write(l, String'("Starting"));
    writeline (output, l);
    arazb <= '0';

    wait for 1 ms;
    write(l, String'("Reset finished"));
    writeline (output, l);
    arazb <= '1';

    wait for 1 us;
    rd <= '1';
    burst <= '1';
    
    wait until data_valid='1';
    wait until data_valid='0';
    wait until data_valid='1';
    wait until data_valid='0';
    wait until data_valid='1';
    wait until data_valid='0';

    burst <= '0';

    wait for 1 ms;

    rd <= '0';
          
    write(l, String'("Ended"));
    writeline (output, l);
    
    wait;
  end process;
  

end behavior;
