library IEEE;
        use IEEE.std_logic_1164.all;
        use IEEE.std_logic_unsigned.all;
library work;
        use work.camera.all ;

entity yuv_camera_interface is
	port(
 		clock : in std_logic; 
 		i2c_clk : in std_logic; 
 		arazb : in std_logic; 
 		pixel_data : in std_logic_vector(7 downto 0 ); 
 		y_data : out std_logic_vector(7 downto 0 ); 
 		u_data : out std_logic_vector(7 downto 0 ); 
 		v_data : out std_logic_vector(7 downto 0 ); 
 		scl : inout std_logic; 
 		sda : inout std_logic; 
 		pixel_clock_out, hsync_out, vsync_out : out std_logic; 
 		pxclk, href, vsync : in std_logic
	); 
end yuv_camera_interface;

architecture systemc of yuv_camera_interface is
	constant NB_REGS : integer := 255; 
	constant OV7670_I2C_ADDR : std_logic_vector(6 downto 0) := "0100001"; 
	TYPE pixel_state IS (Y1, U1, Y2, V1) ; 
	TYPE registers_state IS (INIT, SEND_ADDR, WAIT_ACK0, SEND_DATA, WAIT_ACK1, NEXT_REG, STOP) ; 
	signal i2c_data : std_logic_vector(7 downto 0 ) ; 
	signal reg_data : std_logic_vector(15 downto 0 ) ; 
	signal i2c_addr : std_logic_vector(6 downto 0 ) ; 
	signal send : std_logic ; 
	signal rcv : std_logic ; 
	signal dispo : std_logic ; 
	signal ack_byte, nack_byte : std_logic ; 
	signal pix_state : pixel_state ; 
	signal next_state : pixel_state ; 
	signal reg_state : registers_state ; 
	signal reg_addr : std_logic_vector(7 downto 0 ) ;
	begin
	
	register_rom0 : yuv_register_rom --rom containg sensor configuration
		port map (
		   clk => clock,
			en => '1',
			addr => reg_addr, 
			data => reg_data
		); 
	i2c_master0 : i2c_master -- i2c master to send sensor configuration, no proof its working
		port map ( 
			clock => i2c_clk, 
			arazb => arazb, 
			sda => sda, 
			scl => scl, 
			data_in => i2c_data, 
			slave_addr => i2c_addr, 
			send => send, 
			rcv => rcv, 
			dispo => dispo, 
			ack_byte => ack_byte,
			nack_byte => nack_byte
		); 
	
	-- sccb_interface
	process(clock, arazb)
		 begin
		 	i2c_addr <= OV7670_I2C_ADDR ; -- sensor address
		 	if  arazb = '0'  then
		 		reg_state <= init ;
				reg_addr <= (others => '0');
		 	elsif clock'event and clock = '1' then
		 		case reg_state is
		 			when init => 
		 				if  dispo = '1'  then 
		 					send <= '1' ; 
		 					i2c_data <= reg_data(15 downto 8) ; 
		 					reg_state <= send_addr ;
		 				end if ;
		 			when send_addr => --send register address
		 				if  ack_byte = '1'  then
		 					send <= '1' ; 
		 					i2c_data <= reg_data(7 downto 0) ; 
		 					reg_state <= wait_ack0 ;
						elsif nack_byte = '1' then
							send <= '0' ; 
							reg_state <= next_reg ;
		 				end if ;
		 			when wait_ack0 => -- falling edge of ack 
		 			  if  ack_byte = '0'  then
		 					reg_state <= send_data ;
		 				end if ;
		 			when send_data => --send register value
		 				if  ack_byte = '1'  then
		 					send <= '0' ; 
		 					reg_state <= wait_ack1 ; 
		 					reg_addr <= (reg_addr + 1) ;
						elsif nack_byte = '1' then
							send <= '0' ; 
							reg_state <= next_reg ;
		 				end if ;
		 			when wait_ack1 => -- wait for ack
		 			  if  ack_byte = '0'  then
		 					reg_state <= next_reg ;
		 				end if ;
		 			when next_reg => -- switching to next register
		 				send <= '0' ;
		 				if ( NOT ack_byte = '1' ) AND  reg_data /= X"FFFF"  AND  dispo = '1'  AND  conv_integer(reg_addr) < 255  then
		 					reg_state <= send_addr ; 
		 					i2c_data <= reg_data(15 downto 8) ; 
		 					send <= '1' ;
		 				elsif  conv_integer(reg_addr) >= 255  OR  reg_data = X"FFFF"  then
		 					reg_state <= stop ;
		 				end if ;
		 			when stop => -- all register were set, were done !
		 				send <= '0' ;
		 				reg_state <= stop ;
		 			when others => 
		 				reg_state <= init ;
		 		end case ;
		 	end if ;
		 end process;  

	-- pixel_interface
	process(clock, arazb)
		 begin
		 	if arazb = '0'  then
		 		pix_state <= Y1 ;
		 	elsif  clock'event and clock = '1'  then
				hsync_out <= NOT href ; -- changing href into hsync
				vsync_out <= vsync ;
		 		if  href = '1'  AND  NOT vsync = '1'  then
		 			if pxclk = '1' then 
						case pix_state is
							when Y1 => 
								y_data <= pixel_data ;
								pixel_clock_out <= '0' ;
								next_state <= U1 ;
							when U1 => 
								u_data <= pixel_data ;
								pixel_clock_out <= '1' ;
								next_state <= Y2 ;
							when Y2 => 
								y_data <= pixel_data ;
								pixel_clock_out <= '0' ;
								next_state <= V1 ;
							when V1 => 
								v_data <= pixel_data ;
								pixel_clock_out <= '1' ;
								next_state <= Y1 ;
							when others => 
								next_state <= Y1 ;
						end case ;
					else
						pix_state <= next_state ; -- state evolution
					end if ;
				elsif href = '0'  OR  vsync = '1' then
						pixel_clock_out <= '0' ;
						pix_state <= Y1 ;
		 		else
						pixel_clock_out <= '0' ;
						pix_state <= Y1 ;
		 		end if ;
		 	end if ;
		 end process;  
	
end systemc ;