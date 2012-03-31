library IEEE;
        use IEEE.std_logic_1164.all;
        use IEEE.std_logic_unsigned.all;
library work;
        use work.all ;

entity rgb565_register_romv2 is
	port(
	   clk, en	:	in std_logic ;
 		data : out std_logic_vector(15 downto 0 ); 
 		addr : in std_logic_vector(7 downto 0 )
	); 
end rgb565_register_romv2;

architecture systemc of rgb565_register_romv2 is
 
	type array_171 is array (0 to 168) of std_logic_vector(15 downto 0 ); 
	
	-- CONFIGURATION TAKEN FROM OV7670.c IN LINUX KERNEL DRIVERS
	signal rom : array_171 :=( 
	(X"12" & X"80"),
	(X"3a" & X"04"),
	(X"40" & X"d0"),
	(X"12" & X"14"),
	(X"32" & X"80"),
	(X"17" & X"16"),
	(X"18" & X"04"),
	(X"19" & X"02"),
	(X"1a" & X"7b"),--X"7a,
	(X"03" & X"06"),--X"0a,
	(X"0c" & X"00"),
	(X"3e" & X"00"),--
	(X"70" & X"00"),
	(X"71" & X"00"),
	(X"72" & X"11"),
	(X"73" & X"00"),--
	(X"a2" & X"02"),
	(X"11" & X"01"),
	(X"7a" & X"20"),
	(X"7b" & X"1c"),
	(X"7c" & X"28"),
	(X"7d" & X"3c"),
	(X"7e" & X"55"),
	(X"7f" & X"68"),
	(X"80" & X"76"),
	(X"81" & X"80"),
	(X"82" & X"88"),
	(X"83" & X"8f"),
	(X"84" & X"96"),
	(X"85" & X"a3"),
	(X"86" & X"af"),
	(X"87" & X"c4"),
	(X"88" & X"d7"),
	(X"89" & X"e8"),
	(X"13" & X"e0"),
	(X"00" & X"00"),--AGC
	(X"10" & X"00"),
	(X"0d" & X"00"),
	(X"14" & X"20"),--X"38, limit the max gain
	(X"a5" & X"05"),
	(X"ab" & X"07"),
	(X"24" & X"75"),
	(X"25" & X"63"),
	(X"26" & X"A5"),
	(X"9f" & X"78"),
	(X"a0" & X"68"),
	(X"a1" & X"03"),--X"0b,
	(X"a6" & X"df"),--X"d8,
	(X"a7" & X"df"),--X"d8,
	(X"a8" & X"f0"),
	(X"a9" & X"90"),
	(X"aa" & X"94"),
	(X"13" & X"e5"),
	(X"0e" & X"61"),
	(X"0f" & X"4b"),
	(X"16" & X"02"),
	(X"1e" & X"37"),--X"07,
	(X"21" & X"02"),
	(X"22" & X"91"),
	(X"29" & X"07"),
	(X"33" & X"0b"),
	(X"35" & X"0b"),
	(X"37" & X"1d"),
	(X"38" & X"71"),
	(X"39" & X"2a"),--
	(X"3c" & X"78"),
	(X"4d" & X"40"),
	(X"4e" & X"20"),
	(X"69" & X"0c"),----------------------/
	(X"6b" & X"4A"),--PLL
	(X"74" & X"19"),
	(X"8d" & X"4f"),
	(X"8e" & X"00"),
	(X"8f" & X"00"),
	(X"90" & X"00"),
	(X"91" & X"00"),
	(X"92" & X"00"),--X"19,--X"66
	(X"96" & X"00"),
	(X"9a" & X"80"),
	(X"b0" & X"84"),
	(X"b1" & X"0c"),
	(X"b2" & X"0e"),
	(X"b3" & X"82"),
	(X"b8" & X"0a"),
	(X"43" & X"14"),
	(X"44" & X"f0"),
	(X"45" & X"34"),
	(X"46" & X"58"),
	(X"47" & X"28"),
	(X"48" & X"3a"),
	(X"59" & X"88"),
	(X"5a" & X"88"),
	(X"5b" & X"44"),
	(X"5c" & X"67"),
	(X"5d" & X"49"),
	(X"5e" & X"0e"),
	(X"64" & X"04"),
	(X"65" & X"20"),
	(X"66" & X"05"),
	(X"94" & X"04"),
	(X"95" & X"08"),
	(X"6c" & X"0a"),
	(X"6d" & X"55"),
	(X"6e" & X"11"),
	(X"6f" & X"9f"),--X"9e for advance AWB
	(X"6a" & X"40"),
	(X"01" & X"40"),
	(X"02" & X"40"),
	(X"13" & X"e7"),
	(X"15" & X"00"),
	(X"4f" & X"80"),
	(X"50" & X"80"),
	(X"51" & X"00"),
	(X"52" & X"22"),
	(X"53" & X"5e"),
	(X"54" & X"80"),
	(X"58" & X"9e"),	
	(X"41" & X"08"),
	(X"3f" & X"00"),
	(X"75" & X"05"),
	(X"76" & X"e1"),
	(X"4c" & X"00"),
	(X"77" & X"01"),
	(X"3d" & X"c2"),	--X"c0,
	(X"4b" & X"09"),
	(X"c9" & X"60"),
	(X"41" & X"38"),
	(X"56" & X"40"),--X"40,  change according to Jim's request	
	(X"34" & X"11"),
	(X"3b" & X"02"),--X"00,--X"02,
	(X"a4" & X"89"),--X"88,
	(X"96" & X"00"),
	(X"97" & X"30"),
	(X"98" & X"20"),
	(X"99" & X"30"),
	(X"9a" & X"84"),
	(X"9b" & X"29"),
	(X"9c" & X"03"),
	(X"9d" & X"4c"),
	(X"9e" & X"3f"),
	(X"78" & X"04"),	
	(X"79" & X"01"),
	(X"c8" & X"f0"),
	(X"79" & X"0f"),
	(X"c8" & X"00"),
	(X"79" & X"10"),
	(X"c8" & X"7e"),
	(X"79" & X"0a"),
	(X"c8" & X"80"),
	(X"79" & X"0b"),
	(X"c8" & X"01"),
	(X"79" & X"0c"),
	(X"c8" & X"0f"),
	(X"79" & X"0d"),
	(X"c8" & X"20"),
	(X"79" & X"09"),
	(X"c8" & X"80"),
	(X"79" & X"02"),
	(X"c8" & X"c0"),
	(X"79" & X"03"),
	(X"c8" & X"40"),
	(X"79" & X"05"),
	(X"c8" & X"30"),
	(X"79" & X"26"),
	(X"09" & X"03"),
	(X"55" & X"00"),
	(X"56" & X"40"),	
	(X"3b" & X"42"),--X"82,--X"c0,--X"c2,	--night mode
	
	(X"ff" & X"ff")
);

	begin
	
	
	-- rom_process
	process(clk)
		 begin
		 if clk'event and clk = '1' then
			if en = '1' then
				data <= rom(conv_integer(addr)) ;
			end if;
		 end if;
		 end process;  
	
end systemc ;


