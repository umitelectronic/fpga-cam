----------------------------------------------------------------------------------
-- Company: 		 N/A
-- Engineer: 		 Brian Wiec
-- Create Date:    12:05:27 12/08/2012 
-- Design Name: 	 spi2wishbone
-- Module Name:    spi2wishbone - Behavioral 
-- Project Name: 	 Mark-1
-- Target Devices: xc6slx9
-- Tool versions:  ISE 14.3
-- Description: 	 This module implements a SPI to wishbone shim for use with
--						 commonly available wishbone-compliant IP cores.
-- Dependencies: 
--						 - spi_slave.vhd
--						 - wb_shim.vhd
-- Revision:
--						 - Revision 1.01 - 12/08/12 - Meets timing at 125MHz
--						 - Revision 1.00 - 12/08/12 - Behavioral simulation verified
-- 					 - Revision 0.01 - 12/08/12 - File Created
-- Additional Comments: 
--						 - Note that this design is initially intended for the
--							specific purpose of dumping VGA data to a host processor.
--							Sending data from the processor to the FPGA is an
--							an afterthought and not yet implemented.
--						 - SPI slave module taken from opencores
--						 - Currently no support for wishbone bursts. Should there be?
-- To Do:
--						 - Add a parallel WB interface to allow data to be passed back
--							to the SPI Master (i.e. RPi) during the same time that VGA
--						   data is being dumped to the host CPU.
--						 - Think about SPI prefetch pipeline depth... It will depend on
--							WB bus latency between req and ack
----------------------------------------------------------------------------------

library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity spi2wishbone is
	generic
	(   
		N    		  : positive  := 32;  		  -- Wishbone data width AND SPI serial data length
		CPOL 		  : std_logic := '0'; 		  -- SPI mode selection (mode 0 default)
		CPHA 		  : std_logic := '0';  		  -- CPOL = clock polarity, CPHA = clock phase.
		ADDR_WIDTH : positive  := 32; 		  -- Width of wishbone address bus
		ADDR 		  : unsigned  := X"00000000" -- Address that WB master presents on the interface during transactitons		  
	);
	port 
	(
		----- SPI Slave Signals -----
		spi_sck  : in  std_logic;
		spi_ss   : in  std_logic;
		spi_mosi : in  std_logic;
		spi_miso : out std_logic;
		
		----- Wishbone Master Signals -----
		wb_clk    : in  std_logic;
		wb_rst 	 : in  std_logic;
		wb_adr_o0 : out std_logic_vector (ADDR_WIDTH-1 downto 0); -- Address output
		wb_dat_i0 : in  std_logic_vector (N-1 			  downto 0); -- Data input
		wb_we_o 	 : out std_logic;								 			 -- Indicates if current bus cycle is a write or a read. 1 = Write, 0 = Read
		wb_sel_o0 : out std_logic;								 			 -- Byte enables. Width depends on granulatity of data
		wb_stb_o  : out std_logic;								 			 -- Indicates valid transfer cycle
		wb_ack_i  : in  std_logic; 							 		 	 -- Acknowledge from slave
		wb_cyc_o  : out std_logic; 							 			 -- Indicates a valid bus cycle is in process
		wb_tgc_o  : out std_logic 							 	 			 -- User information associated with data output of a transfer. Qualified by stb
	);
end spi2wishbone;

architecture Behavioral of spi2wishbone is

	----- Internal Signals -----
	signal di_req : std_logic;
	signal di	  : std_logic_vector(N-1 downto 0);
	signal wren   : std_logic;
	
begin

	spi_slave_inst : entity work.spi_slave
	generic map
	(
		N 			=> N,
		CPOL 		=> CPOL,
		CPHA 		=> CPHA
	)
	port map
	(
		----- SPI Interface Signals -----
		spi_sck_i  => spi_sck,		
		spi_ssel_i => spi_ss,
		spi_mosi_i => spi_mosi,
		spi_miso_o => spi_miso,
		
		----- User Interface Signals -----
		clk_i 	  => wb_clk,
		di_req_o   => di_req,
		di_i 		  => di,
		wren_i 	  => wren,
		do_valid_o => open, -- Don't need these signals for interfacing to VGA
		do_o 		  => open  -- which is just dumping data to the processor
	);
	
	wb_shim_inst : entity work.wb_shim
	generic map
	(
		N 			  => N,
		ADDR_WIDTH => ADDR_WIDTH,
		ADDR		  => ADDR
	)
	port map
	(		
		----- SPI User Interface Signals -----
		spi_di_req_i   => di_req,
		spi_di_o 		=> di,
		spi_wren_o 	   => wren,
		spi_wr_ack_i	=> '1',   -- Don't care... slave can't provide flow control anyway
		spi_do_valid_i => '0', 
		spi_do_i 		=> (others => '0'),
		
		----- Wishbone interface signals -----
		wb_clk 	 => wb_clk,
		wb_rst 	 => wb_rst,
		wb_adr_o0 => wb_adr_o0,
		wb_dat_i0 => wb_dat_i0,
		wb_we_o 	 => wb_we_o,
		wb_sel_o0 => wb_sel_o0,
		wb_stb_o  => wb_stb_o,
		wb_ack_i  => wb_ack_i,
		wb_cyc_o  => wb_cyc_o,
		wb_tgc_o  => wb_tgc_o -- Eventually used for burst transfers
	);

----- Important wishbone spec notes -----
--
-- stb_o and cyc_o must be deasserted during reset and for 1 clock cycle after deassertion of reset
--
-- WB slave may tie ack high... master must handle this
--
-- I believe a transaction occurs when stb/cyc AND ack are asserted (similar to valid/ready in AXI)
--
-- data_o (from the slave) is qualified by ack, making the above statement true
--
-- adr_o, data_o, sel_o, we_o, and tagn_o must be qualified (by the master) by the stb signal
end Behavioral;

