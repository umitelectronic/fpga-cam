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
generic(LINE_SIZE : natural := 640);
port(
 		clk : in std_logic; 
 		resetn: in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic;
 		pixel_data_in : in std_logic_vector(7 downto 0 );
		blob_data : out std_logic_vector(7 downto 0);
		send_blob : out std_logic
		);
end blob_detection;

architecture Behavioral of blob_detection is


type blob_states is (WAIT_VSYNC, WAIT_HSYNC, WAIT_PIXEL, COMPARE_PIXEL, ADD_TO_BLOB, ADD_NEW_BLOB, END_PIXEL) ;

signal blob_state0 : blob_states ;
signal pixel_x, pixel_y : std_logic_vector(9 downto 0);
signal hsync_old, pixel_clock_old : std_logic := '0';
signal sraz_neighbours, sraz_blobs : std_logic ;
signal neighbours0 : pix_neighbours;
signal new_line, add_neighbour, add_pixel, merge_blob, new_blob, oe_blob : std_logic ;
signal current_pixel : std_logic_vector(7 downto 0) ;
signal new_blob_index, current_blob, blob_index_to_merge, true_blob_index : unsigned(7 downto 0) ;

begin


blobs0 : blobs
	port map(
		clk => clk, resetn => resetn, sraz => sraz_blobs,
		blob_index => current_blob,
		next_blob_index => new_blob_index,
		blob_index_to_merge => blob_index_to_merge ,
		true_blob_index => true_blob_index,
		merge_blob => merge_blob,
		new_blob => new_blob, 
		add_pixel => add_pixel,
		pixel_posx => unsigned(pixel_x), pixel_posy => unsigned(pixel_y),
		
		blob_data => blob_data ,
		oe => oe_blob ,
		send_blob => send_blob
	);

update_neighbours : neighbours
		generic map(LINE_SIZE => LINE_SIZE )
		port map(
			clk => clk, 
			resetn => resetn , sraz => sraz_neighbours, 
			add_neighbour => add_neighbour, next_line => new_line,  
			neighbour_in => current_blob,
			neighbours => neighbours0);
			
pixel_counter0: pixel_counter
		port map(
			clk => clk,
			resetn => resetn, 
			pixel_clock => pixel_clock, hsync => hsync,
			pixel_count => pixel_x
			);
			
line_counter0: line_counter
		port map(
			clk => clk,
			resetn => resetn, 
			hsync => hsync, vsync => vsync, 
			line_count => pixel_y
			);

with blob_state0 select 
	oe_blob <= '1' when WAIT_VSYNC ,
				  '0' when others ;

process(clk, resetn)
begin
if resetn = '0' then
	add_neighbour <= '0' ;
	blob_state0 <= WAIT_VSYNC ;
elsif clk'event and clk = '1' then
	case blob_state0 is
		when WAIT_VSYNC =>
			add_neighbour <= '0' ;
			add_pixel <= '0';
			merge_blob <= '0' ;
			new_blob <= '0' ;
			if vsync = '0' and  hsync = '0' then
				blob_state0 <= WAIT_PIXEL ;
			end if;
		when WAIT_HSYNC =>
			add_neighbour <= '0' ;
			add_pixel <= '0';
			merge_blob <= '0' ;
			new_blob <= '0' ;
			if vsync = '1' then
				blob_state0 <= WAIT_VSYNC ;
			elsif hsync = '0' then
				blob_state0 <= WAIT_PIXEL ;
			end if;
		when WAIT_PIXEL =>
			add_neighbour <= '0' ;
			add_pixel <= '0';
			merge_blob <= '0' ;
			new_blob <= '0' ;
			if pixel_clock =  '1' and hsync = '0' and vsync = '0' then
				if pixel_data_in /= X"00" and pixel_x > 3 and pixel_y > 3 and  pixel_x < LINE_SIZE - 3 and pixel_y < 480 - 3 then
					current_pixel <= pixel_data_in ;
					blob_state0 <= COMPARE_PIXEL ;
				else
					current_blob <= (others => '0') ;
					blob_state0 <= ADD_TO_BLOB ;
				end if;
			elsif hsync = '1' then
				blob_state0 <= WAIT_HSYNC ;
			elsif vsync = '1' then
				blob_state0 <= WAIT_VSYNC ;
			end if;
		when COMPARE_PIXEL =>
			add_neighbour <= '0' ;
			add_pixel <= '0';
			merge_blob <= '0' ;
			new_blob <= '0' ;
			if neighbours0 (2) /= X"00" then
				current_blob <= neighbours0 (2) ;
				blob_state0 <= ADD_TO_BLOB ;
			elsif neighbours0 (0) /= X"00" then
				current_blob <= neighbours0 (0) ;
				blob_state0 <= ADD_TO_BLOB ;
			elsif neighbours0 (1) /= X"00" then
				current_blob <= neighbours0 (1) ;
				blob_state0 <= ADD_TO_BLOB ;
			elsif neighbours0 (3) /= X"00" then
				current_blob <= neighbours0 (3) ;
				blob_state0 <= ADD_TO_BLOB ;
			else 
				current_blob <= new_blob_index; -- getting new blob index from blobs
				blob_state0 <= ADD_NEW_BLOB ;
			end if ; 
		when ADD_TO_BLOB =>
			add_neighbour <= '1' ;
			if current_blob /= X"00" then
				add_pixel <= '1';
				if neighbours0(3)/=X"00" and neighbours0(3) /= current_blob then -- left pixel and upper right pixel are different, merge
					blob_index_to_merge <= neighbours0(3) ;
					merge_blob <= '1' ;
				end if ;
			else
				add_pixel <= '0';
				merge_blob <= '0' ;
			end if;
			blob_state0 <= END_PIXEL ;
		when ADD_NEW_BLOB =>
			add_neighbour <= '1' ;
			merge_blob <= '0' ;
			add_pixel <= '1';
			new_blob <= '1' ;
			blob_state0 <= END_PIXEL ;
		when END_PIXEL =>
			add_neighbour <= '0' ;
			add_pixel <= '0';
			merge_blob <= '0' ;
			new_blob <= '0' ;
			if pixel_clock =  '0' then
				blob_state0 <= WAIT_PIXEL ;
			end if;
		when others => 
			merge_blob <= '0' ;
			add_pixel <= '0';
			new_blob <= '0' ;
			blob_state0 <= WAIT_PIXEL ;
	end case;
end if;
end process;
	
						  
with blob_state0 select
	sraz_blobs <= vsync when WAIT_PIXEL ,
					  vsync when WAIT_HSYNC ,
						  '0' when others ;						  

with blob_state0 select
	new_line <= hsync when WAIT_PIXEL ,
				   '0' when others ;		

with blob_state0 select
	sraz_neighbours <= '1' when WAIT_VSYNC,
							 '0' when others ;


end Behavioral;

