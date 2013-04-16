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
use IEEE.NUMERIC_STD.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

library work ;
use work.utils_pack.all ;
use work.peripheral_pack.all ;
use work.interface_pack.all ;
use work.filter_pack.all ;
use work.image_pack.all ;
use work.feature_pack.all ;
-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
library UNISIM;
use UNISIM.VComponents.all;

entity logibone_tracking is
port( OSC_FPGA : in std_logic;
		PB : in std_logic_vector(1 downto 0);
		LED : out std_logic_vector(1 downto 0);	
		
		--gpmc interface
		GPMC_CSN : in std_logic_vector(2 downto 0);
		GPMC_WEN, GPMC_OEN, GPMC_ADVN, GPMC_CLK, GPMC_BE0N, GPMC_BE1N:	in std_logic;
		GPMC_AD :	inout std_logic_vector(15 downto 0)	
);
end logibone_tracking;

architecture Behavioral of logibone_tracking is

	COMPONENT clock_gen
	PORT(
		CLK_IN1 : IN std_logic;          
		CLK_OUT1 : OUT std_logic;
		CLK_OUT2 : OUT std_logic;
		CLK_OUT3 : OUT std_logic;
		LOCKED : OUT std_logic
		);
	END COMPONENT;

	constant DESC_SIZE : integer := 128 ;
	constant IMG_WIDTH : integer := 320 ;
	constant IMG_HEIGHT : integer := 240 ;
	
	signal clk_sys, clk_100, clk_24, clk_48, clk_locked : std_logic ;
	signal resetn , sys_resetn : std_logic ;
	signal counter_output : std_logic_vector(31 downto 0);
	signal fifo_image_output, fifo_image_input : std_logic_vector(15 downto 0);
	signal fifo_correl_output, fifo_correl_input : std_logic_vector(15 downto 0);
	signal fifo_feat_output, fifo_feat_input : std_logic_vector(15 downto 0);
	signal fifo_image_wr, fifo_image_rd : std_logic ;
	signal fifo_feat_wr, fifo_feat_rd : std_logic ;
	signal fifo_correl_wr, fifo_correl_rd : std_logic ;
	signal bus_data_in, bus_data_out : std_logic_vector(15 downto 0);
	signal bus_fifo_image_out, bus_fifo_feat_out,bus_fifo_correl_out : std_logic_vector(15 downto 0);
	signal bus_addr : std_logic_vector(15 downto 0);
	signal bus_wr, bus_rd, bus_cs : std_logic ;
	signal cs_image_fifo, cs_feat_fifo, cs_correl_fifo : std_logic ;
	signal fifo_image_empty : std_logic ;
	
	signal cam_data : std_logic_vector(7 downto 0);
	signal cam_sioc, cam_siod : std_logic ;
	signal cam_xclk, cam_pclk, cam_vsync, cam_href, cam_reset : std_logic ;
	
	signal rom_addr : std_logic_vector(7 downto 0);
	signal rom_data : std_logic_vector(15 downto 0);
	
	signal pixel_from_interface : std_logic_vector(7 downto 0);
	signal pxclk_from_interface, href_from_interface, vsync_from_interface : std_logic ;

	signal pixel_from_harris : std_logic_vector(7 downto 0);
	signal raw_from_harris : std_logic_vector(15 downto 0);
	signal pxclk_from_harris, href_from_harris, vsync_from_harris : std_logic ;
	
	signal output_pxclk, output_href , output_vsync : std_logic ;
	signal output_pixel : std_logic_vector(7 downto 0) ;
	
	signal feat_desc, feature_descriptor : std_logic_vector((DESC_SIZE-1) downto 0);
	
	signal new_feature, new_desc, write_feature, latch_desc : std_logic ;
	signal featx, featy, feat_score : std_logic_vector(15 downto 0) ;
begin
	
	resetn <= PB(0) ;
	sys_clocks_gen: clock_gen 
	PORT MAP(
		CLK_IN1 => OSC_FPGA,
		CLK_OUT1 => clk_100,
		CLK_OUT2 => clk_24,
		CLK_OUT3 => clk_sys, --60Mhz system clock
		LOCKED => clk_locked
	);


	reset0: reset_generator 
	generic map(HOLD_0 => 1000)
	port map(clk => clk_sys, 
		resetn => resetn ,
		resetn_0 => sys_resetn
	 );


