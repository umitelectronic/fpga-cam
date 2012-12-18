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

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity mark1_beaglebone_demo is
port( OSC_FPGA : in std_logic;
		PB, DIP_SW: in std_logic_vector(3 downto 0);
		LED : out std_logic_vector(7 downto 0);
		--gpmc interface
		GPMC_CSN : in std_logic_vector(2 downto 0);
		GPMC_WEN, GPMC_OEN, GPMC_ADVN, GPMC_CLK, GPMC_BE0N:	in std_logic;
		GPMC_AD :	inout std_logic_vector(15 downto 0)	
);
end mark1_beaglebone_demo;

architecture Behavioral of mark1_beaglebone_demo is

	signal clk_sys : std_logic ;
	signal resetn , sys_resetn : std_logic ;
	
	
	signal fifo_output : std_logic_vector(15 downto 0);
	signal fifo_input : std_logic_vector(15 downto 0);
	signal fifoB_wr, fifoA_rd, fifoA_rd_old, fifoA_empty, fifoA_full, fifoB_empty, fifoB_full : std_logic ;
	signal fifo_full_rising_edge, fifo_full_old : std_logic ;
	signal bus_data_in, bus_data_out : std_logic_vector(15 downto 0);
	signal bus_addr : std_logic_vector(7 downto 0);
	signal bus_wr, bus_rd, bus_cs : std_logic ;
	
	
begin
	
	resetn <= PB(0) ;
	clk_sys <= OSC_FPGA ;



	reset0: reset_generator 
	generic map(HOLD_0 => 500000)
	port map(clk => clk_sys, 
		resetn => RESETN ,
		resetn_0 => sys_resetn
	 );


mem_interface0 : muxed_addr_interface
generic map(ADDR_WIDTH => 8 , DATA_WIDTH =>  16)
port map(clk => clk_sys ,
	  resetn => sys_resetn ,
	  data	=> GPMC_AD,
	  wrn => GPMC_WEN, oen => GPMC_OEN, addr_en_n => GPMC_ADVN, csn => GPMC_CSN(0),
	  data_bus_out	=> bus_data_out,
	  data_bus_in	=> bus_data_in ,
	  addr_bus	=> bus_addr, 
	  wr => bus_wr , rd => bus_rd 
);


bi_fifo0 : fifo_peripheral 
		generic map(BASE_ADDR => 0, ADDR_WIDTH => 8,WIDTH => 16, SIZE => 1024)
		port map(
			clk => clk_sys,
			resetn => sys_resetn,
			addr_bus => bus_addr,
			wr_bus => bus_wr,
			rd_bus => bus_rd,
			wrB => fifoB_wr,
			rdA => fifoA_rd,
			data_bus_in => bus_data_out,
			data_bus_out => bus_data_in,
			inputB => fifo_output, 
			outputA => fifo_output,
			emptyA => fifoA_empty,
			fullA => fifoA_full,
			emptyB => fifoB_empty,
			fullB => fifoB_full
		);
		
		fifo_input <= fifo_output(7 downto 0) & fifo_output(15 downto 8) ;
		
		process(resetn, clk_sys)
		begin	
			if resetn = '0' then 
				fifo_full_old <= '0' ;
			elsif clk_sys'event and clk_sys = '1' then
				fifo_full_old <= fifoB_full ;
			end if ;
		end process ;
		fifo_full_rising_edge <= (NOT fifo_full_old) AND fifoB_full ;
		
		process(sys_resetn, clk_sys)
		begin
		 if sys_resetn = '0' then
			fifoA_rd <= '0' ;
		 elsif clk_sys'event and clk_sys = '1' then
			if fifoA_empty = '0' then
				fifoA_rd <= not fifoA_rd ;
			else 
				fifoA_rd <= '0' ;
			end if ;
		 end if ;
		end process ;
		
		process(sys_resetn, clk_sys)
		begin
		 if sys_resetn = '0' then
			fifoB_wr <= '0' ;
		 elsif clk_sys'event and clk_sys = '1' then
				fifoB_wr <= fifoA_rd ;
		 end if ;
		end process ;



end Behavioral;

