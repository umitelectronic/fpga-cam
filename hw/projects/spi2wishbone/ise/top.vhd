----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    16:17:39 12/09/2012 
-- Design Name: 
-- Module Name:    top - Behavioral 
-- Project Name: 
-- Target Devices: 
-- Tool versions: 
-- Description: This module is a wrapper around spi2wishbone for testing purposes
--
-- Dependencies: 
--
-- Revision: 
-- Revision 0.01 - File Created
-- Additional Comments: 
--
----------------------------------------------------------------------------------

library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity top is
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
		clk50		 : in  std_logic;
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
end top;

architecture Behavioral of top is
	signal wb_clk : std_logic;
begin

	clk_gen_inst : entity work.clk_gen
	port map
	(
		CLK_IN1 => clk50,
		CLK_OUT1 => wb_clk
	);

	spi2wishbone_inst : entity work.spi2wishbone
		generic map
		(
			N 			  => N,
			CPOL 		  => CPOL,
			CPHA 		  => CPHA,
			ADDR_WIDTH => ADDR_WIDTH,
			ADDR		  => ADDR
		)
		port map
		(		
			----- SPI Interface Signals -----
			spi_sck  => spi_sck,		
			spi_ss   => spi_ss,
			spi_mosi => spi_mosi,
			spi_miso => spi_miso,
			
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
		
end behavioral;

