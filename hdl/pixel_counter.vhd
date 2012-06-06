----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    09:31:17 03/23/2012 
-- Design Name: 
-- Module Name:    pixel_counter - Behavioral 
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



library work ;
use work.generic_components.all ;
-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity pixel_counter is
		generic(POL : std_logic := '0'; MAX : positive := 640);
		port(
			clk : in std_logic; 
			arazb : in std_logic; 
			pixel_clock, hsync : in std_logic; 
			pixel_count : out std_logic_vector((nbit(MAX) - 1) downto 0 )
			);
end pixel_counter;

architecture Behavioral of pixel_counter is
signal pixel_clock_old : std_logic ;
signal pixel_count_temp : std_logic_vector((nbit(MAX) - 1) downto 0 ) ;
begin
process(clk, arazb)
begin
if arazb = '0' then 
	pixel_count_temp <= (others => '0') ;
elsif clk'event and clk = '1'  then
		if hsync = '1' then
			pixel_count_temp <= (others => '0') ;
		elsif pixel_clock /= pixel_clock_old and pixel_clock = POL then
			pixel_count_temp <= pixel_count_temp + 1 ;
		end if ;
		pixel_clock_old <= pixel_clock ;
end if ;
end process ;

pixel_count <= pixel_count_temp ;

end Behavioral;

