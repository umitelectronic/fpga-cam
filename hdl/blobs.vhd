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
use work.generic_components.all ;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity blobs is
	generic(NB_BLOB : positive := 32);
	port(
		clk, arazb, sraz : in std_logic ; --standard signals
		blob_index : in unsigned(7 downto 0); -- blob index to madd/merge with
		next_blob_index : out unsigned(7 downto 0); -- available index
		blob_index_to_merge : in unsigned(7 downto 0); -- the blob index to merge
		true_blob_index : out unsigned(7 downto 0); -- blob index after merge
		add_pixel : in std_logic ; -- add pixel to blob
		new_blob : in std_logic ; -- getting new blob
		
		merge_blob : in std_logic ; -- merge blob at blob index with blob index
		pixel_posx, pixel_posy : in unsigned(9 downto 0); -- position of the pixel to add to the blob
		
		
		--output interface
		blob_data : out std_logic_vector(7 downto 0); -- data of blob
		oe : in std_logic ;
		send_blob	:	out std_logic 
	);
 
end blobs;


architecture Behavioral of blobs is

type PIXEL_ADD_MAE is (INIT_BLOB, WAIT_PIXEL, READ_BLOB, COMPARE_BLOB, NEW_BLOB1, MERGE_BLOB1, MERGE_BLOB2, MERGE_BLOB3,  UPDATE_BLOB);
type FRAME_MAE is (ACTIVE_FRAME, WAIT_NEW_FRAME, SEND_DATA, OUTPUT1, OUTPUT2, OUTPUT3, OUTPUT4, ERASE_BLOB, NEXT_BLOB);

constant NEW_PACKET	: std_logic_vector(7 downto 0) := X"55" ;
signal pixel_state : PIXEL_ADD_MAE ;
signal frame_state, next_frame_state : FRAME_MAE ;
signal ram0_out, ram0_in : std_logic_vector(39 downto 0);
signal blobxmin, blobxmax, blobymin, blobymax, newxmin, newxmax, newymin, newymax, width, height : unsigned(9 downto 0);
signal blobdatax, blobdatay, blobdataw, blobdatah : std_logic_vector(7 downto 0);
signal ram_addr, ram_addr_tp, free_addr, blob_merge_addr, blob_addr  : std_logic_vector(7 downto 0);
signal ram_en, ram_wr, index_wr : std_logic ;
signal blob_index_init, blob_index_tp: unsigned(7 downto 0);
signal index_in : unsigned(7 downto 0);
signal nclk, to_merge : std_logic ;
signal nb_free_index : unsigned (7 downto 0);
signal next_blob_index_tp : unsigned (7 downto 0);
signal blob_area, blob_max_area : unsigned(20 downto 0);
signal pos_index : unsigned(7 downto 0);
signal sraz_blob_addr, en_blob_addr : std_logic ;


begin 

nclk <= NOT clk ;

blobxmin <= unsigned(ram0_out(9 downto 0)) ; -- top left coordinate
blobxmax <= unsigned(ram0_out(19 downto 10)) ; -- top right coordinate

blobymin <= unsigned(ram0_out(29 downto 20)) ; -- bottom left coordinate
blobymax <= unsigned(ram0_out(39 downto 30)) ; -- bottom right coordinate
 
width  <= blobxmax - blobxmin ;
height <= blobymax - blobymin ;

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
						  

ram_addr_tp <= blob_addr when frame_state /= ACTIVE_FRAME else
					free_addr when pixel_state = MERGE_BLOB2 else
					ram_addr ;
	

true_blob_index <= unsigned(ram_addr) ; 

blob_index_ram : ram_NxN -- should use the write first architecture ...
	generic map(SIZE => 256 , NBIT => 8, ADDR_WIDTH => 8)
	port map(
 		clk => nclk, -- was using nclk but caused timing problem ... must check how it works.
 		we => index_wr, en => '1',
 		do => ram_addr ,
 		di => std_logic_vector(index_in),  
 		addr => std_logic_vector(blob_index_tp)
	); 

