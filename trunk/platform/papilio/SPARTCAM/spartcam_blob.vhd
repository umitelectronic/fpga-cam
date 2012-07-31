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

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity spartcam_blob is
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
end spartcam_blob;


architecture Structural of spartcam_blob is

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

	signal clk_24, clk_96, clk_48, clk_1_8 : std_logic ;
	signal baud_count, resetn_delayed, clk0, cam_reset_delayed : std_logic ;
	signal baud_rate_divider : integer range 0 to 53 := 0 ;

	signal pixel_y_from_interface, pixel_u_from_interface, pixel_v_from_interface : std_logic_vector(7 downto 0);
	signal pixel_from_ds : std_logic_vector(7 downto 0);
	
	signal pixel_from_conv : std_logic_vector(7 downto 0);
	signal binarized_pixel , binarized_pixel_y , binarized_pixel_u , binarized_pixel_v  : std_logic_vector(7 downto 0);
	signal pixel_from_erode : std_logic_vector(7 downto 0);
	signal pixel_from_dilate : std_logic_vector(7 downto 0);
	signal pixel_from_square: std_logic_vector(7 downto 0);
	signal pixel_from_blob: std_logic_vector(7 downto 0);
	signal pixel_from_switch: std_logic_vector(7 downto 0);
	
	signal raw_data : std_logic_vector(7 downto 0 );
	signal raw_data_available : std_logic := '0' ;
	signal read_raw_data : std_logic ;
	
	signal data_to_send : std_logic_vector(7 downto 0);
	signal data_to_read : std_logic_vector(7 downto 0);
	signal send_signal, tx_buffer_full, read_signal, data_present	:	std_logic ;
	signal pxclk_from_interface, href_from_interface, vsync_from_interface : std_logic ;
	signal pxclk_from_bin, href_from_bin, vsync_from_bin : std_logic ;
	signal pxclk_from_ds, href_from_ds, vsync_from_ds : std_logic ;
	signal pxclk_from_conv, href_from_conv, vsync_from_conv : std_logic ;
	signal pxclk_from_erode, href_from_erode, vsync_from_erode : std_logic ;
	signal pxclk_from_dilate, href_from_dilate, vsync_from_dilate : std_logic ;
	signal pxclk_from_blob, href_from_blob, vsync_from_blob : std_logic ;
	signal pxclk_from_square, href_from_square, vsync_from_square : std_logic ;
	signal pxclk_from_switch, href_from_switch, vsync_from_switch : std_logic ;
	signal blobx, bloby : unsigned(9 downto 0);
	
	signal configuration_registers :  register_array(0 to 6) ;
	
	signal fifo_empty, fifo_wr0, send_data, tx1_buffer_full : std_logic ;
	signal fifo_input, fifo_output : std_logic_vector(7 downto 0);
	
	signal i2c_scl, i2c_sda : std_logic;
	
	constant nb_channels : integer := 4 ;
	signal pxclk_to_switch, hsync_to_switch, vsync_to_switch	: std_logic_vector(nb_channels - 1 downto 0);
	signal pixel_to_switch	: slv8_array(nb_channels - 1 downto 0);
	begin


--comment connections below when using pins
	LCD_RS <= 'Z' ;
	LCD_CS <= 'Z' ; 
	LCD_WR <= 'Z' ; 
	LCD_RD <= 'Z' ;
	LCD_DATA <= (others => 'Z')  ;
	FIFO_CS <= 'Z' ;
	--FIFO_WR <= 'Z' ; 
	FIFO_RD <= 'Z' ; 
	FIFO_A0 <= 'Z' ;
	FIFO_DATA <= (others => 'Z')  ;


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
		
		
		bin_pixel0:  synced_binarization 
		port map( clk	=> clk_96, 
				resetn	=> resetn_delayed,
				pixel_clock => pxclk_from_interface, hsync =>  href_from_interface, vsync => vsync_from_interface, 
				pixel_clock_out => pxclk_from_bin, hsync_out => href_from_bin, vsync_out => vsync_from_bin, 
				pixel_data_1 => pixel_y_from_interface,
				pixel_data_2 => pixel_u_from_interface,
				pixel_data_3 => pixel_v_from_interface,
				upper_bound_1	=>	configuration_registers(0) ,
				upper_bound_2	=>	configuration_registers(2) ,
				upper_bound_3	=>	configuration_registers(4) ,
				lower_bound_1	=>	configuration_registers(1),
				lower_bound_2	=>	configuration_registers(3),
				lower_bound_3	=>	configuration_registers(5),
				pixel_data_out => binarized_pixel 
		);
		
