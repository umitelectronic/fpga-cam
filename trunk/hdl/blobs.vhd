----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    12:26:44 03/14/2012 
-- Design Name: 
-- Module Name:    blobs - Behavioral 
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

library work ;
use work.camera.all ;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity blobs is
	port(
		clk, arazb, sraz : in std_logic ;
		blob_index : in unsigned(7 downto 0);
		next_blob_index : out unsigned(7 downto 0);
		blob_index_to_merge : in unsigned(7 downto 0);
		true_blob_index : out unsigned(7 downto 0);
		add_pixel : in std_logic ;
		new_blob : in std_logic ;
		
		merge_blob : in std_logic ;
		pixel_posx, pixel_posy : in unsigned(9 downto 0);
		
		
		--output interface
		xmin, xmax, ymin, ymax : out unsigned(9 downto 0);
		get_blob	:	in std_logic := '0';
		blob_addr : in std_logic_vector(7 downto 0) := X"00"
	);
 
end blobs;


architecture Behavioral of blobs is
type PIXEL_ADD_MAE is (INIT_BLOB, WAIT_PIXEL, READ_BLOB, COMPARE_BLOB, NEW_BLOB1, MERGE_BLOB1, MERGE_BLOB2, MERGE_BLOB3,  UPDATE_BLOB);
type FRAME_MAE is (FRAME_RUNNING, READ_BLOB, OUTPUT_BLOB, WAIT_NEW_FRAME);
signal pixel_state : PIXEL_ADD_MAE ;
signal frame_state : FRAME_MAE ;
signal ram0_out, ram0_in : std_logic_vector(47 downto 0);
signal blobxmin, blobxmax, blobymin, blobymax, newxmin, newxmax, newymin, newymax : unsigned(9 downto 0);
signal ram_addr, ram_addr_tp, free_addr, blob_merge_addr : std_logic_vector(7 downto 0);
signal ram_en, ram_wr, index_wr : std_logic ;
signal blob_index_init, blob_index_tp: unsigned(7 downto 0);
signal index_in : unsigned(7 downto 0);
signal current_blob_centerx, current_blob_centery : unsigned(9 downto 0) := (others => '0') ;
signal addx, addy, subx, suby : unsigned(10 downto 0) := (others => '0');
signal max_blob_height, max_blob_width : unsigned(10 downto 0) := (others => '0');
signal nclk, to_merge : std_logic ;
signal nb_free_index : unsigned (7 downto 0);
signal next_blob_index_tp : unsigned (7 downto 0);
signal blob_area, blob_max_area : unsigned(20 downto 0);
signal pos_index : unsigned(7 downto 0);
begin 

nclk <= NOT clk ;

blobxmin <= unsigned(ram0_out(9 downto 0)) ; -- top left coordinate
blobxmax <= unsigned(ram0_out(19 downto 10)) ; -- top right coordinate

blobymin <= unsigned(ram0_out(29 downto 20)) ; -- bottom left coordinate
blobymax <= unsigned(ram0_out(39 downto 30)) ; -- bottom right coordinate
 
 
blob_area <=  subx * suby ;

addx <=  ('0' &  newxmin) + ('0' &  newxmax) ;
addy <=  ('0' &  newymin) + ('0' &  newymax) ;

subx <=   ('0' &  newxmax) - ('0' &  newxmin);
suby <=  ('0' &  newymax) - ('0' &  newymin) ;

current_blob_centerx <=  addx(10 downto 1) ;
current_blob_centery <=  addy(10 downto 1) ;

next_blob_index <= next_blob_index_tp when nb_free_index > 0 else -- no more free index ...
						 X"00";
						
 
pos_index <= blob_index when blob_index = X"00" else
				 blob_index - 1 ;
with pixel_state select
	blob_index_tp <= blob_index_init when INIT_BLOB,
						  (blob_index_to_merge - 1) when MERGE_BLOB1  ,
						  (blob_index_to_merge - 1) when MERGE_BLOB2  ,
						  ((next_blob_index_tp - 1) + nb_free_index) when MERGE_BLOB3  ,
						  (pos_index) when others;

ram_addr_tp <= ram_addr when get_blob = '0' else
					blob_addr ;

true_blob_index <= unsigned(ram_addr) ; 

blob_index_ram :ram_NxN
	generic map(SIZE => 256 , NBIT => 8, ADDR_WIDTH => 8)
	port map(
 		clk => nclk, -- was using nclk but caused timing problem ... must check how it works.
 		we => index_wr, en => '1',
 		do => ram_addr ,
 		di => std_logic_vector(index_in),  
 		addr => std_logic_vector(blob_index_tp)
	); 