xy_pixel_ram0: ram_NxN
	generic map(SIZE => NB_BLOB , NBIT => 40, ADDR_WIDTH => 8)
	port map(
 		clk => clk, 
 		we => ram_wr, en => ram_en,
 		do => ram0_out ,
 		di => ram0_in,  
 		addr => ram_addr_tp
	); 
	
	ram_en <= '1' ;
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
			blob_index_init <= (others => '0'); -- initializing index ram 
			index_in <= (others => '0');
			index_wr <= '1' ;
			to_merge <= '0' ;
			blob_max_area <= (others => '0');
			pixel_state <= INIT_BLOB ;
		else
			case pixel_state is
				when INIT_BLOB =>
					blob_max_area <= (others => '0');
					index_in <= index_in + 1 ;
					blob_index_init <= blob_index_init + 1 ;
					index_wr <= '1' ;
					to_merge <= '0' ;
					if index_in = NB_BLOB - 1 then
						index_in <= (others => '0');
						next_blob_index_tp <= X"01" ; -- index starts at 1
						nb_free_index <= to_unsigned(NB_BLOB, 8); -- all index are free to use
						pixel_state <= WAIT_PIXEL ;
					end if;
				when WAIT_PIXEL =>
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
							pixel_state <= COMPARE_BLOB ;
						end if ;
					end if ;
				when COMPARE_BLOB =>
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
					index_wr <= '1' ;
					index_in <= unsigned(free_addr) ; -- writing free addr to index table
					pixel_state <= MERGE_BLOB3 ;
				when MERGE_BLOB3 =>
					index_wr <= '0' ;
					nb_free_index <= nb_free_index + 1 ;
					pixel_state <= UPDATE_BLOB ;
				when NEW_BLOB1 =>
					newxmin <= pixel_posx ;
					newxmax <= pixel_posx ;
					newymin <= pixel_posy ;
					newymax <= pixel_posy ;
					index_wr <= '0' ;
					if nb_free_index > 0 then
						nb_free_index <= nb_free_index - 1 ;
						next_blob_index_tp <= next_blob_index_tp + 1 ;
					end if ;
					pixel_state <= UPDATE_BLOB ;
				when UPDATE_BLOB =>
					index_wr <= '0' ;
					if add_pixel = '0' then
						pixel_state <= WAIT_PIXEL ;
					end if;
				when others =>
			end case ;
		end if;
	end if ;
	
	end process;
	
	
	process(clk, arazb)
	begin
	if arazb = '0' then
		frame_state <= WAIT_NEW_FRAME ;
	elsif clk'event and clk = '1' then
		frame_state <= next_frame_state ;
	end if;
	end process ;
	
	process(frame_state, oe)
	begin
		next_frame_state  <= frame_state ;
		case frame_state is
			when ACTIVE_FRAME =>
				if oe = '1' then
					next_frame_state <= SEND_DATA ;
				end if ;
			when WAIT_NEW_FRAME => 
				if oe = '0' then
					next_frame_state <= ACTIVE_FRAME ;
				end if ;
			when SEND_DATA =>
				next_frame_state <= OUTPUT1 ;
			when OUTPUT1 =>
					next_frame_state <= OUTPUT2 ;
			when OUTPUT2 =>
					next_frame_state <= OUTPUT3 ;
			when OUTPUT3 =>
					next_frame_state <= OUTPUT4 ;
			when OUTPUT4 =>
					next_frame_state <= ERASE_BLOB ;
			when ERASE_BLOB =>
				if blob_addr = (NB_BLOB - 1)  OR oe = '0' then
					next_frame_state <= WAIT_NEW_FRAME ;
				else
					next_frame_state <= NEXT_BLOB ;
				end if ;
			when NEXT_BLOB =>
					next_frame_state <= OUTPUT1 ;
			when others => next_frame_state <= WAIT_NEW_FRAME ;
		end case ;
	end process ;
	
	
	addr_counter0 :  simple_counter
	 generic map(MODULO => NB_BLOB , NBIT => 4)
    port map( clk => clk,
           arazb => arazb,
           sraz => sraz_blob_addr,
           en => en_blob_addr,
           Q => blob_addr(3 downto 0)
			  );
	blob_addr(7 downto 4) <= (others => '0') ;
	
	
	
	ram0_in <= std_logic_vector(newymax) & std_logic_vector(newymin) & std_logic_vector(newxmax) & std_logic_vector(newxmin) when pixel_state = UPDATE_BLOB else
				  (others => '0') ;
				  
	ram_wr <= '1' when pixel_state = UPDATE_BLOB else
				 '1' when pixel_state = MERGE_BLOB2 else -- to be tested
				 '1' when frame_state = ERASE_BLOB else
				 '0' ;
	with frame_state select
		send_blob <= '1' when SEND_DATA,
						 '1' when OUTPUT1 ,
						 '1' when OUTPUT2 ,
						 '1' when OUTPUT3 ,
						 '1' when OUTPUT4 ,
						 '0' when others ;
						 
	with frame_state select
	blob_data <= NEW_PACKET when SEND_DATA,
					 --X"01" when OUTPUT1 ,
					 --X"02" when OUTPUT2 ,
					 --X"03" when OUTPUT3  ,
					 --X"04" when OUTPUT4 ,
					 blobdatax when OUTPUT1 ,
					 blobdatay when OUTPUT2 ,
					 blobdataw when OUTPUT3  ,
					 blobdatah when OUTPUT4 ,
					 X"05" when others ;
					 
	with frame_state select
	en_blob_addr <= '1' when ERASE_BLOB,
						 '0' when others ;
	with frame_state select
	sraz_blob_addr <= '1' when ACTIVE_FRAME,
					  '1' when WAIT_NEW_FRAME,
					 '0' when others ;


	blobdatax <= std_logic_vector(blobxmin(8 downto 1)) when (std_logic_vector(blobxmin(8 downto 1)) /= NEW_PACKET) else 
					 std_logic_vector(blobxmin(8 downto 1) - 1)	; 
	blobdatay <= std_logic_vector(blobymin(8 downto 1)) when std_logic_vector(blobymin(8 downto 1)) /= NEW_PACKET else
					 std_logic_vector(blobymin(8 downto 1) - 1)	; 

	blobdataw <= std_logic_vector(width(8 downto 1)) when std_logic_vector(width(8 downto 1)) /= NEW_PACKET else	
					 std_logic_vector(width(8 downto 1) - 1) ; -- bottom left coordinate
	blobdatah <= std_logic_vector(height(8 downto 1)) when std_logic_vector(height(8 downto 1)) /= NEW_PACKET else
					 std_logic_vector(height(8 downto 1) - 1) ; -- bottom right coordinate
	
	
end Behavioral;

