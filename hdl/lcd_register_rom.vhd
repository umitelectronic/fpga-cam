library IEEE;
        use IEEE.std_logic_1164.all;
        use IEEE.std_logic_unsigned.all;
library work;
        use work.camera.all ;

entity lcd_register_rom is
	port(
	   clk, en	:	in std_logic ;
 		data : out std_logic_vector(23 downto 0 ); 
 		addr : in std_logic_vector(7 downto 0 )
	); 
end lcd_register_rom;

architecture lcd2_4 of lcd_register_rom is
 
	type array_70 is array (0 to 69) of std_logic_vector(23 downto 0 ); 
	
	-- CONFIGURATION TAKEN FROM LCD DATASHEET AT http://www.allshore.com/pdf/HimaxHX8347A.pdf
	signal rom : array_70 :=( 
	(X"46" & X"0094"),    
	(X"47" & X"0041"),    
	(X"48" & X"0000"),    
	(X"49" & X"0033"),    
	(X"4A" & X"0023"),    
	(X"4B" & X"0045"),    
	(X"4C" & X"0044"),    
	(X"4D" & X"0077"),    
	(X"4E" & X"0012"),    
	(X"4F" & X"00CC"),    
	(X"50" & X"0046"),    
	(X"51" & X"0082"),      
	--240x320 window setting 
	(X"02" & X"0000"),    -- Column address start2
	(X"03" & X"0000"),    -- Column address start1
	(X"04" & X"0000"),    -- Column address end2 
	(X"05" & X"00EF"),    -- Column address end1
	(X"06" & X"0000"),    -- Row address start2
	(X"07" & X"0000"),    -- Row address start1   
	(X"08" & X"0001"),    -- Row address end2 
	(X"09" & X"003F"),   -- Row address end1  
-- Display Setting  
	(X"01" & X"0006"),  -- IDMON=0" &  INVON=1" &  NORON=1" &  PTLON=0 
	(X"16" & X"0048"),   -- MY=0" &  MX=0" &  MV=0" &  ML=1" &  BGR=0" &  TEON=0 
	(X"23" & X"0095"),   -- N_DC=1001 0101
	(X"24" & X"0095"),    -- PI_DC=1001 0101 
	(X"25" & X"00FF"),    -- I_DC=1111 1111   
	(X"27" & X"0002"),    -- N_BP=0000 0010
	(X"28" & X"0002"),    -- N_FP=0000 0010 
	(X"29" & X"0002"),    -- PI_BP=0000 0010 
	(X"2A" & X"0002"),    -- PI_FP=0000 0010
	(X"2C" & X"0002"),    -- I_BP=0000 0010 
	(X"2D" & X"0002"),    -- I_FP=0000 0010 
	(X"3A" & X"0001"),    -- N_RTN=0000" &  N_NW=001   
	(X"3B" & X"0000"),    -- PI_RTN=0000" &  PI_NW=000
	(X"3C" & X"00F0"),    -- I_RTN=1111" &  I_NW=000
	(X"3D" & X"0000"),    -- DIV=00
	(X"FF" & X"0020"),  -- delay
	(X"35" & X"0038"),    -- EQS=38h   
	(X"36" & X"0078"),    -- EQP=78hHimax Confidential  -P.51- 
	(X"3E" & X"0038"),    -- SON=38h
	(X"40" & X"000F"),    -- GDON=0Fh
	(X"41" & X"00F0"),    -- GDOFF
	-- Power Supply Setting 
	(X"19" & X"0049"),    -- CADJ=0100" &  CUADJ=100(FR:60Hz)" &  OSD_EN=1
	(X"93" & X"000F"),    -- RADJ=1111" &  100%
	(X"FF" & X"0000"),  -- delay
	(X"20" & X"0040"),      -- BT=0100     
	(X"1D" & X"0007"),  -- VC1=111
	(X"1E" & X"0000"),  -- VC3=000
	(X"1F" & X"0004"),  -- VRH=0100
	-- VCOM Setting for CMO 2.4" Panel
	(X"44" & X"0040"),     -- VCM=100 0000
	(X"45" & X"0012"),    -- VDV=1 0001
	(X"FF" & X"0000"),  --delay
	(X"1C" & X"0004"),    -- AP=100
	(X"FF" & X"0000"),   --delay
	(X"1B" & X"0018"),    -- GASENB=0" &  PON=1" &  DK=1" &  XDK=0" &  VLCD_TRI=0" &  STB=0
	(X"FF" & X"0000"),  -- delay
	(X"1B" & X"0010"),    -- GASENB=0" &  PON=1" &  DK=0" &  XDK=0" &  VLCD_TRI=0" &  STB=0
	(X"FF" & X"0000"), 
	(X"43" & X"0080"),    --Set VCOMG=1
	(X"FF" & X"0000"),  --delay
	-- Display ON Setting 
	(X"90" & X"007F"),     -- SAP=0111 1111   
	(X"26" & X"0004"),   --GON=0" &  DTE=0" &  D=01
	(X"FF" & X"0000"), -- delay
	(X"26" & X"0024"),    --GON=1" &  DTE=0" &  D=01
	(X"26" & X"002C"),    --GON=1" &  DTE=0" &  D=11
	(X"FF" & X"0000"),  --delay
	(X"26" & X"003C"),    --GON=1" &  DTE=1" &  D=11   
	-- Internal register setting 
	(X"57" & X"0002"),    --Test_Mode Enable
	(X"95" & X"0001"),    -- Set Display clock and Pumping clock to synchronize 
	(X"57" & X"0000"),    -- Test_Mode Disable
	(X"ff" & X"ffff")
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
	
end lcd2_4 ;




architecture lcd2_4_bis of lcd_register_rom is
 
	type array_61 is array (0 to 60) of std_logic_vector(23 downto 0 ); 
	
	-- CONFIGURATION TAKEN FROM ARDUINO LIBRARY
	signal rom : array_61 :=( 
	(X"E3" & X"3008"),    --set the internal timing
	(X"E7" & X"0012"),    --set the internal timing
	(X"EF" & X"1231"),    --set the internal timing
	(X"00" & X"0001"),    -- start oscillator
	(X"FF" & X"0000"),    --delay
	(X"01" & X"0100"),    --LCD_DRIV_OUT_CTRL
	(X"02" & X"0700"),    --LCD_DRIV_WAV_CTRL
	(X"03" & X"1030"),    --LCD_ENTRY_MOD
	(X"04" & X"0000"),    --LCD_RESIZE_CTRL
	(X"08" & X"0202"),    --LCD_DISP_CTRL2
	(X"09" & X"0000"),    --LCD_DISP_CTRL3
	(X"0A" & X"0000"),    --LCD_DISP_CTRL4
	(X"0C" & X"0000"),    --LCD_RGB_DISP_IF_CTRL1
	(X"0D" & X"0000"),    --LCD_FRM_MARKER_POS
	(X"0F" & X"0000"),    --LCD_RGB_DISP_IF_CTRL2
	(X"10" & X"0000"),    --LCD_POW_CTRL1
	(X"11" & X"0007"),    --LCD_POW_CTRL2
	(X"12" & X"0000"),    --LCD_POW_CTRL3
	(X"13" & X"0000"),    --LCD_POW_CTRL4
	(X"FF" & X"0000"),   --delay
	(X"10" & X"1690"),   --LCD_POW_CTRL1
	(X"11" & X"0227"),   --LCD_POW_CTRL2
	(X"FF" & X"0000"),   --delay
	(X"12" & X"001A"),   --LCD_POW_CTRL3
	(X"FF" & X"0000"),   --delay
	(X"13" & X"1800"),   --LCD_POW_CTRL4
	(X"29" & X"002A"),   --LCD_POW_CTRL7
	(X"FF" & X"0000"),   --delay 
	(X"30" & X"0000"),   --LCD_GAMMA_CTRL1 
	(X"31" & X"0000"),   --LCD_GAMMA_CTRL2 
	(X"32" & X"0000"),   --LCD_GAMMA_CTRL3 
	(X"35" & X"0206"),   --LCD_GAMMA_CTRL4 
	(X"36" & X"0808"),   --LCD_GAMMA_CTRL5
	(X"37" & X"0007"),   --LCD_GAMMA_CTRL6 
	(X"38" & X"0201"),   --LCD_GAMMA_CTRL7 
	(X"39" & X"0000"),   --LCD_GAMMA_CTRL8
	(X"3C" & X"0000"),   --LCD_GAMMA_CTRL9
	(X"3D" & X"0000"),   --LCD_GAMMA_CTRL10
	(X"20" & X"0000"),   --LCD_GRAM_HOR_AD
	(X"21" & X"0000"),   --LCD_GRAM_VER_AD 
	(X"50" & X"0000"),   --LCD_HOR_START_AD 
	(X"51" & X"00EF"),   --LCD_HOR_END_AD
	(X"52" & X"0000"),   --LCD_VER_START_AD 
	(X"53" & X"013F"),   --LCD_VER_END_AD
	(X"60" & X"A700"),   --LCD_GATE_SCAN_CTRL1     
	(X"61" & X"0003"),   --LCD_GATE_SCAN_CTRL2
	(X"6A" & X"0000"),   --LCD_GATE_SCAN_CTRL3
	(X"80" & X"0000"),   --LCD_PART_IMG1_DISP_POS
	(X"81" & X"0000"),   --LCD_PART_IMG1_START_AD 
	(X"82" & X"0000"),   --LCD_PART_IMG1_END_AD
	(X"83" & X"0000"),   --LCD_PART_IMG2_DISP_POS
	(X"84" & X"0000"),   --LCD_PART_IMG2_START_AD
	(X"85" & X"0000"),   --LCD_PART_IMG2_END_AD
	(X"90" & X"0010"),   --LCD_PANEL_IF_CTRL1  
	(X"92" & X"0000"),   --LCD_PANEL_IF_CTRL2
	(X"93" & X"0003"),   --LCD_PANEL_IF_CTRL3 
	(X"95" & X"0110"),   --LCD_PANEL_IF_CTRL4
	(X"97" & X"0000"),   --LCD_PANEL_IF_CTRL5 
	(X"98" & X"0000"),   --LCD_PANEL_IF_CTRL6
	(X"07" & X"0133"),   --LCD_DISP_CTRL1  
	(X"ff" & X"ffff")		-- END OF CONFIG
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
	
end lcd2_4_bis ;