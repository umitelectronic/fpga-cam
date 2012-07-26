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
		BEAGLE_CSN, BEAGLE_WRN, BEAGLE_OEN:	in std_logic;
		BEAGLE_DATA :	inout std_logic_vector(15 downto 0);
		BEAGLE_ADDR :	in std_logic_vector(7 downto 0);
		--FIFO unsused signals
		SPARE :	out std_logic_vector(3 downto 0)
		
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
	
	COMPONENT dcm_32_144
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
	
	COMPONENT dcm_32_24
	PORT(
		CLKIN_IN : IN std_logic;          
		CLKFX_OUT : OUT std_logic;
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
	signal pixel_buffer : std_logic_vector(15 downto 0);
	signal write_pixel : std_logic ;
	signal fifoB_wr, fifoA_rd, fifoA_rd_old, fifoA_empty, fifoA_full, fifoB_empty, fifoB_full : std_logic ;
	signal fifo_full_rising_edge, fifo_full_old : std_logic ;
	signal bus_data_in, bus_data_out : std_logic_vector(15 downto 0);
	signal bus_addr : std_logic_vector(7 downto 0);
	signal bus_wr, bus_rd, bus_cs : std_logic ;
	
	signal pixel_from_interface : std_logic_vector(7 downto 0);
	signal pxclk_from_interface, href_from_interface, vsync_from_interface : std_logic ;

	signal hsync_rising_edge, vsync_rising_edge, pxclk_rising_edge, hsync_old, vsync_old, pxclk_old, write_pixel_old : std_logic ;
	signal modulo_2 :std_logic_vector(1 downto 0);
	signal pixel_count :std_logic_vector(7 downto 0);
	
begin
	
	
	SPARE <= (others => 'Z') ;

--comment connections below when using pins
	FIFO_CS <= 'Z' ;
	FIFO_WR <= BEAGLE_CSN	; 
	FIFO_RD <= BEAGLE_OEN	; 
	FIFO_A0 <= 'Z' ;
	
	CAM_RESET <= ARAZB ;

	TXD <= 'Z' ;


	reset0: reset_generator 
	generic map(HOLD_0 => 500000)
	port map(clk => clk0, 
		arazb => ARAZB ,
		arazb_0 => arazb_delayed
	 );



--	Inst_dcm_32_144: dcm_32_144 PORT MAP(
--		CLKIN_IN => clk,
--		CLKFX_OUT => clk_120,
--		CLKIN_IBUFG_OUT => clk0_buf,
--		CLK0_OUT => clk0
--	);
	
	Inst_dcm_32_120: dcm_32_120 PORT MAP(
		CLKIN_IN => clk,
		CLKFX_OUT => clk_120,
		CLKIN_IBUFG_OUT => clk0_buf,
		CLK0_OUT => clk0
	);	
	
	
	
	
--	Inst_dcm_32_24: dcm_32_24 PORT MAP(
--		CLKIN_IN => clk0_buf,
--		CLKFX_OUT => clk_24
--	);
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
			inputB => fifo_input, -- fifo_output, 
			outputA => fifo_output,
			emptyA => fifoA_empty,
			fullA => fifoA_full,
			emptyB => fifoB_empty,
			fullB => fifoB_full
		);
		
--		process(arazb, clk_24)
--		begin	
--			if arazb = '0' then 
--				fifo_full_old <= '0' ;
--			elsif clk_24'event and clk_24 = '1' then
--				fifo_full_old <= fifoB_full ;
--			end if ;
--		end process ;
--		fifo_full_rising_edge <= (NOT fifo_full_old) AND fifoB_full ;
--		
--		process(arazb_delayed, clk_120)
--		begin
--		 if arazb_delayed = '0' then
--			fifoA_rd <= '0' ;
--		 elsif clk_120'event and clk_120 = '1' then
--			if fifoA_empty = '0' then
--				fifoA_rd <= not fifoA_rd ;
--			else 
--				fifoA_rd <= '0' ;
--			end if ;
--		 end if ;
--		end process ;
--		
--		process(arazb_delayed, clk_120)
--		begin
--		 if arazb_delayed = '0' then
--			fifoB_wr <= '0' ;
--		 elsif clk_120'event and clk_120 = '1' then
--				fifoB_wr <= fifoA_rd ;
--		 end if ;
--		end process ;
--	
-- camera0: yuv_camera_interface
--		generic map(FORMAT => QVGA)
--		port map(clock => clk_120,
--			pixel_data => CAM_DATA, 
--			i2c_clk => clk_24,
--			scl => CAM_SIOC ,
--			sda => CAM_SIOD ,
--			arazb => arazb_delayed,
--			pxclk => CAM_PCLK, href => CAM_HREF, vsync => CAM_VSYNC,
--			pixel_clock_out => pxclk_from_interface, hsync_out => href_from_interface, vsync_out => vsync_from_interface,
--			y_data => pixel_from_interface
--		);	
--
	gen0: graphic_generator
	 port map(clk => clk_120, 
		arazb => arazb_delayed,
		pixel_clock_out => pxclk_from_interface,
		hsync_out => href_from_interface, 
		vsync_out => vsync_from_interface,
	   pixel_r => pixel_from_interface
	  );

