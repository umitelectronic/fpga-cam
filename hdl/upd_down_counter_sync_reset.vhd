----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    10:11:51 07/09/2012 
-- Design Name: 
-- Module Name:    upd_down_counter_sync_reset - Behavioral 
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

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity up_down_counter_sync_reset is
generic(NBIT : positive := 4);
    Port ( clk : in  STD_LOGIC;
           sraz : in  STD_LOGIC;
           en, load : in  STD_LOGIC;
			  up_downn : in  STD_LOGIC;
			  E : in  STD_LOGIC_VECTOR(NBIT - 1 downto 0);
           Q : out  STD_LOGIC_VECTOR(NBIT - 1 downto 0)
			  );
end up_down_counter_sync_reset;

architecture Behavioral of up_down_counter_sync_reset is
signal Qp : std_logic_vector(NBIT - 1 downto 0);
begin

process(clk) 
begin
   if clk='1' and clk'event then
      if sraz='1' then 
          Qp <= (others => '0');
      elsif load='1' then
             Qp <= E;
		elsif en='1' then
				if up_downn='1' then   
					 Qp <= Qp + 1;
				else
					 Qp <= Qp - 1;
				end if;
      end if;
   end if;
end process; 

Q <= Qp ;

end Behavioral;

