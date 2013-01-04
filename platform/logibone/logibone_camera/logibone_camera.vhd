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
use IEEE.STD_LOGIC_UNSIGNED.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

library work ;
use work.utils_pack.all ;
use work.peripheral_pack.all ;
use work.interface_pack.all ;
use work.conf_pack.all ;
use work.filter_pack.all ;
-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
library UNISIM;
use UNISIM.VComponents.all;

entity logibone_camera is
port( OSC_FPGA : in std_logic;
		PB : in std_logic_vector(1 downto 0);
		LED : out std_logic_vector(1 downto 0);
		
		--PMOD
		PMOD1_1, PMOD1_2  : inout std_logic ; -- used as SCL, SDA
		PMOD1_3 ,PMOD1_4 : out std_logic ; -- used as reset and xclk 
		PMOD1_7, PMOD1_8, PMOD1_9, PMOD1_10 : in std_logic ; -- used as pclk, href, vsync
		PMOD2 : in std_logic_vector(7 downto 0); -- used as cam data
		
		
		--gpmc interface
		GPMC_CSN : in std_logic_vector(2 downto 0);
		GPMC_WEN, GPMC_OEN, GPMC_ADVN, GPMC_CLK, GPMC_BE0N, GPMC_BE1N:	in std_logic;
		GPMC_AD :	inout std_logic_vector(15 downto 0)	
);
end logibone_camera;

architecture Behavioral of logibone_camera is

	COMPONENT clock_gen
	PORT(
		CLK_IN1 : IN std_logic;          
		CLK_OUT1 : OUT std_logic;
		CLK_OUT2 : OUT std_logic;
		CLK_OUT3 : OUT std_logic;
		LOCKED : OUT std_logic
		);
	END COMPONENT;

	
	signal clk_sys, clk_100, clk_24, clk_locked : std_logic ;
	signal resetn , sys_resetn : std_logic ;
	
	signal counter_output : std_logic_vector(31 downto 0);
	signal fifo_output : std_logic_vector(15 downto 0);
	signal fifo_input : std_logic_vector(15 downto 0);
	signal latch_output : std_logic_vector(15 downto 0);
	signal fifoB_wr, fifoA_rd, fifoA_rd_old, fifoA_empty, fifoA_full, fifoB_empty, fifoB_full : std_logic ;
	signal fifo_full_rising_edge, fifo_full_old : std_logic ;
	signal bus_data_in, bus_data_out : std_logic_vector(15 downto 0);
	signal bus_fifo_out, bus_latch_out : std_logic_vector(15 downto 0);
	signal bus_addr : std_logic_vector(7 downto 0);
	signal bus_wr, bus_rd, bus_cs : std_logic ;
	signal cs_fifo, cs_latch : std_logic ;
	
	
	signal cam_data : std_logic_vector(7 downto 0);
	signal cam_sioc, cam_siod : std_logic ;
	signal cam_xclk, cam_pclk, cam_vsync, cam_href, cam_reset : std_logic ;
	
	signal rom_addr : std_logic_vector(7 downto 0);
	signal rom_data : std_logic_vector(15 downto 0);
	
	signal pixel_from_interface : std_logic_vector(7 downto 0);
	signal pxclk_from_interface, href_from_interface, vsync_from_interface : std_logic ;
	signal pixel_from_sobel : std_logic_vector(7 downto 0);
	signal pxclk_from_sobel, href_from_sobel, vsync_from_sobel : std_logic ;
	
	signal output_pxclk, output_href , output_vsync : std_logic ;
	signal output_pixel : std_logic_vector(7 downto 0);
	signal hsync_rising_edge, vsync_rising_edge, pxclk_rising_edge, hsync_old, vsync_old, pxclk_old, write_pixel_old : std_logic ;
	signal pixel_buffer : std_logic_vector(15 downto 0);	
	signal pixel_count :std_logic_vector(7 downto 0);
	signal write_pixel : std_logic ;
	
	for all : yuv_register_rom use entity work.yuv_register_rom(ov7670_qvga);
	
