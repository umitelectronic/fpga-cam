library IEEE;
        use IEEE.std_logic_1164.all;
        use IEEE.std_logic_unsigned.all;
library work;
        use work.camera.all ;

entity lcd_register_rom is
	port(
	   clk, en	:	in std_logic ;
 		data : out std_logic_vector(15 downto 0 ); 
 		addr : in std_logic_vector(7 downto 0 )
	); 
end lcd_register_rom;

architecture content of lcd_register_rom is
 
	type array_60 is array (0 to 60) of std_logic_vector(15 downto 0 ); 
	
	
	
	-- CONFIGURATION TAKEN FROM LCD DATASHEET AT http://www.allshore.com/pdf/HimaxHX8347A.pdf
	signal rom : array_60 :=( 
	(X"46" & X"95"),    
	(X"47" & X"51"),    
	(X"48" & X"00"),    
	(X"49" & X"36"),    
	(X"4A" & X"11"),   
	(X"4B" & X"66"),    
	(X"4C" & X"14"),    
	(X"4D" & X"77"),    
	(X"4E" & X"13"),    
	(X"4F" & X"4C"),   
	(X"50" & X"46"),    
	(X"51" & X"46"),      
	--24X"320 window setting 
	(X"02" & X"00"),     -- Column address start2
	(X"03" & X"00"),     -- Column address start1   
	(X"04" & X"00"),     -- Column address end2
	(X"05" & X"EF"),     -- Column address end1     
	(X"06" & X"00"),     -- Row address start2
	(X"07" & X"00"),     -- Row address start1   
	(X"08" & X"01"),     -- Row address end2
	(X"09" & X"3F"),     -- Row address end1 
	-- Display Setting  
	(X"01" & X"06"),     -- IDMON=0" &  INVON=1" &  NORON=1" &  PTLON=0
	(X"16" & X"48"),      -- MY=0" &  MX=0" &  MV=0" &  ML=1" &  BGR=0" &  TEON=0
	(X"23" & X"95"),     -- N_DC=1001 0101 
	(X"24" & X"95"),     -- P_DC=1001 0101
	(X"25" & X"FF"),     -- I_DC=1111 1111  
	(X"27" & X"06"),     -- N_BP=0000 0110
	(X"28" & X"06"),     -- N_FP=0000 0110
	(X"29" & X"06"),     -- P_BP=0000 0110 
	(X"2A" & X"06"),     -- P_FP=0000 0110
	(X"2C" & X"06"),     -- I_BP=0000 0110  
	(X"2D" & X"06"),     -- I_FP=0000 0110  
	(X"3A" & X"01"),     -- N_RTN=0000" &  N_NW=001   
	(X"3B" & X"00"),     -- P_RTN=0000" &  P_NW=000 
	(X"3C" & X"F0"),     -- I_RTN=1111" &  I_NW=000
	(X"3D" & X"00"),     -- DIV=00
	(X"35" & X"38"),     -- EQS=38h   
	(X"36" & X"78"),     -- EQP=78h Himax Confidential  -P.53- 
	(X"3E" & X"38"),     -- SON=38h
	(X"40" & X"0F"),     -- GDON=0Fh
	(X"41" & X"F0"),     -- GDOFF
	-- Power Supply Setting 
	(X"19" & X"49"),  -- OSCADJ=10 0000" &  OSD_EN=1 --60Hz
	(X"93" & X"0C"),  -- RADJ=1100
	(X"20" & X"40"),  -- BT=0100 
	(X"1D" & X"07"),  -- VC1=111
	(X"1E" & X"00"),  -- VC3=000
	(X"1F" & X"04"),  -- VRH=0100 
	-- VCOM Setting for CMO 2.8" Panel
	 (X"44" & X"4D"),    -- VCM=101 0000 
	(X"45" & X"11"),     -- VDV=1 0001 
	(X"1C" & X"04"),    -- AP=100 
	(X"1B" & X"18"),    -- GASENB=0" &  PON=1" &  DK=1" &  XDK=0" &  DDVDH_TRI=0" &  STB=0
	(X"1B" & X"10"),    -- GASENB=0" &  PON=1" &  DK=0" &  XDK=0" &  DDVDH_TRI=0" &  STB=0      
	(X"43" & X"80"),      --Set VCOMG=1
	-- Display ON Setting 
	(X"90" & X"7F"),     -- SAP=0111 1111  
	(X"26" & X"04"),     --GON=0" &  DTE=0" &  D=01
	(X"26" & X"24"),     --GON=1" &  DTE=0" &  D=01
	(X"26" & X"2C"),     --GON=1" &  DTE=0" &  D=11 
	(X"26" & X"3C"),     --GON=1" &  DTE=1" &  D=11  
	-- Internal register setting 
	 (X"57" & X"02"),    --Test_Mode Enable
	 (X"95" & X"01"),    -- Set Display clock and Pumping clock to synchronize 
	 (X"57" & X"00"),    -- Test_Mode Disable
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
	
end content ;