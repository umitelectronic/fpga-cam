----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    16:59:00 10/04/2012 
-- Design Name: 
-- Module Name:    BRIEF - Behavioral 
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

entity BRIEF is
generic(WIDTH: natural := 640;
		  HEIGHT: natural := 480;
		  WINDOW_SIZE : positive := 8;
		  DESCRIPTOR_LENGTH : positive := 64;
		  PATTERN : brief_pattern );
		port(
			clk : in std_logic; 
			resetn : in std_logic; 
			pixel_clock, hsync, vsync : in std_logic; 
			pixel_data_in : in std_logic_vector(7 downto 0 ); 
			new_desc : out std_logic ;
			descriptor :  out std_logic_vector((DESCRIPTOR_LENGTH - 1) downto 0) );
end BRIEF;

architecture Behavioral of BRIEF is

signal new_block : std_logic ;
signal window : matNM(0 to WINDOW_SIZE-1, 0 to WINDOW_SIZE-1) ;
signal desc : std_logic_vector((DESCRIPTOR_LENGTH - 1) downto 0) ;

begin


window_mgt : blockNxN
		generic map(WIDTH => WIDTH ,
		  HEIGHT => HEIGHT,
		  N => WINDOW_SIZE)
		port map(
			clk => clk ,
			resetn => resetn , 
			pixel_clock => pixel_clock, hsync => hsync, vsync => vsync , 
			pixel_data_in =>  pixel_data_in, 
			new_block => new_block ,
			block_out => window);

gen_pattern_comp : for I in 0 to DESCRIPTOR_LENGTH generate 
		desc(I) <= '1' when  (window((brief_pattern(I,0)/WINDOW_SIZE), (brief_pattern(I,0) rem WINDOW_SIZE)) < window((brief_pattern(I,1)/WINDOW_SIZE), (brief_pattern(I,1) rem WINDOW_SIZE)))  else'0' ;
end generate gen_pattern_comp ;


new_desc <= new_block ;

end Behavioral;

