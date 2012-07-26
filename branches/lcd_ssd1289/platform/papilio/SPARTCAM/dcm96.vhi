
-- VHDL Instantiation Created from source file dcm96.vhd -- 16:27:14 07/25/2012
--
-- Notes: 
-- 1) This instantiation template has been automatically generated using types
-- std_logic and std_logic_vector for the ports of the instantiated module
-- 2) To use this template to instantiate this entity, cut-and-paste and then edit

	COMPONENT dcm96
	PORT(
		CLKIN_IN : IN std_logic;
		RST_IN : IN std_logic;          
		CLKFX_OUT : OUT std_logic;
		CLKIN_IBUFG_OUT : OUT std_logic;
		CLK0_OUT : OUT std_logic;
		LOCKED_OUT : OUT std_logic
		);
	END COMPONENT;

	Inst_dcm96: dcm96 PORT MAP(
		CLKIN_IN => ,
		RST_IN => ,
		CLKFX_OUT => ,
		CLKIN_IBUFG_OUT => ,
		CLK0_OUT => ,
		LOCKED_OUT => 
	);


