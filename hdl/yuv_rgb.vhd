----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    11:48:01 03/12/2012 
-- Design Name: 
-- Module Name:    binarization - Behavioral 
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
use IEEE.NUMERIC_STD.ALL ;
use IEEE.STD_LOGIC_UNSIGNED.ALL ;

library work;
use work.generic_components.all ;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity synced_binarization is
port( clk	:	in std_logic ;
		arazb	:	in std_logic ;
		pixel_clock, hsync, vsync : in std_logic; 
		pixel_clock_out, hsync_out, vsync_out : out std_logic; 
 		pixel_y : in std_logic_vector(7 downto 0) ;
		pixel_u : in std_logic_vector(7 downto 0) ;
		pixel_v : in std_logic_vector(7 downto 0) ;
		pixel_r : out std_logic_vector(7 downto 0) ;
		pixel_g : out std_logic_vector(7 downto 0)  ;
		pixel_b : out std_logic_vector(7 downto 0)  
);
end synced_binarization;

architecture Behavioral of synced_binarization is
signal pixel_r_t, pixel_g_t, pixel_b_t: std_logic_vector(8 downto 0);
signal pixel_data1_bin, pixel_data2_bin, pixel_data3_bin, pixels_and : std_logic ;
begin

pixel_r_t <= (('0' & pixel_y) + ('0' & pixel_v)) - std_logic_vector(to_unsigned(128, 9)) ;
pixel_g_t <= (('0' & pixel_y) - ("000" & (pixel_u(7 downto 2)))) - ("00" & (pixel_v(7 downto 1))) + std_logic_vector(to_unsigned(96, 9));
pixel_b_t <= ('0' & pixel_y) + (pixel_u & '0') - std_logic_vector(to_unsigned(256, 9)) ;




pixel_r_latch0 : edge_triggered_latch 
		 generic map( NBIT => 8)
		 port map( clk =>clk,
				  arazb => arazb ,
				  sraz => '0' ,
				  en => pixel_clock ,
				  d => pixel_r_t(7 downto 0) , 
				  q => pixel_r);
				  
pixel_g_latch0 : edge_triggered_latch 
		 generic map( NBIT => 8)
		 port map( clk =>clk,
				  arazb => arazb ,
				  sraz => '0' ,
				  en => pixel_clock ,
				  d => pixel_g_t(7 downto 0) , 
				  q => pixel_g);

pixel_b_latch0 : edge_triggered_latch 
		 generic map( NBIT => 8)
		 port map( clk =>clk,
				  arazb => arazb ,
				  sraz => '0' ,
				  en => pixel_clock ,
				  d => pixel_b_t(7 downto 0) , 
				  q => pixel_b);				  

process(clk, arazb)
begin
	if arazb = '0' then
		pixel_clock_out <= '0';
		hsync_out <= '0' ;
		vsync_out <= '0' ;
	elsif clk'event and clk = '1' then
		pixel_clock_out <= pixel_clock;
		hsync_out <= hsync ;
		vsync_out <= vsync ;
	end if ;
end process ;

end Behavioral;

