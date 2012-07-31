----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    10:25:52 03/03/2012 
-- Design Name: 
-- Module Name:    sobel3x3 - Behavioral 
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

library WORK;
use WORK.CAMERA.ALL;
-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity conv3x3 is
generic(KERNEL : imat3 := ((1, 2, 1),(0, 0, 0),(-1, -2, -1));
		  NON_ZERO	: index_array := ((0, 0), (0, 1), (0, 2), (2, 0), (2, 1), (2, 2), (3, 3), (3, 3), (3, 3) ); -- (3, 3) indicate end  of non zero values
		  IS_POWER_OF_TWO : natural := 0 -- (3, 3) indicate end  of non zero values
		  );
port(
 		clk : in std_logic; 
 		resetn : in std_logic; 
 		new_block : in std_logic ;
		block3x3 : in mat3;
		new_conv : out std_logic ;
		busy : out std_logic ;
 		abs_res : out std_logic_vector(7 downto 0 );
		raw_res : out signed(15 downto 0 )
);
end conv3x3;

architecture Behavioral of conv3x3 is

type compute_state	is	(WAIT_PIXEL, COMPUTE, END_PIPELINE1, END_PIPELINE2);

signal convolution_state : compute_state ;

signal sraz_mac : std_logic ;
signal MAC1_A, MAC1_B, MAC2_A, MAC2_B	:	signed(15 downto 0);
signal MAC1_RES, MAC2_RES:	signed(31 downto 0);

signal final_res, abs_resl : signed(31 downto 0);
signal index : std_logic_vector(3 downto 0) := (others => '0');
begin

final_res <= MAC1_RES + MAC2_RES ;

is_power_of_two0 : IF IS_POWER_OF_TWO = 1 GENERATE
	mac1: SAC16
	port map(clk => clk, sraz => sraz_mac,
	  A => MAC1_A, B => MAC1_B,
	  RES => MAC1_RES 
	);

	mac2: SAC16
	port map(clk => clk, sraz => sraz_mac, 
		  A => MAC2_A, B => MAC2_B,
		  RES => MAC2_RES 
	);
END GENERATE is_power_of_two0 ;

is_power_of_two1 : IF IS_POWER_OF_TWO = 0 GENERATE
mac1: MAC16
port map(clk => clk, sraz => sraz_mac,
	  add_subb	=> '1' ,
	  A => MAC1_A, B => MAC1_B,
	  RES => MAC1_RES 
);

mac2: MAC16
port map(clk => clk, sraz => sraz_mac,
	  add_subb	=> '1' ,
	  A => MAC2_A, B => MAC2_B,
	  RES => MAC2_RES 
);
END GENERATE is_power_of_two1 ;

--compute matrix convolution with non-zero matrix elts
process(clk, resetn)
begin
if resetn = '0' then 
	sraz_mac <= '1' ;
	new_conv <= '0' ;
	busy <= '0' ;
	index <= (others => '0') ;
elsif clk'event and clk = '1'  then
	case convolution_state is
		when WAIT_PIXEL =>
			sraz_mac <= '1' ;
			new_conv <= '0' ;
			busy <= '0' ;
			index <= (others => '0') ;
			if new_block = '1'  then
				new_conv <= '0' ;
				busy <= '1' ;
				sraz_mac <= '0' ;
				MAC1_A(8 downto 0) <= block3x3(NON_ZERO(conv_integer(index))(0))(NON_ZERO(conv_integer(index))(1)) ;
				MAC1_B <= to_signed(KERNEL(NON_ZERO(conv_integer(index))(0))(NON_ZERO(conv_integer(index))(1)), 16) ;
				if NON_ZERO(conv_integer(index+1))(0) < 3 then
					MAC2_A(8 downto 0) <= block3x3(NON_ZERO(conv_integer(index+1))(0))(NON_ZERO(conv_integer(index+1))(1)) ;
					MAC2_B <= to_signed(KERNEL(NON_ZERO(conv_integer(index+1))(0))(NON_ZERO(conv_integer(index+1))(1)), 16) ;
					index <= index + 2;
				else
					MAC2_A(8 downto 0) <= (others => '0');
					MAC2_B <= (others => '0') ;
					index <= index + 1;
				end if;
				convolution_state <= COMPUTE ;
			end if;
		when COMPUTE =>
			busy <= '1' ;
			new_conv <= '0' ;
			if NON_ZERO(conv_integer(index))(0) < 3 then
				sraz_mac <= '0' ;
				MAC1_A(8 downto 0) <= block3x3(NON_ZERO(conv_integer(index))(0))(NON_ZERO(conv_integer(index))(1)) ;
				MAC1_B <= to_signed(KERNEL(NON_ZERO(conv_integer(index))(0))(NON_ZERO(conv_integer(index))(1)), 16) ;
				if NON_ZERO(conv_integer(index+1))(0) < 3 then
					MAC2_A(8 downto 0) <= block3x3(NON_ZERO(conv_integer(index+1))(0))(NON_ZERO(conv_integer(index+1))(1)) ;
					MAC2_B <= to_signed(KERNEL(NON_ZERO(conv_integer(index+1))(0))(NON_ZERO(conv_integer(index+1))(1)), 16) ;
					index <= index + 2;
				else
					MAC2_A(8 downto 0) <= (others => '0');
					MAC2_B <= (others => '0') ;
					index <= index + 1;
				end if;
			else
				MAC2_A(8 downto 0) <= (others => '0'); --zeroing to stop mac operations
				MAC2_B <= (others => '0') ;
				MAC1_A(8 downto 0) <= (others => '0');
				MAC1_B <= (others => '0') ;
				convolution_state <= END_PIPELINE1 ;
			end if;
		when END_PIPELINE1 => -- accumulator is pipelined
			busy <= '1' ;
			new_conv <= '0' ;
			convolution_state <= END_PIPELINE2 ;
		when END_PIPELINE2 => -- accumulator is pipelined
			busy <= '0' ;
			new_conv <= '1' ;
			raw_res <= FINAL_RES(15 downto 0) ; -- should not overflow
			abs_resl <= abs(FINAL_RES) ;
			convolution_state <= WAIT_PIXEL ;
		when others => 
			convolution_state <= WAIT_PIXEL ;
	end case ;
end if;
end process;

abs_res <= std_logic_vector(abs_resl(7 downto 0));

MAC1_A(15 downto 9) <= (others => '0');
MAC2_A(15 downto 9) <= (others => '0');

end Behavioral;