divider : simple_counter 
	 generic map(NBIT => 32)
    port map( clk => clk_sys, 
           resetn => sys_resetn, 
           sraz => '0',
           en => '1',
			  load => '0' ,
			  E => X"00000000",
			  Q => counter_output
			  );
LED(0) <= counter_output(24);
LED(1) <= NOT GPMC_CSN(1) ;
mem_interface0 : sync_muxed_addr_interface
generic map(ADDR_WIDTH => 16 , DATA_WIDTH =>  16)
port map(clk => clk_sys ,
	  resetn => sys_resetn ,
	  data	=> GPMC_AD,
	  ext_clk => gpmc_clk, wrn => GPMC_WEN, oen => GPMC_OEN, addr_en_n => GPMC_ADVN, csn => GPMC_CSN(1),
	  be0n => GPMC_BE0N, be1n => GPMC_BE1N,
	  data_bus_out	=> bus_data_out,
	  data_bus_in	=> bus_data_in ,
	  addr_bus	=> bus_addr, 
	  wr => bus_wr , rd => bus_rd 
);

cs_image_fifo <= '1' when bus_addr(15 downto 10) = "000000" else
			  '0' ;	  
cs_feat_fifo <= '1' when bus_addr(15 downto 10) = "000001" else
			  '0' ;
cs_correl_fifo <= '1' when bus_addr(15 downto 10) = "000010" else
			  '0' ;

bus_data_in <= bus_fifo_image_out when cs_image_fifo = '1' else
					bus_fifo_feat_out when cs_feat_fifo = '1' else
					bus_fifo_correl_out when cs_correl_fifo = '1' else
					(others => '1');

image_fifo : fifo_peripheral 
		generic map(ADDR_WIDTH => 16,
						WIDTH => 16, SIZE => 4096, 
						BURST_SIZE => 512,
						SYNC_LOGIC_INTERFACE => false)
		port map(
			clk => clk_sys,
			resetn => sys_resetn,
			addr_bus => bus_addr,
			wr_bus => bus_wr,
			rd_bus => bus_rd,
			cs_bus => cs_image_fifo,
			wrB => fifo_image_wr,
			rdA => fifo_image_rd,
			data_bus_in => bus_data_out,
			data_bus_out => bus_fifo_image_out,
			inputB => fifo_image_input, 
			outputA => fifo_image_output,
			emptyA => fifo_image_empty,
			fullA => open,
			emptyB => open,
			fullB => open
		);
		
		feat_fifo : fifo_peripheral 
		generic map(ADDR_WIDTH => 16,
						WIDTH => 16, 
						SIZE => 1024, 
						BURST_SIZE => 512,
						SYNC_LOGIC_INTERFACE => true
		)
		port map(
			clk => clk_sys,
			resetn => sys_resetn,
			addr_bus => bus_addr,
			wr_bus => bus_wr,
			rd_bus => bus_rd,
			cs_bus => cs_feat_fifo,
			wrB => fifo_feat_wr,
			rdA => '0',
			data_bus_in => bus_data_out,
			data_bus_out => bus_fifo_feat_out,
			inputB => fifo_feat_input, 
			outputA => open,
			emptyA => open,
			fullA => open,
			emptyB => open,
			fullB => open
		);
		
		
		correl_fifo : fifo_peripheral 
		generic map(ADDR_WIDTH => 16,
						WIDTH => 16, 
						SIZE => 1024, 
						BURST_SIZE => 512,
						SYNC_LOGIC_INTERFACE => true
		)
		port map(
			clk => clk_sys,
			resetn => sys_resetn,
			addr_bus => bus_addr,
			wr_bus => bus_wr,
			rd_bus => bus_rd,
			cs_bus => cs_correl_fifo,
			wrB => fifo_correl_wr,
			rdA => fifo_correl_rd,
			data_bus_in => bus_data_out,
			data_bus_out => bus_fifo_correl_out,
			inputB => fifo_correl_input, 
			outputA => fifo_correl_output, 
			emptyA => open,
			fullA => open,
			emptyB => open,
			fullB => open
		);


