library IEEE;
        use IEEE.std_logic_1164.all;
        use IEEE.std_logic_unsigned.all;
		  use ieee.math_real.log2;
		  use ieee.math_real.ceil;

entity ram_Nx8 is
	generic(N : natural := 64; A : natural := 6);
	port(
 		clk : in std_logic; 
 		we, en : in std_logic; 
 		do : out std_logic_vector(7 downto 0 ); 
 		di : in std_logic_vector(7 downto 0 ); 
 		addr : in std_logic_vector((A - 1) downto 0 )
	); 
end ram_Nx8;

architecture behavioral of ram_Nx8 is
 
	type array_N is array (0 to N-1) of std_logic_vector(7 downto 0 ); 
	signal ram : array_N ;
	begin
	
	
	-- ram_process
	process(clk)
		 begin
		 	if  clk'event and clk = '1'  then
		 		if  en = '1'  then
		 			if  we = '1'  then
		 				ram(conv_integer(addr)) <= di ; 
		 			end if ;
		 			do <= ram(conv_integer(addr)) ;
		 		end if ;
		 	end if ;
		 end process;  
	
end behavioral ;