xy_pixel_ram0: ram_NxN
	generic map(SIZE => 32 , NBIT => 48, ADDR_WIDTH => 8)
	port map(
 		clk => clk, 
 		we => ram_wr, en => ram_en,
 		do => ram0_out ,
 		di => ram0_in,  
 		addr => ram_addr_tp
	); 
	 --blob_add
	process(clk, arazb)
	begin
	if arazb = '0' then
		blob_index_init <= (others => '0');
		index_in <= (others => '0');
		to_merge <= '0' ;
		pixel_state <= INIT_BLOB ;
		next_blob_index_tp <= (others => '0');
		nb_free_index <= (others => '0');
	elsif clk'event and clk = '1' then
		if sraz = '1' then
			to_merge <= '0' ;
			max_blob_width <= (others => '0');
			max_blob_height <= (others => '0');
			
			
			blob_index_init <= (others => '0'); -- initializing index ram 
			index_in <= (others => '0');
			index_wr <= '1' ;
			to_merge <= '0' ;
			ram_wr <= '0' ;
			ram_en <= '0' ;
			
			blob_max_area <= (others => '0');
			
			pixel_state <= INIT_BLOB ;
		else
			case pixel_state is
				when INIT_BLOB =>
					blob_max_area <= (others => '0');
					index_in <= index_in + 1 ;
					blob_index_init <= blob_index_init + 1 ;
					ram_wr <= '0' ;
					ram_en <= '0' ;
					index_wr <= '1' ;
					to_merge <= '0' ;
					if index_in = 31 then
						index_in <= (others => '0');
						next_blob_index_tp <= X"01" ; -- index starts at 1
						nb_free_index <= to_unsigned(32, 8); -- all index are free to use
						pixel_state <= WAIT_PIXEL ;
					end if;
				when WAIT_PIXEL =>
					ram_wr <= '0' ;
					ram_en <= '0' ;
					index_wr <= '0' ;
					to_merge <= '0' ;
					if add_pixel = '1' then
						if new_blob = '1' then
							pixel_state <= NEW_BLOB1 ;
						else
							if merge_blob = '1' then
								to_merge <= '1' ;
							else
								to_merge <= '0' ;
							end if ;
							ram_en <= '1' ;
							pixel_state <= COMPARE_BLOB ;
						end if ;
					end if ;
				when COMPARE_BLOB =>
					ram_en <= '1' ;
					ram_wr <= '0' ;
					index_wr <= '0' ;
					if pixel_posx < blobxmin then
						newxmin <= pixel_posx ;
					else
						newxmin <= blobxmin ;
					end if;
					if pixel_posx > blobxmax then
						newxmax <= pixel_posx ;
					else
						newxmax <= blobxmax ;
					end if;
					if pixel_posy < blobymin then
						newymin <= pixel_posy ;
					else
						newymin <= blobymin ;
					end if; 
					if pixel_posy > blobymax then
						newymax <= pixel_posy ;
					else
						newymax <= blobymax ;
					end if;
					if to_merge = '1' then
						pixel_state <= MERGE_BLOB1 ;
						blob_merge_addr <= ram_addr ;
					else
						pixel_state <= UPDATE_BLOB ;
					end if ;
				when MERGE_BLOB1 =>
					ram_en <= '1' ;
					ram_wr <= '0' ;
					index_wr <= '0' ;
					to_merge <= '0' ;
					if blobxmin < newxmin then
						newxmin <= blobxmin ;
					end if;
					if blobxmax > newxmax then
						newxmax <= blobxmax ;
					end if;
					if blobymin < newymin then
						newymin <= blobymin ;
					end if; 
					if blobymax > newymax then
						newymax <= blobymax ;
					end if;
					free_addr <= ram_addr ;
					if blob_merge_addr /= ram_addr then
						index_in <= unsigned(blob_merge_addr) ; -- index now point to new memory location
						free_addr <= ram_addr ;
						index_wr <= '1' ;
						pixel_state <= MERGE_BLOB2 ;
					else
						index_wr <= '0' ;
						pixel_state <= UPDATE_BLOB ;
					end if;
				when MERGE_BLOB2 =>
					ram_en <= '1' ;
					ram_wr <= '0' ;
					index_wr <= '1' ;
					index_in <= unsigned(free_addr) ; -- writing free addr to index table
					pixel_state <= MERGE_BLOB3 ;
				when MERGE_BLOB3 =>
					ram_en <= '1' ;
					ram_wr <= '0' ;
					index_wr <= '0' ;
					nb_free_index <= nb_free_index + 1 ;
					pixel_state <= UPDATE_BLOB ;
				when NEW_BLOB1 =>
					newxmin <= pixel_posx ;
					newxmax <= pixel_posx ;
					newymin <= pixel_posy ;
					newymax <= pixel_posy ;
					ram_en <= '0' ;
					ram_wr <= '0' ;
					index_wr <= '0' ;
					if nb_free_index > 0 then
						nb_free_index <= nb_free_index - 1 ;
						next_blob_index_tp <= next_blob_index_tp + 1 ;
					end if ;
					pixel_state <= UPDATE_BLOB ;
				when UPDATE_BLOB =>
					ram0_in(9 downto 0) <= std_logic_vector(newxmin) ;
					ram0_in(19 downto 10) <= std_logic_vector(newxmax) ;
					ram0_in(29 downto 20) <= std_logic_vector(newymin) ;
					ram0_in(39 downto 30) <= std_logic_vector(newymax) ;
					ram_en <= '1' ;
					ram_wr <= '1' ;
					index_wr <= '0' ;
					if add_pixel = '0' then
						pixel_state <= WAIT_PIXEL ;
					end if;
				when others =>
			end case ;
		end if;
	end if ;
	
	end process;


end Behavioral;

