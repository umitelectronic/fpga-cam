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
-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
library UNISIM;
use UNISIM.VComponents.all;

entity logibone_mining is
port( OSC_FPGA : in std_logic;
		PB : in std_logic_vector(1 downto 0);
		LED : out std_logic_vector(1 downto 0);	
		
		--gpmc interface
		GPMC_CSN : in std_logic_vector(2 downto 0);
		GPMC_WEN, GPMC_OEN, GPMC_ADVN, GPMC_CLK, GPMC_BE0N, GPMC_BE1N:	in std_logic;
		GPMC_AD :	inout std_logic_vector(15 downto 0)	
);
end logibone_mining;

architecture Behavioral of logibone_mining is

	COMPONENT clock_gen
	PORT(
		CLK_IN1 : IN std_logic;          
		CLK_OUT1 : OUT std_logic;
		CLK_OUT2 : OUT std_logic;
		CLK_OUT3 : OUT std_logic;
		CLK_OUT4 : OUT std_logic;
		LOCKED : OUT std_logic
		);
	END COMPONENT;


	
	signal clk_sys, clk_100, clk_24, clk_48, clk_locked : std_logic ;
	signal resetn , sys_resetn : std_logic ;
	
	signal counter_output : std_logic_vector(31 downto 0);
	signal fifo_output : std_logic_vector(15 downto 0);
	signal fifo_input : std_logic_vector(15 downto 0);
	signal latch_output : std_logic_vector(15 downto 0);
	signal fifoB_wr, fifoA_rd, fifoA_rd_old, fifoA_empty, fifoA_full, fifoB_empty, fifoB_full : std_logic ;
	signal fifo_full_rising_edge, fifo_full_old : std_logic ;
	signal bus_data_in, bus_data_out : std_logic_vector(15 downto 0);
	signal bus_fifo_out, bus_latch_out : std_logic_vector(15 downto 0);
	signal bus_addr : std_logic_vector(15 downto 0);
	signal bus_wr, bus_rd, bus_cs : std_logic ;
	signal cs_fifo, cs_latch : std_logic ;

	signal data : std_logic_vector(95 downto 0);
	signal state : std_logic_vector(255 downto 0);
	signal nonce : std_logic_vector(31 downto 0);
	signal step : std_logic_vector(5 downto 0) := "000000";
	signal hit : std_logic;
	signal load : std_logic_vector(351 downto 0);
	signal txdata : std_logic_vector(48 downto 0);
	signal txwidth : std_logic_vector(5 downto 0);
	
begin
	
	resetn <= PB(0) ;
	sys_clocks_gen: clock_gen 
	PORT MAP(
		CLK_IN1 => OSC_FPGA,
		CLK_OUT1 => clk_100,
		CLK_OUT2 => clk_24,
		CLK_OUT3 => clk_sys, --120Mhz system clock
		CLK_OUT4 => clk_48, --120Mhz system clock
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
mem_interface0 : muxed_addr_interface
generic map(ADDR_WIDTH => 16 , DATA_WIDTH =>  16)
port map(clk => clk_sys ,
	  resetn => sys_resetn ,
	  data	=> GPMC_AD,
	  wrn => GPMC_WEN, oen => GPMC_OEN, addr_en_n => GPMC_ADVN, csn => GPMC_CSN(1),
	  data_bus_out	=> bus_data_out,
	  data_bus_in	=> bus_data_in ,
	  addr_bus	=> bus_addr, 
	  wr => bus_wr , rd => bus_rd 
);

cs_fifo <= '1' when bus_addr(15 downto 10) = "000000" else
			  '0' ;	  

bus_data_in <= bus_fifo_out when cs_fifo = '1' else
					(others => '1');

bi_fifo0 : fifo_peripheral 
		generic map(ADDR_WIDTH => 16,WIDTH => 16, SIZE => 2048, BURST_SIZE => 512)--16384)
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
		
		miner0: miner
	   generic map ( DEPTH => DEPTH )
		port map (
			clk => clk_sys,
			step => step,
			data => data,
			state => state,
			nonce => nonce,
			hit => hit
		);
		
	process(clk_sys)
	begin
		if rising_edge(clk_sys) then
			step <= step + 1;
			if conv_integer(step) = 2 ** (6 - DEPTH) - 1 then
				step <= "000000";
				nonce <= nonce + 1;
			end if;
			txdata <= "-------------------------------------------------";
			txwidth <= "------";
			txstrobe <= '0';
			if fifoA_empty = '0' then
				if loading = '1' then
					if loadctr = "101011" then
						state <= load(343 downto 88);
						data <= load(87 downto 0) & rxdata;
						nonce <= x"00000000";
						txdata <= "1111111111111111111111111111111111111111000000010";
						txwidth <= "001010";
						txstrobe <= '1';
						loading <= '0';
					else
						load(351 downto 16) <= load(325 downto 0);
						load(15 downto 0) <= fifo_output; -- loading data from fifo, needs to assert fifo_rd ...
						loadctr <= loadctr + 1; -- increase
					end if;
				else
					if rxdata = "00000000" then
						txdata <= "1111111111111111111111111111111111111111000000000";
						txwidth <= "001010";
						txstrobe <= '1';
					elsif rxdata = "00000001" then
					   loadctr <= "000000";
						loading <= '1';
					end if;
				end if;
			elsif hit = '1' then
				txdata <= currnonce(7 downto 0) & "01" & currnonce(15 downto 8) & "01" & currnonce(23 downto 16) & "01" & currnonce(31 downto 24) & "01000000100"; -- need to transfer 32 bits of data, remove 01 (start)
				txwidth <= "110010"; -- 
				txstrobe <= '1'; -- need to trigger two transfers
			elsif nonce = x"ffffffff" and step = "000000" then
				txdata <= "1111111111111111111111111111111111111111000000110";
				txwidth <= "110010";
				txstrobe <= '1';
			end if;
		end if;
	end process;	
		
		

end Behavioral;

