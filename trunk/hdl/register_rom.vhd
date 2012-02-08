library IEEE;
        use IEEE.std_logic_1164.all;
        use IEEE.std_logic_arith.all;
        use IEEE.numeric_bit.all;
        use IEEE.numeric_std.all;
        use IEEE.std_logic_signed.all;
        use IEEE.std_logic_unsigned.all;

entity register_rom is
	port(
 		data : out std_logic_vector(15 downto 0 ); 
 		addr : in std_logic_vector(7 downto 0 )
	); 
end register_rom;

architecture systemc of register_rom is
 
	type array_256 is array (0 to 256 ) of std_logic_vector(15 downto 0 ); 
	signal rom : array_256 ;
	begin
	
	
	-- rom_process
	process(addr)
		 begin
		 	data <= rom(addr  ) ;
		 end process;  
	
end systemc ;