----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    11:45:31 03/14/2012 
-- Design Name: 
-- Module Name:    blob_detection - Behavioral 
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
use ieee.math_real.log2;
use ieee.math_real.ceil;

library work;
use work.camera.all ;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;
-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity blob_detection is
generic(LINE_SIZE : natural := 640; MAX_BLOB : natural := 8);
port(
 		clk : in std_logic; 
 		arazb: in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_data_in : in std_logic_vector(7 downto 0 );
		big_blob_posx, big_blob_posy : out unsigned(9 downto 0)
		);
end blob_detection;

architecture Behavioral of blob_detection is


type blob_states is (WAIT_VSYNC, WAIT_HSYNC, WAIT_PIXEL, COMPARE_PIXEL, ADD_TO_BLOB, END_PIXEL) ;

signal blob_state0 : blob_states ;
signal pixel_x, pixel_y : unsigned(9 downto 0);
signal nb_blob : unsigned(7 downto 0) := (others => '0');
signal last_hsync, last_pxclk : std_logic := '0';
signal sraz_neighbours, sraz_blobs : std_logic ;
signal neighbours0 : pix_neighbours;
signal new_line, add_neighbour, add_pixel : std_logic ;
signal current_pixel : std_logic_vector(7 downto 0) ;
signal current_blob : unsigned(7 downto 0) ;
signal big_blob_posx_tp, big_blob_posy_tp :unsigned(9 downto 0) ;

begin


blobs0 : blobs
	generic map(NB_BLOB => MAX_BLOB)
	port map(
		clk => clk, arazb => arazb, sraz => sraz_blobs,
		blob_index => current_blob,
		blob_index_to_merge => (others => '0') ,
		get_blob => '0' ,
		merge_blob => '0',
		add_pixel => add_pixel,
		pixel_posx => pixel_x, pixel_posy => pixel_y,
		max_blob_centerx => big_blob_posx_tp, max_blob_centery => big_blob_posy_tp
	);

update_neighbours : neighbours
		generic map(LINE_SIZE => LINE_SIZE )
		port map(
			clk => clk, 
			arazb => arazb , sraz => sraz_neighbours, 
			add_neighbour => add_neighbour, next_line => new_line,  
			neighbour_in => current_blob,
			neighbours => neighbours0);


process(clk, arazb)
begin
if arazb = '0' then
	nb_blob <= (others => '0');
	blob_state0 <= WAIT_VSYNC ;
elsif clk'event and clk = '1' then
	case blob_state0 is
		when WAIT_VSYNC =>
			sraz_neighbours <= '1' ;
			sraz_blobs <= '0' ;
			add_neighbour <= '0' ;
			add_pixel <= '0';
			if vsync = '0' then
				sraz_blobs <= '1' ;
				nb_blob <= (others => '0');
				blob_state0 <= WAIT_HSYNC ;
			end if;
		when WAIT_HSYNC =>
			sraz_neighbours <= '0' ;
			sraz_blobs <= '0' ;
			add_neighbour <= '0' ;
			add_pixel <= '0';
			if vsync = '1' then
				big_blob_posx <= big_blob_posx_tp ;
				big_blob_posy <= big_blob_posy_tp ;
				blob_state0 <= WAIT_VSYNC ;
			elsif hsync = '0' then
				blob_state0 <= WAIT_PIXEL ;
			end if;
		when WAIT_PIXEL =>
			sraz_neighbours <= '0' ;
			sraz_blobs <= '0' ;
			add_neighbour <= '0' ;
			add_pixel <= '0';
			new_line <= '0' ;
			if pixel_clock =  '1' and hsync = '0' and vsync = '0' then
				if pixel_data_in /= X"00" then
					current_pixel <= pixel_data_in ;
					blob_state0 <= COMPARE_PIXEL ;
				else
					current_blob <= (others => '0') ;
					blob_state0 <= ADD_TO_BLOB ;
				end if;
			elsif hsync = '1' then
				new_line <= '1' ;
				blob_state0 <= WAIT_HSYNC ;
			elsif vsync = '1' then
				big_blob_posx <= big_blob_posx_tp ;
				big_blob_posy <= big_blob_posy_tp ;
				blob_state0 <= WAIT_VSYNC ;
			end if;
		when COMPARE_PIXEL =>
			sraz_neighbours <= '0' ;
			sraz_blobs <= '0' ;
			add_neighbour <= '0' ;
			add_pixel <= '0';
			new_line <= '0' ;
			if neighbours0 (0) /= X"00" then
				current_blob <= neighbours0 (0) ;
			elsif neighbours0 (1) /= X"00" then
				current_blob <= neighbours0 (1) ;
			elsif neighbours0 (2) /= X"00" then
				current_blob <= neighbours0 (2) ;
			elsif neighbours0 (3) /= X"00" then
				current_blob <= neighbours0 (3) ;
			else
				current_blob <= nb_blob + 1;
				nb_blob <= nb_blob + 1 ;
			end if ;
			blob_state0 <= ADD_TO_BLOB ;
		when ADD_TO_BLOB => 
			sraz_neighbours <= '0' ;
			sraz_blobs <= '0' ;
			add_neighbour <= '1' ;
			new_line <= '0' ;
			if current_blob /= X"00" then
				add_pixel <= '1';
			else
				add_pixel <= '0';
			end if;
			blob_state0 <= END_PIXEL ;
		when END_PIXEL =>
			sraz_neighbours <= '0' ;
			sraz_blobs <= '0' ;
			add_neighbour <= '0' ;
			add_pixel <= '0';
			new_line <= '0' ;
			if pixel_clock =  '0' then
				blob_state0 <= WAIT_PIXEL ;
			end if;
		when others => 
			sraz_neighbours <= '0' ;
			sraz_blobs <= '0' ;
			add_neighbour <= '0' ;
			add_pixel <= '0';
			new_line <= '0' ;
			blob_state0 <= WAIT_PIXEL ;
	end case;
end if;
end process;

process(clk, arazb)
begin
	if arazb = '0' then
		pixel_x <= (others => '0');
		pixel_y <= (others => '0');
	elsif clk'event and clk = '1' then
		if vsync = '1' then
			pixel_x <= (others => '0');
			pixel_y <= (others => '0');
		elsif hsync = '1' and last_hsync /= hsync then
			pixel_x <= (others => '0');
			pixel_y <= pixel_y + 1 ;
		elsif last_pxclk /= pixel_clock and pixel_clock = '0' and hsync = '0' then --increasing on falling edge of clock
			pixel_x <= pixel_x + 1;
		end if;
		last_hsync <= hsync ;
		last_pxclk <= pixel_clock ;
	end if;
end process ;




end Behavioral;

