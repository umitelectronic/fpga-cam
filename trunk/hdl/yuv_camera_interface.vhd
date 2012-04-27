library IEEE;
        use IEEE.std_logic_1164.all;
        use IEEE.std_logic_unsigned.all;
		  
library work;
        use work.camera.all ;
		  use work.generic_components.all ;

entity yuv_camera_interface is
generic(FORMAT : FRAME_FORMAT := QVGA);
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
	TYPE pixel_state IS (WAIT_PIXEL, Y1, U1, Y2, V1) ; 
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
	signal pxclk_old, pxclk_rising_edge, nclk : std_logic ;
	signal en_ylatch, en_ulatch, en_vlatch : std_logic ;
	signal hsynct, vsynct  : std_logic ;
	for register_rom_vga : yuv_register_rom use entity yuv_register_rom(vga) ;
	for register_rom_qvga : yuv_register_rom use entity yuv_register_rom(qvga) ;
	
	begin
	
gen_vga : if FORMAT = VGA generate
	register_rom_vga : yuv_register_rom --rom containg sensor configuration
		port map (
		   clk => clock,
			en => '1',
			addr => reg_addr, 
			data => reg_data
		); 
	 end generate ;
	 
gen_qvga : if FORMAT = QVGA generate
	register_rom_qvga : yuv_register_rom --rom containg sensor configuration
		port map (
		   clk => clock,
			en => '1',
			addr => reg_addr, 
			data => reg_data
		); 
	 end generate ;
	
nclk <= not clock ;	
y_latch : generic_latch 
	 generic map( NBIT => 8)
    port map( clk =>nclk,
           arazb => arazb ,
           sraz => '0' ,
           en => en_ylatch ,
           d => pixel_data , 
           q => y_data);
			  
u_latch : generic_latch 
	 generic map( NBIT => 8)
    port map( clk => nclk,
           arazb => arazb ,
           sraz => '0' ,
           en => en_ulatch ,
           d => pixel_data , 
           q => u_data);

v_latch : generic_latch 
	 generic map( NBIT => 8)
    port map( clk => nclk,
           arazb => arazb ,
           sraz => '0' ,
           en => en_vlatch ,
           d => pixel_data , 
           q => v_data);

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




	process(clock, arazb)
		 begin
			if arazb = '0' then
				hsynct <= '0' ;
				vsynct <= '0' ;
		 	elsif  clock'event and clock = '1'  then
				hsynct <= NOT href ; -- changing href into hsync
				vsynct <= vsync ;
			end if ;
	end process ;
	
	process(clock, arazb)
		 begin
			if arazb = '0' then
				pxclk_rising_edge <= '0' ;
				pxclk_old <= '0' ;
		 	elsif  clock'event and clock = '1' then
				pxclk_old <= pxclk ;
				if pxclk /= pxclk_old and pxclk = '1' and hsynct = '0' and vsynct = '0' then
					pxclk_rising_edge <= '1' ;
				else
					pxclk_rising_edge <= '0' ;
				end if ;
			end if ;
	end process ;
	
	process(clock, arazb)
		begin
		if arazb = '0'  then
		 		pix_state <= WAIT_PIXEL ;
		elsif clock'event and clock = '1'  then
				pix_state <= next_state ;
		end if ;
	end process ;


	process(hsynct, vsynct, pix_state, pxclk_rising_edge)
		begin
			next_state <= pix_state ;
			case pix_state is
				when WAIT_PIXEL =>
					if hsynct = '1' or vsynct = '1' then
						next_state <= WAIT_PIXEL ;
					elsif pxclk_rising_edge = '1' then
						next_state <= Y1 ;
					end if ;
				when Y1 => 
					if hsynct = '1' or vsynct = '1' then
						next_state <= WAIT_PIXEL ;
					elsif pxclk_rising_edge = '1' then
						next_state <= U1 ;
					end if ;
				when U1 => 
					if hsynct = '1' or vsynct = '1' then
						next_state <= WAIT_PIXEL ;
					elsif pxclk_rising_edge = '1' then
						next_state <= Y2 ;
					end if ;
				when Y2 => 
					if hsynct = '1' or vsynct = '1' then
						next_state <= WAIT_PIXEL ;
					elsif pxclk_rising_edge = '1' then
						next_state <= V1 ;
					end if ;
				when V1 => 
					if hsynct = '1' or vsynct = '1' then
						next_state <= WAIT_PIXEL ;
					elsif pxclk_rising_edge = '1' then
						next_state <= Y1 ;
					end if ;
				when others => 
					next_state <= WAIT_PIXEL ;
			end case ;
	 end process;  
	 
	 with pix_state select
		pixel_clock_out <=  '1' when  U1 ,
								  '1' when  V1 ,
								  '0' when others ;
								  
	 with pix_state select
		en_ylatch <=  pxclk_rising_edge when  WAIT_PIXEL ,
						  pxclk_rising_edge when  U1 ,
						  pxclk_rising_edge when  V1 ,
						  '0' when others ;
	 with pix_state select
		en_ulatch <=  pxclk_rising_edge when  Y1 ,
						  '0' when others ;
	 with pix_state select
		en_vlatch <=  pxclk_rising_edge when  Y2 ,
						  '0' when others ;
	
    hsync_out <= hsynct ;	
	 vsync_out <= vsynct ;
						  
end systemc ;