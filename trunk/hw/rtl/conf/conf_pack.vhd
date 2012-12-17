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

package conf_pack is


component lcd_register_rom is
	port(
	   clk, en	:	in std_logic ;
 		data : out std_logic_vector(23 downto 0 ); 
 		addr : in std_logic_vector(7 downto 0 )
	); 
end component;

component configuration_module is
generic(NB_REGISTERS : natural := 6);
port(
	clk, resetn : in std_logic ;
	input_data	:	in std_logic_vector(7 downto 0) ;
	read_data	:	out std_logic ;
	data_present	:	in std_logic ;
	vsync	:	in std_logic ;
	registers	: out register_array(0 to (NB_REGISTERS - 1))
);
end component;

component rgb565_register_rom is
	port(
	   clk, en	:	in std_logic ;
 		data : out std_logic_vector(15 downto 0 ); 
 		addr : in std_logic_vector(7 downto 0 )
	); 
end component;

component yuv_register_rom is
	port(
	   clk, en	:	in std_logic ;
 		data : out std_logic_vector(15 downto 0 ); 
 		addr : in std_logic_vector(7 downto 0 )
	); 
end component;


end conf_pack;

package body conf_pack is

---- Example 1
--  function <function_name>  (signal <signal_name> : in <type_declaration>  ) return <type_declaration> is
--    variable <variable_name>     : <type_declaration>;
--  begin
--    <variable_name> := <signal_name> xor <signal_name>;
--    return <variable_name>; 
--  end <function_name>;

---- Example 2
--  function <function_name>  (signal <signal_name> : in <type_declaration>;
--                         signal <signal_name>   : in <type_declaration>  ) return <type_declaration> is
--  begin
--    if (<signal_name> = '1') then
--      return <signal_name>;
--    else
--      return 'Z';
--    end if;
--  end <function_name>;

---- Procedure Example
--  procedure <procedure_name>  (<type_declaration> <constant_name>  : in <type_declaration>) is
--    
--  begin
--    
--  end <procedure_name>;
 
end conf_pack;
