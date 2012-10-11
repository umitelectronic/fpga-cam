----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    15:23:24 10/11/2012 
-- Design Name: 
-- Module Name:    HARRIS - Behavioral 
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

entity HARRIS is
generic(WIDTH : positive := 640 ; HEIGHT : positive := 480; WINDOW_SIZE : positive := 8);
port (
		clk : in std_logic; 
 		resetn : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_clock_out, hsync_out, vsync_out : out std_logic; 
 		pixel_data_in : in std_logic_vector(7 downto 0 ); 
 		harris_out : out std_logic_vector(15 downto 0 )
);
end HARRIS;

architecture Behavioral of HARRIS is
	signal pixel_from_sobel : std_logic_vector(7 downto 0);
	signal pixel_from_gauss : std_logic_vector(7 downto 0);
	
	signal pxclk_from_gauss, href_from_gauss, vsync_from_gauss : std_logic ;
	signal pxclk_from_sobel, href_from_sobel, vsync_from_sobel : std_logic ;


	signal xgrad, ygrad : std_logic_vector(7 downto 0);
	signal xgrad_square, ygrad_square, xygrad, xgrad_square_sum, ygrad_square_sum, xygrad_sum : std_logic_vector(15 downto 0);
	signal xgrad_square_sum_latched, ygrad_square_sum_latched, xygrad_sum_latched : std_logic_vector(15 downto 0);
	signal xgrad_square_sum_ram, ygrad_square_sum_ram, xygrad_sum_ram : std_logic_vector(15 downto 0);

	signal pixel_count : std_logic_vector((nbit(WIDTH) - 1) downto 0);
	signal line_count : std_logic_vector((nbit(HEIGHT) - 1) downto 0);
	signal block_xaddress : std_logic_vector((nbit(WIDTH/WINDOW_SIZE) - 1) downto 0);
	signal block_xpos : std_logic_vector((nbit(WINDOW_SIZE) - 1) downto 0);
	signal block_yaddress : std_logic_vector((nbit(HEIGHT/WINDOW_SIZE) - 1) downto 0);
	signal block_ypos : std_logic_vector((nbit(WINDOW_SIZE) - 1) downto 0);
	
	signal store_grads : std_logic ;
begin

	gauss3x3_0	: gauss3x3 
		generic map(WIDTH => WIDTH,
				  HEIGHT => HEIGHT)
		port map(
					clk => clk_96 ,
					resetn => resetn_delayed ,
					pixel_clock => pixel_clock, hsync => hsync, vsync =>  vsync,
					pixel_clock_out => pxclk_from_gauss, hsync_out => href_from_gauss, vsync_out => vsync_from_gauss, 
					pixel_data_in => pixel_data_in,  
					pixel_data_out => pixel_from_gauss
		);		
		
		
	sobel0: sobel3x3
		generic map(
		  WIDTH => WIDTH,
		  HEIGHT => HEIGHT)
		port map(
			clk => clk_96 ,
			resetn => resetn_delayed ,
			pixel_clock => pxclk_from_gauss, hsync => href_from_gauss, vsync =>  vsync_from_gauss,
			pixel_clock_out => pxclk_from_sobel, hsync_out => href_from_sobel, vsync_out => vsync_from_sobel, 
			pixel_data_in => pixel_from_gauss,  
			pixel_data_out => pixel_from_sobel,
			xgrad => xgrad ,
			ygrad => ygrad
		);	
	
	pixel_counter0 : pixel_counter
		generic map(MAX => WIDTH)
		port map(
			clk => clk,
			resetn => resetn,
			pixel_clock => pxclk_from_sobel, hsync => href_from_sobel,
			pixel_count => pixel_count
			);
			
	line_counter0: line_counter 
		generic map(MAX => HEIGHT)
		port map(
			clk => clk, 
			resetn => resetn, 
			hsync => href_from_sobel, vsync => vsync_from_sobel,
			line_count => line_count );
			
		block_xaddress <= pixel_count((nbit(WIDTH) - 1) downto (nbit(WINDOW_SIZE)));
		block_xpos <= pixel_count((nbit(WINDOW_SIZE) -1) downto 0);
		block_yaddress <= line_count((nbit(HEIGHT) - 1) downto (nbit(WINDOW_SIZE)));
		block_ypos <= line_count((nbit(WINDOW_SIZE) -1) downto 0);
		
		
		xgrad_square <= xgrad * ygrad ;
		ygrad_square <= ygrad * ygrad ;
		xygrad <= xgrad * ygrad ;
	
		xgrad_square_sum <= xgrad_square + xgrad_square_sum_latched ;
		ygrad_square_sum <= ygrad_square + ygrad_square_sum_latched ;
		xygrad_sum <= xygrad + xygrad_sum_latched ;

		harris_window_ram : dpram_NxN 
			generic map(SIZE => WIDTH/WINDOW_SIZE , NBIT => 64, ADDR_WIDTH => nbit(WIDTH/WINDOW_SIZE))
			port map(
				clk => clk,  
				we => store_grads, 		
				di =>  (xgrad_square_sum & ygrad_square_sum & xygrad_sum),
				a	=> block_xaddress,
				--dpra => ,
				spo => (xgrad_square_sum_ram & ygrad_square_sum_ram & xygrad_sum_ram)
				--dpo =>  		
			); 
		store_grads <= '1' when block_ypos = 0 and block_xpos = 0 else
							'0' ;

		xgrad_square_sum_latched <= (others => '0') when (block_ypos = 0 and block_xpos = 0) else 
											  xgrad_square_sum_ram ;
		ygrad_square_sum_latched <= (others => '0') when block_ypos = 0 and block_xpos = 0 else 
											  ygrad_square_sum_ram ;
		xygrad_sum_latched <= (others => '0') when block_ypos = 0 and block_xpos = 0 else 
											  xygrad_sum_ram ;
		
		

		-- need logic to compute determinant, trace and and latch in on window end



end Behavioral;

