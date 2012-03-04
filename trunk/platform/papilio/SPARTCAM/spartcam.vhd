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

library work;
use work.camera.all ;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity spartcam is
port( CLK : in std_logic;
		ARAZB	:	in std_logic;
		CAM_XCLK	:	out std_logic;
		TXD	:	out std_logic;
		CAM_SIOC, CAM_SIOD	:	inout std_logic; 
		CAM_DATA	:	in std_logic_vector(7 downto 0);
		CAM_PCLK, CAM_HREF, CAM_VSYNC	:	in std_logic;
		CAM_PCLK_OUT, CAM_HREF_OUT, CAM_VSYNC_OUT	:	out std_logic;
		CAM_RESET	:	out std_logic ;
		CAM_PWEN		:	out std_logic
);
end spartcam;

architecture Structural of spartcam is

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

	signal clk_24, clk_96, clk_48 : std_logic ;
	signal baud_count, arazb_delayed, clk0 : std_logic ;
	constant arazb_delay : integer := 1000000 ;
	signal arazb_time : integer range 0 to 1048576 := arazb_delay ;

	signal pixel_from_interface : std_logic_vector(7 downto 0);
	signal pixel_from_ds : std_logic_vector(7 downto 0);
	signal data_to_send : std_logic_vector(7 downto 0);
	signal send_signal, tx_buffer_full	:	std_logic ;
	signal pxclk_from_interface, href_from_interface, vsync_from_interface : std_logic ;
	signal pxclk_from_ds, href_from_ds, vsync_from_ds : std_logic ;
	signal i2c_scl, i2c_sda : std_logic;
	begin

	process(clk0, arazb) -- reset process
	begin
		if arazb = '0' then
			arazb_time <= arazb_delay;
		elsif clk0'event and clk0 = '1' then
			if arazb_time = 0 then
				arazb_delayed <= '1' ;
			else
				arazb_delayed <= '0';
				arazb_time <= arazb_time - 1 ;
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

	CAM_RESET <= arazb ;
	CAM_PWEN <= '0';
	CAM_XCLK <= clk_24 ;
	--CAM_PCLK_OUT <= CAM_PCLK;
	--CAM_HREF_OUT <= CAM_HREF;
	--CAM_VSYNC_OUT <= CAM_VSYNC;
	--CAM_PCLK_OUT <= pxclk_from_interface;
	--CAM_HREF_OUT <= href_from_interface;
	--CAM_VSYNC_OUT <= vsync_from_interface;
	--CAM_PCLK_OUT <= pxclk_from_ds;
	--CAM_HREF_OUT <= href_from_ds;
	--CAM_VSYNC_OUT <= vsync_from_ds;
	
	CAM_HREF_OUT <= i2c_scl;
	CAM_VSYNC_OUT <= i2c_sda;
	CAM_PCLK_OUT <= 'Z';
	
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
		port map(clock => clk_96,
		pixel_data => CAM_DATA, 
 		i2c_clk => clk_24,
		scl => i2c_scl ,
		sda => i2c_sda ,
 		arazb => arazb_delayed,
 		pxclk => CAM_PCLK, href => CAM_HREF, vsync => CAM_VSYNC,
 		new_pix => pxclk_from_interface, new_line => href_from_interface, new_frame => vsync_from_interface,
 		y_data => pixel_from_interface
		);
		
		down_scaler0: down_scaler
		port map(clk => clk_96,
		  arazb => arazb_delayed,
		  pixel_clock => pxclk_from_interface, hsync => href_from_interface, vsync => vsync_from_interface,
		  pixel_clock_out => pxclk_from_ds, hsync_out => href_from_ds, vsync_out => vsync_from_ds,
		  pixel_data_in => pixel_from_interface,
		  pixel_data_out => pixel_from_ds 
		);
		
		send_picture0: send_picture
		port map(
			clk => clk_96,
			arazb => arazb_delayed,
			pixel_clock => pxclk_from_ds, hsync => href_from_ds, vsync => vsync_from_ds, 
			pixel_data_in => pixel_from_ds,
			data_out => data_to_send, 
			send => send_signal, 
			output_ready => NOT tx_buffer_full
		);

	uart_tx0 : uart_tx 
    port map (   data_in => data_to_send, 
                 write_buffer => send_signal,
                 reset_buffer => NOT arazb_delayed, 
                 en_16_x_baud => clk_48,
                 serial_out => TXD,
                 clk => clk_96,
					  buffer_half_full => tx_buffer_full);



end Structural;

