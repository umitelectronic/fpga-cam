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

package interface_components is

component fx2_interface is
port(
	-- logic interface
	clk, resetn : in std_logic ;
	wr, rd, cs	: in std_logic ;
	dv, busy	: out std_logic ;
	data_in : in std_logic_vector(7 downto 0 ); 
	data_out : out std_logic_vector(7 downto 0 );
	
	-- fx2 interface
	fx2_clk	: in std_logic ;
	fx2_wr, fx2_rd, fx2_oe : out std_logic ;
	fx2_full, fx2_empty : in std_logic ;
	fx2_data	: inout	std_logic_vector(7 downto 0 );
	
	--debug signals
	latch_enable : out std_logic 
);
end component;

component muxed_addr_interface is
generic(ADDR_WIDTH : positive := 8 ; DATA_WIDTH : positive := 16);
port(clk, resetn : in std_logic ;
	  data	:	inout	std_logic_vector((DATA_WIDTH - 1) downto 0);
	  wrn, oen, addr_en_n, csn : in std_logic ;
	  data_bus_out	: out	std_logic_vector((DATA_WIDTH - 1) downto 0);
	  data_bus_in	: in	std_logic_vector((DATA_WIDTH - 1) downto 0);
	  addr_bus	:	out	std_logic_vector((ADDR_WIDTH - 1) downto 0);
	  wr, rd	:	out	std_logic
);
end component;

component addr_interface is
generic(ADDR_WIDTH : positive := 8 ; DATA_WIDTH : positive := 16; USE_EXT_CLOCK : boolean := false);
port(clk, resetn : in std_logic ;
	  data	:	inout	std_logic_vector((DATA_WIDTH - 1) downto 0);
	  addr	:	in	std_logic_vector((ADDR_WIDTH - 1) downto 0);
	  wrn, oen, csn, ext_clk : in std_logic ;
	  data_bus_out	: out	std_logic_vector((DATA_WIDTH - 1) downto 0);
	  data_bus_in	: in	std_logic_vector((DATA_WIDTH - 1) downto 0);
	  addr_bus	:	out	std_logic_vector((ADDR_WIDTH - 1) downto 0);
	  wr, rd	:	out	std_logic
);
end component;

component addr_decoder is
generic(ADDR_WIDTH	: positive := 16 ; BASE_ADDR	: natural := 0 ; ADDR_OUT_WIDTH	: positive	:= 2);
port(addr_bus_in	: in	std_logic_vector((ADDR_WIDTH - 1) downto 0 );
	  addr_bus_out	:	out std_logic_vector((ADDR_OUT_WIDTH - 1) downto 0 );
	  cs	:	out std_logic
);	
end component;


end interface_components;

package body interface_components is

end interface_components;
