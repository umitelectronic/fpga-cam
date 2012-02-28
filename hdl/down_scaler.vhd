library IEEE;
        use IEEE.std_logic_1164.all;
        use IEEE.std_logic_unsigned.all;
library work;
        use work.camera.all ;

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
 
	TYPE scaler_state IS (WAIT_LINE, WAIT_PIXEL, WRITE_PIXEL) ; 
	signal line_ram_addr : std_logic_vector(6 downto 0 ) ; 
	signal line_ram_data_in, line_ram_data_out : std_logic_vector(15 downto 0 ) ; 
	signal line_ram_en, line_ram_we : std_logic ; 
	signal add_result : std_logic_vector(15 downto 0 ) ; 
	signal add_temp : std_logic_vector(15 downto 0 ) ; 
	signal nb_line_accumulated : std_logic_vector(3 downto 0 ) ; 
	signal nb_pix_accumulated : std_logic_vector(3 downto 0 ) ; 
	signal state : scaler_state ;
	begin
	
	line_ram0 : line_ram
		port map ( 
			clk => clk, 
			addr => line_ram_addr, 
			data_in => line_ram_data_in, 
			data_out => line_ram_data_out, 
			en => line_ram_en,
			we => line_ram_we
		); 
	
	-- update_output
	process(line_ram_data_out, add_result, pixel_data_in)
		 begin
		 	pixel_data_out <= line_ram_data_out(10 downto 3) ;
		 	add_temp <= (add_result + ("00000000" & pixel_data_in)) ;
		 end process;  

	-- down_scaler_process
	process(clk, arazb)
		 begin
		 	if arazb = '0'  then
		 		nb_line_accumulated <= (others => '0') ; 
		 		nb_pix_accumulated <= (others => '0') ; 
		 		add_result <= (others => '0') ; 
		 		state <= wait_line ;
		 	else
		 		if  clk'event and clk = '1'  then
		 			vsync_out <= vsync ; 
		 			case state is
		 				when wait_line => 
		 					pixel_clock_out <= '0' ;
		 					line_ram_en <= '0' ;
		 					line_ram_we <= '0' ;
		 					if  vsync = '1'  then
		 					  nb_line_accumulated <= (others => '0') ;
		 					  nb_pix_accumulated <= (others => '0') ;
		 					  line_ram_addr <= (others => '0') ;
		 					  hsync_out <= '1' ;
		 					  add_result <= (others => '0') ; 
		 					elsif hsync = '0'  then
		 						state <= wait_pixel ;
		 					end if ;
		 				when wait_pixel => 
		 					line_ram_en <= '0' ;
		 					line_ram_we <= '0' ;
		 					if  hsync = '1'  then
		 						line_ram_addr <= (others => '0') ; 
		 						nb_pix_accumulated <= (others => '0') ; 
		 						if  nb_line_accumulated = 7  then
		 							nb_line_accumulated <= (others => '0') ; 
		 							add_result <= (others => '0') ; 
		 							hsync_out <= '1' ;
		 						else
		 							hsync_out <= '0' ; 
		 							nb_line_accumulated <= (nb_line_accumulated + 1) ;
		 						end if ; 
		 						line_ram_we <= '0' ; 
		 						state <= wait_line ;
		 					elsif  pixel_clock = '1'  then
		 						pixel_clock_out <= '0' ; 
		 						hsync_out <= '0' ; 
		 						if  nb_pix_accumulated = 0  then
		 							add_result <= "00000000" & pixel_data_in ;
		 						elsif  nb_pix_accumulated = 7  then
		 							if  nb_line_accumulated = 0  then
		 								line_ram_data_in <= "00000000" & add_temp(10 downto 3) ;
		 							else
		 								line_ram_data_in <= (("00000000" & add_temp(10 downto 3)) + line_ram_data_out) ;
		 							end if ; 
		 							line_ram_we <= '1' ; 
		 							line_ram_en <= '1' ;
		 						else
		 							add_result <= add_temp ;
		 						end if ; 
		 						state <= write_pixel ;
		 					end if ;
		 				when write_pixel => 
		 					line_ram_we <= '0' ;
		 					line_ram_en <= '0' ;
		 					if  NOT pixel_clock = '1'  then
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
		 	end if ;
		 end process;  
	
end systemc ;