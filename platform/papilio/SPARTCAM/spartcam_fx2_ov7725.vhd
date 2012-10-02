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

entity spartcam_fx2_ov7725 is
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
		FX2_SLOE, FX2_SLWR, FX2_SLRD :	out std_logic;
		FX2_FLAGA : in std_logic ;
		FX2_FD :	inout std_logic_vector(7 downto 0);
		FX2_ADDR :	out std_logic_vector(1 downto 0);
		FX2_IFCLK:	out std_logic;
		
		--FIFO interface
		FIFO_CS, FIFO_WR, FIFO_RD, FIFO_A0:	out std_logic;
		FIFO_DATA :	out std_logic_vector(7 downto 0)
		
);
end spartcam_fx2_ov7725;


architecture Structural of spartcam_fx2_ov7725 is

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
	signal pixel_from_conv : std_logic_vector(7 downto 0);
	signal pixel_from_gauss : std_logic_vector(7 downto 0);
	
	
	signal pxclk_from_interface, href_from_interface, vsync_from_interface : std_logic ;
	signal pxclk_from_gauss, href_from_gauss, vsync_from_gauss : std_logic ;
	signal pxclk_from_conv, href_from_conv, vsync_from_conv : std_logic ;
	
	
	signal vsync_old, vsync_rising_edge : std_logic ;
	
	signal i2c_scl, i2c_sda : std_logic;
	signal fifo_data_input : std_logic_vector(7 downto 0);
	signal fifo_wr_data : std_logic ;
	begin


--comment connections below when using pins
	--FIFO_CS <= 'Z' ;
	--FIFO_WR <= 'Z' ; 
	--FIFO_RD <= 'Z' ; 
	FIFO_CS <= CAM_PCLK ;
	FIFO_WR <= CAM_HREF ; 
	FIFO_RD <= CAM_VSYNC ; 
	FIFO_A0 <= 'Z' ;
	FIFO_DATA <= (others => 'Z')  ;
	FX2_ADDR <= "10" ;
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

	--CAM_RESET <= RESETN ; --only for ov7670
	CAM_RESET <= '0' ; -- tied to fsin and ground ... on ov7725
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
		generic map(FORMAT => QVGA, CAMERA => ov7725)
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
		
gauss3x3_0	: gauss3x3 
		generic map(WIDTH => 320,
				  HEIGHT => 240)
		port map(
					clk => clk_96 ,
					resetn => resetn_delayed ,
					pixel_clock => pxclk_from_interface, hsync => href_from_interface, vsync =>  vsync_from_interface,
					pixel_clock_out => pxclk_from_gauss, hsync_out => href_from_gauss, vsync_out => vsync_from_gauss, 
					pixel_data_in => pixel_y_from_interface,  
					pixel_data_out => pixel_from_gauss
		);		
		
		
sobel0: sobel3x3
		generic map(
		  WIDTH => 320,
		  HEIGHT => 240)
		port map(
			clk => clk_96 ,
			resetn => resetn_delayed ,
			pixel_clock => pxclk_from_gauss, hsync => href_from_gauss, vsync =>  vsync_from_gauss,
			pixel_clock_out => pxclk_from_conv, hsync_out => href_from_conv, vsync_out => vsync_from_conv, 
			pixel_data_in => pixel_from_gauss,  
			pixel_data_out => pixel_from_conv
		);	
		
		
		
	process(clk_96, resetn_delayed)
	begin
		if resetn_delayed = '0' then
			vsync_old <= '0' ;
		elsif clk_96'event and clk_96 = '1' then
			vsync_old <= vsync_from_conv ;
		end if ;
	end process ;
	vsync_rising_edge <= (not vsync_old) and vsync_from_conv ;
	
	fifo_data_input <= pixel_from_conv when vsync_from_conv = '0' and pixel_from_conv /= X"A5" else
							 (pixel_from_conv(7 downto 1) & '0') when vsync_from_conv = '0'  else
							 X"A5";
	
	fifo_wr_data <= pxclk_from_conv when href_from_conv = '0' else
						 vsync_rising_edge ;
	
	FX2_IFCLK <= clk_24 ;	
	fx2_interfaec0 : fx2_interface
		port map(
				-- logic interface
				resetn => resetn_delayed,
				clk => clk_96,
				wr => fifo_wr_data, rd => '0', cs => '1' ,
				data_in => fifo_data_input ,

				-- fx2 interface
				fx2_clk => clk_24 ,
				fx2_wr => FX2_SLWR, fx2_rd => FX2_SLRD,fx2_oe => FX2_SLOE ,
				fx2_full => FX2_FLAGA , fx2_empty => '0',
				fx2_data	=> FX2_FD
		);
	


end Structural;
