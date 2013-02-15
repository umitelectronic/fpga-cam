----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    17:01:25 10/09/2012 
-- Design Name: 
-- Module Name:    BRIEF_MANAGER - Behavioral 
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

entity BRIEF_MANAGER is
generic(WIDTH: natural := 640;
		  HEIGHT: natural := 480;
		  SIZE : natural := 64;
		  DELAY : natural := 4 );
port(
 		clk : in std_logic; 
 		resetn : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_clock_out, hsync_out, vsync_out : out std_logic; 
 		pixel_data_in : in std_logic_vector(7 downto 0 );


-- active search interface
		correl_feature_posx0, correl_feature_posy0, correl_feature_posx1, correl_feature_posy1 : in std_logic_vector((nbit(WIDTH) - 1) downto 0 );
		feature_to_correl : in std_logic_vector((SIZE - 1) downto 0 );
		correl_score : out std_logic_vector((nbit(SIZE) - 1) downto 0 );
		max_correl_posx, max_correl_posy : out std_logic_vector((nbit(WIDTH) - 1) downto 0 );
		latch_correl : in std_logic ;

-- feature extractor interface
		feature_descriptor : in std_logic_vector((SIZE - 1) downto 0 );
		latch_feature_descriptor : in std_logic 		

);
end BRIEF_MANAGER;

architecture Behavioral of BRIEF_MANAGER is


	signal pixel_clock_delayed, hsync_delayed, vsync_delayed :  std_logic; 
 	signal pixel_data_delayed :  std_logic_vector(7 downto 0 );

	signal brief_hsync, brief_vsync : std_logic ;

	signal line_count : std_logic_vector((nbit(HEIGHT) - 1) downto 0 ) ;
	signal pixel_count : std_logic_vector((nbit(WIDTH) - 1) downto 0 ) ;


	signal current_descriptor, latched_descriptor : std_logic_vector((SIZE - 1) downto 0 );
	signal current_score, latched_score : std_logic_vector((nbit(SIZE) - 1) downto 0 ) ;
	signal new_descriptor, hamming_done, latch_score, valid_windowx, valid_windowy : std_logic ;
begin



-- delaying inputs to be in sync with commands
delayed_pixels : generic_delay
	generic map( WIDTH => 11 , DELAY => DELAY)
	port map(
		clk => clk, resetn => resetn,
		input(0)	=> pixel_clock,
		input(1) => hsync,
		input(2) => vsync,
		input(10 downto 3) => pixel_data_in ,	
		output(0)	=> pixel_clock_delayed,
		output(1) => hsync_delayed,
		output(2) => vsync_delayed,
		output(10 downto 3) => pixel_data_delayed 		 
	);		




brief_0 : BRIEF
	generic map(WIDTH => WIDTH ,
		  HEIGHT => HEIGHT ,
		  WINDOW_SIZE => 8 ,
		  DESCRIPTOR_LENGTH => SIZE)
		port map(
			clk => clk,
			resetn => resetn ,
			pixel_clock => pixel_clock_delayed, hsync => hsync_delayed, vsync => vsync_delayed, 
			pixel_data_in => pixel_data_delayed ,
			pixel_clock_out => new_descriptor,
			descriptor => current_descriptor);
			
	process(clk, resetn)
	begin
		if resetn = '0' then
			latched_descriptor <= (others => '0') ;
		elsif clk'event and clk = '1' then
			if latch_feature_descriptor = '1' then
				latched_descriptor <= current_descriptor ;
			end if ;
		end if ;
	end process ;
	feature_descriptor <= latched_descriptor ;	


	-- correlation part

	score: HAMMING_DIST 
		generic map(WIDTH => SIZE, CYCLES => 4)
		port map(
			clk => clk,
			resetn => resetn ,
			en => new_descriptor,
			vec1 => current_descriptor, vec2 => feature_to_correl ,
			dv => hamming_done ,
			distance =>  current_score);
	
	
	
	count_pixels: pixel_counter
		generic map(MAX => WIDTH)
		port map(
			clk => clk,
			resetn=> resetn, 
			pixel_clock => new_descriptor, hsync => brief_hsync , 
			pixel_count => pixel_count);

	count_lines: line_counter 
		generic map(MAX => HEIGHT)
		port map(
			clk => clk,
			resetn => resetn, 
			hsync => brief_hsync, vsync => brief_vsync, 
			line_count => line_count);
	
	process(clk, resetn)
	begin
		if resetn = '0' then
			latched_score <= (others => '0') ;
		elsif clk'event and clk = '1' then
			if latch_score = '1' then
				latched_score <= current_score ;
			end if ;
		end if ;
	end process ;
	
	valid_windowx <=  '1' when pixel_count > correl_feature_posx0 and pixel_count < correl_feature_posx1 else
							'0' ;
	valid_windowy <=  '1' when line_count > correl_feature_posy0 and line_count < correl_feature_posy1 else
							'0' ;
	-- need to check windows is valid
	latch_score <= '1' when current_score > latched_score and valid_windowx = '1' and valid_windowy = '1' else
						'0' ;

end Behavioral;

