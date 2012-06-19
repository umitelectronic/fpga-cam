----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    15:37:36 06/18/2012 
-- Design Name: 
-- Module Name:    dp_fifo - Behavioral 
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
use IEEE.NUMERIC_STD.ALL;


library work ;
use work.generic_components.all ;
-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity dp_fifo is
	generic(N : natural := 128 ; W : positive := 16);
	port(
 		clk, arazb, sraz : in std_logic; 
 		wr, rd : in std_logic; 
		empty, full : out std_logic ;
 		data_out : out std_logic_vector((W - 1) downto 0 ); 
 		data_in : in std_logic_vector((W - 1) downto 0 );
		nb_free : out unsigned(nbit(N) downto 0 ); 
		nb_available : out unsigned(nbit(N)  downto 0 )
	); 
end dp_fifo;

architecture Behavioral of dp_fifo is
signal rd_addr, wr_addr: std_logic_vector((nbit(N) - 1) downto 0)  ;
signal nb_free_t, nb_available_t : unsigned(nbit(N) downto 0 ) ;
signal fifo_out, fifo_in : std_logic_vector((W - 1 ) downto 0)  ;
signal rd_old, wr_old, wr_data, rd_data, one_turn, latch_data : std_logic ;
begin

dp_ram0 : dpram_NxN 
	generic map(SIZE => N , NBIT => W, ADDR_WIDTH => nbit(N))
	port map(
 		clk => clk , 
 		we => wr_data ,
 		di =>  data_in ,
		a	=> wr_addr,
 		dpra => rd_addr ,	
		dpo =>  fifo_out 
	); 


output_latch_0 : edge_triggered_latch
	 generic map(NBIT => W,  POL => '1')
    port map( clk => clk,
           arazb => arazb ,
           sraz => '0' ,
           en => latch_data ,
           d => fifo_out ,
           q => data_out ) ;
			  
latch_data <= '0' when (nb_available_t = 0) else
				  (NOT rd) ; -- latch next data on falling edge of read, ensure data to be stable while read is high
			  
process(clk, arazb)
begin
if arazb = '0' then
	rd_addr <= (others => '0') ;
	rd_old <= '0' ;
elsif clk'event and clk = '1' then
	if rd_old /= rd and rd = '1' and nb_available_t > 0 then
		if rd_addr < (N - 1) then
			rd_addr <= rd_addr + 1;
		else
			rd_addr <= (others => '0');
		end if ;
	end if ;
	rd_old <= rd ;
end if ;
end process ;

-- wr process 
process(clk, arazb)
begin
if arazb = '0' then
	wr_addr <= (others => '0') ;
	wr_old <= '0' ;
elsif clk'event and clk = '1' then
	if wr_old /= wr and wr = '1' and nb_free_t > 0 then
		if wr_addr < (N - 1) then
			wr_addr <= wr_addr + 1;
		else
			wr_addr <= (others => '0');
		end if ;
	end if ;
	wr_old <= wr ;
end if ;
end process ;

process(clk, arazb)
begin
if arazb = '0' then
	one_turn <= '0' ;
elsif clk'event and clk = '1' then
	if rd_old /= rd and rd = '1' and nb_available_t > 0 and NOT(rd_addr < (N - 1)) then
		one_turn <= '0' ;
	elsif wr_old /= wr and wr = '1' and nb_free_t > 0 and NOT(wr_addr < (N - 1)) then
		one_turn <= '1' ;
	end if ;
end if ;
end process ;



nb_available_t <= (unsigned(wr_addr) - unsigned('0' & rd_addr)) when one_turn = '0'  else
				  (to_unsigned(N, nbit(N) + 1) -  unsigned('0' & rd_addr) +  unsigned('0' & wr_addr)) ;
				  
nb_free_t <= (to_unsigned(N, nbit(N) + 1) - unsigned('0' & wr_addr) + unsigned('0' & rd_addr)) when one_turn = '0' else
				  (unsigned('0' & rd_addr) - unsigned('0' & wr_addr)) ;

nb_free <= nb_free_t ;
nb_available <= nb_available_t ;

empty <= '1' when nb_available_t = 0 else
         '0' ;

full <= '1' when nb_free_t = 0 else
		  '0' ;

wr_data <= wr when nb_free_t > 0 else
			  '0' ;

end Behavioral;

