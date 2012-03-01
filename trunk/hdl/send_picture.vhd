library IEEE;
        use IEEE.std_logic_1164.all;
        use IEEE.std_logic_unsigned.all;
library work;
        use work.camera.all ;

entity send_picture is
	port(
 		clk : in std_logic; 
 		arazb : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_data_in : in std_logic_vector(7 downto 0 ); 
 		data_out : out std_logic_vector(7 downto 0 ); 
		output_ready : in std_logic;
 		send : out std_logic
	); 
end send_picture;

architecture systemc of send_picture is
	constant VSYNC_CHAR : std_logic_vector(7 downto 0) := "01010101"; 
	constant HSYNC_CHAR : std_logic_vector(7 downto 0) := "10101001";
	TYPE send_state IS (WAIT_PIXEL, WRITE_DATA, WAIT_SYNC) ; 
	signal state : send_state ; 
	signal isControlChar : std_logic ; 
	signal end_sig : std_logic ; 
	signal select_end : std_logic_vector(1 downto 0 ) ;
	signal fifo_empty, fifo_full, fifo_rd, fifo_wr : std_logic ;
	signal fifo_data_in : std_logic_vector(7 downto 0);
	begin
	fifo_64x8_0 : fifo_64x8
		port map(
 		clk => clk, 
		arazb => arazb, 
 		wr => fifo_wr , 
		rd => fifo_rd, 
		empty => fifo_empty , full => fifo_full, data_rdy => send,
 		data_out => data_out,  
 		data_in => fifo_data_in
	); 
	
	-- send_picture_process
	process(clk, arazb)
		 begin
		 	if  NOT arazb = '1'  then
		 		state <= wait_pixel ;
		 	elsif  clk'event and clk = '1'  then
		 		case state is
		 			when wait_pixel => 
		 				if  pixel_clock = '1'  then
		 					select_end <= (others => '0') ; 
							fifo_data_in <= pixel_data_in(7 downto 1) & (pixel_data_in(0) AND (NOT isControlChar));
		 					state <= write_data ;
		 				elsif  vsync = '1'  then
		 					fifo_data_in <= VSYNC_CHAR ; 
		 					select_end <= "01" ; 
		 					state <= write_data ;
		 				elsif  hsync = '1'  then
		 					fifo_data_in <= HSYNC_CHAR ; 
		 					select_end <= "10" ; 
		 					state <= write_data ;
		 				end if ;
		 			when write_data => 
		 				state <= wait_sync ;
		 			when wait_sync => 
		 				if  end_sig = '1'  then
		 					state <= wait_pixel ;
		 				end if ;
		 			when others => 
		 				state <= wait_pixel ;
		 		end case ;
				end if ;
		 end process;  

	process(clk)
	begin 
	if clk'event and clk = '0' then
		  case state is
				when write_data => 
					fifo_wr <= '1' ;
				when others => 
					fifo_wr <= '0' ;
			end case;
	end if ;
	end process ;

	-- end_sig_mux
	process(pixel_clock, hsync, vsync, select_end)
		 begin
		 	if  conv_integer(select_end) = 1  then
		 		end_sig <= NOT vsync ;
		 	elsif  conv_integer(select_end) = 2  then
				end_sig <= vsync OR (NOT hsync);
			elsif conv_integer(select_end) = 0 then
				end_sig <= NOT pixel_clock ; 
			else 
				end_sig <= NOT pixel_clock ;
		 	end if ;
		 end process;  

isControlChar <= '1' when (pixel_data_in = "01010101") else -- equals VSYNC
					  '1' when (pixel_data_in = "10101001") else -- equals HSYNC
					  '0';
	
fifo_rd <= '1' when output_ready = '1' and fifo_empty = '0' else
			  '0' ;
end systemc ;