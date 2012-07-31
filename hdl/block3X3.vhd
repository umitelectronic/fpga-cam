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

entity block3X3 is
		generic(LINE_SIZE : natural := 640);
		port(
			clk : in std_logic; 
			resetn : in std_logic; 
			pixel_clock, hsync, vsync : in std_logic; 
			pixel_data_in : in std_logic_vector(7 downto 0 ); 
			new_block : out std_logic ;
			block_out : out mat3);
end block3X3;

architecture Behavioral of block3X3 is
type read_pixel_state is (LOAD_VALUES1, LOAD_VALUES2, WAIT_PIXEL, END_PIXEL, END_HSYNC);
type hsync_state is	(WAIT_HSYNC, END_HSYNC);


signal pixel_state : read_pixel_state ;
signal hsync_state0 : hsync_state ;

signal block3x3 : mat3 := (((others => '0'), (others => '0'), (others => '0')), 
									((others => '0'), (others => '0'), (others => '0')), 
									((others => '0'), (others => '0'), (others => '0')));

signal k02, k12 :	signed(8 downto 0) := (others => '0');


signal fifo1_wr, fifo1_rd, fifo1_empty, fifo1_rdy, fifo2_wr, fifo2_rd, fifo2_empty, fifo2_rdy, sraz_fifo: std_logic ;


signal FIFO1_INPUT, FIFO1_OUTPUT, FIFO2_INPUT, FIFO2_OUTPUT : std_logic_vector(7 downto 0) := X"00";
signal final_res : signed(31 downto 0);
signal nb_line, nb_pixel : std_logic_vector(3 downto 0) := (others => '0');
begin

linefifo1 : fifo_Nx8
	generic map(N => LINE_SIZE + 5) -- fifo gets full a bit too fast
	port map(
	clk => clk,
	resetn => resetn,
	sraz => sraz_fifo,
	wr => fifo1_wr , 
	rd => fifo1_rd, 
	empty => fifo1_empty , data_rdy => fifo1_rdy,
	data_out => FIFO1_OUTPUT,  
	data_in => FIFO1_INPUT
); 

linefifo2 : fifo_Nx8
	generic map(N => LINE_SIZE + 5) -- fifo gets full a bit too fast
	port map(
	clk => clk, 
	resetn => resetn,
	sraz => sraz_fifo,
	wr => fifo2_wr , 
	rd => fifo2_rd, 
	empty => fifo2_empty , data_rdy => fifo2_rdy,
	data_out => FIFO2_OUTPUT,  
	data_in => FIFO2_INPUT
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
	FIFO2_wr <= '0' ;
	FIFO1_wr <= '0' ;
	FIFO2_rd <= '0' ;
	FIFO1_rd <= '0' ;
	k02 <= (others => '0') ;
	k12 <= (others => '0') ;
	nb_pixel <= (others => '0') ;
	pixel_state <= LOAD_VALUES1 ;
elsif clk'event and clk = '1' then
	case pixel_state is
		when LOAD_VALUES1 => -- load value from fifos into buffer
			new_block <= '0' ;
			FIFO2_wr <= '0' ;
			FIFO1_wr <= '0' ;
			FIFO2_rd <= '0' ;
			FIFO1_rd <= '0' ;
			if nb_line > 0 then
				FIFO2_rd <= '1' ;
				FIFO1_rd <= '1' ;
			end if;
			pixel_state <= LOAD_VALUES2 ;
		when LOAD_VALUES2  =>
			new_block <= '0' ;
			FIFO2_wr <= '0' ;
			FIFO1_wr <= '0' ;
			FIFO2_rd <= '0' ;
			FIFO1_rd <= '0' ;
			if nb_line > 0 then
				if fifo2_rdy =  '1' and fifo1_rdy =  '1' then -- just hope two fifo are synchronize (should be ...)
					k12 <= signed('0' & FIFO2_OUTPUT) ;
					k02 <= signed('0' & FIFO1_OUTPUT) ;
					if hsync = '1' then
						pixel_state <= END_HSYNC ;
					else
						pixel_state <= END_PIXEL ;
					end if ;
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
			FIFO2_wr <= '0' ;
			FIFO1_wr <= '0' ;
			FIFO2_rd <= '0' ;
			FIFO1_rd <= '0' ;
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
				
				FIFO1_input <= std_logic_vector(block3x3(1)(2)(7 downto 0)) ; -- shifting pixel to upper line fifo
				FIFO1_wr <= '1' ;
				FIFO2_input <= pixel_data_in ; -- shifting pixel to upper line fifo
				FIFO2_wr <= '1' ;
				
				new_block <= '1' ;
				if nb_pixel < 3 then
					nb_pixel <= nb_pixel + 1 ;
				end if ;
				pixel_state <= LOAD_VALUES1 ;
			elsif  hsync = '1' then
				nb_pixel <= (others => '0') ;
				pixel_state <= LOAD_VALUES1 ;
			elsif vsync = '1' then
				nb_pixel <= (others => '0') ;
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
			FIFO2_wr <= '0' ;
			FIFO1_wr <= '0' ;
			FIFO2_rd <= '0' ;
			FIFO1_rd <= '0' ;
			if pixel_clock = '0' then
				pixel_state <= WAIT_PIXEL ;
			elsif  hsync = '1' then
				pixel_state <= LOAD_VALUES1 ;
			end if;
		when END_HSYNC => -- waiting for end of pixel
			new_block <= '0' ;
			FIFO2_wr <= '0' ;
			FIFO1_wr <= '0' ;
			FIFO2_rd <= '0' ;
			FIFO1_rd <= '0' ;
			if hsync = '0' then
				pixel_state <= WAIT_PIXEL ;
			end if;
		when others =>
			pixel_state <= WAIT_PIXEL ;
	end case ;
end if;
end process;


process(clk, resetn)
begin
if resetn = '0' then 
	nb_line <= (others => '0') ;
	hsync_state0 <= WAIT_HSYNC ;
elsif clk'event and clk = '1'  then
	case hsync_state0 is
		when WAIT_HSYNC =>
			sraz_fifo <= '0' ;
			if hsync = '1' then
				if nb_line < 3 then
					nb_line <= nb_line + 1 ;
				end if;
				hsync_state0 <= END_HSYNC ;
			end if ;
		when END_HSYNC =>
			if vsync = '1' then
				nb_line <= (others => '0') ;
				sraz_fifo <= '1' ;
			else
				sraz_fifo <= '0' ;
				if hsync = '0' then
					hsync_state0 <= WAIT_HSYNC ;
				end if ;
			end if;
		when others =>
			nb_line <= (others => '0') ;
			hsync_state0 <= WAIT_HSYNC ;
	end case ;
end if;
end process;


block_out(0)(2) <= block3x3(0)(2) ;
block_out(1)(2) <= block3x3(1)(2) ;
block_out(2)(2) <= block3x3(2)(2) ;

block_out(0)(1) <= block3x3(0)(1) when nb_pixel > 2 else (others => '0'); -- edges
block_out(1)(1) <= block3x3(1)(1) when nb_pixel > 2 else (others => '0'); -- edges
block_out(2)(1) <= block3x3(2)(1) when nb_pixel > 2 else (others => '0'); -- edges

block_out(0)(0) <= block3x3(0)(0) when nb_pixel > 2 else (others => '0'); -- edges
block_out(1)(0) <= block3x3(1)(0) when nb_pixel > 2 else (others => '0'); -- edges
block_out(2)(0) <= block3x3(2)(0) when nb_pixel > 2 else (others => '0'); -- edges

end Behavioral;

