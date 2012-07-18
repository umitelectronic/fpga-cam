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
generic(BASE_ADDR	:	natural	:= 0; ADDR_WIDTH : positive := 8; WIDTH	: positive := 16; SIZE	: positive	:= 128);
port(
	clk, arazb : in std_logic ;
	addr_bus : in std_logic_vector((ADDR_WIDTH - 1) downto 0);
	wr_bus, rd_bus, cs_bus : in std_logic ;
	wrB, rdA : in std_logic ;
	data_bus_in	: in std_logic_vector((WIDTH - 1) downto 0); -- bus interface
	data_bus_out	: out std_logic_vector((WIDTH - 1) downto 0); -- bus interface
	inputB: in std_logic_vector((WIDTH - 1) downto 0); -- logic interface
	outputA	: out std_logic_vector((WIDTH - 1) downto 0); -- logic interface
	emptyA, fullA, emptyB, fullB	:	out std_logic 
);
end fifo_peripheral;

architecture Behavioral of fifo_peripheral is
signal  fifoA_wr, fifoB_rd, bus_cs, srazA, srazB : std_logic ;
signal in_addr	:	std_logic_vector(2 downto 0);
signal fifoA_in,  fifoB_out : std_logic_vector((WIDTH - 1) downto 0 ); 
signal nb_availableA, nb_availableB  :  unsigned((WIDTH - 1) downto 0 ); 
signal nb_availableA_latched, nb_availableB_latched : std_logic_vector((WIDTH - 1) downto 0  );
signal data_bus_out_t	: std_logic_vector((WIDTH - 1) downto 0); 
signal latch_registers : std_logic ;
begin

fifo_addr_dec0 : addr_decoder
generic map(ADDR_WIDTH => ADDR_WIDTH ,BASE_ADDR => BASE_ADDR , ADDR_OUT_WIDTH =>  3)
port map(addr_bus_in	=> addr_bus ,
	  addr_bus_out	=> in_addr ,
	  cs => bus_cs
);	

--bus_cs <= '1' ;
--in_addr <= addr_bus ;

fifo_A : dp_fifo -- write from bus, read from logic
	generic map(N => SIZE , W => WIDTH)
	port map(
 		clk => clk, arazb => arazb , sraz => srazA , 
 		wr => fifoA_wr, rd => rdA,
		empty => emptyA,
		full => fullA ,
 		data_out => outputA , 
 		data_in => fifoA_in ,
		nb_available => nb_availableA(nbit(SIZE)   downto 0)
	); 
	
fifo_B : dp_fifo -- read from bus, write from logic
	generic map(N => SIZE , W => WIDTH)
	port map(
 		clk => clk, arazb => arazb , sraz => srazB , 
 		wr => wrB, rd => fifoB_rd,
		empty => emptyB,
		full => fullB ,
 		data_out => fifoB_out , 
 		data_in => inputB ,
		nb_available => nb_availableB(nbit(SIZE)  downto 0)
	); 

latch_registers <= NOT rd_bus ;
	  
--nb_available_latch0 : generic_latch 
--	 generic map(NBIT => WIDTH)
--    Port map( clk => clk ,
--           arazb => arazb ,
--           sraz => '0' ,
--           en => latch_registers ,
--           d => std_logic_vector(nb_availableB),
--           q => nb_availableB_latched);

nb_availableB_latched  <= std_logic_vector(nb_availableB) ;	  
--nb_available_latch1 : generic_latch 
--	 generic map(NBIT => WIDTH)
--    Port map( clk => clk ,
--           arazb => arazb ,
--           sraz => '0' ,
--           en => latch_registers ,
--           d => std_logic_vector(nb_availableA),
--           q => nb_availableA_latched);

nb_availableA_latched <= std_logic_vector(nb_availableA) ;

nb_availableB((WIDTH - 1) downto (nbit(SIZE) + 1)) <= (others => '0') ;
nb_availableA((WIDTH - 1) downto (nbit(SIZE) + 1)) <= (others => '0') ;


data_bus_out_t <= fifoB_out when in_addr(2) = '0'  else --fifo has 2 bits address space
				std_logic_vector(to_unsigned(SIZE, 16)) when in_addr(2 downto 0) = "100" else
				( nb_availableA_latched) when in_addr(2 downto 0) = "101" else
				( nb_availableB_latched) when in_addr(2 downto 0) = "110"  else
				fifoB_out when in_addr(2 downto 0) = "111" else -- peek !
				(others => '0');

data_bus_out <= data_bus_out_t when bus_cs = '1' else
					(others => 'Z');


fifoB_rd <= rd_bus when in_addr(2) = '0' and bus_cs = '1' else
				'0' ;
				
fifoA_wr <= wr_bus when in_addr(2) = '0' and bus_cs = '1' else
				'0' ;
	
srazA <= '1' when bus_cs = '1' and rd_bus = '0' and wr_bus = '1' and in_addr(2 downto 0) = "101" else
			'0' ;

srazB <= '1' when bus_cs = '1' and rd_bus = '0' and wr_bus = '1' and in_addr(2 downto 0) = "110" else
			'0' ;
				
fifoA_in <= data_bus_in ;

end Behavioral;

