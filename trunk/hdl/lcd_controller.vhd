----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    13:58:21 05/26/2012 
-- Design Name: 
-- Module Name:    lcd_controller - Behavioral 
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
use work.camera.all ;
use work.generic_components.all ;
-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity lcd_controller is
port(
 		clk : in std_logic; 
 		arazb : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_r, pixel_g, pixel_b : in std_logic_vector(7 downto 0 );
		lcd_rs, lcd_cs, lcd_rd, lcd_wr	:	 out std_logic;
	   lcd_data	:	out std_logic_vector(15 downto 0) 
	); 
end lcd_controller;

architecture Behavioral of lcd_controller is

constant delay : positive :=  100 ;

type lcd_state	is (LCD_INIT, WAIT_DONE, WAIT_DELAY, WAIT_VSYNC, LCD_VSYNC, LCD_VIDEO) ;
signal state, next_state : lcd_state  ;

signal en_rom, en_counter, sraz_counter, en_delay, sraz_delay : std_logic ;
signal wr_lcd, set_addr_lcd, lcd_busy : std_logic ;
signal register_addr, lcd_addr,  count	:	std_logic_vector(7 downto 0);
signal register_data, lcd_data_s	:	std_logic_vector(15 downto 0);
signal pxclk_old, pxclk_rising	:	std_logic ;
begin


cl_interface0: lcd_interface
port map(clk => clk, arazb => arazb ,
	  addr => lcd_addr,
	  data => lcd_data_s ,
	  wr_data => wr_lcd,
	  set_addr => set_addr_lcd,
	  busy	=> lcd_busy,
	  lcd_rs => lcd_rs, lcd_cs => lcd_cs, lcd_rd => lcd_rd, lcd_wr => lcd_wr ,
	  lcd_data	=> lcd_data);

register0: lcd_register_rom 
	port map(
	   clk => clk, en => '1',
 		data => register_data, 
 		addr => register_addr
	); 
	

register_counter :  simple_counter
 generic map(NBIT => 8)
 port map( clk => clk,
		  arazb => arazb,
		  sraz => '0',
		  en => en_counter,
		  load => '0', 
		  E => std_logic_vector(to_unsigned(0, 8)),
		  Q => register_addr
		  );	

delay_counter :  simple_counter
 generic map(NBIT => 8)
 port map( clk => clk,
		  arazb => arazb,
		  sraz => sraz_delay,
		  en => en_delay,
		  load => '0', 
		  E => std_logic_vector(to_unsigned(0, 8)),
		  Q => count
		  );

process(clk, arazb)
begin
if arazb = '0' then
	pxclk_old <= '0' ;
	pxclk_rising <= '0' ;
elsif clk'event and clk = '1' then
	if pxclk_old /= pixel_clock and pixel_clock = '1' and hsync = '0' then
		pxclk_rising <= '1' ;
	else
		pxclk_rising <= '0' ;
	end if ;
	pxclk_old <= pixel_clock ;
end if ;
end process ;


process(clk, arazb)
begin
if arazb = '0' then
	state <= LCD_INIT ;
elsif clk'event and clk = '1' then
	state <= next_state ;
end if ;
end process ;


process(state, vsync)
begin
next_state <= state ;
case state is
	WHEN LCD_INIT => 
		next_state <= WAIT_DONE ;	
	WHEN WAIT_DONE =>
		if lcd_busy = '0' then
			next_state <= WAIT_DELAY ;
		end if ;
	WHEN WAIT_DELAY => 
		if register_data = X"FF" then
			next_state <= WAIT_VSYNC ;
		elsif count = delay then
			next_state <= LCD_INIT ;
		end if;
	WHEN WAIT_VSYNC => 
		if vsync = '1' then
			next_state <= LCD_VSYNC ;
		end if ;
	WHEN LCD_VSYNC => 
		if vsync = '0' then
			next_state <= LCD_VIDEO ;
		end if ;
	WHEN LCD_VIDEO => 
		if vsync = '1' then
			next_state <= LCD_VSYNC ;
		end if ;
	WHEN others => 
		next_state <= LCD_INIT ;
end case ;
end process ;


-- control of register counter

with state select
	en_counter <= '1' when LCD_INIT,
					  '0' when others ;

-- control of delay counter
with state select 
	en_delay <= '1' when WAIT_DELAY,
					'0' when others ;
with state select 
	sraz_delay <= '1' when LCD_INIT,
					  '0' when others ;



-- control of LCD interface
with state select
	lcd_data_s <= pixel_r(4 downto 0) & pixel_g(5 downto 0) & pixel_b(4 downto 0) when LCD_VIDEO,
					register_data(7 downto 0) when others ;
					
with state select
	lcd_addr <= X"22" when LCD_VSYNC,
					register_data(15 downto 8) when others ;		

with state select
	wr_lcd <=  '1' when LCD_INIT ,
				  pxclk_rising when LCD_VIDEO ,
				  '0' when others ;	
				  
with state select
	set_addr_lcd <= '1' when LCD_INIT ,
						 (NOT vsync) when LCD_VSYNC,
						  '0' when others ;	

end Behavioral;

