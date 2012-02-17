library IEEE;
        use IEEE.std_logic_1164.all;
        use IEEE.std_logic_unsigned.all;
library work;
        use work.all ;

entity line_ram is
	port(
 		clk : in std_logic; 
 		we, en : in std_logic; 
 		data_out : out std_logic_vector(15 downto 0 ); 
 		data_in : in std_logic_vector(15 downto 0 ); 
 		addr : in std_logic_vector(6 downto 0 )
	); 
end line_ram;

architecture systemc of line_ram is
 
	type array_80 is array (0 to 80) of std_logic_vector(15 downto 0 ); 
	signal ram : array_80 ;
	begin
	
	
	-- ram_process
	process(clk)
		 begin
		 	if  clk'event and clk = '1'  then
		 		if  en = '1'  then
		 			if  we = '1'  then
		 				ram(conv_integer(addr)) <= data_in ; 
		 				data_out <= data_in ;
		 			else
		 				data_out <= ram(conv_integer(addr)) ;
		 			end if ;
		 		end if ;
		 	end if ;
		 end process;  
	
end systemc ;