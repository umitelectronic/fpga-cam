library IEEE;
        use IEEE.std_logic_1164.all;
        use IEEE.std_logic_unsigned.all;

library work ;
	use work.camera.all ;


entity camera_interface_testbench is
end camera_interface_testbench;

architecture test of camera_interface_testbench is
	constant clk_period : time := 5 ns ;
	constant pclk_period : time := 20 ns ;
	constant arazb_delay : integer := 1024 ;
	signal arazb_time : integer range 0 to 1024 := arazb_delay ;
	signal clk, arazb_delayed : std_logic ;
	signal pixel_from_camera : std_logic_vector(7 downto 0);
	signal pixel_from_interface : std_logic_vector(7 downto 0);
	signal pixel_from_conv : std_logic_vector(7 downto 0);
	signal pixel_from_ds : std_logic_vector(7 downto 0);
	signal data_to_send : std_logic_vector(7 downto 0);
	signal pxclk_from_camera, href_from_camera, vsync_from_camera : std_logic ;
	signal pxclk_from_interface, href_from_interface, vsync_from_interface : std_logic ;
	signal pxclk_from_conv, href_from_conv, vsync_from_conv : std_logic ;
	signal pxclk_from_ds, href_from_ds, vsync_from_ds : std_logic ;
	signal send_data, scl, sda : std_logic ;
	begin
	
	process(clk) -- reset process
	begin
		if clk'event and clk = '1' then
			if arazb_time = 0 then
				arazb_delayed <= '1' ;
			else
				arazb_delayed <= '0';
				arazb_time <= arazb_time - 1 ;
			end if;
		end if;
	end process;
	
	
	camera0: camera_interface
		port map(clock => clk,
		pixel_data => pixel_from_camera, 
 		i2c_clk => clk,
 		arazb => arazb_delayed,
 		pxclk => pxclk_from_camera, href => href_from_camera, vsync => vsync_from_camera,
 		pixel_clock_out => pxclk_from_interface, hsync_out => href_from_interface, vsync_out => vsync_from_interface,
 		y_data => pixel_from_interface, 
		scl => scl,
		sda => sda
		);
		
		sobel0: sobel3x3
		port map(
			clk => clk ,
			arazb => arazb_delayed ,
			pixel_clock => pxclk_from_interface, hsync => href_from_interface, vsync =>  vsync_from_interface,
			pixel_clock_out => pxclk_from_conv, hsync_out => href_from_conv, vsync_out => vsync_from_conv, 
			pixel_data_in => pixel_from_interface,  
			pixel_data_out => pixel_from_conv

		);
		
		down_scaler0: down_scaler
		port map(clk => clk,
		  arazb => arazb_delayed,
		  pixel_clock => pxclk_from_conv, hsync => href_from_conv, vsync => vsync_from_conv,
		  pixel_clock_out => pxclk_from_ds, hsync_out => href_from_ds, vsync_out => vsync_from_ds,
		  pixel_data_in => pixel_from_interface,
		  pixel_data_out => pixel_from_ds 
		);
pixel_from_camera <= "10100101";

send_pic0 : send_picture 
	port map(
 		clk => clk, 
 		arazb => arazb_delayed,
 		pixel_clock => pxclk_from_ds, hsync => href_from_ds, vsync => vsync_from_ds, 
 		pixel_data_in => pixel_from_ds,
 		data_out => data_to_send, 
 		send => send_data, 
		output_ready => '1'
	); 


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
