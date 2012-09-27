----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    17:16:17 02/19/2012 
-- Design Name: 
-- Module Name:    spartcam - Behavioral 
-- Project Name: 
-- Target Devices: 
-- Tool versions: 
-- Description: 
--
-- Dependencies: 
--
-- Revision: 
-- Revision 0.01 - File Created
-- Additional Comments: 
--
----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

library work;
use work.camera.all ;
use WORK.GENERIC_COMPONENTS.ALL ;
use WORK.interface_components.ALL ;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity spartcam_fx2 is
port( CLK : in std_logic;
		RESETN	:	in std_logic;
		TXD	:	out std_logic;
		RXD   :	in std_logic;
		
		
		--camera interface
		CAM_XCLK	:	out std_logic;
		CAM_SIOC, CAM_SIOD	:	inout std_logic; 
		CAM_DATA	:	in std_logic_vector(7 downto 0);
		CAM_PCLK, CAM_HREF, CAM_VSYNC	:	in std_logic;
		CAM_RESET	:	out std_logic ;
		
		--FX2 INTERFACE
		FX2_SLOE, FX2_SLWR, FX2_SLRD:	out std_logic;
		FX2_FD :	inout std_logic_vector(7 downto 0);
		FX2_ADDR :	out std_logic_vector(1 downto 0);
		FX2_IFCLK:	in std_logic;
		
		--FIFO interface
		FIFO_CS, FIFO_WR, FIFO_RD, FIFO_A0:	out std_logic;
		FIFO_DATA :	out std_logic_vector(7 downto 0)
		
);
end spartcam_fx2;


architecture Structural of spartcam_fx2 is

	COMPONENT dcm24
	PORT(
		CLKIN_IN : IN std_logic;          
		CLKDV_OUT : OUT std_logic;
		CLK0_OUT : OUT std_logic
		);
	END COMPONENT;

	COMPONENT dcm96
	PORT(
		CLKIN_IN : IN std_logic;          
		CLKFX_OUT : OUT std_logic;
		CLKIN_IBUFG_OUT : OUT std_logic;
		CLK0_OUT : OUT std_logic
		);
	END COMPONENT;
	

	signal clk_24, clk_96, clk_48, clk_1_8 : std_logic ;
	signal baud_count, resetn_delayed, clk0, cam_reset_delayed : std_logic ;
	signal baud_rate_divider : integer range 0 to 53 := 0 ;

	signal pixel_y_from_interface, pixel_u_from_interface, pixel_v_from_interface : std_logic_vector(7 downto 0);
	
	signal pxclk_from_interface, href_from_interface, vsync_from_interface : std_logic ;

	
	signal i2c_scl, i2c_sda : std_logic;
	
	begin


--comment connections below when using pins
	FIFO_CS <= 'Z' ;
	FIFO_WR <= 'Z' ; 
	FIFO_RD <= 'Z' ; 
	FIFO_A0 <= 'Z' ;
	FIFO_DATA <= (others => 'Z')  ;
	FX2_ADDR <= "00" ;
	TXD <= 'Z' ;


	reset0: reset_generator 
	generic map(HOLD_0 => 500000)
	port map(clk => clk0, 
		resetn => RESETN ,
		resetn_0 => resetn_delayed
	 );
	
	process(clk_96) -- clk div for uart 3Mbs process
	begin
	if clk_96'event and clk_96 = '1' then
		if baud_count = '1' then
			baud_count <= '0' ;
			clk_48 <= '1';
		else
			baud_count <= '1';
			clk_48 <= '0';
		end if;
	end if;
	end process;
	
	
	process(clk_96)
			begin
			if clk_96'event and clk_96='1' then
				if baud_rate_divider=52 then
					baud_rate_divider <= 0;
					clk_1_8 <= '1';
				else
					baud_rate_divider <= baud_rate_divider + 1;
					clk_1_8 <= '0';
				end if;
			end if;
	end process;

	CAM_RESET <= RESETN ;
	CAM_XCLK <= clk_24 ;
	
	CAM_SIOC <= i2c_scl ;
	CAM_SIOD <= i2c_sda ;

	Inst_dcm96: dcm96 PORT MAP(
		CLKIN_IN => clk,
		CLKFX_OUT => clk_96, 
		CLKIN_IBUFG_OUT => clk0
	);	


	Inst_dcm24: dcm24 PORT MAP(
		CLKIN_IN => clk_96,
		CLKDV_OUT => clk_24
	);
	
	
	camera0: yuv_camera_interface
		generic map(FORMAT => QVGA)
		port map(clock => clk_96,
		pixel_data => CAM_DATA, 
 		i2c_clk => clk_24,
		scl => i2c_scl ,
		sda => i2c_sda ,
 		resetn => resetn_delayed,
 		pxclk => CAM_PCLK, href => CAM_HREF, vsync => CAM_VSYNC,
 		pixel_clock_out => pxclk_from_interface, hsync_out => href_from_interface, vsync_out => vsync_from_interface,
 		y_data => pixel_y_from_interface,
		u_data => pixel_u_from_interface,
		v_data => pixel_v_from_interface
		);
		
	fx2_interfaec0 : fx2_interface
		port map(
				-- logic interface
				resetn => resetn_delayed,
				clk => clk_96, ext_clk => FX2_IFCLK ,
				wr => pxclk_from_interface, rd => '0', cs => '1' ,
				data_in =>  pixel_y_from_interface ,

				-- fx2 interface
				fx2_wr => FX2_SLWR, fx2_oe => FX2_SLOE ,
				fx2_full => '0', fx2_empty => '0',
				fx2_data	=> FX2_FD,
				latch_enable =>  FX2_SLRD
		);
		
		--FX2_SLWR <= pxclk_from_interface ;
		--FX2_SLOE <= pxclk_from_interface ;
		---FX2_SLRD <= CAM_PCLK ;


end Structural;
