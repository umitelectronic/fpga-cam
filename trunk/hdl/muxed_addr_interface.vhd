----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    09:45:03 06/19/2012 
-- Design Name: 
-- Module Name:    muxed_addr_interface - Behavioral 
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

library work ;
use work.generic_components.all ;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity muxed_addr_interface is
generic(ADDR_WIDTH : positive := 16 ; DATA_WIDTH : positive := 16);
port(clk, arazb : in std_logic ;
	  data	:	inout	std_logic_vector((DATA_WIDTH - 1) downto 0);
	  wrn, oen, addr_en_n, csn : in std_logic ;
	  data_bus	: inout	std_logic_vector((DATA_WIDTH - 1) downto 0);
	  addr_bus	:	out	std_logic_vector((ADDR_WIDTH - 1) downto 0);
	  wr, rd	:	out	std_logic
);
end muxed_addr_interface;

architecture Behavioral of muxed_addr_interface is

begin


add_latch0 : generic_latch 
	 generic map(NBIT => ADDR_WIDTH)
    Port map( clk => clk ,
           arazb => arazb ,
           sraz => '0' ,
           en => (NOT addr_en_n),
           d => data((ADDR_WIDTH - 1) downto 0),
           q => addr_bus);

wr <= (NOT wrn) AND (NOT csn) ;
rd <= (NOT oen) AND (NOT csn) ;

data <= data_bus when oen = '0' and csn = '0' else
		  (others => 'Z');

data_bus <= data when (wrn = '0' and oen = '1' and csn = '0') else
				(others => 'Z');


end Behavioral;

