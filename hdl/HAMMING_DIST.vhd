----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    17:31:14 10/04/2012 
-- Design Name: 
-- Module Name:    HAMMING_DIST - Behavioral 
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

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity HAMMING_DIST is
generic(WIDTH: natural := 64);
		port(
			clk : in std_logic; 
			resetn : in std_logic; 
			en : in std_logic ;
			vec1, vec2 :  in std_logic_vector((WIDTH - 1) downto 0);
			distance : out std_logic_vector(nbit(WIDTH)-1 downto 0 ) );
end HAMMING_DIST;

architecture Behavioral of HAMMING_DIST is
signal comp : std_logic_vector((WIDTH - 1) downto 0) ;



begin
 
 comp <= vec1 AND vec2 ;
 
 distance <= std_logic_vector(to_unsigned(count_ones(comp), nbit(WIDTH)));

end Behavioral;

