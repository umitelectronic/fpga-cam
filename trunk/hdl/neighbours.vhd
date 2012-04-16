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

entity neighbours is
		generic(LINE_SIZE : natural := 640);
		port(
			clk : in std_logic; 
			arazb, sraz : in std_logic; 
			add_neighbour, next_line : in std_logic; 
			neighbour_in : in unsigned(7 downto 0 );
			neighbours : out pix_neighbours);
end neighbours;

architecture Behavioral of neighbours is
type read_neighbour_state is (WRITE_VALUE, LOAD_VALUE, WAIT_NEIGHBOUR, WAIT_END_NEW_LINE);


signal pixel_state : read_neighbour_state ;

signal neighbours0 : pix_neighbours := ((others => '0'), (others => '0'), (others => '0'), (others => '0')); 
signal nl :	unsigned(7 downto 0) := (others => '0');
signal pixel_count, pixel_count_tp : std_logic_vector(9 downto 0) := (others => '0');
signal line_count : std_logic_vector(9 downto 0) := (others => '0');
signal line_addr : std_logic_vector(9 downto 0) ;

signal new_neighbour, next_neighbour: std_logic_vector(7 downto 0) := X"00";
signal nclk, first_line, neighbour_wr : std_logic;

signal pixel_counter_sraz : std_logic ;
begin

nclk <= NOT clk ;

line1: ram_Nx8
	generic map(N => LINE_SIZE + 2, A => 10)
	port map(
 		clk => nclk, 
 		we => neighbour_wr, en => '1' ,
 		do => next_neighbour,
 		di => new_neighbour,
 		addr => line_addr
	); 


pixel_count_tp <= pixel_count when neighbour_wr = '1' else
						pixel_count + 1 ;

line_addr <= pixel_count_tp when pixel_count_tp < LINE_SIZE else -- pixel count modulo 640
						 pixel_count_tp - LINE_SIZE ;

	

pixel_counter_sraz <= (next_line OR sraz) ;
	
pixel_counter0: pixel_counter
		generic map(POL => '0')
		port map(
			clk => clk,
			arazb => arazb, 
			pixel_clock => add_neighbour, hsync => pixel_counter_sraz,
			pixel_count => pixel_count
			);
			
line_counter0: line_counter
		port map(
			clk => clk,
			arazb => arazb, 
			hsync => next_line, vsync => sraz, 
			line_count => line_count
			);

			

-- actualize matrix with values
process(clk, arazb)
begin
if arazb = '0' then 
	neighbours0(0) <= (others => '0') ;
	neighbours0(1) <= (others => '0') ; -- zeroing neighbours
	neighbours0(2) <= (others => '0') ;
	neighbours0(3) <= (others => '0') ;
	neighbour_wr <= '0' ;
	nl <= (others => '0') ;
	pixel_state <= LOAD_VALUE ;
	first_line <= '1' ;
elsif clk'event and clk = '1' then
	if sraz = '1' then
		neighbours0(0) <= (others => '0') ;
		neighbours0(1) <= (others => '0') ; -- zeroing neighbours
		neighbours0(2) <= (others => '0') ;
		neighbours0(3) <= (others => '0') ;
		nl <= (others => '0') ;
		neighbour_wr <= '0' ;
		pixel_state <= LOAD_VALUE ;
		first_line <= '1' ;
	else
		case pixel_state is
			when WRITE_VALUE => -- load value from fifos into buffer
				neighbour_wr <= '0' ;
				pixel_state <= LOAD_VALUE ;
			when LOAD_VALUE => -- load value from fifos into buffer
				neighbour_wr <= '0' ;
				if first_line = '0' OR pixel_count > (LINE_SIZE - 2) then
					nl <= unsigned(next_neighbour) ;
				else
					nl <= (others => '0') ;
				end if;
				pixel_state <= WAIT_NEIGHBOUR ;
			when WAIT_NEIGHBOUR =>
				neighbour_wr <= '0' ;
				if add_neighbour = '1' then
					neighbours0(0) <=  neighbours0(1);
					neighbours0(1) <= neighbours0(2) ; -- shifting matrix to right
					neighbours0(2) <= nl ; -- from fifo
					neighbours0(3) <= neighbour_in ;
					
					new_neighbour <= std_logic_vector(neighbour_in) ; -- shifting left neighbour to upper line fifo
					neighbour_wr <= '1' ;
					pixel_state <= WRITE_VALUE ;
				elsif  next_line = '1' then
					pixel_state <= WAIT_END_NEW_LINE ;
				end if;
			when WAIT_END_NEW_LINE =>
				neighbour_wr <= '0' ;
				if  next_line = '0' then
					nl <=  unsigned(next_neighbour) ; -- loading next neighbour
					first_line <= '0' ;
					pixel_state <= LOAD_VALUE ;
				end if;
			when others =>
				pixel_state <= WAIT_NEIGHBOUR ;
		end case ;
	end if;
end if;
end process;


neighbours(0) <= neighbours0(0 ) when pixel_count > 0 else
					  X"00" ;
neighbours(1) <= neighbours0(1) ; -- always valid
neighbours(3) <= neighbours0(3) ;-- always valid
neighbours(2) <= X"00" when pixel_count > (LINE_SIZE - 2) else -- ul neighbour is zero when reaching end of line
					  neighbours0(2) ;

end Behavioral;

