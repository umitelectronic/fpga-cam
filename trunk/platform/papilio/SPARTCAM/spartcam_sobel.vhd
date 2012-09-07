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
use IEEE.STD_LOGIC_UNSIGNED.ALL;

library work;
use work.camera.all ;
use work.generic_components.all ;
-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity spartcam_sobel is
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
		
		--LCD interface
		LCD_RS, LCD_CS, LCD_WR, LCD_RD:	out std_logic;
		LCD_DATA :	out std_logic_vector(15 downto 0);
		
		--FIFO interface
		FIFO_CS, FIFO_WR, FIFO_RD, FIFO_A0:	out std_logic;
		FIFO_DATA :	out std_logic_vector(7 downto 0)
		
);
end spartcam_sobel;

architecture Structural of spartcam_sobel is

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


	signal clk0, clk_24, clk_96 : std_logic ;
	signal resetn_delayed : std_logic ;

	signal pixel_from_interface : std_logic_vector(7 downto 0);
	signal pixel_from_gauss : std_logic_vector(7 downto 0);
	signal pixel_from_conv : std_logic_vector(7 downto 0);
	signal binarized_pixel : std_logic_vector(7 downto 0);
	signal pixel_from_erode : std_logic_vector(7 downto 0);
	
	signal pxclk_from_interface, href_from_interface, vsync_from_interface : std_logic ;
	signal pxclk_from_gauss, href_from_gauss, vsync_from_gauss : std_logic ;
	signal pxclk_from_conv, href_from_conv, vsync_from_conv : std_logic ;
	signal pxclk_from_bin, href_from_bin, vsync_from_bin : std_logic ;
	signal pxclk_from_erode, href_from_erode, vsync_from_erode : std_logic ;
	
	signal i2c_scl, i2c_sda : std_logic;
	
	for gauss3x3_0 : gauss3x3 use entity gauss3x3(RTL) ;
	begin
	
	
	--comment connections below when using pins
	FIFO_CS <= 'Z' ;
	FIFO_WR <= 'Z' ; 
	FIFO_RD <= 'Z' ; 
	FIFO_A0 <= 'Z' ;
	FIFO_DATA <= (others => 'Z')  ;
	TXD <= 'Z' ;
	
	
	reset0: reset_generator 
	generic map(HOLD_0 => 500000)
	port map(clk => clk0, 
		resetn => RESETN ,
		resetn_0 => resetn_delayed
	 );
	

	CAM_RESET <= resetn ;
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
 		y_data => pixel_from_interface
		);
		
		gauss3x3_0	: gauss3x3 
		generic map(WIDTH => 320,
				  HEIGHT => 240)
		port map(
					clk => clk_96 ,
					resetn => resetn_delayed ,
					pixel_clock => pxclk_from_interface, hsync => href_from_interface, vsync =>  vsync_from_interface,
					pixel_clock_out => pxclk_from_gauss, hsync_out => href_from_gauss, vsync_out => vsync_from_gauss, 
					pixel_data_in => pixel_from_interface,  
					pixel_data_out => pixel_from_gauss
		);


		sobel0: sobel3x3
		generic map(
		  WIDTH => 320,
		  HEIGHT => 240)
		port map(
			clk => clk_96 ,
			resetn => resetn_delayed ,
			pixel_clock => pxclk_from_gauss, hsync => href_from_gauss, vsync =>  vsync_from_interface,
			pixel_clock_out => pxclk_from_conv, hsync_out => href_from_conv, vsync_out => vsync_from_conv, 
			pixel_data_in => pixel_from_gauss,  
			pixel_data_out => pixel_from_conv
		);
		
		bin_pixel0:  synced_binarization 
		port map( clk	=> clk_96, 
				resetn	=> resetn_delayed,
				pixel_clock => pxclk_from_conv, hsync =>  href_from_conv, vsync => vsync_from_conv, 
				pixel_clock_out => pxclk_from_bin, hsync_out => href_from_bin, vsync_out => vsync_from_bin, 
				pixel_data_1 => pixel_from_conv,
				pixel_data_2 => X"F0",
				pixel_data_3 => X"F0",
				upper_bound_1	=>	X"FF" ,
				upper_bound_2	=>	X"FF" ,
				upper_bound_3	=>	X"FF" ,
				lower_bound_1	=>	X"10",
				lower_bound_2	=>	X"00",
				lower_bound_3	=>	X"00",
				pixel_data_out => binarized_pixel 
		);
		
		erode0 : erode3x3
		generic map(
		  WIDTH => 320, 
		  HEIGHT => 240)
		port map(
				clk => clk_96,  
				resetn => resetn_delayed ,  
				pixel_clock => pxclk_from_bin, hsync => href_from_bin, vsync => vsync_from_bin,
				pixel_clock_out => pxclk_from_erode, hsync_out => href_from_erode, vsync_out => vsync_from_erode, 
				pixel_data_in => binarized_pixel, 
				pixel_data_out => pixel_from_erode

		);  
		
		
		lcd_controller0 : lcd_controller 
		port map(
				clk => clk_96,
				resetn => resetn_delayed, 
				pixel_clock => pxclk_from_erode, hsync => href_from_erode, vsync => vsync_from_erode, 
				pixel_r => pixel_from_erode ,
				pixel_g => pixel_from_erode ,		
				pixel_b => pixel_from_erode ,
				
				lcd_rs => LCD_RS, lcd_cs => LCD_CS, lcd_rd => LCD_RD, lcd_wr => LCD_WR,
				lcd_data	=> LCD_DATA
			); 


		




end Structural;

