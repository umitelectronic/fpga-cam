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
use work.camera.all ;
use work.generic_components.all ;


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


	signal xgrad, ygrad : signed(7 downto 0);
	signal xgrad_square, ygrad_square, xygrad, xgrad_square_sum, ygrad_square_sum, xygrad_sum : signed(15 downto 0);
	signal xgrad_square_sum_latched, ygrad_square_sum_latched, xygrad_sum_latched : signed(15 downto 0);
	signal xgrad_square_sum_ram, ygrad_square_sum_ram, xygrad_sum_ram : signed(15 downto 0);

	signal pixel_count : std_logic_vector((nbit(WIDTH) - 1) downto 0);
	signal line_count : std_logic_vector((nbit(HEIGHT) - 1) downto 0);
	signal block_xaddress : std_logic_vector((nbit(WIDTH/WINDOW_SIZE) - 1) downto 0);
	signal block_xpos : std_logic_vector((nbit(WINDOW_SIZE) - 1) downto 0);
	signal block_yaddress : std_logic_vector((nbit(HEIGHT/WINDOW_SIZE) - 1) downto 0);
	signal block_ypos : std_logic_vector((nbit(WINDOW_SIZE) - 1) downto 0);
	
	signal ram_in, ram_out : std_logic_vector(47 downto 0);
	
	signal store_grads, store_grads_re, store_grads_old : std_logic ;
	
	signal pxclk_from_sobel_old, pxclk_from_sobel_re : std_logic ;
	signal end_of_window : std_logic ;
	
	
	signal stage1, stage2, stage3 : std_logic ; --pipeline stages enable signal
	signal det, det_latched : signed(15 downto 0);
	signal det0, det1, det0_latched, det1_latched : signed(15 downto 0);
	signal trace, trace_latched : signed(15 downto 0);
	signal trace_square, trace_square_latched : signed(15 downto 0);
	signal harris_val : signed(15 downto 0);
	
begin

	gauss3x3_0	: gauss3x3 
		generic map(WIDTH => WIDTH,
				  HEIGHT => HEIGHT)
		port map(
					clk => clk ,
					resetn => resetn ,
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
			clk => clk ,
			resetn => resetn ,
			pixel_clock => pxclk_from_gauss, hsync => href_from_gauss, vsync =>  vsync_from_gauss,
			pixel_clock_out => pxclk_from_sobel, hsync_out => href_from_sobel, vsync_out => vsync_from_sobel, 
			pixel_data_in => pixel_from_gauss,  
			pixel_data_out => pixel_from_sobel,
			x_grad => xgrad ,
			y_grad => ygrad
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
	
		xgrad_square_sum <= xgrad_square + xgrad_square_sum_latched ; -- accumulating in register
		ygrad_square_sum <= ygrad_square + ygrad_square_sum_latched ;
		xygrad_sum <= xygrad + xygrad_sum_latched ;

		process(clk, resetn)
		begin
			if resetn = '0' then
				xgrad_square_sum_latched <= (others => '0');
				ygrad_square_sum_latched <= (others => '0');
				xygrad_sum_latched <= (others => '0');
			elsif clk'event and clk = '1' then 
				pxclk_from_sobel_old <= pxclk_from_sobel ;
				if (block_xpos = 0) then
						xgrad_square_sum_latched <= (others => '0');
						ygrad_square_sum_latched <= (others => '0');
						xygrad_sum_latched <= (others => '0');
				elsif pxclk_from_sobel_re = '1' then
					xgrad_square_sum_latched <= xgrad_square_sum;
					ygrad_square_sum_latched <= ygrad_square_sum;
					xygrad_sum_latched <= xygrad_sum;
				end if ;
			end if ;
		end process ;
		pxclk_from_sobel_re <= pxclk_from_sobel AND (NOT pxclk_from_sobel_old);


		ram_in(47 downto 32) <= std_logic_vector(xgrad_square_sum + xgrad_square_sum_ram) when block_ypos /= 0 else
										 std_logic_vector(xgrad_square_sum); -- accumulating in RAM
		ram_in(31 downto 16) <= std_logic_vector(ygrad_square_sum + ygrad_square_sum_ram) when block_ypos /= 0 else
										std_logic_vector(ygrad_square_sum)	; 
		ram_in(15 downto 0) <= std_logic_vector(xygrad_sum + xygrad_sum_ram)  when block_ypos /= 0 else 
									  std_logic_vector(xygrad_sum);
		
		
		xgrad_square_sum_ram  <= signed(ram_out(47 downto 32)) ;
		ygrad_square_sum_ram <= signed(ram_out(31 downto 16)) ;
		xygrad_sum_ram <= signed(ram_out(15 downto 0)) ;
		
		harris_window_ram : dpram_NxN 
			generic map(SIZE => WIDTH/WINDOW_SIZE , NBIT => 48, ADDR_WIDTH => nbit(WIDTH/WINDOW_SIZE))
			port map(
				clk => clk,  
				we => store_grads_re, 		
				di =>  ram_in,
				a	=> block_xaddress,
				dpra => std_logic_vector(to_unsigned(0, nbit(WIDTH/WINDOW_SIZE))),
				spo => ram_out
				--dpo =>  		
			); 
			
			
		store_grads <= '1' when block_xpos = (WINDOW_SIZE - 1) else
							'0' ;
		process(clk, resetn)
		begin
			if resetn = '0' then
				store_grads_old <= '0' ;
			elsif clk'event and clk = '1' then 
				store_grads_old <= store_grads ;
			end if ;
		end process ;		
		store_grads_re <= store_grads and (NOT store_grads_old);
		
		end_of_window <= store_grads_re when block_y_pos = WINDOW_SIZE - 1 else
						  '0' ;
		
		
		-- need logic to compute determinant, trace and and latch

		trace <= signed(ram_in(47 downto 32)) + signed(ram_in(31 downto 16)) ; -- first stage
		det0 <= signed(ram_in(47 downto 32)) * signed(ram_in(31 downto 16));
		det1 <= signed(ram_in(15 downto 0)) * signed(ram_in(15 downto 0));
		
		
		
		trace_square <= trace_latched * trace_latched ; -- second stage
		det <= det0_latched - det1_latched ;
		
		harris_val <= det_latched - trace_square_latched ; -- final stage
		
	
		
		process(clk, resetn)
		begin
			if resetn = '0' then
				stage1 <= '0' ;
				stage2 <= '0' ;
				stage3 <= '0' ;
			elsif clk'event and clk ='1' then
				stage1 <= end_of_window ;
				stage2 <= stage1 ;
				stage3 <= stage2 ;
			end if ;
		end process ;
		
		process(clk, resetn)
		begin
			if resetn = '0' then
				trace_latched <= (others => '0') ;
				det0_latched <= (others => '0') ;
				det1_latched <= (others => '0') ;
				det_latched <= (others => '0') ;
				trace_square_latched <= (others => '0') ;
			elsif clk'event and clk ='1' then
				trace_latched <= trace ;
				det0_latched <= det0 ;
				det1_latched <= det1 ;
				det_latched <= det ;
				trace_square_latched <= trace_square ;
			end if ;
		end process ;
		
		harris_out <= harris_val ;
		pixel_clock_out <= stage3 ;
		

end Behavioral;