--gen_graph : graphic_generator
--port map(clk => clk_120, arazb => arazb_delayed ,
--	  pixel_clock_out => pxclk_from_interface, hsync_out => href_from_interface, vsync_out => vsync_from_interface,
--	  pixel_r => pixel_from_interface
--	  );

CAM_XCLK <= clk_24 ;



process(clk_120, arazb_delayed)
begin
	if arazb_delayed = '0' then
		vsync_old <= '0' ;
	elsif clk_120'event and clk_120 = '1' then
		vsync_old <= vsync_from_interface ;
	end if ;
end process ;
vsync_rising_edge <= (NOT vsync_old) and vsync_from_interface ;

process(clk_120, arazb_delayed)
begin
	if arazb_delayed = '0' then
		hsync_old <= '0' ;
	elsif clk_120'event and clk_120 = '1' then
		hsync_old <= href_from_interface ;
	end if ;
end process ;
hsync_rising_edge <= (NOT hsync_old) and href_from_interface ;

process(clk_120, arazb_delayed)
begin
	if arazb_delayed = '0' then
		pxclk_old <= '0' ;
	elsif clk_120'event and clk_120 = '1' then
		pxclk_old <= pxclk_from_interface ;
	end if ;
end process ;
pxclk_rising_edge <= (NOT pxclk_old) and pxclk_from_interface ;

process(clk_120, arazb_delayed)
begin
	if arazb_delayed = '0' then
		pixel_buffer(15 downto 0) <= (others => '0') ;
	elsif clk_120'event and clk_120 = '1' then
		if hsync_rising_edge = '1' then
			pixel_buffer(15 downto 0) <= (others => '0') ;
		elsif pxclk_rising_edge = '1' then
			pixel_buffer(7 downto 0) <= pixel_buffer(15 downto 8) ;
			pixel_buffer(15 downto 8)  <= pixel_from_interface ;
		end if ;
	end if ;
end process ;

process(clk_120, arazb_delayed)
begin
	if arazb_delayed = '0' then
		pixel_count <= (others => '0'); 
	elsif clk_120'event and clk_120 = '1' then
		if hsync_rising_edge = '1' then
			pixel_count <= (others => '0'); 
		elsif pxclk_rising_edge = '1'  and href_from_interface = '0' then
			pixel_count <= pixel_count + 1 ;
		end if ;
	end if ;
end process ;
write_pixel <= pixel_count(0);

process(clk_120, arazb_delayed)
begin
	if arazb_delayed = '0' then
		write_pixel_old <= '0'; 
	elsif clk_120'event and clk_120 = '1' then
		write_pixel_old <= write_pixel ;
	end if ;
end process ;





fifoB_wr <= (write_pixel and (NOT write_pixel_old)) when vsync_from_interface = '0' and href_from_interface = '0' else
			   vsync_rising_edge when vsync_from_interface = '1' else
				'0' ;
				
fifo_input <= (X"AA55") when vsync_rising_edge = '1' else
				  (X"55AA") when hsync_rising_edge = '1' else
				  --(pixel_buffer(15 downto 1) & '0') when  pixel_buffer = X"AA55" else
				  (pixel_buffer(15 downto 9) & '0' & pixel_buffer(7 downto 1) & '0' );-- when  pixel_buffer = X"55AA" else
				   --pixel_buffer ;


end Behavioral;

