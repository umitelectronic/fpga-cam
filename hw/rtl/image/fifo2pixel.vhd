----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    19:19:26 01/10/2013 
-- Design Name: 
-- Module Name:    fifo2pixel - Behavioral 
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
use IEEE.STD_LOGIC_UNSIGNED.ALL;
use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;
library work ;
use work.utils_pack.all ;


entity fifo2pixel is
	generic(WIDTH : positive := 320 ; HEIGHT : positive := 240);
	port(
		clk, resetn : in std_logic ;
		
		
		-- fifo side
		fifo_empty : in std_logic ;
		fifo_rd : out std_logic ;
		fifo_data : in std_logic_vector(15 downto 0);
		
		-- pixel side 
		pixel_en : in std_logic ;
		y_data : out std_logic_vector(7 downto 0 );  
 		pixel_clock_out, hsync_out, vsync_out : out std_logic
	
	);
end fifo2pixel;

architecture Behavioral of fifo2pixel is

signal pixel_count, hsync_count : std_logic_vector(9 downto 0);
signal sraz_pixel_count, en_pixel_count, sraz_hsync_count : std_logic ;
signal hsync_outq, vsync_outq, pixel_out_q : std_logic ;
signal fifo_empty_latched : std_logic ;
begin


empty_latch : generic_latch
	 generic map(NBIT => 1)
    port map( clk => pixel_en ,
           resetn => resetn ,
           sraz => '0' ,
           en => '1',
           d(0) => fifo_empty,
           q(0) => fifo_empty_latched );



hsync_out <= hsync_outq ;
vsync_out <= vsync_outq ;

hsync_outq <= '1' when hsync_count < 20 else
				'1' when pixel_count > (WIDTH - 1) else
				'1' when hsync_count > (HEIGHT - 1) else
				'0' ;
				
vsync_outq <= '1' when hsync_count > 1 and hsync_count < 4   else
				'0' ;
				
pixel_clock_out <= (not pixel_en) when hsync_outq = '0' and fifo_empty_latched = '0' else
						 (not pixel_en) when hsync_outq = '0' and pixel_count(0) =  '1' else
						 '0' ;
						
				
en_pixel_count <= '1' when fifo_empty_latched = '0' else
						'1' when fifo_empty_latched = '1' and pixel_count(0) =  '1' else
						'1' when hsync_outq = '1' else
						'0' ;
						
sraz_pixel_count <= '1' when pixel_count = (WIDTH + 45) else
						'0' ;
						
sraz_hsync_count <= '1' when hsync_count = (HEIGHT + 17 ) else
						  '0' ;
	
fifo_rd <= 	pixel_en when hsync_outq = '0' and pixel_count(0) =  '1' else
				'0' ;
pixel_counter : simple_counter
	 generic map(NBIT => 10)
    port map( clk => pixel_en ,
           resetn => resetn ,
           sraz => sraz_pixel_count ,
           en => en_pixel_count,
			  load => '0' ,
			  E => (others => '0'),
           Q => pixel_count
			  );
			  
			  
hsync_counter : simple_counter
	 generic map(NBIT => 10)
    port map( clk => pixel_en ,
           resetn => resetn ,
           sraz => sraz_hsync_count ,
           en => sraz_pixel_count,
			  load => '0' ,
			  E => (others => '0'),
           Q => hsync_count
			  );
y_data <= fifo_data(7 downto 0) when pixel_count(0) = '1' else
				fifo_data(15 downto 8) ;

end Behavioral;

