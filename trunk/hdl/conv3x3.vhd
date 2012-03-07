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
generic(KERNEL : mat3 := ((1, 2, 1),(0, 0, 0),(-1, -2, -1));
		  NON_ZERO	: index_array := ((0, 0), (0, 1), (0, 2), (2, 0), (2, 1), (2, 2), (3, 3) ) -- (3, 3) indicate end  of non zero values
		  );
port(
 		clk : in std_logic; 
 		arazb : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_clock_out, hsync_out, vsync_out : out std_logic; 
 		pixel_data_in : in std_logic_vector(7 downto 0 ); 
 		pixel_data_out : out std_logic_vector(7 downto 0 )

);
end conv3x3;

architecture Behavioral of conv3x3 is


type read_pixel_state is (WAIT_PIXEL, FIFO_SHIFT, LOAD_VALUES1, LOAD_VALUES2, END_PIXEL);
type read_hsync_state is (WAIT_HSYNC, END_HSYNC);
type read_vsync_state is (WAIT_VSYNC, END_VSYNC);
type compute_state	is	(WAIT_PIXEL, COMPUTE);
type clock_state	is	(HIGH, LOW);

signal pixel_state : read_pixel_state ;
signal convolution_state : compute_state ;
signal pixel_clock_state : clock_state ;

signal block3x3 : mat3 := ((0, 0, 0), (0, 0, 0), (0, 0, 0));

signal k00, k10 :	signed(15 downto 0) := 0 ;


signal pixel_state : read_pixel_state ;
signal fifo1_wr, fifo1_rd, fifo1_empty, fifo1_rdy, fifo2_wr, fifo2_rd, fifo2_empty, fifo2_rdy : std_logic ;
signal sraz_mac, new_pixel, new_mac : std_logic ;
signal MAC_A, MAC_B, MAC_RES	:	std_logic_vector(15 downto 0);


signal FIFO1_INPUT, FIFO1_OUTPUT, FIFO2_INPUT, FIFO2_OUTPUT : std_logic(7 downto 0);
signal index, nb_line : std_logic_vector(1 downto 0);
signal half_pixel_count : std_logic_vector(5 downto 0);
begin


pixel_clock_out <= new_mac ;

linefifo1 : fifo_Nx8
	generic map(N => 641)
	port map(
	clk => clk, 
	arazb => arazb, 
	wr => fifo1_wr , 
	rd => fifo1_rd, 
	empty => fifo1_empty , fifo1_rdy => send,
	data_out => FIFO1_OUTPUT,  
	data_in => FIFO1_INPUT
); 

linefifo2 : fifo_Nx8
	generic map(N => 641)
	port map(
	clk => clk, 
	arazb => arazb, 
	wr => fifo2_wr , 
	rd => fifo2_rd, 
	empty => fifo2_empty , fifo2_rdy => send,
	data_out => FIFO2_OUTPUT,  
	data_in => FIFO2_INPUT
); 

mac0: MAC16
port map(clk => NOT clk, sraz => sraz_mac, -- using phase shifted clock
	  add_subb	=> '1' ,
	  A => MAC_A, B => MAC_B,
	  RES => MAC_RES 
);



-- actualize matrix with values
process(clk)
begin
if arazb = '0' then 
	block3x3(0)(0) <= 0 ;
	block3x3(0)(1) <= 0 ; -- zeroing matrix
	block3x3(0)(2) <= 0 ;
	
	block3x3(1)(0) <= 0 ;
	block3x3(1)(1) <= 0 ;
	block3x3(1)(2) <= 0 ;
	
	block3x3(2)(0) <= 0 ;
	block3x3(2)(1) <= 0 ;
	block3x3(2)(2) <= 0 ;
	pixel_state <= WAIT_PIXEL ;
