--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   17:39:07 12/18/2012
-- Design Name:   
-- Module Name:   /home/jpiat/development/FPGA/fpga-cam/platform/mark1/mark1_beaglebone_demo/mark1_beaglebone_demo_testbench.vhd
-- Project Name:  mark1_beaglebone_demo
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: mark1_beaglebone_demo
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
 
ENTITY mark1_beaglebone_demo_testbench IS
END mark1_beaglebone_demo_testbench;
 
ARCHITECTURE behavior OF mark1_beaglebone_demo_testbench IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT mark1_beaglebone_demo
    PORT(
         OSC_FPGA : IN  std_logic;
         PB : IN  std_logic_vector(3 downto 0);
         DIP_SW : IN  std_logic_vector(3 downto 0);
         LED : OUT  std_logic_vector(7 downto 0);
         GPMC_CSN : IN  std_logic_vector(2 downto 0);
         GPMC_WEN : IN  std_logic;
         GPMC_OEN : IN  std_logic;
         GPMC_ADVN : IN  std_logic;
         GPMC_CLK : IN  std_logic;
         GPMC_BE0N : IN  std_logic;
         GPMC_AD : INOUT  std_logic_vector(15 downto 0)
        );
    END COMPONENT;
    

   --Inputs
   signal OSC_FPGA : std_logic := '0';
   signal PB : std_logic_vector(3 downto 0) := (others => '0');
   signal DIP_SW : std_logic_vector(3 downto 0) := (others => '0');
   signal GPMC_CSN : std_logic_vector(2 downto 0) := (others => '0');
   signal GPMC_WEN : std_logic := '0';
   signal GPMC_OEN : std_logic := '0';
   signal GPMC_ADVN : std_logic := '0';
   signal GPMC_CLK : std_logic := '0';
   signal GPMC_BE0N : std_logic := '0';

	--BiDirs
   signal GPMC_AD : std_logic_vector(15 downto 0);

 	--Outputs
   signal LED : std_logic_vector(7 downto 0);

   -- Clock period definitions
   constant GPMC_CLK_period : time := 10 ns;
 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: mark1_beaglebone_demo PORT MAP (
          OSC_FPGA => OSC_FPGA,
          PB => PB,
          DIP_SW => DIP_SW,
          LED => LED,
          GPMC_CSN => GPMC_CSN,
          GPMC_WEN => GPMC_WEN,
          GPMC_OEN => GPMC_OEN,
          GPMC_ADVN => GPMC_ADVN,
          GPMC_CLK => GPMC_CLK,
          GPMC_BE0N => GPMC_BE0N,
          GPMC_AD => GPMC_AD
        );

   -- Clock process definitions
   GPMC_CLK_process :process
   begin
		GPMC_CLK <= '0';
		wait for GPMC_CLK_period/2;
		GPMC_CLK <= '1';
		wait for GPMC_CLK_period/2;
   end process;
 

   -- Stimulus process
   stim_proc: process
   begin		
       PB(0) <= '0' ;
		GPMC_AD <=  (others => 'Z') ;
		GPMC_CSN(1) <= '1' ;
		GPMC_ADVN <= '1' ;
		GPMC_OEN <= '1' ;
		GPMC_WEN <= '1' ;
      wait for 100 ns;	
		 PB(0) <= '1' ;
		wait for GPMC_CLK_period*2000;	
      wait for GPMC_CLK_period*10;
		-- reading fifo size
		GPMC_AD <= X"0004" ;
		GPMC_CSN(1) <= '0' ;
		GPMC_ADVN <= '0' ;
		GPMC_OEN <= '1' ;
		GPMC_WEN <= '1' ;
		wait for GPMC_CLK_period*2;
		GPMC_AD <= (others => 'Z') ;
		GPMC_CSN(1) <= '0' ;
		GPMC_ADVN <= '1' ;
		GPMC_OEN <= '1' ;
		GPMC_WEN <= '1' ;
		wait for GPMC_CLK_period;
		GPMC_AD <= (others => 'Z') ;
		GPMC_CSN(1) <= '0' ;
		GPMC_ADVN <= '1' ;
		GPMC_OEN <= '0' ;
		GPMC_WEN <= '1' ;
		wait for GPMC_CLK_period*4;
		GPMC_AD <= (others => 'Z') ;
		GPMC_CSN(1) <= '1' ;
		GPMC_ADVN <= '1' ;
		GPMC_OEN <= '1' ;
		GPMC_WEN <= '1' ;
		wait for GPMC_CLK_period*10;
		
		--writing to fifo
		GPMC_AD <= X"0000" ;
		GPMC_CSN(1) <= '0' ;
		GPMC_ADVN <= '0' ;
		GPMC_OEN <= '1' ;
		GPMC_WEN <= '1' ;
		wait for GPMC_CLK_period*2;
		GPMC_AD <= (others => 'Z') ;
		GPMC_CSN(1) <= '0' ;
		GPMC_ADVN <= '1' ;
		GPMC_OEN <= '1' ;
		GPMC_WEN <= '1' ;
		wait for GPMC_CLK_period;
		GPMC_AD <= X"55AA" ;
		GPMC_CSN(1) <= '0' ;
		GPMC_ADVN <= '1' ;
		GPMC_OEN <= '1' ;
		GPMC_WEN <= '0' ;
		wait for GPMC_CLK_period*4;
		GPMC_AD <= (others => 'Z') ;
		GPMC_CSN(1) <= '1' ;
		GPMC_ADVN <= '1' ;
		GPMC_OEN <= '1' ;
		GPMC_WEN <= '1' ;
		wait for GPMC_CLK_period*10;
		
		
		-- writing to leds
		GPMC_AD <= X"0008" ;
		GPMC_CSN(1) <= '0' ;
		GPMC_ADVN <= '0' ;
		GPMC_OEN <= '1' ;
		GPMC_WEN <= '1' ;
		wait for GPMC_CLK_period*2;
		GPMC_AD <= (others => 'Z') ;
		GPMC_CSN(1) <= '0' ;
		GPMC_ADVN <= '1' ;
		GPMC_OEN <= '1' ;
		GPMC_WEN <= '1' ;
		wait for GPMC_CLK_period;
		GPMC_AD <= X"5AA5" ;
		GPMC_CSN(1) <= '0' ;
		GPMC_ADVN <= '1' ;
		GPMC_OEN <= '1' ;
		GPMC_WEN <= '0' ;
		wait for GPMC_CLK_period*4;
		GPMC_AD <= (others => 'Z') ;
		GPMC_CSN(1) <= '1' ;
		GPMC_ADVN <= '1' ;
		GPMC_OEN <= '1' ;
		GPMC_WEN <= '1' ;
		wait for GPMC_CLK_period*10;
		
      -- insert stimulus here 

      wait;
   end process;

END;
