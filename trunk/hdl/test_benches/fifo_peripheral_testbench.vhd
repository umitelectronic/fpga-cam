--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   13:03:11 06/19/2012
-- Design Name:   
-- Module Name:   /home/jpiat/development/FPGA/projects/fpga-cam/hdl/test_benches/fifo_peripheral_testbench.vhd
-- Project Name:  SPARTCAM
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: fifo_peripheral
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
USE ieee.std_logic_UNSIGNED.ALL;
USE ieee.numeric_std.ALL;
 
-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--USE ieee.numeric_std.ALL;
 
ENTITY fifo_peripheral_testbench IS
END fifo_peripheral_testbench;
 
ARCHITECTURE behavior OF fifo_peripheral_testbench IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT fifo_peripheral
    PORT(
         clk : IN  std_logic;
         arazb : IN  std_logic;
         addr_bus : IN  std_logic_vector(15 downto 0);
         wr_bus : IN  std_logic;
         rd_bus : IN  std_logic;
         wrB : IN  std_logic;
         rdA : IN  std_logic;
         data_bus : INOUT  std_logic_vector(15 downto 0);
         inputB : IN  std_logic_vector(15 downto 0);
         outputA : OUT  std_logic_vector(15 downto 0);
         emptyA : OUT  std_logic;
         fullA : OUT  std_logic;
         emptyB : OUT  std_logic;
         fullB : OUT  std_logic
        );
    END COMPONENT;
    

   --Inputs
   signal clk : std_logic := '0';
   signal arazb : std_logic := '0';
   signal addr_bus : std_logic_vector(15 downto 0) := (others => '0');
   signal wr_bus : std_logic := '0';
   signal rd_bus : std_logic := '0';
   signal wrB : std_logic := '0';
   signal rdA : std_logic := '0';
   signal inputB : std_logic_vector(15 downto 0) := (others => '0');

	--BiDirs
   signal data_bus : std_logic_vector(15 downto 0);

 	--Outputs
   signal outputA : std_logic_vector(15 downto 0);
   signal emptyA : std_logic;
   signal fullA : std_logic;
   signal emptyB : std_logic;
   signal fullB : std_logic;

   -- Clock period definitions
   constant clk_period : time := 10 ns;
 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: fifo_peripheral PORT MAP (
          clk => clk,
          arazb => arazb,
          addr_bus => addr_bus,
          wr_bus => wr_bus,
          rd_bus => rd_bus,
          wrB => wrB,
          rdA => rdA,
          data_bus => data_bus,
          inputB => inputB,
          outputA => outputA,
          emptyA => emptyA,
          fullA => fullA,
          emptyB => emptyB,
          fullB => fullB
        );

   -- Clock process definitions
   clk_process :process
   begin
		clk <= '0';
		wait for clk_period/2;
		clk <= '1';
		wait for clk_period/2;
   end process;
 

   -- bus Stimulus process
   bus_proc: process
   begin		
      arazb <= '0' ;
		addr_bus <= (others => '0') ;
      wait for 100 ns;	
		arazb <= '1' ;
		addr_bus <= X"0002" ;
		data_bus <= (others => 'Z');
      wait for clk_period*10;
		loop_available: FOR b IN 1 TO 10 LOOP -- la variable de boucle est a de 1 à 10
					rd_bus <= '1' ;
					WAIT FOR clk_period; -- attend la valeur de pulse_time
					rd_bus <= '0' ;
					WAIT FOR clk_period;
				END LOOP loop_available;
		addr_bus <= X"0000" ;
		loop_read: FOR b IN 1 TO 10 LOOP -- la variable de boucle est a de 1 à 10
					rd_bus <= '1' ;
					WAIT FOR clk_period; -- attend la valeur de pulse_time
					rd_bus <= '0' ;
					WAIT FOR clk_period;
				END LOOP loop_read;
			data_bus <= (others => '0');	
			loop_write: FOR b IN 1 TO 10 LOOP -- la variable de boucle est a de 1 à 10
					wr_bus <= '1' ;
					WAIT FOR clk_period; -- attend la valeur de pulse_time
					wr_bus <= '0' ;
					WAIT FOR clk_period;
					data_bus <= data_bus + 1 ;
				END LOOP loop_write;
      -- insert stimulus here 

      wait;
   end process;
	
	
	-- logic Stimulus process
   logic_proc: process
   begin		
      -- hold reset state for 100 ns.
      inputB <= (others => '0') ;
		wait for 100 ns;	
		
      wait for clk_period*10;
		loop_logic: FOR a IN 1 TO 10 LOOP -- la variable de boucle est a de 1 à 10
					wrB <= '1' ;
					WAIT FOR clk_period; -- attend la valeur de pulse_time
					wrB <= '0' ;
					inputB <= inputB + 1;
					WAIT FOR clk_period;
				END LOOP loop_logic;
      -- insert stimulus here 

      wait;
   end process;

END;
