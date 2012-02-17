library IEEE;
        use IEEE.std_logic_1164.all;
        use IEEE.std_logic_unsigned.all;
library work;
        use work.all ;

entity send_picture is
	port(
 		clk : in std_logic; 
 		arazb : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_data_in : in std_logic_vector(7 downto 0 ); 
 		data_out : out std_logic_vector(7 downto 0 ); 
 		send : out std_logic
	); 
end send_picture;

architecture systemc of send_picture is
	constant VSYNC_CHAR : integer := 0; 
	TYPE send_state IS (WAIT_PIXEL, WRITE_DATA, WAIT_SYNC) ; 
	signal state : send_state ; 
	signal isControlChar : std_logic ; 
	signal end_sig : std_logic ; 
	signal select_end : std_logic_vector(1 downto 0 ) ;
	begin
	
	
	-- send_picture_process
	process(clk, arazb)
		 begin
		 	if  NOT arazb = '1'  then
		 		state <= wait_pixel ;
		 	elsif  clk'event and clk = '1'  then
		 		case state is
		 			when wait_pixel => 
		 				send <= '0' ;
		 				if  pixel_clock = '1'  then
		 					select_end <= (others => '0') ; 
		 					state <= write_data ;
		 				elsif  vsync = '1'  then
		 					data_out <= VSYNC_CHAR ; 
		 					select_end <= "1" ; 
		 					state <= write_data ;
		 				elsif  hsync = '1'  then
		 					data_out <= HSYNC_CHAR ; 
		 					select_end <= "10" ; 
		 					state <= write_data ;
		 				end if ;
		 			when write_data => 
		 				send <= '1' ;
		 				state <= wait_sync ;
		 			when wait_sync => 
		 				send <= '0' ;
		 				if  end_sig = '1'  then
		 					state <= wait_pixel ;
		 				end if ;
		 			when others => 
		 				state <= wait_pixel ;
		 		end case ;
		 	end if ;
		 end process;  

	-- end_sig_mux
	process(pixel_clock, hsync, vsync, select_end)
		 begin
		 	if  conv_integer(select_end) = 1  then
		 		end_sig <= NOT vsync ;
		 	elsif  conv_integer(select_end) = 2  then

		 	end if ;
		 end process;  

	-- update_is_control_char
	process(pixel_data_in)
		 begin
		 end process;  
	
end systemc ;