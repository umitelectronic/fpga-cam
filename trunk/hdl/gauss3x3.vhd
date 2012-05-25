----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    10:25:52 03/03/2012 
-- Design Name: 
-- Module Name:    sobel3x3 - Behavioral 
-- Project Name: 
-- Target Devices: 
-- Tool versions: 
-- Description: 
--
-- Dependencies: 
--
-- Revision: 
-- Revision 0.01 - File Created
-- Additional Comments: 
--
----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

library WORK ;
USE WORK.CAMERA.ALL ;
USE WORK.GENERIC_COMPONENTS.ALL ;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity gauss3x3 is
generic(WIDTH: natural := 640;
		  HEIGHT: natural := 480);
port(
 		clk : in std_logic; 
 		arazb : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_clock_out, hsync_out, vsync_out : out std_logic; 
 		pixel_data_in : in std_logic_vector(7 downto 0 ); 
 		pixel_data_out : out std_logic_vector(7 downto 0 )

);
end gauss3x3;



architecture Behavioral of gauss3x3 is
	signal block3x3_sig : mat3 ;
	signal new_block : std_logic ;
	signal line_1, line_2, line_3 : std_logic_vector(15 downto 0);
	signal conv : std_logic_vector(15 downto 0);
begin

		block0:  block3X3v2 
		generic map(LINE_SIZE =>  WIDTH)
		port map(
			clk => clk ,
			arazb => arazb , 
			pixel_clock => pixel_clock , hsync => hsync , vsync => vsync,
			pixel_data_in => pixel_data_in ,
			new_block => new_block,
			block_out => block3x3_sig);
		
	
		line_1 <= (X"00" & block3x3_sig(0)(0)) + ("0000000" & block3x3_sig(0)(1) & '0') + (X"00" & block3x3_sig(0)(2)) ;
		line_2 <= ("0000000" & block3x3_sig(1)(0) & '0') + ("000000" & block3x3_sig(1)(1) & "00") + ("0000000" & block3x3_sig(1)(2) & '0') ;
		line_3 <= (X"00" & block3x3_sig(2)(0)) + (block3x3_sig(2)(1) & '0') + (X"00" & block3x3_sig(2)(2)) ;
		conv <= line_1 + line_2 + line_3 ;
		
		conv_latch0 : generic_latch 
	 generic map(NBIT => 8)
    Port map( clk => clk ,
           arazb => arazb ,
           sraz => '0' ,
           en => new_block ,
           d => conv(12 downto 4) ,
           q => pixel_data_out );
		


		--sync signals latch
		process(clk, arazb)
		begin
		if arazb = '0' then 
			pixel_clock_out <= '0' ;
			hsync_out <= '0' ;
			vsync_out <= '0' ;
		elsif clk'event and clk = '1'  then
			pixel_clock_out <= new_block ;
			hsync_out <= hsync ;
			vsync_out <= vsync ;
		end if ;
		end process ;
		

end Behavioral;

