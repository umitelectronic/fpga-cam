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
use work.primitive_pack.all ;
-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;


-- N must be power of two
entity dp_fifo is
	generic(N : natural := 128 ; W : positive := 16);
	port(
 		clk, resetn, sraz : in std_logic; 
 		wr, rd : in std_logic; 
		empty, full : out std_logic ;
 		data_out : out std_logic_vector((W - 1) downto 0 ); 
 		data_in : in std_logic_vector((W - 1) downto 0 );
		nb_available : out unsigned(nbit(N)  downto 0 )
	); 
end dp_fifo;

architecture Behavioral of dp_fifo is

constant std_fifo_size : std_logic_vector(nbit(N)  downto 0 ) :=  std_logic_vector(to_unsigned(N, nbit(N) + 1));

signal rd_addr, wr_addr: std_logic_vector((nbit(N) - 1) downto 0)  ;
signal nb_free_t, nb_available_t : unsigned(nbit(N) downto 0 ) ;
signal slv_nb_available_t : std_logic_vector(nbit(N) downto 0 ) ;
signal fifo_out, fifo_in : std_logic_vector((W - 1 ) downto 0)  ;
signal rd_old, wr_old, wr_data, rd_data, one_turn, latch_data : std_logic ;
signal rd_rising_edge, wr_rising_edge : std_logic ;
signal rd_falling_edge, wr_falling_edge : std_logic ;

signal en_available_counter, up_downn_available_counter : std_logic ;
signal en_free_counter, up_downn_free_counter, counter_load : std_logic ;


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


data_out <= fifo_out ;
			  
process(resetn, clk)
begin
	if resetn = '0' then
		rd_old <= '0' ;
	elsif clk'event and clk = '1' then
		rd_old <= rd ;
	end if ;
end process ;
rd_rising_edge <= (rd AND (NOT rd_old));
rd_falling_edge <= ((NOT rd) AND rd_old);

process(resetn, clk)
begin
	if resetn = '0' then
		wr_old <= '0' ;
	elsif clk'event and clk = '1' then
		wr_old <= wr ;
	end if ;
end process ;
wr_rising_edge <= (wr AND (NOT wr_old)) ;
wr_falling_edge <= ((NOT wr) AND wr_old) ;

process(clk, resetn)
begin
if resetn = '0' then
	rd_addr <= (others => '0') ;
elsif clk'event and clk = '1' then
	if sraz = '1' then
		rd_addr <= (others => '0');
	elsif rd_falling_edge = '1' and nb_available_t /= 0 then
			rd_addr <= rd_addr + 1;
	end if ;
end if ;
end process ;

-- wr process 
process(clk, resetn)
begin
if resetn = '0' then
	wr_addr <= (others => '0') ;
elsif clk'event and clk = '1' then
	if sraz = '1' then
		wr_addr <= (others => '0');
	elsif wr_falling_edge = '1' and nb_available_t /= N then
		wr_addr <= wr_addr + 1;
	end if ;
end if ;
end process ;



--counter_load <= sraz ;
--
--available_counter : up_down_counter 
--	 generic map(NBIT => nbit(N) + 1)
--    port map( clk => clk,
--			  resetn => resetn,
--           sraz => '0' ,
--           en =>  en_available_counter,
--			  load => counter_load,
--			  up_downn => up_downn_available_counter ,
--			  E =>  std_logic_vector(to_unsigned(0, nbit(N) + 1)),
--           Q => slv_nb_available_t
--			  );
--
--en_available_counter <= '1' when wr_falling_edge = '1'  AND (nb_available_t /= N) and rd_falling_edge = '0' else
--								'1' when rd_falling_edge = '1' AND (nb_available_t /= 0) and wr_falling_edge = '0' else
--								'0' ;
--up_downn_available_counter <= wr_falling_edge ;
--nb_available_t <= unsigned(slv_nb_available_t);
--
--										
--free_counter : up_down_counter
--	 generic map(NBIT => nbit(N) + 1)
--    port map( clk => clk,
--				resetn => resetn,
--           sraz => '0' ,
--           en =>  en_free_counter,
--			  load => counter_load,
--			  up_downn => up_downn_free_counter ,
--			  E => std_logic_vector(to_unsigned(N, nbit(N) + 1)),
--           Q => slv_nb_free_t
--			  );
--
--en_free_counter <= '1' when wr_falling_edge = '1' and nb_free_t /= 0 and rd_falling_edge = '0' else
--						 '1' when rd_falling_edge = '1' and nb_free_t /= N and wr_falling_edge = '0' else
--						 '0' ;
--up_downn_free_counter <= rd_falling_edge ;
--nb_free_t <= unsigned(slv_nb_free_t) ;


-- nb available process
process(clk, resetn)
begin
if resetn = '0' then
	nb_available_t <= (others => '0') ;
elsif clk'event and clk = '1' then
	if sraz = '1' then
		nb_available_t <= (others => '0') ;
	elsif wr_falling_edge = '1' and rd_falling_edge = '0' and nb_available_t /= N then
		nb_available_t <= nb_available_t + 1 ;
	elsif rd_falling_edge = '1' and wr_falling_edge = '0' and nb_available_t /= 0 then
		nb_available_t <= nb_available_t - 1 ;	
	end if ;
end if ;
end process ;


nb_available <= nb_available_t ;

empty <= '1' when nb_available_t = 0 else
			'1' when nb_available_t = 1 and rd_falling_edge = '1' else
         '0' ;

full <= '1' when nb_available_t = N else
		  '1' when nb_available_t = N - 1 and wr_falling_edge = '1' else
		  '0' ;

wr_data <= wr ;

end Behavioral;

