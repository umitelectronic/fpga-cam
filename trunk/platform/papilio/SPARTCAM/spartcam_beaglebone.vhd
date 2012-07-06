----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    14:14:22 06/21/2012 
-- Design Name: 
-- Module Name:    spartcam_beaglebone - Behavioral 
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

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

library work ;
use work.generic_components.all ;
use work.camera.all ;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity spartcam_beaglebone is
port( CLK : in std_logic;
		ARAZB	:	in std_logic;
		TXD	:	out std_logic;
		RXD   :	in std_logic;
		
		
		--camera interface
		CAM_XCLK	:	out std_logic;
		CAM_SIOC, CAM_SIOD	:	inout std_logic; 
		CAM_DATA	:	in std_logic_vector(7 downto 0);
		CAM_PCLK, CAM_HREF, CAM_VSYNC	:	in std_logic;
		CAM_RESET	:	out std_logic ;
		
		--beaglebone interface
		BEAGLE_ALE, BEAGLE_CSN, BEAGLE_WRN, BEAGLE_OEN:	in std_logic;
		BEAGLE_DATA :	inout std_logic_vector(15 downto 0);
		BEAGLE_ADDR :	in std_logic_vector(7 downto 0);
		--FIFO unsused signals
		FIFO_CS, FIFO_WR, FIFO_RD, FIFO_A0:	out std_logic
		
);
end spartcam_beaglebone;

architecture Behavioral of spartcam_beaglebone is


	COMPONENT dcm_32_120
	PORT(
		CLKIN_IN : IN std_logic;          
		CLKFX_OUT : OUT std_logic;
		CLKIN_IBUFG_OUT : OUT std_logic;
		CLK0_OUT : OUT std_logic;
		LOCKED_OUT : OUT std_logic
		);
	END COMPONENT;
	
	COMPONENT dcm_120_24
	PORT(
		CLKIN_IN : IN std_logic;          
		CLKDV_OUT : OUT std_logic;
		CLK0_OUT : OUT std_logic;
		LOCKED_OUT : OUT std_logic
		);
	END COMPONENT;

signal clk_120, clk_24: std_logic ;
	signal baud_count, arazb_delayed, clk0, clk0_buf, cam_reset_delayed : std_logic ;
	signal baud_rate_divider : integer range 0 to 53 := 0 ;
	signal cam_clock_divider : integer range 0 to 10 := 0 ;
	
	
	signal fifo_output : std_logic_vector(15 downto 0);
	signal fifo_input : std_logic_vector(15 downto 0);
	signal fifoB_wr, fifoA_rd, fifoA_empty, fifoA_full, fifoB_empty, fifoB_full : std_logic ;
	
	signal bus_data_in, bus_data_out : std_logic_vector(15 downto 0);
	signal bus_addr : std_logic_vector(7 downto 0);
	signal bus_wr, bus_rd, bus_cs : std_logic ;
	
	signal pixel_from_interface : std_logic_vector(7 downto 0);
	signal pxclk_from_interface, href_from_interface, vsync_from_interface : std_logic ;

begin

--comment connections below when using pins
	FIFO_CS <= bus_cs ;
	FIFO_WR <= href_from_interface ; 
	FIFO_RD <= pxclk_from_interface ; 
	FIFO_A0 <= 'Z' ;
	
	CAM_RESET <= ARAZB ;

	TXD <= 'Z' ;


	reset0: reset_generator 
	generic map(HOLD_0 => 500000)
	port map(clk => clk0, 
		arazb => ARAZB ,
		arazb_0 => arazb_delayed
	 );


	
	Inst_dcm_32_120: dcm_32_120 PORT MAP(
		CLKIN_IN => clk,
		CLKFX_OUT => clk_120,
		CLK0_OUT => clk0
	);	
	
	Inst_dcm_120_24: dcm_120_24 PORT MAP(
		CLKIN_IN => clk_120,
		CLKDV_OUT => clk_24
	);





mem_interface0 : addr_interface
generic map(ADDR_WIDTH => 8 , DATA_WIDTH => 16)
		port map(clk => clk_120 , arazb => arazb_delayed ,
		  data	=> BEAGLE_DATA ,
		  addr	=> BEAGLE_ADDR ,
		  wrn => BEAGLE_WRN, oen => BEAGLE_OEN, csn => BEAGLE_CSN ,
		  data_bus_in	=> bus_data_in ,
		  data_bus_out	=> bus_data_out ,
		  addr_bus	=> bus_addr ,
		  wr => bus_wr, rd => bus_rd
		);



bi_fifo0 : fifo_peripheral 
		generic map(BASE_ADDR => 0, ADDR_WIDTH => 8,WIDTH => 16, SIZE => 1024)
		port map(
			clk => clk_120,
			arazb => arazb_delayed,
			addr_bus => bus_addr,
			wr_bus => bus_wr,
			rd_bus => bus_rd,
			wrB => fifoB_wr,
			rdA => fifoA_rd,
			data_bus_in => bus_data_out,
			data_bus_out => bus_data_in,
			inputB => fifo_input,
			outputA => fifo_output,
			emptyA => fifoA_empty,
			fullA => fifoA_full,
			emptyB => fifoB_empty,
			fullB => fifoB_full
		);
	
 camera0: yuv_camera_interface
		generic map(FORMAT => QVGA)
		port map(clock => clk_120,
			pixel_data => CAM_DATA, 
			i2c_clk => clk_24,
			scl => CAM_SIOC ,
			sda => CAM_SIOD ,
			arazb => arazb_delayed,
			pxclk => CAM_PCLK, href => CAM_HREF, vsync => CAM_VSYNC,
			pixel_clock_out => pxclk_from_interface, hsync_out => href_from_interface, vsync_out => vsync_from_interface,
			y_data => pixel_from_interface
		);	

CAM_XCLK <= clk_24 ;


fifoB_wr <= pxclk_from_interface OR vsync_from_interface;
fifo_input <= (X"AA55") when vsync_from_interface = '1' else
				  (X"00" & pixel_from_interface);


end Behavioral;