begin
	
	resetn <= PB(0) ;
	sys_clocks_gen: clock_gen 
	PORT MAP(
		CLK_IN1 => OSC_FPGA,
		CLK_OUT1 => clk_100,
		CLK_OUT2 => clk_24,
		CLK_OUT3 => clk_sys, --120Mhz system clock
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
LED(1) <= cam_vsync ;
mem_interface0 : muxed_addr_interface
generic map(ADDR_WIDTH => 8 , DATA_WIDTH =>  16)
port map(clk => clk_sys ,
	  resetn => sys_resetn ,
	  data	=> GPMC_AD,
	  wrn => GPMC_WEN, oen => GPMC_OEN, addr_en_n => GPMC_ADVN, csn => GPMC_CSN(1),
	  data_bus_out	=> bus_data_out,
	  data_bus_in	=> bus_data_in ,
	  addr_bus	=> bus_addr, 
	  wr => bus_wr , rd => bus_rd 
);

cs_fifo <= '1' when bus_addr(7 downto 3) = "00000" else
			  '0' ;	  

bus_data_in <= bus_fifo_out when cs_fifo = '1' else
					(others => '1');

bi_fifo0 : fifo_peripheral 
		generic map(ADDR_WIDTH => 8,WIDTH => 16, SIZE => 16384)
		port map(
			clk => clk_sys,
			resetn => sys_resetn,
			addr_bus => bus_addr,
			wr_bus => bus_wr,
			rd_bus => bus_rd,
			cs_bus => cs_fifo,
			wrB => fifoB_wr,
			rdA => fifoA_rd,
			data_bus_in => bus_data_out,
			data_bus_out => bus_fifo_out,
			inputB => fifo_input, 
			outputA => fifo_output,
			emptyA => fifoA_empty,
			fullA => fifoA_full,
			emptyB => fifoB_empty,
			fullB => fifoB_full
		);
		
		
 
 conf_rom : yuv_register_rom
	port map(
	   clk => clk_sys, en => '1' ,
 		data => rom_data,
 		addr => rom_addr
	); 
 
 camera_conf_block : i2c_conf 
	generic map(ADD_WIDTH => 8 , SLAVE_ADD => "0100001")
	port map(
		clock => clk_sys, 
		resetn => sys_resetn ,		
 		i2c_clk => clk_24 ,
		scl => PMOD1_1,
 		sda => PMOD1_2, 
		reg_addr => rom_addr ,
		reg_data => rom_data
	);	
		
 camera0: yuv_camera_interface
		port map(clock => clk_sys,
					resetn => sys_resetn,
					pixel_data => cam_data, 
					pxclk => cam_pclk, href => cam_href, vsync => cam_vsync,
					pixel_clock_out => pxclk_from_interface, hsync_out => href_from_interface, vsync_out => vsync_from_interface,
					y_data => pixel_from_interface
		);	
		
	cam_xclk <= clk_24;
	PMOD1_4 <= cam_xclk ;
	cam_data <= PMOD2 ;
	cam_pclk <= PMOD1_7 ;
	cam_href <= PMOD1_8 ;
	cam_vsync <= PMOD1_9 ;
	PMOD1_3 <= cam_reset ;
	cam_reset <= resetn ;

soberl_filter : sobel3x3 
generic map(WIDTH => 320, HEIGHT => 240)
port map(
 		clk => clk_sys, 
 		resetn => sys_resetn ,
 		pixel_clock => pxclk_from_interface, hsync => href_from_interface, vsync => vsync_from_interface,
 		pixel_clock_out => pxclk_from_sobel, hsync_out => href_from_sobel, vsync_out => vsync_from_sobel,
 		pixel_data_in => pixel_from_interface,
 		pixel_data_out => pixel_from_sobel
		--x_grad	:	out signed(7 downto 0);
		--y_grad	:	out signed(7 downto 0)
);
output_pxclk <= pxclk_from_sobel ;
output_href <= href_from_sobel ;
output_vsync <= vsync_from_sobel ;
output_pixel <= pixel_from_sobel ;
		
	process(clk_sys, sys_resetn)
begin
	if sys_resetn = '0' then
		vsync_old <= '0' ;
	elsif clk_sys'event and clk_sys = '1' then
		vsync_old <= output_vsync ;
	end if ;
end process ;
vsync_rising_edge <= (NOT vsync_old) and output_vsync ;

process(clk_sys, sys_resetn)
begin
	if sys_resetn = '0' then
		hsync_old <= '0' ;
	elsif clk_sys'event and clk_sys = '1' then
		hsync_old <= output_href ;
	end if ;
end process ;
hsync_rising_edge <= (NOT hsync_old) and output_href ;

process(clk_sys, sys_resetn)
begin
	if sys_resetn = '0' then
		pxclk_old <= '0' ;
	elsif clk_sys'event and clk_sys = '1' then
		pxclk_old <= output_pxclk ;
	end if ;
end process ;
pxclk_rising_edge <= (NOT pxclk_old) and output_pxclk ;

process(clk_sys, sys_resetn)
begin
	if sys_resetn = '0' then
		pixel_buffer(15 downto 0) <= (others => '0') ;
	elsif clk_sys'event and clk_sys = '1' then
		if hsync_rising_edge = '1' then
			pixel_buffer(15 downto 0) <= (others => '0') ;
		elsif pxclk_rising_edge = '1' then
			pixel_buffer(7 downto 0) <= pixel_buffer(15 downto 8) ;
			pixel_buffer(15 downto 8)  <= output_pixel ;
		end if ;
	end if ;
end process ;

process(clk_sys, sys_resetn)
begin
	if sys_resetn = '0' then
		pixel_count <= (others => '0'); 
	elsif clk_sys'event and clk_sys = '1' then
		if hsync_rising_edge = '1' then
			pixel_count <= (others => '0'); 
		elsif pxclk_rising_edge = '1'  and href_from_interface = '0' then
			pixel_count <= pixel_count + 1 ;
		end if ;
	end if ;
end process ;
write_pixel <= pixel_count(0);

process(clk_sys, sys_resetn)
begin
	if sys_resetn = '0' then
		write_pixel_old <= '0'; 
	elsif clk_sys'event and clk_sys = '1' then
		write_pixel_old <= write_pixel ;
	end if ;
end process ;


fifoB_wr <= (write_pixel and (NOT write_pixel_old)) when output_vsync = '0' and href_from_interface = '0' else
			   vsync_rising_edge when output_vsync = '1' else
				'0' ;
				
fifo_input <= (X"AA55") when vsync_rising_edge = '1' else
				  (pixel_buffer(15 downto 1) & '0') ;



end Behavioral;

