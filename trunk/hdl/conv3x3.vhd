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
		  NON_ZERO	: index_array := ((0, 0), (0, 1), (0, 2), (2, 0), (2, 1), (2, 2), (3, 3), (3, 3), (3, 3) ) -- (3, 3) indicate end  of non zero values
		  );
port(
 		clk : in std_logic; 
 		arazb : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_clock_out, hsync_out, vsync_out : out std_logic; 
 		pixel_data_in : in std_logic_vector(7 downto 0 ); 
 		abs_res : out unsigned(7 downto 0 );
		raw_res : out signed(15 downto 0 )

);
end conv3x3;

architecture Behavioral of conv3x3 is


type read_pixel_state is (WAIT_PIXEL, LOAD_VALUES1, LOAD_VALUES2, END_PIXEL);
type compute_state	is	(WAIT_PIXEL, COMPUTE);
type hsync_state is	(WAIT_HSYNC, END_HSYNC);

signal hsync_state0	:	hsync_state ;
signal pixel_state : read_pixel_state ;
signal convolution_state : compute_state ;

signal block3x3 : mat3 := (((others => '0'), (others => '0'), (others => '0')), 
									((others => '0'), (others => '0'), (others => '0')), 
									((others => '0'), (others => '0'), (others => '0')));

signal k02, k12 :	signed(8 downto 0) := (others => '0');


signal fifo1_wr, fifo1_rd, fifo1_empty, fifo1_rdy, fifo2_wr, fifo2_rd, fifo2_empty, fifo2_rdy, sraz_fifo, nclk : std_logic ;
signal sraz_mac, new_pixel, new_mac : std_logic ;
signal MAC1_A, MAC1_B, MAC2_A, MAC2_B	:	signed(15 downto 0);
signal MAC1_RES, MAC2_RES:	signed(31 downto 0);


signal FIFO1_INPUT, FIFO1_OUTPUT, FIFO2_INPUT, FIFO2_OUTPUT : std_logic_vector(7 downto 0) := X"00";
signal final_res : signed(31 downto 0);
signal index, nb_line : std_logic_vector(3 downto 0) := (others => '0');
begin

with convolution_state select
pixel_clock_out <= NOT (hsync OR vsync) when WAIT_PIXEL,
						 new_mac when others ;

with pixel_state select
hsync_out <= hsync when WAIT_PIXEL ,
				 '0' when others;
				 
with pixel_state select				 
vsync_out <= vsync when WAIT_PIXEL ,
				 '0' when others ;

final_res <= MAC1_RES + MAC2_RES ;

nclk <= NOT clk ; --shifted clock

linefifo1 : fifo_Nx8
	generic map(N => 645) -- fifo gets full a bit too fast
	port map(
	clk => clk,
	arazb => arazb,
	sraz => sraz_fifo,
	wr => fifo1_wr , 
	rd => fifo1_rd, 
	empty => fifo1_empty , data_rdy => fifo1_rdy,
	data_out => FIFO1_OUTPUT,  
	data_in => FIFO1_INPUT
); 

linefifo2 : fifo_Nx8
	generic map(N => 645) -- fifo gets full a bit too fast
	port map(
	clk => clk, 
	arazb => arazb,
	sraz => sraz_fifo,
	wr => fifo2_wr , 
	rd => fifo2_rd, 
	empty => fifo2_empty , data_rdy => fifo2_rdy,
	data_out => FIFO2_OUTPUT,  
	data_in => FIFO2_INPUT
); 

mac1: MAC16
port map(clk => nclk, sraz => sraz_mac, -- using phase shifted clock
	  add_subb	=> '1' ,
	  A => MAC1_A, B => MAC1_B,
	  RES => MAC1_RES 
);

mac2: MAC16
port map(clk => nclk, sraz => sraz_mac, -- using phase shifted clock
	  add_subb	=> '1' ,
	  A => MAC2_A, B => MAC2_B,
	  RES => MAC2_RES 
);




-- actualize matrix with values
process(clk, arazb)
begin
if arazb = '0' then 
	block3x3(0)(0) <= (others => '0') ;
	block3x3(0)(1) <= (others => '0') ; -- zeroing matrix
	block3x3(0)(2) <= (others => '0') ;
	
	block3x3(1)(0) <= (others => '0') ;
	block3x3(1)(1) <= (others => '0') ;
	block3x3(1)(2) <= (others => '0') ;
	
	block3x3(2)(0) <= (others => '0') ;
	block3x3(2)(1) <= (others => '0') ;
	block3x3(2)(2) <= (others => '0') ;
	FIFO2_wr <= '0' ;
	FIFO1_wr <= '0' ;
	FIFO2_rd <= '0' ;
	FIFO1_rd <= '0' ;
	k02 <= (others => '0') ;
	k12 <= (others => '0') ;
	pixel_state <= WAIT_PIXEL ;
