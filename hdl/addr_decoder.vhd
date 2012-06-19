----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    10:04:35 06/19/2012 
-- Design Name: 
-- Module Name:    addr_decoder - Behavioral 
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

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity addr_decoder is
generic(BUS_WIDTH	: positive := 16 ; BASE_ADDR	: natural := 0 ; END_ADDR	: positive	:= 16);
port(addr_bus_in	: in	std_logic_vector((BUS_WIDTH - 1) downto 0 );
	  addr_bus_out	:	out std_logic_vector((BUS_WIDTH - 1) downto 0 );
	  cs	:	out std_logic
);	
end addr_decoder;

architecture Behavioral of addr_decoder is
signal gteq_base, lteq_end : std_logic ;
signal minus_offset : signed(BUS_WIDTH downto 0 ) ;
begin


minus_offset <= signed('0' & addr_bus_in) - BASE_ADDR ;

gteq_base <= '1' when minus_offset >= 0 else
				 '0' ;
				 
lteq_end <= '1' when  addr_bus_in <= END_ADDR else
				'0' ;
				 
cs <= gteq_base AND lteq_end ;

addr_bus_out <= std_logic_vector(minus_offset((BUS_WIDTH - 1) downto 0))  when gteq_base = '1' and lteq_end = '1' else
					(others => '0') ;


end Behavioral;

