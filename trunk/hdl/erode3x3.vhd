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
use IEEE.STD_LOGIC_UNSIGNED.ALL;

library WORK ;
USE WORK.CAMERA.ALL ;
USE WORK.GENERIC_COMPONENTS.ALL ;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity erode3x3 is
generic(INVERT : natural := 0; 
		  VALUE : std_logic_vector(7 downto 0) := X"FF";
		  WIDTH: natural := 640;
		  HEIGHT: natural := 480);
port(
 		clk : in std_logic; 
 		arazb : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_clock_out, hsync_out, vsync_out : out std_logic; 
 		pixel_data_in : in std_logic_vector(7 downto 0 ); 
 		pixel_data_out : out std_logic_vector(7 downto 0 )

);
end erode3x3;



architecture Behavioral of erode3x3 is
	type clock_state is (LOW, HIGH);
	constant clock_stretch_cycle : integer range 0 to 4 := 4 ;
	signal clock_stretch : integer range 0 to 4 := 0 ;
	signal conv_state : clock_state ;
	signal block3x3_sig : mat3 ;
	signal new_block, pxclk_state, one_value : std_logic ;
	signal nb_pixel : std_logic_vector(9 downto 0) := (others => '0') ;
	signal nb_line : std_logic_vector(9 downto 0) := (others => '0') ;
	signal block_counter : std_logic_vector(9 downto 0) := (others => '0') ;
	signal pixel_clock_old, hsync_old, new_block_old, pixel_clock_hold : std_logic ;
begin

		block0:  block3X3v2 
		generic map(LINE_SIZE =>  WIDTH)
		port map(
			clk => clk ,
			arazb => arazb , 
			pixel_clock => pixel_clock , hsync => hsync , vsync => vsync,
			pixel_data_in => pixel_data_in ,
			new_block => new_block,
			block_out => block3x3_sig);
		
		inv0 : IF INVERT = 0 generate 
			pixel_data_out <= VALUE when ((block3x3_sig(0)(1) = "011111111" )AND (block3x3_sig(1)(0) = "011111111") 
							AND (block3x3_sig(1)(1) = "011111111") 
							AND (block3x3_sig(1)(2) = "011111111")  
							AND (block3x3_sig(2)(1) = "011111111")) else
							(others => '0');
		end generate inv0 ;
		
		ninv0 : IF INVERT = 1 generate 
			pixel_data_out <= (others => '0') when ((block3x3_sig(0)(1) = "011111111")AND (block3x3_sig(1)(0) = "011111111") 
							AND (block3x3_sig(1)(1) = "011111111") 
							AND (block3x3_sig(1)(2) = "011111111")  
							AND (block3x3_sig(2)(1) = "011111111")) else
							VALUE ;
		end generate ninv0 ;
		
		
		
--		process(clk, arazb)
--		begin
--		if arazb = '0' then 
--			block_counter <= (others => '0') ;
--		elsif clk'event and clk = '1'  then
--				if vsync = '1' then
--					block_counter <= (others => '0') ;
--				elsif new_block /= new_block_old  and new_block = '0' then
--					if block_counter = WIDTH - 1 then
--						block_counter <= (others => '0') ;
--					else
--						block_counter <= block_counter + 1 ;
--					end if;
--				end if ;
--				new_block_old <= new_block ;
--		end if ;
--		end process ;
--		
		
		block_counter0: pixel_counter
		generic map(POL => '0')
		port map(
			clk => clk,
			arazb => arazb, 
			pixel_clock => new_block, hsync => hsync,
			pixel_count => block_counter
			);
		
		pixel_counter0: pixel_counter
		generic map(POL => '1')
		port map(
			clk => clk,
			arazb => arazb, 
			pixel_clock => pixel_clock, hsync => hsync,
			pixel_count => nb_pixel
			);
		
--		
--		process(clk, arazb)
--		begin
--		if arazb = '0' then 
--			pixel_counter <= (others => '0') ;
--		elsif clk'event and clk = '1'  then
--				if hsync = '1' then
--					pixel_counter <= (others => '0') ;
--				elsif pixel_clock /= pixel_clock_old and pixel_clock = '0' then
--					pixel_counter <= pixel_counter + 1 ;
--				end if ;
--				pixel_clock_old <= pixel_clock ;
--		end if ;
--		end process ;

line_counter0: line_counter
		port map(
			clk => clk,
			arazb => arazb, 
			hsync => hsync, vsync => vsync, 
			line_count => nb_line
			);

		-- count lines on rising edge of hsync
--		process(clk, arazb)
--		begin
--		if arazb = '0' then 
--			nb_line <= (others => '0') ;
--		elsif clk'event and clk = '1'  then
--				if vsync = '1' then
--					nb_line <= (others => '0') ;
--				elsif hsync /= hsync_old and hsync = '1' then
--					nb_line <= nb_line + 1 ;
--				end if ;
--				hsync_old <= hsync ;
--		end if ;
--		end process ;
		
		
	 hold_pixel_clock0: hold 
	 generic map(HOLD_TIME => clock_stretch_cycle, HOLD_LEVEL => '1')
    port map( clk => clk, 
           arazb => arazb,
           sraz => '0',
           input => new_block,
			  output => pixel_clock_out, 
			  holding => pixel_clock_hold
			  );
		
--		process(clk, arazb)
--		begin
--			if arazb = '0' then
--				clock_stretch <= 0 ;
--				conv_state <= LOW ;
--			elsif clk'event and clk = '1' then
--				case conv_state is
--					when LOW =>
--						if clock_stretch > 0 then
--							pixel_clock_out <= '1' ;
--							clock_stretch <= clock_stretch - 1 ;
--						else
--							pixel_clock_out <= '0' ;
--						end if ;
--						if new_block = '1' then
--							clock_stretch <= clock_stretch_cycle ;
--							pixel_clock_out <= '1' ;
--							conv_state <= HIGH ; 
--						end if ;
--					when HIGH =>
--						pixel_clock_out <= '1' ;
--						if new_block = '0' then
--							conv_state <= LOW ; 
--						end if ;
--					when others =>
--						conv_state <= LOW ;
--				end case;
--			end if;
--		end process ;
	
		hsync_out	<= hsync when (pixel_clock_hold = '0' and block_counter = nb_pixel) else --need to get this clean
							'0' ;
		vsync_out <= vsync when (pixel_clock_hold = '0' and block_counter = nb_pixel) else
						 '0' ;

end Behavioral;

