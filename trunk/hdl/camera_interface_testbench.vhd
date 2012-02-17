library IEEE;
        use IEEE.std_logic_1164.all;
        use IEEE.std_logic_unsigned.all;

library work ;
	use work.camera.all ;


entity camera_interface_testbench is
end camera_interface_testbench;

architecture test of camera_interface_testbench is
	constant clk_period : time := 1 ns ;
	constant pclk_period : time := 21 ns ;
	signal clk : std_logic ;
	signal pixel_from_camera : std_logic_vector(7 downto 0);
	signal pixel_from_interface : std_logic_vector(7 downto 0);
	signal pixel_from_ds : std_logic_vector(7 downto 0);
	signal pxclk_from_camera, href_from_camera, vsync_from_camera : std_logic ;
	signal pxclk_from_interface, href_from_interface, vsync_from_interface : std_logic ;
	signal pxclk_from_ds, href_from_ds, vsync_from_ds : std_logic ;
	begin
	camera0: camera_interface
		port map(clock => clk,
		pixel_data => pixel_from_camera, 
 		i2c_clk => clk,
 		arazb => '1',
 		pxclk => pxclk_from_camera, href => href_from_camera, vsync => vsync_from_camera,
 		new_pix => pxclk_from_interface, new_line => href_from_interface, new_frame => vsync_from_interface,
 		y_data => pixel_from_interface
		);
		
		down_scaler0: down_scaler
		port map(clk => clk,
		  arazb => '1',
		  pixel_clock => pxclk_from_interface, hsync => href_from_interface, vsync => vsync_from_interface,
		  pixel_clock_out => pxclk_from_ds, hsync_out => href_from_ds, vsync_out => vsync_from_ds,
		  pixel_data_in => pixel_from_interface,
		  pixel_data_out => pixel_from_ds 
		);
pixel_from_camera <= "10100101";


process
	begin
		clk <= '0';
		wait for clk_period;
		clk <= '1';
		wait for clk_period; 
	end process;
	
process
	variable px_count, line_count, byte_count : integer := 0 ;
	begin
		pxclk_from_camera <= '0';
		if px_count < 640 * 2 and line_count >= 20 and line_count < 497 then
			href_from_camera <= '1' ;
		else
				href_from_camera <= '0' ;
		end if ;

		if line_count < 3 then
			vsync_from_camera <= '1' ;
		 else 
			vsync_from_camera <= '0' ;
		end if ;
		wait for pclk_period;
		
		pxclk_from_camera <= '1';
		
		if byte_count < 2 then
		  byte_count := byte_count + 1 ;
		else
		  byte_count := 0;
		end if ;
		if (px_count = 784 * 2) then
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
	
end test ;
