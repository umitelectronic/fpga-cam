--------------------------------------------------------------------------------
-- Company:LAAS-CNRS 
-- Author:Jonathan Piat <piat.jonathan@gmail.com>
--
-- Create Date:   18:00:34 12/08/2012
-- Design Name:   
-- Module Name:   C:/Users/bwiec/Documents/cert_projects/rpi/spi2wishbone/tb/spi2wishbone_tb.vhd
-- Project Name:  ise
-- Target Device:  
-- Tool versions: ISE 14.1  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: spi2wishbone
-- 
-- Dependencies:
-- 
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
--
-- Notes: 
--
--------------------------------------------------------------------------------
library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;
 
entity spi2wishbone_tb is
end spi2wishbone_tb;
 
architecture behavior of spi2wishbone_tb is

	----- TB Parameters -----
	constant SPI_SCK_PERIOD : time	 := 8 ns; -- 125 MHz
	constant WB_CLK_PERIOD  : time 	 := 8 ns; -- 125 MHz	
	constant FIFO_DEPTH 		: integer := 16;
	constant IO_LATENCY 		: time := 74*SPI_SCK_PERIOD;

	----- UUT Parameters -----
	constant N    		  : positive  := 32;  		   -- Wishbone data width AND SPI serial data length
	constant CPOL 		  : std_logic := '0'; 		   -- SPI mode selection (mode 0 default)
	constant CPHA 		  : std_logic := '0';  		 	-- CPOL = clock polarity, CPHA = clock phase.
	constant ADDR_WIDTH : positive  := 32; 		   -- Width of wishbone address bus
	constant ADDR 		  : unsigned  := X"00000000"; -- Address that WB master presents on the interface during transactitons
	
	----- Component Declaration for the Unit Under Test (UUT) -----
	component spi2wishbone
		generic
		(   
			N    		  : positive  := 16;  		  -- Wishbone data width AND SPI serial data length
			CPOL 		  : std_logic := '0'; 		  -- SPI mode selection (mode 0 default)
			CPHA 		  : std_logic := '0';  		  -- CPOL = clock polarity, CPHA = clock phase.
			ADDR_WIDTH : positive  := 32; 		  -- Width of wishbone address bus
			ADDR 		  : unsigned  := X"00000000" -- Address that WB master presents on the interface during transactitons		  
		);
		port
		(
			spi_sck   : in  std_logic;
			spi_ss  	 : in  std_logic;
			spi_mosi  : in  std_logic;
			spi_miso  : out std_logic;
			wb_clk 	 : in  std_logic;
			wb_rst 	 : in  std_logic;
			wb_adr_o0 : out std_logic_vector(ADDR_WIDTH-1 downto 0);
			wb_dat_i0 : in  std_logic_vector(N-1		    downto 0);
			wb_we_o 	 : out std_logic;
			wb_sel_o0 : out std_logic;
			wb_stb_o  : out std_logic;
			wb_ack_i  : in  std_logic;
			wb_cyc_o  : out std_logic;
			wb_tgc_o  : out std_logic
		);
	end component;
    
   ----- Inputs -----
   signal spi_sck   : std_logic 							  := '0';
   signal spi_ss    : std_logic 							  := '1';
   signal spi_mosi  : std_logic 							  := '0';
   signal wb_clk 	  : std_logic 							  := '0';
   signal wb_rst 	  : std_logic 							  := '1';
   signal wb_dat_i0 : std_logic_vector(N-1 downto 0) := (others => '0');
   signal wb_ack_i  : std_logic 							  := '1';

 	----- Outputs -----
   signal spi_miso  : std_logic;
   signal wb_adr_o0 : std_logic_vector(ADDR_WIDTH-1 downto 0);
   signal wb_we_o   : std_logic;
   signal wb_sel_o0 : std_logic;
   signal wb_stb_o  : std_logic;
   signal wb_cyc_o  : std_logic;
   signal wb_tgc_o  : std_logic;
	
	----- Internal Signals -----
	type fifo_memory_type is array (0 to FIFO_DEPTH-1) of std_logic_vector (N-1 downto 0);
	constant fifo_memory : fifo_memory_type :=
	(
		X"90201031",X"97640231",X"ef55aaf1",X"babaca51",X"b00b1ee5",X"51525354",X"81828384",X"91929394",
		X"be575ec5",X"2fa57410",X"cafed0ce",X"afadab0a",X"bac7ed1a",X"f05fac75",X"2acbac7e",X"12345678"
	);
	
	signal mosi_ver : std_logic := '0';
begin
 
	-- Instantiate the Unit Under Test (UUT)
   uut : spi2wishbone
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
			spi_sck 	 => spi_sck,
			spi_ss 	 => spi_ss,
			spi_mosi  => spi_mosi,
			spi_miso  => spi_miso,
			wb_clk 	 => wb_clk,
			wb_rst 	 => wb_rst,
			wb_adr_o0 => wb_adr_o0,
			wb_dat_i0 => wb_dat_i0,
			wb_we_o 	 => wb_we_o,
			wb_sel_o0 => wb_sel_o0,
			wb_stb_o  => wb_stb_o,
			wb_ack_i  => wb_ack_i,
			wb_cyc_o  => wb_cyc_o,
			wb_tgc_o  => wb_tgc_o
		);

   ----- Clock Process -----
   wb_clk_process : process
   begin
		wb_clk <= '0';
		wait for WB_CLK_PERIOD/2;
		wb_clk <= '1';
		wait for WB_CLK_PERIOD/2;
   end process;
 
   ----- Reset Process -----
   rst_proc : process
   begin		
      wait for 100 ns;
		wb_rst <= '0';
      wait;
   end process;

	----- SPI Interface -----
	spi_proc : process
	begin
	
		wait for 200 ns;
		spi_sck <= '1';
		wait for SPI_SCK_PERIOD/2;
		for i in 0 to FIFO_DEPTH-1 loop
			spi_ss <= '0'; -- Assert SS
			for j in 0 to N-1 loop
				wait for SPI_SCK_PERIOD/2;
				spi_sck  <= '0';
				spi_mosi <= fifo_memory(i)(N-1-j);
				wait for SPI_SCK_PERIOD/2;
				spi_sck <= '1';
			end loop;
			spi_ss <= '1';	
			wait for SPI_SCK_PERIOD*5;
		end loop;
	end process;
	
	----- Wishbone Interface -----
	wb_proc : process
	begin
		for idx in 0 to FIFO_DEPTH-1 loop
			wait until wb_stb_o = '1';
			wb_dat_i0 <= fifo_memory(idx);
		end loop;
		wait;
	end process;
	
	----- Checker -----
	mosi_ver <= transport spi_mosi after IO_LATENCY;
	
	checker: process (spi_sck)
	begin
		if rising_edge(spi_sck) then
			assert mosi_ver = spi_miso report "MISO data incorrect!" severity warning;
		end if;
	end process;
	
end;



