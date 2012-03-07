-- TestBench Template 

  LIBRARY ieee;
  USE ieee.std_logic_1164.ALL;
  USE ieee.std_logic_unsigned.ALL;
  USE ieee.numeric_std.ALL;
  
  LIBRARY WORK;
  USE WORK.CAMERA.ALL;

  ENTITY conv3x3_tb IS
  END conv3x3_tb;

  ARCHITECTURE behavior OF conv3x3_tb IS 



  -- Component Declaration
          component conv3x3 is
				generic(KERNEL : imat3 := ((1, 2, 1),(0, 0, 0),(-1, -2, -1));
						  NON_ZERO	: index_array := ((0, 0), (0, 1), (0, 2), (2, 0), (2, 1), (2, 2), (3, 3), (3, 3), (3, 3)  ) -- (3, 3) indicate end  of non zero values
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
			end component ;
			
			constant clk_period : time := 5 ns ;
			constant pclk_period : time := 40 ns ;
			
			signal clk, arazb : std_logic ;
			signal pxclk, hsync, vsync : std_logic ;
			signal pxclk_out, hsync_out, vsync_out : std_logic ;
			signal pixel : std_logic_vector(7 downto 0 ) := (others => '0');
			signal abs_val : unsigned(7 downto 0 );
			signal raw_val : signed(15 downto 0 ) ;	
         
  BEGIN

  -- Component Instantiation
         conv3x3_0 :  conv3x3 
				port map(
						clk => clk, 
						arazb => arazb, 
						pixel_clock => pxclk, 
						hsync => hsync, 
						vsync => vsync,
						pixel_clock_out => pxclk_out, 
						hsync_out => hsync_out, 
						vsync_out => vsync_out,
						pixel_data_in => pixel, 
						abs_res => abs_val,
						raw_res => raw_val

				);

	process
	begin
		arazb <= '0' ;
		wait for 10*clk_period;
		arazb <= '1' ;
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
		if px_count < 640 and line_count >= 20 and line_count < 497 then
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
