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
			resetn, sraz : in std_logic; 
			add_neighbour, next_line : in std_logic; 
			neighbour_in : in unsigned(7 downto 0 );
			neighbours : out pix_neighbours);
end neighbours;

architecture Behavioral of neighbours is
type read_neighbour_state is (WRITE_VALUE, LOAD_VALUE, WAIT_NEIGHBOUR, WAIT_END_NEW_LINE);


signal pixel_state, next_pixel_state : read_neighbour_state ;

signal neighbours0 : pix_neighbours := ((others => '0'), (others => '0'), (others => '0'), (others => '0')); 
signal line_count : std_logic_vector(9 downto 0) := (others => '0');
signal line_addr : std_logic_vector(9 downto 0) ;
signal read_pixel_index, write_pixel_index : std_logic_vector(9 downto 0) ;

signal new_neighbour, next_neighbour: std_logic_vector(7 downto 0) := X"00";
signal nclk, first_line, neighbour_wr : std_logic;

signal en_read_pixel_index, load_read_pixel_index, sraz_read_pixel_index : std_logic ;
signal pixel_counter_sraz, en_write_pixel_index, sraz_write_pixel_index : std_logic ;
begin

nclk <= NOT clk ;

line1: ram_Nx8
	generic map(N => LINE_SIZE + 2, A => 10)
	port map(
 		clk => clk,  --worked with nclk, but messy ...
 		we => neighbour_wr, en => '1' ,
 		do => next_neighbour,
 		di => new_neighbour,
 		addr => line_addr
	); 


line_addr <= write_pixel_index when neighbour_wr = '1' else
				 read_pixel_index ;

	

pixel_counter_sraz <= (next_line OR sraz) ;
	
	
read_pixel_index0 : simple_counter 
	 generic map(NBIT => 10)
    port map( clk => clk,
           resetn => resetn,
           sraz => sraz_read_pixel_index ,
           en => en_read_pixel_index,
			  load => load_read_pixel_index,
			  E => std_logic_vector(to_unsigned(1, 10)),
           Q => read_pixel_index
			  );

sraz_read_pixel_index <= '1' when read_pixel_index = LINE_SIZE else
							    '0' ;
with pixel_state select
	en_read_pixel_index <= add_neighbour when WAIT_NEIGHBOUR,
								  '0' when others ;
	load_read_pixel_index <= sraz ;
	
	
write_pixel_index0 : simple_counter 
	 generic map(NBIT => 10)
    port map( clk => clk,
           resetn => resetn,
           sraz => sraz_write_pixel_index ,
           en => en_write_pixel_index,
			  load => '0',
			  E => std_logic_vector(to_unsigned(0, 10)),
           Q => write_pixel_index
			  );

sraz_write_pixel_index <= '1' when write_pixel_index = LINE_SIZE else
							     pixel_counter_sraz ;
with pixel_state select
	en_write_pixel_index <= '1' when LOAD_VALUE,
								  '0' when others ;
			
line_counter0: line_counter
		port map(
			clk => clk,
			resetn => resetn, 
			hsync => next_line, vsync => sraz, 
			line_count => line_count
			);
							

-- actualize matrix with values
process(clk, resetn)
begin
if resetn = '0' then 
	neighbours0(0) <= (others => '0') ;
	neighbours0(1) <= (others => '0') ; -- zeroing neighbours
	neighbours0(2) <= (others => '0') ;
	neighbours0(3) <= (others => '0') ;
	neighbour_wr <= '0' ;
	pixel_state <= WAIT_NEIGHBOUR ;
	first_line <= '1' ;
elsif clk'event and clk = '1' then
	if sraz = '1' then
		neighbours0(0) <= (others => '0') ;
		neighbours0(1) <= (others => '0') ; -- zeroing neighbours
		neighbours0(2) <= (others => '0') ;
		neighbours0(3) <= (others => '0') ;
		neighbour_wr <= '0' ;
		pixel_state <= WAIT_NEIGHBOUR ;
		first_line <= '1' ;
	else
		case pixel_state is
			when WRITE_VALUE => -- load value from fifos into buffer
				neighbour_wr <= '0' ;
				pixel_state <= LOAD_VALUE ;
			when LOAD_VALUE => -- load value from fifos into buffer
				neighbour_wr <= '0' ;
				pixel_state <= WAIT_NEIGHBOUR ;
			when WAIT_NEIGHBOUR =>
				neighbour_wr <= '0' ;
				if add_neighbour = '1' then
					neighbours0(0) <=  neighbours0(1);
					neighbours0(1) <= neighbours0(2) ; -- shifting matrix to right
					if first_line = '0' OR write_pixel_index > (LINE_SIZE - 2) then
						neighbours0(2) <= unsigned(next_neighbour) ;
					else
						neighbours0(2) <= (others => '0') ;
					end if;
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
					first_line <= '0' ;
					pixel_state <= WAIT_NEIGHBOUR ;
				end if;
			when others =>
				pixel_state <= WAIT_NEIGHBOUR ;
		end case ;
	end if;
end if;
end process;








neighbours(0) <= neighbours0(0 ) when write_pixel_index > 0 else
					  X"00" ;
neighbours(1) <= neighbours0(1) ; -- always valid
neighbours(3) <= neighbours0(3) ;-- always valid
neighbours(2) <= X"00" when write_pixel_index > (LINE_SIZE - 2) else -- ul neighbour is zero when reaching end of line
					  neighbours0(2) ;

end Behavioral;

