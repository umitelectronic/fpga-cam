----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    11:17:32 10/22/2012 
-- Design Name: 
-- Module Name:    HARRIS_TESSELATION - Behavioral 
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

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity HARRIS_TESSELATION is
	generic(WIDTH : positive := 640 ; HEIGHT : positive := 480; TILE_NBX : positive := 8 ; TILE_NBY : positive := 6 );
	port (
			clk : in std_logic; 
			resetn : in std_logic; 
			pixel_clock, hsync, vsync : in std_logic; 
			pixel_data_in : in std_logic_vector(7 downto 0 ); 
			blockx_address	:	out std_logic_vector((nbit(TILE_NBX) - 1) downto 0 );
			blocky_address	:	out std_logic_vector((nbit(TILE_NBY) - 1) downto 0 );
			maxima_coordx	:	out std_logic_vector((nbit(WIDTH) - 1) downto 0 );
			maxima_coordy	:	out std_logic_vector((nbit(HEIGHT) - 1) downto 0 );
			end_of_block	:	out std_logic ;
			harris_score	: 	out std_logic_vector(15 downto 0 );
			latch_maxima	:	out std_logic ;
			harris_out : out std_logic_vector(15 downto 0 )
	);
end HARRIS_TESSELATION;

architecture Behavioral of HARRIS_TESSELATION is

	signal pixel_count : std_logic_vector((nbit(WIDTH) - 1) downto 0);
	signal line_count : std_logic_vector((nbit(HEIGHT) - 1) downto 0);
	signal block_xaddress, block_xaddress_old : std_logic_vector((nbit(WIDTH/WINDOW_SIZE) - 1) downto 0);
	signal block_xpos : std_logic_vector((nbit(WINDOW_SIZE) - 1) downto 0);
	signal block_yaddress, block_yaddress_old : std_logic_vector((nbit(HEIGHT/WINDOW_SIZE) - 1) downto 0);
	signal block_ypos : std_logic_vector((nbit(WINDOW_SIZE) - 1) downto 0);

begin


pixel_counter0 : pixel_counter
		generic map(MAX => WIDTH)
		port map(
			clk => clk,
			resetn => resetn,
			pixel_clock => pixel_clock, hsync => hsync,
			pixel_count => pixel_count
			);
	
		process(clk, resetn)
		begin
			if resetn = '0' then
				block_xaddress <= (others => '0') ;
				block_xpos <= (others => '0') ;
			elsif clk'event and clk = '1' then
				if href_from_sobel = '1' then
					block_xaddress <= (others => '0') ;
					block_xpos <= (others => '0') ;
				elsif pxclk_from_sobel_re = '1'  then
						if block_xpos = (WINDOW_SIZE - 1) then
							block_xaddress <= block_xaddress  + 1  ;
							block_xpos <= (others => '0');
						else
							block_xpos <= block_xpos + 1 ;
						end if;
				end if ;
			end if ;
		end process ;

	
	line_counter0: line_counter 
		generic map(MAX => HEIGHT)
		port map(
			clk => clk, 
			resetn => resetn, 
			hsync => hsync, vsync => vsync,
			line_count => line_count );
	
	
		process(clk, resetn)
		begin
			if resetn = '0' then
				block_yaddress <= (others => '0') ;
				block_ypos <= (others => '0') ;
			elsif clk'event and clk = '1' then
				if vsync_from_sobel = '1' then
					block_yaddress <= (others => '0') ;
					block_ypos <= (others => '0') ;
				elsif href_from_sobel_re = '1' then
					if  block_ypos = (WINDOW_SIZE - 1) then
						block_yaddress <= block_yaddress  + 1  ;
						block_ypos <= (others => '0');
					else
						block_ypos <= block_ypos + 1;
					end if ;
				end if ;
			end if ;
		end process ;	

end Behavioral;

