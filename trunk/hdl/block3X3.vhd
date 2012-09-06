----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    14:38:37 03/08/2012 
-- Design Name: 
-- Module Name:    block3X3 - Behavioral 
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
use WORK.CAMERA.ALL ;
use WORK.GENERIC_COMPONENTS.ALL ;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity block3X3 is
		generic(WIDTH: natural := 640;
		  HEIGHT: natural := 480);
		port(
			clk : in std_logic; 
			resetn : in std_logic; 
			pixel_clock, hsync, vsync : in std_logic; 
			pixel_data_in : in std_logic_vector(7 downto 0 ); 
			new_block : out std_logic ;
			block_out : out mat3);
end block3X3;

architecture Behavioral of block3X3 is
type read_pixel_state is (LOAD_VALUES2, WAIT_PIXEL, LOAD_VALUES1, END_PIXEL, END_HSYNC);


signal pixel_state : read_pixel_state ;

signal block3x3 : mat3 := (((others => '0'), (others => '0'), (others => '0')), 
									((others => '0'), (others => '0'), (others => '0')), 
									((others => '0'), (others => '0'), (others => '0')));

signal k02, k12 :	signed(8 downto 0) := (others => '0');


signal line_wr, nclk: std_logic ;


signal LINE1_INPUT, LINE1_OUTPUT, LINE2_INPUT, LINE2_OUTPUT : std_logic_vector(7 downto 0) := X"00";

signal INPUT_LINES, OUTPUT_LINES : std_logic_vector(15 downto 0) ;
signal final_res : signed(31 downto 0);

signal nb_line : std_logic_vector((nbit(HEIGHT) - 1) downto 0) := (others => '0');
signal pixel_counterq : std_logic_vector((nbit(WIDTH) - 1) downto 0) := (others => '0');
begin

nclk <= NOT clk ;


lines0: ram_NxN
	generic map(SIZE => WIDTH , NBIT => 16, ADDR_WIDTH => nbit(WIDTH))
	port map(
 		clk => nclk, 
 		we => line_wr, en => '1' ,
 		do => OUTPUT_LINES,
 		di => INPUT_LINES,
 		addr => pixel_counterq
	); 

LINE2_OUTPUT <= OUTPUT_LINES(15 downto 8);
LINE1_OUTPUT <= OUTPUT_LINES(7 downto 0);

INPUT_LINES(7 downto 0) <= LINE1_INPUT; 
INPUT_LINES(15 downto 8) <= LINE2_INPUT; 

--line2: ram_Nx8
--	generic map(N => WIDTH + 2, A => nbit(WIDTH))
--	port map(
-- 		clk => nclk, 
-- 		we => line_wr, en => '1' ,
-- 		do => LINE2_OUTPUT,
-- 		di => LINE2_INPUT,
-- 		addr => pixel_counterq
--	); 


pixel_counter0: pixel_counter
		generic map(MAX => WIDTH)
		port map(
			clk => clk,
			resetn => resetn, 
			pixel_clock => pixel_clock, hsync => hsync,
			pixel_count => pixel_counterq
			);
			
line_counter0: line_counter
		generic map(MAX => HEIGHT)
		port map(
			clk => clk,
			resetn => resetn, 
			hsync => hsync, vsync => vsync, 
			line_count => nb_line
			);

-- actualize matrix with values
process(clk, resetn)
begin
if resetn = '0' then 
	block3x3(0)(0) <= (others => '0') ;
	block3x3(0)(1) <= (others => '0') ; -- zeroing matrix
	block3x3(0)(2) <= (others => '0') ;
	
	block3x3(1)(0) <= (others => '0') ;
	block3x3(1)(1) <= (others => '0') ;
	block3x3(1)(2) <= (others => '0') ;
	
	block3x3(2)(0) <= (others => '0') ;
	block3x3(2)(1) <= (others => '0') ;
	block3x3(2)(2) <= (others => '0') ;
	line_wr <= '0' ;
	k02 <= (others => '0') ;
	k12 <= (others => '0') ;
	pixel_state <= LOAD_VALUES2 ;
