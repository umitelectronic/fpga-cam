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
		  DESC_SIZE : natural := 64;
		  NB_LMK : natural := 1;
		  DELAY : natural := 4 );
port(
 		clk : in std_logic; 
 		resetn : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_clock_out, hsync_out, vsync_out : out std_logic; 
 		pixel_data_in : in std_logic_vector(7 downto 0 );
-- active search interface
-- each lmk to track should be registered as
--------16bit----------
--------desc_msb-------
---------n*desc--------
--------desc_lsb-------
----------xpos---------
----------ypos---------
---xsize---||---ysize--
----------xcorr--------
----------ycorr--------
--corr_score---||status
	   as_mem_addr : out std_logic_vector(7 downto 0);
		as_mem_data_in : in std_logic_vector(15 downto 0 );
		as_mem_data_out : in std_logic_vector(15 downto 0 );
		as_mem_wr : out std_logic ;

-- feature extractor interface
		feature_descriptor : out std_logic_vector(( DESC_SIZE - 1) downto 0 );
		new_descriptor : out std_logic 	-- latch command 	

);
end BRIEF_MANAGER;

architecture Behavioral of BRIEF_MANAGER is


	type loading_states is (WAIT_HSYNC, LOAD_DESC, LOAD_X, LOAD_Y, LOAD_SIZE, WRITE_X, WRITE_Y, WRITE_SCORE);

	signal curr_load_state, next_load_state : loading_states ;

	type lmk_desc_array is array(0 to (NB_LMK - 1)) of std_logic_vector((DESC_SIZE - 1) downto 0);
	type lmk_pos_array is array(0 to (NB_LMK - 1)) of std_logic_vector(15 downto 0);
	type corr_score_array is array(0 to (NB_LMK - 1)) of std_logic_vector((nbit(DESC_SIZE)-1) downto 0);

	signal array_of_desc : lmk_desc_array ;
	signal array_of_posx0 : lmk_pos_array ;
	signal array_of_posx1 : lmk_pos_array ;
	signal array_of_posy0 : lmk_pos_array ;
	signal array_of_posy1 : lmk_pos_array ;
	
	signal array_of_score : corr_score_array ;
	signal array_of_corrx : lmk_pos_array ;
	signal array_of_corry : lmk_pos_array ;
	
	signal array_of_correl_done : std_logic_vector(0 to (NB_LMK-1));
	signal array_of_correl_busy : std_logic_vector(0 to (NB_LMK-1));
	
	signal pixel_clock_delayed, hsync_delayed, vsync_delayed :  std_logic; 
 	signal pixel_data_delayed :  std_logic_vector(7 downto 0 );
	
	signal vsync_falling_edge, vsync_rising_edge, vsync_old : std_logic ;
	signal hsync_falling_edge, hsync_rising_edge, hsync_old : std_logic ;

	signal line_count : std_logic_vector((nbit(HEIGHT) - 1) downto 0 ) ;
	signal pixel_count : std_logic_vector((nbit(WIDTH) - 1) downto 0 ) ;
	signal frame_count : std_logic_vector(1 downto 0);

begin


-- delaying inputs to be in sync with other blocks
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
		  DESCRIPTOR_LENGTH => DESC_SIZE)
		port map(
			clk => clk,
			resetn => resetn ,
			pixel_clock => pixel_clock_delayed, hsync => hsync_delayed, vsync => vsync_delayed, 
			pixel_data_in => pixel_data_delayed ,
			pixel_clock_out => new_descriptor,
			descriptor => feature_descriptor);
	
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
		vsync_old <= '0' ;
		hsync_old <= '0' ;
	elsif clk'event and clk = '1' then
		vsync_old <= vsync_delayed ;
		hsync_old <= hsync_delayed ;
	end if ;
end process ;	
vsync_falling_edge <= (NOT vsync_delayed) and vsync_old ;
vsync_rising_edge <= vsync_delayed and (NOT vsync_old) ;
hsync_falling_edge <= (NOT hsync_delayed) and hsync_old ;
hsync_rising_edge <= hsync_delayed and (NOT hsync_old) ;

			
gen_corr : for i in 0 to NB_LMK generate
	bief_as_i :  BRIEF_AS
		generic map(WIDTH => WIDTH,
					  HEIGHT => HEIGHT,
					  DESCRIPTOR_SIZE => DESCRIPTOR_LENGTH)
		port map(
			clk => clk, 
			resetn => resetn, 
			line_count => line_count,
			pixel_count => pixel_count,
			curr_descriptor => current_descriptor, 
			descriptor_correl => array_of_desc(i),
			correl_winx0 => array_of_posx0(i),
			correl_winx1 => array_of_posx1(i),
			correl_winy0 => array_of_posy0(i),
			correl_winy1 => array_of_posy1(i),
			
			correl_x	=> array_of_corrx(i),
			correl_y	=> array_of_corry(i),
			correl_score => array_of_score(i),
			correl_done => array_of_correl_done(i),
			correl_busy => array_of_correl_busy(i)
			);
end generate ;




