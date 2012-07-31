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

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity spartcam_conf is
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
end spartcam_conf;


architecture Structural of spartcam_conf is

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
	 
	 
	 component uart_rx is
    port (            serial_in : in std_logic;
                       data_out : out std_logic_vector(7 downto 0);
                    read_buffer : in std_logic;
                   reset_buffer : in std_logic;
                   en_16_x_baud : in std_logic;
            buffer_data_present : out std_logic;
                    buffer_full : out std_logic;
               buffer_half_full : out std_logic;
                            clk : in std_logic);
    end component;

	signal clk_24, clk_96, clk_48 : std_logic ;
	signal baud_count, resetn_delayed, clk0 : std_logic ;
	constant resetn_delay : integer := 1000000 ;
	signal resetn_time : integer range 0 to 1048576 := resetn_delay ;

	signal pixel_r_from_interface, pixel_g_from_interface, pixel_b_from_interface : std_logic_vector(7 downto 0);
	signal pixel_from_ds : std_logic_vector(7 downto 0);
	
	signal pixel_from_conv : std_logic_vector(7 downto 0);
	signal binarized_pixel , binarized_pixel_r , binarized_pixel_g , binarized_pixel_b  : std_logic_vector(7 downto 0);
	signal pixel_from_erode : std_logic_vector(7 downto 0);
	signal pixel_from_dilate : std_logic_vector(7 downto 0);
	signal pixel_from_square: std_logic_vector(7 downto 0);
	signal pixel_from_blob: std_logic_vector(7 downto 0);
	
	signal data_to_send : std_logic_vector(7 downto 0);
	signal data_to_read : std_logic_vector(7 downto 0);
	signal send_signal, tx_buffer_full, read_signal, data_present	:	std_logic ;
	signal pxclk_from_interface, href_from_interface, vsync_from_interface : std_logic ;
	signal pxclk_from_ds, href_from_ds, vsync_from_ds : std_logic ;
	signal pxclk_from_conv, href_from_conv, vsync_from_conv : std_logic ;
	signal pxclk_from_erode, href_from_erode, vsync_from_erode : std_logic ;
	signal pxclk_from_dilate, href_from_dilate, vsync_from_dilate : std_logic ;
	signal pxclk_from_blob, href_from_blob, vsync_from_blob : std_logic ;
	signal pxclk_from_square, href_from_square, vsync_from_square : std_logic ;
	signal blobx, bloby : unsigned(9 downto 0);
	
	signal configuration_registers :  register_array(0 to 5) ;
	
	signal i2c_scl, i2c_sda : std_logic;
	begin

	--comment connections below when using pins
	LCD_RS <= 'Z' ;
	LCD_CS <= 'Z' ; 
	LCD_WR <= 'Z' ; 
	LCD_RD <= 'Z' ;
	LCD_DATA <= (others => 'Z')  ;
	FIFO_CS <= 'Z' ;
	FIFO_WR <= 'Z' ; 
	FIFO_RD <= 'Z' ; 
	FIFO_A0 <= 'Z' ;
	FIFO_DATA <= (others => 'Z')  ;

	process(clk0, resetn) -- reset process
	begin
		if resetn = '0' then
			resetn_time <= resetn_delay;
		elsif clk0'event and clk0 = '1' then
			if resetn_time = 0 then
				resetn_delayed <= '1' ;
			else
				resetn_delayed <= '0';
				resetn_time <= resetn_time - 1 ;
			end if;
		end if;
	end process;
	
	process(clk_96) -- clk div for uart process
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
	
	
	camera0: rgb565_camera_interface
		generic map(FORMAT => QVGA)
		port map(clock => clk_96,
		pixel_data => CAM_DATA, 
 		i2c_clk => clk_24,
		scl => i2c_scl ,
		sda => i2c_sda ,
 		resetn => resetn_delayed,
 		pxclk => CAM_PCLK, href => CAM_HREF, vsync => CAM_VSYNC,
 		pixel_clock_out => pxclk_from_interface, hsync_out => href_from_interface, vsync_out => vsync_from_interface,
 		r_data => pixel_r_from_interface,
		g_data => pixel_g_from_interface,
		b_data => pixel_b_from_interface
		);
		
		binr : binarization
		port map( 
				pixel_data_in => pixel_r_from_interface,
				upper_bound	=> configuration_registers(0),
				lower_bound	=> configuration_registers(1),
				pixel_data_out => binarized_pixel_r
		);
		
		bing : binarization
		port map( 
				pixel_data_in => pixel_g_from_interface,
				upper_bound	=> configuration_registers(2),
				lower_bound	=> configuration_registers(3),
				pixel_data_out => binarized_pixel_g 
		);
		
		binb : binarization
		port map( 
				pixel_data_in => pixel_b_from_interface,
				upper_bound	=> configuration_registers(4),
				lower_bound	=> configuration_registers(5),
				pixel_data_out => binarized_pixel_b 
		);
		
		
		binarized_pixel <= binarized_pixel_r AND binarized_pixel_g AND binarized_pixel_b;
		
		erode0 : erode3x3
		generic map(
		  WIDTH => 320,
		  HEIGHT => 240)
		port map(
				clk => clk_96,  
				resetn => resetn_delayed ,  
				pixel_clock => pxclk_from_interface, hsync => href_from_interface, vsync => vsync_from_interface,
				pixel_clock_out => pxclk_from_erode, hsync_out => href_from_erode, vsync_out => vsync_from_erode, 
				pixel_data_in => binarized_pixel, 
				pixel_data_out => pixel_from_erode

		);  
		
		
		down_scaler0: down_scaler
		generic map(SCALING_FACTOR => 4, INPUT_WIDTH => 320, INPUT_HEIGHT => 240 )
		port map(clk => clk_96,
		  resetn => resetn_delayed,
		  pixel_clock => pxclk_from_erode, hsync => href_from_erode, vsync => vsync_from_erode,
		  pixel_clock_out => pxclk_from_ds, hsync_out => href_from_ds, vsync_out => vsync_from_ds,
		  pixel_data_in => pixel_from_erode,
		  pixel_data_out => pixel_from_ds 
		);
		
		send_picture0: send_picture
		port map(
			clk => clk_96,
			resetn => resetn_delayed,
			pixel_clock => pxclk_from_ds, hsync => href_from_ds, vsync => vsync_from_ds, 
			pixel_data_in => pixel_from_ds,
			data_out => data_to_send, 
			send => send_signal, 
			output_ready => NOT tx_buffer_full
		);

	uart_tx0 : uart_tx 
    port map (   data_in => data_to_send, 
                 write_buffer => send_signal,
                 reset_buffer => NOT resetn_delayed, 
                 en_16_x_baud => clk_48,
                 serial_out => TXD,
                 clk => clk_96,
					  buffer_half_full => tx_buffer_full);

	uart_rx0 : uart_rx 
    port map(            serial_in => RXD,
                       data_out => data_to_read,
                    read_buffer => read_signal,
                   reset_buffer => NOT resetn_delayed,
                   en_16_x_baud => clk_48,
            buffer_data_present => data_present,
                            clk => clk_96);

configuration_module0 : configuration_module
	generic map(NB_REGISTERS => 6)
	port map(
		clk => clk_96, resetn =>  resetn_delayed,
		input_data	=> data_to_read,
		read_data	=> read_signal,
		data_present => data_present,
		vsync	=> vsync_from_interface,
		registers	=> configuration_registers
	);


end Structural;
