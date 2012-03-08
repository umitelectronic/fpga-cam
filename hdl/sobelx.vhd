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

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity sobel3x3 is
port(
 		clk : in std_logic; 
 		arazb : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_clock_out, hsync_out, vsync_out : out std_logic; 
 		pixel_data_in : in std_logic_vector(7 downto 0 ); 
 		pixel_data_out : out std_logic_vector(7 downto 0 )

);
end sobel3x3;

architecture Behavioral of sobel3x3 is

begin

FIFO_INPUT <= X"FF" when MAC_RES > 255 else
				  MAC_RES(8 downto 1); -- a bit of scalling to save on memory, true scaling should be shifted by 4 ...
											  -- but wait and see !
pixel_data_out <= FIFO_BUFF - MAC_RES ;


pixel_clock_out <= new_mac when nb_line > 2 else
						 '0' ;

hsync_out <= hsync when new_pixel = '0' and new_mac = '0' else -- output href only when all pixel are discarded
				 '0' ;
				 
vsync_out <= vsync when nb_line = 0 else -- output href only when all lines are discarded
				 '0';

linex2fifo : fifo_Nx8 -- output fifo
	generic map(N => 1280)
	port map(
	clk => clk, 
	arazb => arazb, 
	wr => fifo_wr , 
	rd => fifo_rd, 
	empty => fifo_empty , full => fifo_full, data_rdy => send,
	data_out => FIFO_OUTPUT,  
	data_in => FIFO_INPUT
); 

mac0: MAC16
port map(clk => NOT clk, sraz => sraz_mac, -- using pahse shifted clock
	  add_subb	=> '1' ,
	  A => MAC_A, B => MAC_B,
	  RES => MAC_RES 
);


--store pixel in line
process(clk)
begin
if arazb = '0' then 
	pixel_state <= WAIT_PIXEL ;
	kcol(0) <= (others => '0');
	kcol(1) <= (others => '0');
	kcol(2) <= (others => '0');
elsif clk'event and clk = '1' then
	case pixel_state is
		when WAIT_PIXEL =>
			if pixel_clock = '1' then
				kcol(0) <= kcol(1);
				kcol(1) <= kcol(2);
				kcol(2) <= X"00" & pixel_data_in ;
				half_pixel_count <= (others => '0') ;
				if nb_line > 2 then
					fifo_rd <= '1' ;
					pixel_state <= READ_FIFO ;
				else
					new_pixel <= '1' ;
					FIFO_BUFF <= X"00" ;
					pixel_state <= STORE_PIXEL ;
				end if;
			end if ;
		when READ_FIFO =>
			half_pixel_count <= half_pixel_count + 1 ;
			if  data_rdy = '1' then
				FIFO_BUFF <= FIFO_OUTPUT ;
				fifo_rd <= '0' ;
				pixel_state <= STORE_PIXEL ;
			elsif fifo_empty = '1' then
				FIFO_BUFF <= X"00" ;
				fifo_rd <= '0' ;
				pixel_state <= STORE_PIXEL ;
			end if ;
		when STORE_PIXEL =>
			fifo_rd <= '0' ;
			half_pixel_count <= half_pixel_count + 1 ;
			if pixel_clock = '0' then
				pixel_state <= WAIT_PIXEL ;
			end if ;
	end case ;
end if;
end process;


--compute line convolution with positive sobel
process(clk)
begin
if arazb = '0' then 
	sraz_mac <= '1' ;
	index <= '0' ;
elsif clk'event and clk = '1' then
	if new_pixel = '1' then
		new_mac <= '0' ;
		sraz_mac <= '0' ;
		MAC_A <= kcol(conv_integer(index)) ;
		MAC_B <= sobel_elts(conv_integer(index)) ;
		index <= index + 1;
		if index = 2 then
			--write fifo 
			fifo_wr <= '1' ;
			--reset mac
			sraz_mac <= '1' ;
			index <= '0' ;
			new_pixel <= '0' ;
		end if ;
	else 
		sraz_mac <= '1' ;
		index <= '0' ;
	end if ;
end if;
end process;


process(clk)
begin
if arazb = '0' then 
	sraz_mac <= '1' ;
	index <= '0' ;
elsif clk'event and clk = '1' then
end if;
end process;

end Behavioral;

