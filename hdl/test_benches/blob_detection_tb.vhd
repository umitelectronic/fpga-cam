--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   16:29:52 03/15/2012
-- Design Name:   
-- Module Name:   /home/jpiat/development/FPGA/projects/fpga-cam/platform/papilio/SPARTCAM/blob_detection_tb.vhd
-- Project Name:  SPARTCAM
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: blob_detection
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
USE ieee.std_logic_unsigned.ALL;
 
-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--USE ieee.numeric_std.ALL;
 
ENTITY blob_detection_tb IS
END blob_detection_tb;
 
ARCHITECTURE behavior OF blob_detection_tb IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT blob_detection
    PORT(
         clk : IN  std_logic;
         arazb : IN  std_logic;
         pixel_clock : IN  std_logic;
         hsync : IN  std_logic;
         vsync : IN  std_logic;
         pixel_data_in : IN  std_logic_vector(7 downto 0)
        );
    END COMPONENT;
    
	constant clk_period : time := 5 ns ;
	constant pclk_period : time := 40 ns ;
	
	signal clk, arazb : std_logic ;
	signal pxclk, hsync, vsync : std_logic ;
	signal pixel : std_logic_vector(7 downto 0 ) := (others => '0');
	signal px_count, line_count, byte_count : integer := 0 ;
 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: blob_detection PORT MAP (
          clk => clk,
          arazb => arazb,
          pixel_clock => pxclk,
          hsync => hsync,
          vsync => vsync,
          pixel_data_in => pixel
        );

	process
	begin
		arazb <= '0' ;
		wait for 10*clk_period;
		arazb <= '1' ;
		while true loop
			clk <= '0';
			wait for clk_period;
			clk <= '1';
			wait for clk_period; 
		end loop ;
	end process;
	
process
	begin
		pxclk <= '0';
		if px_count < 640 and line_count >= 20 and line_count < 497 then
				hsync <= '0' ;
		else
				hsync <= '1' ;
		end if ;

		if line_count < 3 then
			vsync <= '1' ;
		 else 
			vsync <= '0' ;
		end if ;
		wait for pclk_period;
		
		pxclk <= '1';
		if (px_count = 784 ) then
			px_count <= 0 ;
			if (line_count > 510) then
			   line_count <= 0;
		  else
		    line_count <= line_count + 1 ;
		  end if ;
		else
		  px_count <= px_count + 1 ;
		end if ;
		
		wait for pclk_period;

	end process;

--pixel <= X"FF" when line_count < 100 and line_count > 50 and  px_count  < 400 and  px_count  > 200 else
--			X"00" ;
			
--pixel <= X"FF" when px_count < 100 and line_count < 240 else
--			X"00" ;

pixel <= X"FF" when line_count < 100  and  px_count  >= 400 else
			X"FF" when line_count >= 100	and  px_count  <= 400 else
			X"00" ;


END;
