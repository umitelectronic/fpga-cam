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

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity erode3x3 is
generic(INVERT : natural := 0; VALUE : std_logic_vector(7 downto 0) := X"FF");
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
	constant clock_stretch_cycle : integer range 0 to 4 := 2 ;
	signal clock_stretch : integer range 0 to 4 := 0 ;
	signal conv_state : clock_state ;
	signal block3x3_sig : mat3 ;
	signal new_block, pxclk_state, one_value : std_logic ;
	signal pixel_count : unsigned(7 downto 0) := (others => '0') ;
begin

		block0:  block3X3 
		generic map(LINE_SIZE =>  640)
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
		
		
		process(clk, arazb)
		begin
			if arazb = '0' then
					pixel_count <= (others => '0') ;
					pxclk_state <= '0' ;
			elsif clk'event and clk = '1' then
				if hsync = '1' OR vsync = '1' then
					pixel_count <= (others => '0') ;
				elsif (pxclk_state /= pixel_clock)  AND pixel_clock = '1' then
					pixel_count <= pixel_count + 1 ;
				elsif new_block = '1' then
					pixel_count <= pixel_count - 1 ;
				end if ;
				pxclk_state <= pixel_clock ;
			end if;
		end process;
		
		
		process(clk, arazb)
		begin
			if arazb = '0' then
				clock_stretch <= 0 ;
				conv_state <= LOW ;
			elsif clk'event and clk = '1' then
				case conv_state is
					when LOW =>
						if clock_stretch > 0 then
							pixel_clock_out <= '1' ;
							clock_stretch <= clock_stretch - 1 ;
						else
							pixel_clock_out <= '0' ;
						end if ;
						if new_block = '1' then
							clock_stretch <= clock_stretch_cycle ;
							pixel_clock_out <= '1' ;
							conv_state <= HIGH ; 
						end if ;
					when HIGH =>
						pixel_clock_out <= '1' ;
						if new_block = '0' then
							conv_state <= LOW ; 
						end if ;
					when others =>
						conv_state <= LOW ;
				end case;
			end if;
		end process ;
	
		hsync_out	<= hsync when (clock_stretch = 0) else --need to get this clean
							'0' ;
		vsync_out <= vsync when (clock_stretch = 0) else
						 '0' ;

end Behavioral;

