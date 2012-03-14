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
		clk, arazb : in std_logic ;
		blob_index : in unsigned(7 downto 0);
		blob_index_to_merge : in unsigned(7 downto 0);
		add_pixel : in std_logic ;
		get_blob	:	in std_logic ;
		merge_blob : in std_logic ;
		pixel_posx, pixel_posy : in unsigned(9 downto 0);
		xmin, xmax, ymin, ymax : out unsigned(9 downto 0)
	);
 
end blobs;

architecture Behavioral of blobs is
constant NBIT : integer := integer(ceil(log2(real(NB_BLOB)))); -- number of bits for addresses
type PIXEL_ADD_MAE is (WAIT_PIXEL, READ_BLOB, COMPARE_BLOB, UPDATE_BLOB);
signal pixel_state : PIXEL_ADD_MAE ;
signal ram0_out, ram1_out, ram0_in, ram1_in : std_logic_vector(31 downto 0);
signal blobxmin, blobxmax, blobymin, blobymax, newxmin, newxmax, newymin, newymax : std_logic_vector(9 downto 0);
signal ram_addr : std_logic_vector((NBIT -1) downto 0);
signal ram_en, ram_wr, index_wr : std_logic ;
begin 

ram_en <= get_blob OR add_pixel ;
ram_wr <= ; -- when to write data ?

blobxmin <= ram0_out(9 downto 0) ; -- top left coordinate
blobxmax <= ram0_out(25 downto 16) ; -- top right coordinate

blobymin <= ram1_out(9 downto 0) ; -- bottom left coordinate
blobymax <= ram1_out(25 downto 16) ; -- bottom right coordinate

blob_index_ram :ram_NxN
	generic map(SIZE => NB_BLOB ; NBIT => NBIT; ADDR_WIDTH => 8)
	port map(
 		clk => NOT clk, 
 		we => ', en => get_blob,
 		do => ram_addr ,
 		di => ram0_in,  
 		addr => blob_index
	); 

xx_pixel_ram0: ram_NxN
	generic map(SIZE => NB_BLOB ; NBIT => 32; ADDR_WIDTH => NBIT)
	port map(
 		clk => clk, 
 		we => ram_wr, en => ram_en,
 		do => ram0_out ,
 		di => ram0_in,  
 		addr => ram_addr
	); 

yy_pixel_ram0:
	generic map(SIZE => NB_BLOB ; NBIT => 32; ADDR_WIDTH => NBIT)
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
	
	elsif clk'event and clk = '1' then
		case pixel_state is
			when WAIT_PIXEL =>
				if add_pixel = '1' then
					ram_en <= '1' ;
					pixel_state <= READ_BLOB ;
				end if ;
			when READ_BLOB =>
				pixel_state <= COMPARE_BLOB ;
			when COMPARE_BLOB =>
				if pixel_posx < blobxmin then
				end if;
				if pixel_posx > blobxmax then
				end if;
				if pixel_posy < blobymin then
				end if;
				if pixel_posy > blobymax then
				end if;
				
			when UPDATE_BLOB =>
			when others =>
		end case ;
	end if ;
	
	end process;

end Behavioral;

