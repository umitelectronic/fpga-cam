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
library UNISIM;
use UNISIM.VComponents.all;

entity logibone_demo is
port( OSC_FPGA : in std_logic;
		PB : in std_logic_vector(1 downto 0);
		LED : out std_logic_vector(1 downto 0);
		
		--gpmc interface
		GPMC_CSN : in std_logic_vector(2 downto 0);
		GPMC_WEN, GPMC_OEN, GPMC_ADVN, GPMC_CLK, GPMC_BE0N, GPMC_BE1N:	in std_logic;
		GPMC_AD :	inout std_logic_vector(15 downto 0)	
);
end logibone_demo;

architecture Behavioral of logibone_demo is

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
	
begin
	
	resetn <= PB(0) ;
	--clk_sys <= OSC_FPGA;
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

cs_latch <= '1' when bus_addr(7 downto 4) = "0000"  and bus_addr(3) = '1' else
			  '0' ;			  

bus_data_in <= bus_latch_out when cs_latch = '1' else
					bus_fifo_out when cs_fifo = '1' else
					(others => '1');

led_sw_latch : latch_peripheral
generic map(ADDR_WIDTH => 8, WIDTH	=> 16)
port map(
	clk => clk_sys,
	resetn => sys_resetn,
	addr_bus => bus_addr,
	wr_bus => bus_wr,
	rd_bus => bus_rd,
	cs_bus => cs_latch,
	data_bus_in => bus_data_out,
	data_bus_out => bus_latch_out,
	latch_input(0) => PB(1),
	latch_input(3 downto 1) => "010",
	latch_input(15 downto 4) => X"A5A",
	latch_output => latch_output
);
 LED(1) <= latch_output(0); 

bi_fifo0 : fifo_peripheral 
		generic map(ADDR_WIDTH => 8,WIDTH => 16, SIZE => 1024)
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
		
		--fifo_input <= fifo_output(7 downto 0) & fifo_output(15 downto 8) ;
		fifo_input <= fifo_output ;
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

