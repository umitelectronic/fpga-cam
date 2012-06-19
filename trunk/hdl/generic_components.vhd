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
 use IEEE.NUMERIC_STD.ALL;
 use ieee.math_real.log2;
 use ieee.math_real.ceil;

package generic_components is

Function nbit(max : integer) return integer;

type slv8_array is array (natural range <>) of std_logic_vector(7 downto 0);

component simple_counter is
	 generic(NBIT : positive := 4);
    Port ( clk : in  STD_LOGIC;
           arazb : in  STD_LOGIC;
           sraz : in  STD_LOGIC;
           en : in  STD_LOGIC;
			  load : in  STD_LOGIC;
			  E : in	STD_LOGIC_VECTOR(NBIT - 1 downto 0);
           Q : out  STD_LOGIC_VECTOR(NBIT - 1 downto 0)
			  );
end component;

component up_down_counter is
	 generic(MODULO : positive := 16 ; NBIT : positive := 4);
    Port ( clk : in  STD_LOGIC;
           arazb : in  STD_LOGIC;
           sraz : in  STD_LOGIC;
           en, load : in  STD_LOGIC;
			  up_downn : in  STD_LOGIC;
			  E : in  STD_LOGIC_VECTOR(NBIT - 1 downto 0);
           Q : out  STD_LOGIC_VECTOR(NBIT - 1 downto 0)
			  );
end component;

component generic_mux is
	generic(NB_INPUTS : natural := 4 );
    Port ( s : in  STD_LOGIC_VECTOR(nbit(NB_INPUTS) - 1 downto 0);
           inputs : in  slv8_array(0 to (NB_INPUTS - 1));
           output : out  STD_LOGIC_VECTOR(7 downto 0));
end component;

component generic_latch is
	 generic(NBIT : positive := 8);
    Port ( clk : in  STD_LOGIC;
           arazb : in  STD_LOGIC;
           sraz : in  STD_LOGIC;
           en : in  STD_LOGIC;
           d : in  STD_LOGIC_VECTOR((NBIT - 1) downto 0);
           q : out  STD_LOGIC_VECTOR((NBIT - 1) downto 0));
end component;

component edge_triggered_latch is
	 generic(NBIT : positive := 8; POL : std_logic :='1');
    Port ( clk : in  STD_LOGIC;
           arazb : in  STD_LOGIC;
           sraz : in  STD_LOGIC;
           en : in  STD_LOGIC;
           d : in  STD_LOGIC_VECTOR((NBIT - 1) downto 0);
           q : out  STD_LOGIC_VECTOR((NBIT - 1) downto 0));
end component;


component ram_NxN is
	generic(SIZE : natural := 64 ; NBIT : natural := 8; ADDR_WIDTH : natural := 6);
	port(
 		clk : in std_logic; 
 		we, en : in std_logic; 
 		do : out std_logic_vector(NBIT-1 downto 0 ); 
 		di : in std_logic_vector(NBIT-1 downto 0 ); 
 		addr : in std_logic_vector((ADDR_WIDTH - 1) downto 0 )
	); 
end component;

component dpram_NxN is
	 generic(SIZE : natural := 64 ; NBIT : natural := 8; ADDR_WIDTH : natural := 6);
    port (clk  : in std_logic;
          we   : in std_logic;
          a    : in std_logic_vector((ADDR_WIDTH - 1) downto 0);
          dpra : in std_logic_vector((ADDR_WIDTH - 1) downto 0);
          di   : in std_logic_vector((NBIT - 1)  downto 0);
          spo  : out std_logic_vector((NBIT - 1) downto 0);
          dpo  : out std_logic_vector((NBIT - 1) downto 0));
end component;

component ram_Nx8 is
	generic(N : natural := 645; A : natural := 10);
	port(
 		clk : in std_logic; 
 		we, en : in std_logic; 
 		do : out std_logic_vector(7 downto 0 ); 
 		di : in std_logic_vector(7 downto 0 ); 
 		addr : in std_logic_vector( (A - 1) downto 0 )
	); 
end component;

component fifo_Nx8 is
	generic(N : natural := 64);
	port(
 		clk, arazb, sraz : in std_logic; 
 		wr, rd : in std_logic; 
		empty, full, data_rdy : out std_logic ;
 		data_out : out std_logic_vector(7 downto 0 ); 
 		data_in : in std_logic_vector(7 downto 0 )
	); 
end component;

component hold is
	 generic(HOLD_TIME : positive := 4; HOLD_LEVEL : std_logic := '1');
    Port ( clk : in  STD_LOGIC;
           arazb : in  STD_LOGIC;
           sraz : in  STD_LOGIC;
           input: in  STD_LOGIC;
			  output: out  STD_LOGIC;
			  holding : out std_logic 
			  );
end component;


component dp_fifo is
	generic(N : natural := 128 ; W : positive := 16);
	port(
 		clk, arazb, sraz : in std_logic; 
 		wr, rd : in std_logic; 
		empty, full : out std_logic ;
 		data_out : out std_logic_vector((W - 1) downto 0 ); 
 		data_in : in std_logic_vector((W - 1) downto 0 );
		nb_free : out unsigned(nbit(N) downto 0 ); 
		nb_available : out unsigned(nbit(N) downto 0 )
	); 
end component;

component muxed_addr_interface is
generic(ADDR_WIDTH : positive := 16 ; DATA_WIDTH : positive := 16);
port(clk, arazb : in std_logic ;
	  data	:	inout	std_logic_vector((DATA_WIDTH - 1) downto 0);
	  wrn, oen, addr_en_n : in std_logic ;
	  data_bus	: inout	std_logic_vector((DATA_WIDTH - 1) downto 0);
	  addr_bus	:	out	std_logic_vector((ADDR_WIDTH - 1) downto 0);
	  wr, rd	:	out	std_logic
);
end component;

component addr_decoder is
generic(BUS_WIDTH	: positive := 16 ; BASE_ADDR	: natural := 0 ; END_ADDR	: positive	:= 16);
port(addr_bus_in	: in	std_logic_vector((BUS_WIDTH - 1) downto 0 );
	  addr_bus_out	:	out std_logic_vector((BUS_WIDTH - 1) downto 0 );
	  cs	:	out std_logic
);	
end component;

component generic_rs_latch is
	port(clk, arazb : in std_logic ;
		  s, r : in std_logic ;
		  q : out std_logic );
end component;

component reset_generator is
generic(HOLD_0	:	natural	:= 100);
port(clk, arazb : in std_logic ;
     arazb_0: out std_logic
	  );
end component;

end generic_components;

Package body generic_components is

 Function nbit (max : integer) return integer is
 begin
   return (integer(ceil(log2(real(max)))));
 end nbit;
end generic_components;