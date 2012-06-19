----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    10:54:36 06/19/2012 
-- Design Name: 
-- Module Name:    fifo_peripheral - Behavioral 
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

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

library work ;
use work.generic_components.all ;
-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity fifo_peripheral is
generic(BASE_ADDR	:	natural	:= 0; WIDTH	: positive := 16; SIZE	: positive	:= 128);
port(
clk, arazb : in std_logic ;
addr_bus : in std_logic_vector((WIDTH - 1) downto 0);
wr_bus, rd_bus : in std_logic ;
wrB, rdA : in std_logic ;
data_bus	: inout std_logic_vector((WIDTH - 1) downto 0); -- bus interface
inputB: in std_logic_vector((WIDTH - 1) downto 0); -- logic interface
outputA	: out std_logic_vector((WIDTH - 1) downto 0); -- logic interface
emptyA, fullA, emptyB, fullB	:	out std_logic 

);
end fifo_peripheral;

architecture Behavioral of fifo_peripheral is
signal  fifoA_wr, fifoB_rd, bus_cs : std_logic ;
signal in_addr	:	std_logic_vector((WIDTH - 1) downto 0);
signal fifoA_in,  fifoB_out : std_logic_vector((WIDTH - 1) downto 0 ); 
signal nb_freeA, nb_availableA, nb_freeB, nb_availableB  :  unsigned((WIDTH - 1) downto 0 ); 
signal nb_freeA_latched, nb_availableB_latched : std_logic_vector((WIDTH - 1) downto 0  );
begin

fifo_addr_dec0 : addr_decoder
generic map(BUS_WIDTH => WIDTH , BASE_ADDR => BASE_ADDR , END_ADDR =>  (BASE_ADDR + 3))
port map(addr_bus_in	=> addr_bus ,
	  addr_bus_out	=> in_addr ,
	  cs => bus_cs
);	

fifo_A : dp_fifo -- write from bus, read from logic
	generic map(N => SIZE , W => WIDTH)
	port map(
 		clk => clk, arazb => arazb , sraz => '0' , 
 		wr => fifoA_wr, rd => rdA,
		empty => emptyA,
		full => fullA ,
 		data_out => outputA , 
 		data_in => fifoA_in ,
		nb_free => nb_freeA(nbit(SIZE)  downto 0) ,
		nb_available => nb_availableA(nbit(SIZE)   downto 0)
	); 
	
fifo_B : dp_fifo -- read from bus, write from logic
	generic map(N => SIZE , W => WIDTH)
	port map(
 		clk => clk, arazb => arazb , sraz => '0' , 
 		wr => wrB, rd => fifoB_rd,
		empty => emptyB,
		full => fullB ,
 		data_out => fifoB_out , 
 		data_in => inputB ,
		nb_free => nb_freeB(nbit(SIZE)   downto 0) ,
		nb_available => nb_availableB(nbit(SIZE)  downto 0)
	); 


nb_free_latch0 : generic_latch 
	 generic map(NBIT => WIDTH)
    Port map( clk => clk ,
           arazb => arazb ,
           sraz => '0' ,
           en => (NOT rd_bus) ,
           d => std_logic_vector(nb_freeA),
           q => nb_freeA_latched);
			  
nb_available_latch0 : generic_latch 
	 generic map(NBIT => WIDTH)
    Port map( clk => clk ,
           arazb => arazb ,
           sraz => '0' ,
           en => (NOT rd_bus) ,
           d => std_logic_vector(nb_availableB),
           q => nb_availableB_latched);


nb_freeA((WIDTH - 1) downto (nbit(SIZE) + 1)) <= (others => '0') ; 
nb_availableB((WIDTH - 1) downto (nbit(SIZE) + 1)) <= (others => '0') ;
nb_freeB((WIDTH - 1) downto (nbit(SIZE) + 1)) <= (others => '0') ; 
nb_availableA((WIDTH - 1) downto (nbit(SIZE) + 1)) <= (others => '0') ;


data_bus <= fifoB_out when bus_cs = '1' and wr_bus = '0' and rd_bus = '1' and in_addr(1 downto 0) = "00" else
				( nb_freeA_latched) when bus_cs = '1' and rd_bus = '1' and wr_bus = '0' and in_addr(1 downto 0) = "01" else
				( nb_availableB_latched) when bus_cs = '1' and rd_bus = '1' and wr_bus = '0' and in_addr(1 downto 0) = "10" else
				(others => 'Z');

fifoB_rd <= rd_bus when in_addr(1 downto 0) = "00" and bus_cs = '1' else
				'0' ;
				
fifoA_wr <= wr_bus when in_addr(1 downto 0) = "00" and bus_cs = '1' and rd_bus = '0' else
				'0' ;
				
fifoA_in <= data_bus ;

end Behavioral;

