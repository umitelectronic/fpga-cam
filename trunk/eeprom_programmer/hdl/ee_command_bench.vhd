--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   18:08:08 05/17/2012
-- Design Name:   
-- Module Name:   /home/wolverine/Documents/Programmation/fpga/papilio/fpga-cam/platform/papilio/SPARTCAM/ee_command_bench.vhd
-- Project Name:  SPARTCAM
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: ee_commands
-- 
-- Dependencies:
-- 
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
--
-- Notes: 
-- This testbench has been automatically generated using types std_logic and
-- std_logic_vector for the ports of the unit under test.  Xilinx recommends
-- that these types always be used for the top-level I/O of a design in order
-- to guarantee that the testbench will bind correctly to the post-implementation 
-- simulation model.
--------------------------------------------------------------------------------
LIBRARY ieee;
USE ieee.std_logic_1164.ALL;
 
-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--USE ieee.numeric_std.ALL;
 
ENTITY ee_command_bench IS
END ee_command_bench;
 
ARCHITECTURE behavior OF ee_command_bench IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT ee_commands
    PORT(
         clk : IN  std_logic;
         arazb : IN  std_logic;
         data_in : IN  std_logic_vector(7 downto 0);
         data_present : IN  std_logic;
         data_read : OUT  std_logic;
         data_out : OUT  std_logic_vector(7 downto 0);
         data_write : OUT  std_logic;
         SDA : INOUT  std_logic;
         SCL : INOUT  std_logic
        );
    END COMPONENT;
    

   --Inputs
   signal clk : std_logic := '0';
   signal arazb : std_logic := '0';
   signal data_in : std_logic_vector(7 downto 0) := (others => '0');
   signal data_present : std_logic := '0';

	--BiDirs
   signal SDA : std_logic;
   signal SCL : std_logic;

 	--Outputs
   signal data_read : std_logic;
   signal data_out : std_logic_vector(7 downto 0);
   signal data_write : std_logic;

   -- Clock period definitions
   constant clk_period : time := 10 ns;
 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: ee_commands PORT MAP (
          clk => clk,
          arazb => arazb,
          data_in => data_in,
          data_present => data_present,
          data_read => data_read,
          data_out => data_out,
          data_write => data_write,
          SDA => SDA,
          SCL => SCL
        );

   -- Clock process definitions
   clk_process :process
   begin
		clk <= '0';
		wait for clk_period/2;
		clk <= '1';
		wait for clk_period/2;
   end process;
 

   -- Stimulus process
   stim_proc: process
   begin		
      -- hold reset state for 100 ns.
      wait for 100 ns;	
		arazb <= '1';

      wait for clk_period*10;

      -- insert stimulus here 
		data_present <= '1';
		
		wait until data_read = '1';

		data_in <= "10101010";
		data_present <= '0';
		
		wait for clk_period;
		
		data_present <= '1';
		
		wait until data_read = '1';
		
		data_in <= "00000001";
		data_present <= '0';
		
		wait for clk_period * 10;
      wait;
   end process;

END;
