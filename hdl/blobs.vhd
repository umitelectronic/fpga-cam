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
	generic(NB_BLOB : natural := 16);
	port(
		clk, arazb, sraz : in std_logic ;
		blob_index : in unsigned(7 downto 0);
		blob_index_to_merge : in unsigned(7 downto 0);
		add_pixel : in std_logic ;
		get_blob	:	in std_logic ;
		merge_blob : in std_logic ;
		pixel_posx, pixel_posy : in unsigned(9 downto 0);
		max_blob_centerx, max_blob_centery	:	out unsigned(9 downto 0);
		xmin, xmax, ymin, ymax : out unsigned(9 downto 0)
	);
 
end blobs;


architecture Behavioral of blobs is
constant NBIT : integer := integer(ceil(log2(real(NB_BLOB)))); -- number of bits for addresses
type PIXEL_ADD_MAE is (INIT_BLOB, WAIT_PIXEL, READ_BLOB, COMPARE_BLOB, UPDATE_BLOB);
signal pixel_state : PIXEL_ADD_MAE ;
signal ram0_out, ram1_out, ram0_in, ram1_in : std_logic_vector(31 downto 0);
signal blobxmin, blobxmax, blobymin, blobymax, newxmin, newxmax, newymin, newymax : unsigned(9 downto 0);
signal ram_addr : std_logic_vector((NBIT -1) downto 0);
signal ram_en, ram_wr, index_wr : std_logic ;
signal blob_index_init, blob_index_tp: unsigned(7 downto 0);
signal index_in : unsigned(NBIT - 1 downto 0);
signal max_blob_centerx_tmp, max_blob_center_y_tmp, current_blob_centerx, current_blob_centery : unsigned(9 downto 0) := (others => '0') ;
signal addx, addy, subx, suby : unsigned(10 downto 0) := (others => '0');
signal max_blob_height, max_blob_width : unsigned(10 downto 0) := (others => '0');
signal nclk : std_logic ;
begin 

nclk <= NOT clk ;

blobxmin <= unsigned(ram0_out(9 downto 0)) ; -- top left coordinate
blobxmax <= unsigned(ram0_out(25 downto 16)) ; -- top right coordinate

blobymin <= unsigned(ram1_out(9 downto 0)) ; -- bottom left coordinate
blobymax <= unsigned(ram1_out(25 downto 16)) ; -- bottom right coordinate
 
 
 

addx <=  ('0' &  newxmin) + ('0' &  newxmax) ;
addy <=  ('0' &  newymin) + ('0' &  newymax) ;

subx <=   ('0' &  newxmax) - ('0' &  newxmin);
suby <=  ('0' &  newymax) - ('0' &  newymin) ;

current_blob_centerx <=  addx(10 downto 1) ;
current_blob_centery <=  addy(10 downto 1) ;




 
with pixel_state select
	blob_index_tp <= blob_index_init when INIT_BLOB,
						  blob_index when others ;

blob_index_ram :ram_NxN
	generic map(SIZE => NB_BLOB , NBIT => NBIT, ADDR_WIDTH => 8)
	port map(
 		clk => nclk, 
 		we => index_wr, en => '1',
 		do => ram_addr ,
 		di => std_logic_vector(index_in),  
 		addr => std_logic_vector(blob_index_tp) -- blobs index starts at 1 but address at zero
	); 

xx_pixel_ram0: ram_NxN
	generic map(SIZE => NB_BLOB , NBIT => 32, ADDR_WIDTH => NBIT)
	port map(
 		clk => clk, 
 		we => ram_wr, en => ram_en,
 		do => ram0_out ,
 		di => ram0_in,  
 		addr => ram_addr
	); 

yy_pixel_ram0: ram_NxN
	generic map(SIZE => NB_BLOB , NBIT => 32, ADDR_WIDTH => NBIT)
	port map(
 		clk => clk, 
 		we => ram_wr, en => ram_en,
 		do => ram1_out ,
 		di => ram1_in,  
 		addr => ram_addr
	); 
	 --blob_add
	process(clk, arazb)
	begin
	if arazb = '0' then
		blob_index_init <= (others => '0');
		index_in <= (others => '0');
		pixel_state <= INIT_BLOB ;
	elsif clk'event and clk = '1' then
		if sraz = '1' then
			pixel_state <= INIT_BLOB ;
		else
			case pixel_state is
				when INIT_BLOB =>
					ram0_in <= X"000003FF";
					ram1_in <= X"000003FF";
					blob_index_init <= blob_index_init + 1 ;
					index_in <= index_in + 1 ;
					ram_wr <= '1' ;
					ram_en <= '1' ;
					index_wr <= '1' ;
					if blob_index_init = (NB_BLOB - 1) then
						blob_index_init <= (others => '0');
						index_in <= (others => '0');
						pixel_state <= WAIT_PIXEL ;
					end if;
				when WAIT_PIXEL =>
					ram_wr <= '0' ;
					ram_en <= '0' ;
					index_wr <= '0' ;
					if add_pixel = '1' then
						ram_en <= '1' ;
						pixel_state <= READ_BLOB ;
					end if ;
				when READ_BLOB =>
					ram_wr <= '0' ;
					ram_en <= '1' ;
					index_wr <= '0' ;
					pixel_state <= COMPARE_BLOB ;
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
					pixel_state <= UPDATE_BLOB ;
				when UPDATE_BLOB =>
					ram0_in(9 downto 0) <= std_logic_vector(newxmin) ;
					ram0_in(25 downto 16) <= std_logic_vector(newxmax) ;
					ram1_in(9 downto 0) <= std_logic_vector(newymin) ;
					ram1_in(25 downto 16) <= std_logic_vector(newymax) ;
					ram_en <= '1' ;
					ram_wr <= '1' ;
					index_wr <= '0' ;
					if subx >= max_blob_width and suby >= max_blob_height then
						max_blob_width <= subx ;
						max_blob_height <= suby ;
						max_blob_centerx <= current_blob_centerx ;
						max_blob_centery <= current_blob_centery ;
					end if;
					if add_pixel = '0' then
						pixel_state <= WAIT_PIXEL ;
					end if;
				when others =>
			end case ;
		end if;
	end if ;
	
	end process;

end Behavioral;