elsif clk'event and clk = '1' then
	case pixel_state is
		when WAIT_PIXEL =>
			if pixel_clock = '1' then
				block3x3(0)(0) <= k00 ;
				block3x3(0)(1) <= block3x3(0)(0) ; -- shifting matrix to right
				block3x3(0)(2) <= block3x3(0)(1) ;
				
				block3x3(1)(0) <= k10 ;
				block3x3(1)(1) <= block3x3(1)(0) ;
				block3x3(1)(2) <= block3x3(1)(1) ;
				
				block3x3(2)(0) <= pixel_data_in ;
				block3x3(2)(1) <= block3x3(2)(0) ;
				block3x3(2)(2) <= block3x3(2)(1) ;
				
				FIFO1_input <= block3x3(1)(0) ; -- shifting pixel to upper line fifo
				FIFO1_wr <= '1' ;
				new_pixel <= '1' ;
				pixel_state <= SHIFT_FIFO ;
			end if ;
		when SHIFT_FIFO => -- copy one elt of fifo2 in fifo1
			new_pixel <= '0' ;
			FIFO1_wr <= '0' ;
			FIFO2_input <= kernel(2)(0) ;
			FIFO2_wr <= '1' ;
			pixel_state <= LOAD_VALUES ;
		when LOAD_VALUES1 => -- load value from fifos into buffer
			new_pixel <= '0' ;
			FIFO2_wr <= '0' ;
			FIFO1_wr <= '0' ;
			FIFO2_rd <= '1' ;
			FIFO1_rd <= '1' ;
			pixel_state <= LOAD_VALUES2 ;
		when LOAD_VALUES2  =>
			new_pixel <= '0' ;
			FIFO2_wr <= '0' ;
			FIFO1_wr <= '0' ;
			FIFO2_rd <= '0' ;
			FIFO1_rd <= '0' ;
			k00 <= FIFO1_OUTPUT ;
			k10 <= FIFO2_OUTPUT ;
			pixel_state <= END_PIXEL ;
		when END_PIXEL => -- waiting for end of pixel
			new_pixel <= '0' ;
			FIFO2_wr <= '0' ;
			FIFO1_wr <= '0' ;
			FIFO2_rd <= '0' ;
			FIFO1_rd <= '0' ;
			if pixel_clock = '0' then
				pixel_state <= WAIT_PIXEL ;
			end if;
		when others =>
			pixel_state <= WAIT_PIXEL ;
	end case ;
end if;
end process;



--compute matrix convolution with non-zero matrix elts
process(clk)
begin
if arazb = '0' then 
	sraz_mac <= '1' ;
	new_mac <= '0' ;
	index <= '0' ;
elsif clk'event and clk = '1'  then
	case convolution_state is
		when WAIT_PIXEL =>
			sraz_mac <= '1' ;
			index <= '0' ;
			if new_pixel = '1'  then
				new_mac <= '0' ;
				sraz_mac <= '0' ;
				MAC_A <= block3x3(NON_ZERO(conv_integer(index))(0))(NON_ZERO(conv_integer(index))(1)) ;
				MAC_B <= KERNEL(NON_ZERO(conv_integer(index))(0))(NON_ZERO(conv_integer(index))(1)) ;
				index <= index + 1;
				convolution_state <= COMPUTE ;
			end if;
		when COMPUTE =>
			if NON_ZERO(conv_integer(index))(0) < 3 then
				new_mac <= '0' ;
				sraz_mac <= '0' ;
				MAC_A <= block3x3(NON_ZERO(conv_integer(index))(0))(NON_ZERO(conv_integer(index))(1)) ;
				MAC_B <= KERNEL(NON_ZERO(conv_integer(index))(0))(NON_ZERO(conv_integer(index))(1)) ;
				index <= index + 1;
			else
				pixel_data_out <= MAC_RES ;
				new_mac <= '1' ;
				convolution_state <= WAIT_PIXEL ;
			end if;
	end case ;
end if;
end process;

process(clk, arazb)
begin 
if clk'event and clk = '1' then
end if;
end process;


end Behavioral;

