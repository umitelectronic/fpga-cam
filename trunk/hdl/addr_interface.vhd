----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    17:04:38 06/28/2012 
-- Design Name: 
-- Module Name:    add_interface - Behavioral 
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

entity addr_interface is
generic(ADDR_WIDTH : positive := 8 ; DATA_WIDTH : positive := 16; USE_EXT_CLOCK : boolean := false);
port(clk, arazb : in std_logic ;
	  data	:	inout	std_logic_vector((DATA_WIDTH - 1) downto 0);
	  addr	:	in	std_logic_vector((ADDR_WIDTH - 1) downto 0);
	  wrn, oen, csn, ext_clk : in std_logic ;
	  data_bus_out	: out	std_logic_vector((DATA_WIDTH - 1) downto 0);
	  data_bus_in	: in	std_logic_vector((DATA_WIDTH - 1) downto 0);
	  addr_bus	:	out	std_logic_vector((ADDR_WIDTH - 1) downto 0);
	  wr, rd	:	out	std_logic
);
end addr_interface;

architecture Behavioral of addr_interface is
signal wrt, rdt, cst : std_logic ;
signal data_bus_out_t, data_bus_in_t	: std_logic_vector((DATA_WIDTH - 1) downto 0);
begin


gen_ext_clk : if USE_EXT_CLOCK generate
	process(ext_clk, arazb)
	begin
	if arazb ='0' then
		wrt <= '0' ;
		rdt <= '0' ;
		data_bus_out_t <= (others => 'Z');
		addr_bus <= (others => '0') ;
		data_bus_in_t <= (others => '0') ;
	elsif ext_clk'event and ext_clk ='1' then
		wrt <= (NOT wrn) and (NOT csn)  ;
		rdt <= (NOT oen) and (NOT csn)  ;
		addr_bus <= addr ;
		data_bus_out_t <= data ;
		data_bus_in_t <= data_bus_in ;
	end if ;
	end process;
end generate ;

gen_no_ext_clk : if (NOT USE_EXT_CLOCK) generate
	process(clk, arazb)
	begin
	if arazb ='0' then
		wrt <= '0' ;
		rdt <= '0' ;
		data_bus_out_t <= (others => '0');
		addr_bus <= (others => '0') ;
		data_bus_in_t <= (others => '0') ;
	elsif clk'event and clk ='1' then
		wrt <= (NOT wrn) and (NOT csn) ;
		rdt <= (NOT oen) and (NOT csn) ;
		addr_bus <= addr ;
		data_bus_out_t <= data ;
		data_bus_in_t <= data_bus_in ;
	end if ;
	end process;
end generate ;



wr <= wrt ;
rd <= rdt ;

data <= data_bus_in_t when oen='0' and csn='0' else--rdt = '1' else
		  (others => 'Z');

data_bus_out <= data_bus_out_t ;



end Behavioral;