elsif clk'event and clk = '1' then
	case pixel_state is
		when WAIT_PIXEL =>
			new_pixel <= '0' ;
			if pixel_clock = '1' and hsync = '0' and vsync = '0' then
				block3x3(0)(2) <= k02 ;
				block3x3(0)(1) <= block3x3(0)(2) ; -- shifting matrix to right
				block3x3(0)(0) <= block3x3(0)(1) ;
				
				block3x3(1)(2) <= k12 ;
				block3x3(1)(1) <= block3x3(1)(2) ;
				block3x3(1)(0) <= block3x3(1)(1) ;
				
				block3x3(2)(2) <= signed('0' & pixel_data_in) ;
				block3x3(2)(1) <= block3x3(2)(2) ;
				block3x3(2)(0) <= block3x3(2)(1) ;
				
				FIFO1_input <= std_logic_vector(block3x3(1)(0)(7 downto 0)) ; -- shifting pixel to upper line fifo
				FIFO1_wr <= '1' ;
				FIFO2_input <= std_logic_vector(block3x3(2)(0)(7 downto 0)) ; -- shifting pixel to upper line fifo
				FIFO2_wr <= '1' ;
				new_pixel <= '1' ;
				pixel_state <= LOAD_VALUES1 ;
			end if;
		when LOAD_VALUES1 => -- load value from fifos into buffer
			new_pixel <= '0' ;
			FIFO2_wr <= '0' ;
			FIFO1_wr <= '0' ;
			if nb_line > 1 then
				FIFO2_rd <= '1' ;
				FIFO1_rd <= '1' ;
			end if;
			pixel_state <= LOAD_VALUES2 ;
		when LOAD_VALUES2  =>
			new_pixel <= '0' ;
			FIFO2_wr <= '0' ;
			FIFO1_wr <= '0' ;
			FIFO2_rd <= '0' ;
			FIFO1_rd <= '0' ;
			if nb_line > 1 then
				if fifo2_rdy =  '1' then
					k12 <= signed('0' & FIFO2_OUTPUT) ;
					pixel_state <= END_PIXEL ;
				end if ;
				if fifo1_rdy =  '1' then
					k02 <= signed('0' & FIFO1_OUTPUT) ;
					pixel_state <= END_PIXEL ;
				end if;
			else 
				k12 <= (others => '0') ;
				k02 <= (others => '0') ;
				pixel_state <= END_PIXEL ; -- need to clean this messy description
			end if;
		when END_PIXEL => -- waiting for end of pixel
			new_pixel <= '0' ;
			FIFO2_wr <= '0' ;
			FIFO1_wr <= '0' ;
			FIFO2_rd <= '0' ;
			FIFO1_rd <= '0' ;
			if pixel_clock = '0' and new_mac = '1' then
				pixel_state <= WAIT_PIXEL ;
			end if;
		when others =>
			pixel_state <= WAIT_PIXEL ;
	end case ;
end if;
end process;



--compute matrix convolution with non-zero matrix elts
process(clk, arazb)
begin
if arazb = '0' then 
	sraz_mac <= '1' ;
	new_mac <= '0' ;
	index <= (others => '0') ;
elsif clk'event and clk = '1'  then
	case convolution_state is
		when WAIT_PIXEL =>
			sraz_mac <= '1' ;
			index <= (others => '0') ;
			if new_pixel = '1'  then
				new_mac <= '0' ;
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
			if NON_ZERO(conv_integer(index))(0) < 3 then
				new_mac <= '0' ;
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
				raw_res <= FINAL_RES ;
				if FINAL_RES < 0 then
					abs_res <= unsigned(-FINAL_RES(7 downto 0)) ;
				else
					abs_res <= unsigned(FINAL_RES(7 downto 0)) ;
				end if ;
				new_mac <= '1' ;
				convolution_state <= WAIT_PIXEL ;
			end if;
	end case ;
end if;
end process;

MAC1_A(15 downto 9) <= (others => '0');
MAC2_A(15 downto 9) <= (others => '0');

process(clk, arazb)
begin
if arazb = '0' then 
	nb_line <= (others => '0') ;
	hsync_state0 <= WAIT_HSYNC ;
elsif clk'event and clk = '1'  then
	case hsync_state0 is
		when WAIT_HSYNC =>
			sraz_fifo <= '0' ;
			if hsync = '1' then
				hsync_state0 <= END_HSYNC ;
			end if ;
		when END_HSYNC =>
			if vsync = '1' then
				nb_line <= (others => '0') ;
				sraz_fifo <= '1' ;
			else
				sraz_fifo <= '0' ;
				if hsync = '0' then
					if nb_line < 3 then
						nb_line <= nb_line + 1 ;
					end if;
					hsync_state0 <= WAIT_HSYNC ;
				end if ;
			end if;
		when others =>
			nb_line <= (others => '0') ;
			hsync_state0 <= WAIT_HSYNC ;
	end case ;
end if;
end process;

end Behavioral;