elsif clk'event and clk = '1' then
	case pixel_state is
		when LOAD_VALUES1 => -- load value from fifos into buffer
			new_block <= '0' ;
			line_wr <= '0' ;
			pixel_state <= LOAD_VALUES2 ;
		when LOAD_VALUES2  =>
			new_block <= '0' ;
			line_wr <= '0' ;
			if nb_line > 0 then
				k12 <= signed('0' & LINE2_OUTPUT) ;
				k02 <= signed('0' & LINE1_OUTPUT) ;
				if hsync = '1' then
					pixel_state <= END_HSYNC ;
				else
					pixel_state <= END_PIXEL ;
				end if ;
			else 
				k12 <= (others => '0') ;
				k02 <= (others => '0') ;
				if hsync = '1' then
						pixel_state <= END_HSYNC ;
				else
					pixel_state <= END_PIXEL ;
				end if ;
			end if;
		when WAIT_PIXEL =>
			new_block <= '0' ;
			line_wr <= '0' ;
			if pixel_clock = '1' and hsync = '0' and vsync = '0' then
				block3x3(0)(2) <= k02 ;
				block3x3(0)(1) <= block3x3(0)(2) ; -- shifting matrix to right
				block3x3(0)(0) <= block3x3(0)(1) ;
				
				block3x3(1)(2) <= k12 ;
				block3x3(1)(1) <= block3x3(1)(2) ;
				block3x3(1)(0) <= block3x3(1)(1) ;
				
				block3x3(2)(2) <= signed('0' & pixel_data_in) ;
				block3x3(2)(1) <= block3x3(2)(2) ;
				block3x3(2)(0) <= block3x3(2)(1) ;
				
				LINE1_input <= std_logic_vector(k12(7 downto 0)) ; -- shifting pixel to upper line fifo
				LINE2_input <= pixel_data_in ; -- shifting pixel to upper line fifo
				line_wr <= '1' ;
				
				new_block <= '1' ;
				pixel_state <= LOAD_VALUES1 ;
			elsif  hsync = '1' then
				block3x3(0)(0) <= (others => '0') ;
				block3x3(0)(1) <= (others => '0') ; -- zeroing matrix
				block3x3(0)(2) <= (others => '0') ;
	
				block3x3(1)(0) <= (others => '0') ;
				block3x3(1)(1) <= (others => '0') ;
				block3x3(1)(2) <= (others => '0') ;
	
				block3x3(2)(0) <= (others => '0') ;
				block3x3(2)(1) <= (others => '0') ;
				block3x3(2)(2) <= (others => '0') ;
				pixel_state <= LOAD_VALUES2 ;
			elsif vsync = '1' then
				block3x3(0)(0) <= (others => '0') ;
				block3x3(0)(1) <= (others => '0') ; -- zeroing matrix
				block3x3(0)(2) <= (others => '0') ;
	
				block3x3(1)(0) <= (others => '0') ;
				block3x3(1)(1) <= (others => '0') ;
				block3x3(1)(2) <= (others => '0') ;
	
				block3x3(2)(0) <= (others => '0') ;
				block3x3(2)(1) <= (others => '0') ;
				block3x3(2)(2) <= (others => '0') ;
			end if;
		when END_PIXEL => -- waiting for end of pixel
			new_block <= '0' ;
			line_wr <= '0' ;
			if pixel_clock = '0' then
				pixel_state <= WAIT_PIXEL ;
			elsif  hsync = '1' then
				pixel_state <= LOAD_VALUES2 ;
			end if;
		when END_HSYNC => -- waiting for end of pixel
			new_block <= '0' ;
			line_wr <= '0' ;
			if hsync = '0' then
				pixel_state <= WAIT_PIXEL ;
			end if;
		when others =>
			pixel_state <= WAIT_PIXEL ;
	end case ;
end if;
end process;




block_out <= block3x3 ;


end Behavioral;

