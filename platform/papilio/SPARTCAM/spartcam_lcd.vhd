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
use work.image_pack.all ;
use work.utils_pack.all ;
use work.interface_pack.all ;
use work.conf_pack.all ;
-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity spartcam_lcd is
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
end spartcam_lcd;

architecture Structural of spartcam_lcd is

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
	
	component uart_tx is
    port (            data_in : in std_logic_vector(7 downto 0);
                 write_buffer : in std_logic;
                 reset_buffer : in std_logic;
                 en_16_x_baud : in std_logic;
                   serial_out : out std_logic;
                  buffer_full : out std_logic;
             buffer_half_full : out std_logic;
                          clk : in std_logic);
    end component;

	signal clk_24, clk_96: std_logic ;
	signal resetn_delayed, clk0 : std_logic ;

	signal pixel_y_from_interface, pixel_u_from_interface, pixel_v_from_interface : std_logic_vector(7 downto 0);
	signal pixel_r, pixel_g, pixel_b : std_logic_vector(7 downto 0);

	
	signal pxclk_from_interface, href_from_interface, vsync_from_interface : std_logic ;
	signal pxclk_from_conv, href_from_conv, vsync_from_conv : std_logic ;
	
	signal i2c_scl, i2c_sda : std_logic;
	signal rom_addr : std_logic_vector(7 downto 0);
	signal rom_data : std_logic_vector(15 downto 0);
	for all : yuv_register_rom use entity work.yuv_register_rom(ov7670_qvga);
	begin
	
	--comment connections below when using pins
	--LCD_RS <= 'Z' ;
	--LCD_CS <= 'Z' ; 
	--LCD_WR <= 'Z' ; 
	--LCD_RD <= 'Z' ;
	--LCD_DATA <= (others => 'Z')  ;
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
	
	
	 conf_rom : yuv_register_rom
	port map(
	   clk => clk_96, en => '1' ,
 		data => rom_data,
 		addr => rom_addr
	); 
 
 camera_conf_block : i2c_conf 
	generic map(ADD_WIDTH => 8 , SLAVE_ADD => "0100001")
	port map(
		clock => clk_96, 
		resetn => resetn_delayed ,		
 		i2c_clk => clk_24 ,
		scl => i2c_scl,
 		sda => i2c_sda, 
		reg_addr => rom_addr ,
		reg_data => rom_data
	);
	
	camera0: yuv_camera_interface
		port map(clock => clk_96,
		resetn => resetn_delayed,
		pixel_data => CAM_DATA, 
 		pxclk => CAM_PCLK, href => CAM_HREF, vsync => CAM_VSYNC,
 		pixel_clock_out => pxclk_from_interface, hsync_out => href_from_interface, vsync_out => vsync_from_interface,
 		y_data => pixel_y_from_interface,
		u_data => pixel_u_from_interface,
		v_data => pixel_v_from_interface
		);
		
		yuv_rgb : yuv_rgb 
		port map( clk	=> clk_96,
				resetn	=> resetn_delayed,
				pixel_clock => pxclk_from_interface, hsync => href_from_interface, vsync => vsync_from_interface,
				pixel_clock_out => pxclk_from_conv, hsync_out => href_from_conv, vsync_out => vsync_from_conv, 
				pixel_y => pixel_y_from_interface,
				pixel_u => pixel_u_from_interface,
				pixel_v => pixel_v_from_interface,
				pixel_r => pixel_r,
				pixel_g => pixel_g,
				pixel_b => pixel_b  
		);
		
		
		lcd_controller0 : lcd_controller 
		port map(
				clk => clk_96,
				resetn => resetn_delayed, 
				pixel_clock => pxclk_from_interface, hsync => href_from_interface, vsync => vsync_from_interface, 
				pixel_r => pixel_r,
				pixel_g => pixel_g,	
				pixel_b => pixel_b,
				lcd_rs => LCD_RS, lcd_cs => LCD_CS, lcd_rd => LCD_RD, lcd_wr => LCD_WR,
				lcd_data	=> LCD_DATA
			); 


end Structural;