-- need to write two state machines, one to return results and one to gather lmk to track


frame_counter : simple_counter
	 generic map(NBIT => 2) 
    Port map( clk => clk,
           resetn => resetn,
           sraz=> '0',
           en => vsync_falling_edge,
			  load => '0',
			  E => (others => '0'),
           Q => frame_count
			  );


lmk_counter : simple_counter
	 generic map(NBIT => 4) 
    Port map( clk => clk,
           resetn => resetn,
           sraz=> sraz_lmk_count,
           en => en_lmk_count,
			  load => '0',
			  E => (others => '0'),
           Q => lmk_count
			  );
			  
cycle_counter : simple_counter
	 generic map(NBIT => 8) 
    Port map( clk => clk,
           resetn => resetn,
           sraz=> sraz_cycle_count,
           en => en_cycle_count,
			  load => '0',
			  E => (others => '0'),
           Q => cycle_count
			  );
			  
addr_counter : simple_counter
	 generic map(NBIT => 8) 
    Port map( clk => clk,
           resetn => resetn,
           sraz=> sraz_addr_count,
           en => en_addr_count,
			  load => '0',
			  E => (others => '0'),
           Q => as_mem_addr
			  );

process (clk,resetn)
begin
	if (reset='0') then
	  curr_load_state <= WAIT_HSYNC;  --default state on reset.
	elsif clk'event and clk = '1' then
	  curr_load_state <= next_load_state;   --state change.
	end if;
end process;

--state machine process.
process (curr_load_state,vsync_falling_edge, cycle_counter, lmk_count)
begin
  next_load_state <= curr_load_state ;
  case curr_load_state is
	when WAIT_HSYNC => 
		if vsync_falling_edge = '1' then
			next_load_state <= LOAD_DESC ;
		end if;
	when LOAD_DESC => 
		if cycle_counter = DESC_SIZE/16 then
			next_load_state <= LOAD_X ;
		end if;
	when LOAD_X => 
			next_load_state <= LOAD_Y ;
	when LOAD_Y => 
			next_load_state <= WRITE_X ;
	when WRITE_X =>
			next_load_state <= WRITE_Y ;
	when WRITE_Y =>
			next_load_state <= WRITE_SCORE ;
	when WRITE_SCORE =>
			if lmk_count = NB_LMK then
				next_load_state <= WAIT_HSYNC ;
			else
				next_load_state <= LOAD_DESC ;
			end if;
			
  end case;
end process;


with curr_load_state select
	sraz_lmk_count <= '1' when WAIT_HSYNC ,
							'0' when others ;
with curr_load_state select
	sraz_cycle_count <= '0' when LOAD_DESC ,
							'1' when others ;
with curr_load_state select
	en_cycle_count <= '0' when WAIT_HSYNC ,
							'1' when others ;
with curr_load_state select
	en_lmk_count <= '1' when WRITE_SCORE ,
						 '0' when others ;

with curr_load_state select
	sraz_addr_count <= '1' when WAIT_HSYNC ,
							'0' when others ;
en_addr_count <= '1' ;
		
with curr_load_state select
			as_mem_wr <=  '1' when WRITE_SCORE ,
							  array_of_correl_done(to_integer(lmk_count)) when WRITE_X ,
							  array_of_correl_done(to_integer(lmk_count)) when WRITE_Y ,
							  '0' when others ;
with curr_load_state select -- writing the frame count allow software to discriminate when was matched the feature
			as_data_in <=  frame_count & array_of_score(to_integer(lmk_count))& array_of_correl_done(to_integer(lmk_count)) when WRITE_SCORE ,
							   array_of_corrx(to_integer(lmk_count)) when WRITE_X ,
							   array_of_corry(to_integer(lmk_count)) when WRITE_Y ,
							   (others => '0') when others ;

-- loading data into registers
process(clk, resetn)
begin
if resetn = '0' then
elsif clk'event and clk = '1' then
	if array_of_correl_busy(to_integer(lmk_count)) = '0' then -- not loading if correl is ongoing
		if curr_state = LOAD_DESC  then
			array_of_desc(to_integer(lmk_count))(DESC_SIZE-1 downto 8) <= array_of_desc(to_integer(lmk_count))(DESC_SIZE-9 downto 0);
			array_of_desc(to_integer(lmk_count))(15 downto 0) <= as_mem_data_in;
		end if;
		if curr_state = LOAD_X then
			array_of_posx0(to_integer(lmk_count)) <= as_mem_data_in ;
		end if;
		if curr_state = LOAD_Y then
			array_of_posy0(to_integer(lmk_count)) <= as_mem_data_in ;
		end if;
		if curr_state = LOAD_SIZE then
			array_of_posx1(to_integer(lmk_count)) <= array_of_posx0(to_integer(lmk_count)) + as_mem_data_in(7 downto 0) ;
			array_of_posy1(to_integer(lmk_count)) <= array_of_posy0(to_integer(lmk_count)) + as_mem_data_in(15 downto 8) ;
		end if;
	end if ;
end if ;
end process ;


end Behavioral;

