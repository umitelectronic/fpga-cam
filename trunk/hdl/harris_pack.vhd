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
use IEEE.NUMERIC_STD.all;

package harris_pack is

type vec_16s is array(natural range<>) of signed(15 downto 0);


component HARRIS is
generic(WIDTH : positive := 640 ; HEIGHT : positive := 480; WINDOW_SIZE : positive := 8; DS_FACTOR : natural := 0);
port (
		clk : in std_logic; 
 		resetn : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_clock_out, hsync_out, vsync_out : out std_logic; 
 		pixel_data_in : in std_logic_vector(7 downto 0 ); 
 		harris_out : out std_logic_vector(15 downto 0 )
);
end component;

component HARRIS_FINAL is
generic(WIDTH : positive := 640 ; HEIGHT : positive := 480; WINDOW_SIZE : positive := 5);
port (
		clk : in std_logic; 
 		resetn : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_clock_out, hsync_out, vsync_out : out std_logic; 
 		pixel_data_in : in std_logic_vector(7 downto 0 ); 
 		harris_out : out std_logic_vector(15 downto 0 )
);
end component;


component HARRIS_RESPONSE is
	port(
	clk, resetn : in std_logic ;
	en : in std_logic ;
	xgrad_square_sum, ygrad_square_sum, xygrad_sum : in signed(15 downto 0);
	dv	:	out std_logic ;
	harris_response : out std_logic_vector(15 downto 0)
	);
end component;

component HARRIS_LINE_ACC is
generic(NB_LINE : positive := 4 ; WIDTH : positive :=320);
port(clk, resetn : in std_logic ;
	  rewind_acc	:	in std_logic ;
	  wr_acc	:	in std_logic ;
	  gradx_square_in, grady_square_in, gradxy_in: in signed(15 downto 0);
	  gradx_square_out, grady_square_out, gradxy_out: out vec_16s(0 to (NB_LINE - 1))
	  );
end component;


component HARRIS_16SADDER is
generic(NB_VAL : positive := 5);
port(
		clk, resetn : in std_logic ;
		val_array : in vec_16s(0 to (NB_VAL-1));
		result : out signed(15 downto 0)
);
end component;

end harris_pack;

package body harris_pack is
 
end harris_pack;
