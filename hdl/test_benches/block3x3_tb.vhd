-- TestBench Template 

  LIBRARY ieee;
  USE ieee.std_logic_1164.ALL;
  USE ieee.numeric_std.ALL;
  USE ieee.std_logic_unsigned.ALL;
  
  LIBRARY work ;
  use work.camera.all ;

  ENTITY testbench IS
  END testbench;

  ARCHITECTURE behavior OF testbench IS 

  -- Component Declaration
			component block3X3_pixel_pipeline is
				generic(WIDTH: natural := 640;
				HEIGHT: natural := 480);
				port(
					resetn : in std_logic; 
					pixel_clock, hsync, vsync : in std_logic;
					pixel_clock_out, hsync_out, vsync_out : out std_logic;
					pixel_data_in : in std_logic_vector(7 downto 0 ); 
					block_out : out mat3);
			end component;

         constant clk_period : time := 5 ns ;
			constant pclk_period : time := 40 ns ;
			
			signal clk, resetn : std_logic ;
			signal pxclk, hsync, vsync : std_logic ;
			signal pxclk_out, hsync_out, vsync_out : std_logic ;
			signal new_block : std_logic ;
			signal block_out :  mat3 ;
			signal pixel : std_logic_vector(7 downto 0 ) := (others => '0');

  BEGIN

    -- Component Instantiation
--         block3X3v3_0 :  block3X3_pixel_pipeline 
--				port map(
--						resetn => resetn, 
--						pixel_clock => pxclk, 
--						hsync => hsync, 
--						vsync => vsync,
--						pixel_data_in => pixel, 
--						pixel_clock_out => pxclk_out, 
--						hsync_out => hsync_out, 
--						vsync_out => vsync_out,
--						block_out => block_out
--				);
				
			  block3X3v3_0 :  block3X3v2
				port map(
						clk => clk ,
						resetn => resetn, 
						pixel_clock => pxclk, 
						hsync => hsync, 
						vsync => vsync,
						pixel_data_in => pixel, 
						new_block => new_block ,
						block_out => block_out
				);
				
				

	process
	begin
		resetn <= '0' ;
		wait for 10*clk_period;
		resetn <= '1' ;
		while true loop
			clk <= '0';
			wait for clk_period;
			clk <= '1';
			wait for clk_period; 
		end loop ;
	end process;
	
process
	variable px_count, line_count, byte_count : integer := 0 ;
	begin
		pxclk <= '0';
		if px_count < 639 and line_count >= 20 and line_count < 497 then
			hsync <= '0' ;
			pixel <= pixel + 1;
		else
				hsync <= '1' ;
		end if ;

		if line_count < 3 then
			vsync <= '1' ;
		 else 
			vsync <= '0' ;
		end if ;
		wait for pclk_period;
		
		pxclk <= '1';
		if (px_count = 784 ) then
			px_count := 0 ;
			if (line_count > 510) then
			   line_count := 0;
		  else
		    line_count := line_count + 1 ;
		  end if ;
		else
		  px_count := px_count + 1 ;
		end if ;
		
		wait for pclk_period;

	end process;
  

  END;
