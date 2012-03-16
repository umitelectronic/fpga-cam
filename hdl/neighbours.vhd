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
type read_neighbour_state is (LOAD_VALUE1, LOAD_VALUE2, WAIT_NEIGHBOUR, WAIT_END_NEW_LINE);


signal pixel_state : read_neighbour_state ;

signal neighbours0 : pix_neighbours := ((others => '0'), (others => '0'), (others => '0'), (others => '0')); 
signal nl :	unsigned(7 downto 0) := (others => '0');
signal pixel_count : unsigned(9 downto 0) := (others => '0');

signal fifo_wr, fifo_rd, fifo_empty, fifo_rdy, sraz_fifo: std_logic ;


signal FIFO_INPUT, FIFO_OUTPUT: std_logic_vector(7 downto 0) := X"00";
signal first_line : std_logic;
begin

linefifo0 : fifo_Nx8
	generic map(N => LINE_SIZE + 5) -- fifo gets full a bit too fast
	port map(
	clk => clk, 
	arazb => arazb,
	sraz => sraz_fifo,
	wr => fifo_wr , 
	rd => fifo_rd, 
	empty => fifo_empty , data_rdy => fifo_rdy,
	data_out => FIFO_OUTPUT,  
	data_in => FIFO_INPUT
); 


-- actualize matrix with values
process(clk, arazb)
begin
if arazb = '0' then 
	neighbours0(0) <= (others => '0') ;
	neighbours0(1) <= (others => '0') ; -- zeroing neighbours
	neighbours0(2) <= (others => '0') ;
	neighbours0(3) <= (others => '0') ;
	FIFO_wr <= '0' ;
	FIFO_rd <= '0' ;
	nl <= (others => '0') ;
	pixel_state <= LOAD_VALUE1 ;
	first_line <= '1' ;
	sraz_fifo <= '1' ;
	pixel_count <= (others => '0');
elsif clk'event and clk = '1' then
	if sraz = '1' then
		neighbours0(0) <= (others => '0') ;
		neighbours0(1) <= (others => '0') ; -- zeroing neighbours
		neighbours0(2) <= (others => '0') ;
		neighbours0(3) <= (others => '0') ;
		FIFO_wr <= '0' ;
		FIFO_rd <= '0' ;
		nl <= (others => '0') ;
		pixel_state <= LOAD_VALUE1 ;
		first_line <= '1' ;
		sraz_fifo <= '1' ;
		pixel_count <= (others => '0');
	else
		sraz_fifo <= '0' ;
		case pixel_state is
			when LOAD_VALUE1 => -- load value from fifos into buffer
				FIFO_wr <= '0' ;
				if first_line = '0' OR pixel_count > (LINE_SIZE - 2) then
					FIFO_rd <= '1' ;
				else
					FIFO_rd <= '0' ;
				end if;
				pixel_state <= LOAD_VALUE2 ;
			when LOAD_VALUE2  =>
				FIFO_wr <= '0' ;
				FIFO_rd <= '0' ;
				if first_line = '0' OR pixel_count > (LINE_SIZE - 2) then
					if fifo_rdy =  '1' then 
						nl <= unsigned(FIFO_OUTPUT) ;
						pixel_state <= WAIT_NEIGHBOUR ;
					end if ;
				else 
					nl <= (others => '0') ;
					pixel_state <= WAIT_NEIGHBOUR ;
				end if;
			when WAIT_NEIGHBOUR =>
				FIFO_wr <= '0' ;
				FIFO_rd <= '0' ;
				if add_neighbour = '1' then
					neighbours0(0) <=  neighbours0(1);
					neighbours0(1) <= neighbours0(2) ; -- shifting matrix to right
					neighbours0(2) <= nl ; -- from fifo
					neighbours0(3) <= neighbour_in ;
					
					FIFO_input <= std_logic_vector(neighbour_in) ; -- shifting left neighbour to upper line fifo
					FIFO_wr <= '1' ;
					pixel_state <= LOAD_VALUE1 ;
					
					pixel_count <= pixel_count + 1 ;
				elsif  next_line = '1' then
					pixel_state <= WAIT_END_NEW_LINE ;
				end if;
			when WAIT_END_NEW_LINE =>
				if  next_line = '0' then
					neighbours0(0) <=  (others => '0');
					neighbours0(1) <= neighbours0(2) ; 
					neighbours0(2) <= nl ; 
					neighbours0(3) <= (others => '0') ;
					neighbours0(3) <= (others => '0') ;

					pixel_count <= (others => '0');
					first_line <= '0' ;
					pixel_state <= WAIT_NEIGHBOUR ;
				end if;
			when others =>
				pixel_state <= WAIT_NEIGHBOUR ;
		end case ;
	end if;
end if;
end process;



neighbours(0 to 1) <= neighbours0(0 to 1) ; -- always valid
neighbours(3) <= neighbours0(3) ;-- always valid
neighbours(2) <= X"00" when pixel_count > (LINE_SIZE - 2) else -- ul neighbour is zero when reaching end of line
					  neighbours0(2) ;

end Behavioral;

