library IEEE;
        use IEEE.std_logic_1164.all;
        use IEEE.std_logic_unsigned.all;
library work;
        use work.camera.all ;
--down scale with factor 8 incoming frame
entity down_scaler is
	port(
 		clk : in std_logic; 
 		arazb : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_clock_out, hsync_out, vsync_out : out std_logic; 
 		pixel_data_in : in std_logic_vector(7 downto 0 ); 
 		pixel_data_out : out std_logic_vector(7 downto 0 )
	); 
end down_scaler;

architecture systemc of down_scaler is
 
	TYPE scaler_state IS (WAIT_FRAME, WAIT_LINE, WAIT_PIXEL, WRITE_PIXEL) ; 
	signal line_ram_addr : std_logic_vector(6 downto 0 ) ; 
	signal line_ram_data_in, line_ram_data_out : std_logic_vector(15 downto 0 ) ; 
	signal line_ram_en, line_ram_we : std_logic ; 
	signal add_result : std_logic_vector(15 downto 0 ) ; 
	signal add_temp : std_logic_vector(15 downto 0 ); 
	signal nb_line_accumulated : std_logic_vector(2 downto 0 ) ; 
	signal nb_pix_accumulated : std_logic_vector(2 downto 0 ) ; 
	signal nb_line_output : std_logic_vector(5 downto 0 ) ;
	signal state : scaler_state ;
	begin
	
	line_ram0 : line_ram --line ram to accumulate data
		port map ( 
			clk => clk, 
			addr => line_ram_addr, 
			data_in => line_ram_data_in,
			data_out => line_ram_data_out, 
			en => line_ram_en,
			we => line_ram_we
		); 
	
	pixel_data_out <= line_ram_data_out(10 downto 3) ; --output data is shifted by 3 for division by 8
	add_temp <= (add_result + ("00000000" & pixel_data_in)) ; -- pixel are accumulated into a register

	-- down_scaler_process
	process(clk, arazb)
		 begin
		 	if arazb = '0'  then
		 		nb_line_accumulated <= (others => '0') ; 
		 		nb_pix_accumulated <= (others => '0') ; 
				nb_line_output <= (others => '0') ; 
		 		add_result <= (others => '0') ; 
		 		state <= wait_frame ;
		 	elsif  clk'event and clk = '1'  then
		 			case state is
						when wait_frame => -- waiting for a new frame
							pixel_clock_out <= '0' ;
		 					line_ram_en <= '0' ;
		 					line_ram_we <= '0' ;
							vsync_out <= '1' ;
							if  vsync = '1' and hsync = '1' then
								nb_line_accumulated <= (others => '0') ;
		 					   nb_pix_accumulated <= (others => '0') ;
								nb_line_output <= (others => '0') ; 
		 					   line_ram_addr <= (others => '0') ;
		 					   hsync_out <= '1' ;
		 					   add_result <= (others => '0') ;
								state <= wait_pixel ;
							end if;
		 				when wait_line => --waiting for the next line
							vsync_out <= '0' ;
		 					pixel_clock_out <= '0' ;
		 					line_ram_en <= '0' ;
		 					line_ram_we <= '0' ;
		 					if hsync = '1'  then
								line_ram_addr <= (others => '0') ; 
		 						nb_pix_accumulated <= (others => '0') ; 
		 						if  nb_line_accumulated = 7  then -- 8 lines were accumulated
		 							nb_line_accumulated <= (others => '0') ; 
		 							add_result <= (others => '0') ; 
									nb_line_output <= (nb_line_output + 1) ;
									hsync_out <= '1' ;
								else
		 							hsync_out <= '0' ; 
									nb_line_accumulated <= nb_line_accumulated + 1 ;
		 						end if ; 
		 						line_ram_we <= '0' ; 
								state <= wait_pixel ;
		 					end if ;
		 				when wait_pixel => 
							vsync_out <= '0' ;
		 					line_ram_en <= '0' ;
		 					line_ram_we <= '0' ;
							if nb_line_output = 60 then --all line were output
								state <= wait_frame ;
							elsif line_ram_addr = 80 then --all pixels were averaged
								state <= wait_line ;
		 					elsif  pixel_clock = '1'  then
		 						pixel_clock_out <= '0' ;  
		 						if  nb_pix_accumulated = 0  then
		 							add_result <= "00000000" & pixel_data_in ; --first pixel of block
		 						elsif  nb_pix_accumulated = 7  then -- 8 pixels were summed
		 							if  nb_line_accumulated = 0  then -- first line
		 								line_ram_data_in <= "00000000" & add_temp(10 downto 3) ; --writing pixels average to ram
		 							else
		 								line_ram_data_in <= (("00000000" & add_temp(10 downto 3)) + line_ram_data_out) ; --ading pixels average to previously averaged pixels
		 							end if ; 
		 							line_ram_we <= '1' ; 
		 							line_ram_en <= '1' ;
		 						else
		 							add_result <= add_temp ;
		 						end if ; 
		 						state <= write_pixel ;
		 					end if ;
		 				when write_pixel => 
							vsync_out <= '0' ;
							hsync_out <= '0' ; 
		 					line_ram_we <= '0' ;
		 					line_ram_en <= '0' ;
		 					if pixel_clock = '0'  then -- waiting for falling edge of pxclk
		 						if  nb_line_accumulated = 7  AND  nb_pix_accumulated = 7  then
		 							pixel_clock_out <= '1' ;
		 						else
		 							pixel_clock_out <= '0' ;
		 						end if ; 
		 						if  nb_pix_accumulated = 7  then
		 							line_ram_addr <= line_ram_addr + 1 ; 
		 							nb_pix_accumulated <= (others => '0') ;
		 						else
		 							if  nb_pix_accumulated /= 0  then
		 								line_ram_en <= '1' ;
		 							end if ; 
		 							nb_pix_accumulated <= (nb_pix_accumulated + 1) ;
		 						end if ; 
		 						state <= wait_pixel ;
		 					end if ;
		 				when others => 

		 			end case ;
		 	end if ;
		 end process;  
	
end systemc ;