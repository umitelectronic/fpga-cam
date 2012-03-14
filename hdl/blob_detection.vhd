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
 		arazb : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_data_in : in std_logic_vector(7 downto 0 ));
end blob_detection;

architecture Behavioral of blob_detection is
constant NBIT : integer := integer(ceil(log2(real(MAX_BLOB)))); -- number of bits for addresses	
type neighbours is array (0 to 3) of std_logic_vector(NBIT - 1 downto 0); -- pointer to blobs data
type blobs is array (0 to MAX_BLOB) of std_logic_vector();
signal pixel_x, pixel_y : unsigned(9 downto 0);
signal last_hsync, last_pxclk : std_logic := '0';
signal sraz_fifo, fifo_wr, fifo_rd, fifo_empty, fifo_rdy : std_logic ;
signal FIFO_OUTPUT, FIFO_INPUT : std_logic_vector(7 downto 0);
signal neighbours0 : neighbours ;
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
		elsif last_pxclk /= pixel_clock and hsync = '0' then
			pixel_x <= pixel_x + 1;
		end if;
		last_hsync <= hsync ;
		last_pxclk <= pixel_clock ;
	end if;
end process ;


process(clk, arazb)
begin
	if arazb = '0' then
		sraz_fifo <= '0' ;
		fifo_wr <= '0' ;
		fifo_rd <= '0' ;
		LEFT_PIXEL <= (others => '0');
		neighbours0(0) <= (others => '0');
		neighbours0(1) <= (others => '0');
		neighbours0(2) <= (others => '0');
		neighbours0(3) <= (others => '0');
	elsif clk'event and clk = '1' then
		case BLOB_STATE0 is
			when =>
				
		end case ;
		
	end if;
end process ;




end Behavioral;