brief0: BRIEF_MANAGER 
generic map(WIDTH => IMG_WIDTH,
		  HEIGHT => IMG_HEIGHT,
		  DESC_SIZE => DESC_SIZE,
		  NB_LMK => 4, 
		  DELAY => 1 )
port map(
 		clk => clk_sys,
 		resetn => sys_resetn,
 		pixel_clock => pxclk_from_interface, 
		hsync => href_from_interface, 
		vsync => vsync_from_interface, 
 		pixel_data_in => pixel_from_interface,
-- active search interface
		correl_fifo_in => fifo_correl_output ,
		rd_correl_fifo => fifo_correl_rd,
		
		correl_fifo_out => fifo_correl_input,
		wr_correl_fifo => fifo_correl_wr,

-- feature descriptor interface
		feature_descriptor => feat_desc,
		new_descriptor => new_desc			

);


harris0 : HARRIS
generic map(WIDTH => IMG_WIDTH, HEIGHT => IMG_HEIGHT, WINDOW_SIZE => 5, DS_FACTOR => 2)
port map(
		clk => clk_sys , 
 		resetn => sys_resetn,  
 		pixel_clock => pxclk_from_interface, hsync => href_from_interface, vsync => vsync_from_interface, 
 		pixel_clock_out => pxclk_from_harris, hsync_out => href_from_harris, vsync_out => vsync_from_harris,
 		pixel_data_in => pixel_from_interface,
 		harris_out => raw_from_harris
);

tessel_harris: HARRIS_TESSELATION
	generic map(WIDTH => IMG_WIDTH, HEIGHT => IMG_HEIGHT, TILE_NBX => 8, TILE_NBY => 6, IGNORE_STRIPES => 7 )
	port map(
			clk => clk_sys, 
			resetn => sys_resetn,
			pixel_clock => pxclk_from_harris, 
			hsync => href_from_harris, 
			vsync => vsync_from_harris, 
			harris_score_in => raw_from_harris, 
			feature_coordx	=> featx(nbit(IMG_WIDTH)-1 downto 0), -- need to connect to a fifo
			feature_coordy	=> featy(nbit(IMG_HEIGHT)-1 downto 0), -- need to connect to a fifo
			end_of_block	=> write_feature, -- to write to the fifo
			harris_score_out	=> feat_score, -- fifo input
			latch_maxima	=> latch_desc -- unused ...
	);


feat2fif : feature2fifo
generic map(FEATURE_SIZE => DESC_SIZE)
port map(
	clk => clk_sys, resetn => sys_resetn,
	feature_desc => feat_desc,
	new_feature_desc => new_desc, 
	harris_posx => featx, harris_posy => featy, harris_score => feat_score,
	new_max => latch_desc,
	write_feature => write_feature,
	
	--fifo interface
	fifo_data => fifo_feat_input,
	fifo_wr => fifo_feat_wr

);




pixel_from_harris <= X"00" when raw_from_harris(15) ='1' else
							raw_from_harris(14 downto 7);	

output_pxclk <= pxclk_from_harris ;
output_href <= href_from_harris ;
output_vsync <= vsync_from_harris ;
output_pixel <= pixel_from_harris ;

pixel2fifo0 :  pixel2fifo
port map(
	clk => clk_sys, resetn => sys_resetn ,
	pixel_clock => output_pxclk, hsync => output_href, vsync => output_vsync,
	pixel_data_in => output_pixel ,
	fifo_data => fifo_image_input,
	fifo_wr => fifo_image_wr
);

pixel_from_fifo : fifo2pixel
generic map(WIDTH => IMG_WIDTH , HEIGHT => IMG_HEIGHT)
port map(
	clk => clk_sys, resetn => sys_resetn ,

	-- fifo side
	fifo_empty => fifo_image_empty ,
	fifo_rd => fifo_image_rd ,
	fifo_data =>fifo_image_output,
	
	-- pixel side 
	pixel_clk => clk_24,
	y_data =>  pixel_from_interface , 
	pixel_clock_out => pxclk_from_interface, 
	hsync_out => href_from_interface, 
	vsync_out =>vsync_from_interface 

);
	
	
end Behavioral;