--		biny : binarization
--		port map( 
--				pixel_data_in => pixel_y_from_interface,
--				upper_bound	=> configuration_registers(0),
--				lower_bound	=> configuration_registers(1),
--				pixel_data_out => binarized_pixel 
--		);
		
		
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
		
		
		blob_detection0:  blob_detection
		generic map(LINE_SIZE => 320)
		port map(
 		clk => clk_96, 
 		resetn => resetn_delayed,
 		pixel_clock => pxclk_from_erode, hsync => href_from_erode, vsync => vsync_from_erode,
		pixel_data_in => pixel_from_erode,
		blob_data => fifo_input,
		send_blob => fifo_wr0
		);
		
		fifo_128x8_0 : fifo_Nx8 -- blob data fifo
			generic map(N =>64)
			port map(
			clk => clk_96, 
			resetn => resetn_delayed,
			sraz => '0',
			wr => fifo_wr0 , 
			rd => NOT tx1_buffer_full, 
			data_rdy => send_data,
			data_out => fifo_output,  
			data_in => fifo_input
		); 
		
		uart_tx1 : uart_tx 
		port map ( data_in => fifo_output, 
                 write_buffer => send_data,
                 reset_buffer => NOT resetn_delayed, 
                 en_16_x_baud => clk_1_8,
                 serial_out => FIFO_WR,
                 clk => clk_96,
					  buffer_half_full => tx1_buffer_full);
		
		
pxclk_to_switch <= (pxclk_from_erode & pxclk_from_interface & pxclk_from_interface & pxclk_from_interface ) ;
hsync_to_switch <= (href_from_erode & href_from_interface & href_from_interface & href_from_interface) ;
vsync_to_switch <= (vsync_from_erode & vsync_from_interface & vsync_from_interface & vsync_from_interface) ;
pixel_to_switch <= (pixel_y_from_interface, pixel_u_from_interface, pixel_v_from_interface, pixel_from_erode);


	
switch0 : video_switch
generic map(NB	=> nb_channels)
port map(pixel_clock => pxclk_to_switch, 
		   hsync => hsync_to_switch, 
			vsync => vsync_to_switch,
	  pixel_data => pixel_to_switch,
	  pixel_clock_out => pxclk_from_switch, hsync_out => href_from_switch, vsync_out => vsync_from_switch,
	  pixel_data_out	=> pixel_from_switch,
	  channel	=> configuration_registers(6)
	);
		
		
		
		down_scaler0: down_scaler
		generic map(SCALING_FACTOR => 4, INPUT_WIDTH => 320, INPUT_HEIGHT => 240 )
		port map(clk => clk_96,
		  resetn => resetn_delayed,
		  pixel_clock => pxclk_from_switch, hsync => href_from_switch, vsync => vsync_from_switch,
		  pixel_clock_out => pxclk_from_ds, hsync_out => href_from_ds, vsync_out => vsync_from_ds,
		  pixel_data_in => pixel_from_switch,
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
	generic map(NB_REGISTERS => 7)
	port map(
		clk => clk_96, resetn =>  resetn_delayed,
		input_data	=> data_to_read,
		read_data	=> read_signal,
		data_present => data_present,
		vsync	=> vsync_from_interface,
		registers	=> configuration_registers
	);


end Structural;
