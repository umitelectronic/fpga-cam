--
--	Package File Template
--
--	Purpose: This package defines supplemental types, subtypes, 
--		 constants, and functions 
--
--   To use any of the example code shown below, uncomment the lines and modify as necessary
--

library IEEE;
use IEEE.STD_LOGIC_1164.all;

package peripheral_pack is

component fifo_peripheral is
generic(ADDR_WIDTH : positive := 8; WIDTH	: positive := 16; SIZE	: positive	:= 128 ; BURST_SIZE : positive := 4);
port(
	clk, resetn : in std_logic ;
	addr_bus : in std_logic_vector((ADDR_WIDTH - 1) downto 0);
	wr_bus, rd_bus, cs_bus : in std_logic ;
	wrB, rdA : in std_logic ;
	data_bus_in	: in std_logic_vector((WIDTH - 1) downto 0); -- bus interface
	data_bus_out	: out std_logic_vector((WIDTH - 1) downto 0); -- bus interface
	inputB: in std_logic_vector((WIDTH - 1) downto 0); -- logic interface
	outputA	: out std_logic_vector((WIDTH - 1) downto 0); -- logic interface
	emptyA, fullA, emptyB, fullB	:	out std_logic 
);
end component;

component latch_peripheral is
generic(ADDR_WIDTH : positive := 8; WIDTH	: positive := 16);
port(
	clk, resetn : in std_logic ;
	addr_bus : in std_logic_vector((ADDR_WIDTH - 1) downto 0);
	wr_bus, rd_bus, cs_bus : in std_logic ;
	data_bus_in	: in std_logic_vector((WIDTH - 1) downto 0); -- bus interface
	data_bus_out	: out std_logic_vector((WIDTH - 1) downto 0); -- bus interface
	latch_input : in  std_logic_vector((WIDTH - 1) downto 0);
	latch_output :out  std_logic_vector((WIDTH - 1) downto 0)
);
end component;

end peripheral_pack;

package body peripheral_pack is

 
end peripheral_pack;
