library IEEE;
        use IEEE.std_logic_1164.all;
        use IEEE.std_logic_unsigned.all;
		  
library work;
        use work.camera.all ;
		  use work.generic_components.all ;

entity yuv_camera_interface is
generic(FORMAT : FRAME_FORMAT := QVGA; CAMERA : CAMERA_TYPE := OV7670);
	port(
 		clock : in std_logic; 
 		i2c_clk : in std_logic; 
 		resetn : in std_logic; 
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
	TYPE pixel_state IS (WAIT_LINE, Y1, U1, Y2, V1) ; 
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
	signal pxclk_old, pxclk_rising_edge, pxclk_falling_edge, nclk : std_logic ;
	signal en_ylatch, en_ulatch, en_vlatch : std_logic ;
	signal hsynct, vsynct, pxclkt, pixel_clock_out_t  : std_logic ;
	
	signal pclk_set, pclk_reset, first_pixeln : std_logic ;
	signal cpt_nb_pixel : std_logic_vector(1 downto 0);
	
	for register_rom_ov7670_vga : yuv_register_rom use entity yuv_register_rom(ov7670_vga) ;
	for register_rom_ov7670_qvga : yuv_register_rom use entity yuv_register_rom(ov7670_qvga) ;
	for register_rom_ov7725_vga : yuv_register_rom use entity yuv_register_rom(ov7725_vga) ;
	for register_rom_ov7725_qvga : yuv_register_rom use entity yuv_register_rom(ov7725_qvga) ;
	begin
	
	
gen_ov7670: if CAMERA = OV7670 generate	
		gen_vga : if FORMAT = VGA generate
			register_rom_ov7670_vga : yuv_register_rom --rom containg sensor configuration
				port map (
					clk => i2c_clk,
					en => '1',
					addr => reg_addr, 
					data => reg_data
				); 
			 end generate ;
			 
		gen_qvga : if FORMAT = QVGA generate
			register_rom_ov7670_qvga : yuv_register_rom --rom containg sensor configuration
				port map (
					clk => i2c_clk,
					en => '1',
					addr => reg_addr, 
					data => reg_data
				); 
			 end generate ;
end generate ;


gen_ov7725: if CAMERA = OV7725 generate	
		gen_vga : if FORMAT = VGA generate
			register_rom_ov7725_vga : yuv_register_rom --rom containg sensor configuration
				port map (
					clk => i2c_clk,
					en => '1',
					addr => reg_addr, 
					data => reg_data
				); 
			 end generate ;
			 
		gen_qvga : if FORMAT = QVGA generate
			register_rom_ov7725_qvga : yuv_register_rom --rom containg sensor configuration
				port map (
					clk => i2c_clk,
					en => '1',
					addr => reg_addr, 
					data => reg_data
				); 
			 end generate ;
end generate ;


	
y_latch : generic_latch 
	 generic map( NBIT => 8)
    port map( clk =>pxclk,
           resetn => resetn ,
           sraz => '0' ,
           en => en_ylatch ,
           d => pixel_data , 
           q => y_data);
			  
u_latch : generic_latch 
	 generic map( NBIT => 8)
    port map( clk => pxclk,
           resetn => resetn ,
           sraz => '0' ,
           en => en_ulatch ,
           d => pixel_data , 
           q => u_data);

v_latch : generic_latch 
	 generic map( NBIT => 8)
    port map( clk => pxclk,
           resetn => resetn ,
           sraz => '0' ,
           en => en_vlatch ,
           d => pixel_data , 
           q => v_data);

	i2c_master0 : i2c_master
		port map ( 
			clock => i2c_clk, 
			resetn => resetn, 
			sda => sda, 
			scl => scl, 
			data_in => i2c_data, 
			slave_addr => i2c_addr, 
			send => send, 
			rcv => rcv,
                        hold => '0',
			dispo => dispo, 
			ack_byte => ack_byte,
			nack_byte => nack_byte
		); 
	
	-- sccb_interface
	process(i2c_clk, resetn)
		 begin
		 	i2c_addr <= OV7670_I2C_ADDR ; -- sensor address
		 	if  resetn = '0'  then
		 		reg_state <= init ;
				reg_addr <= (others => '0');
		 	elsif i2c_clk'event and i2c_clk = '1' then
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
						end if;
		 			when wait_ack0 => -- falling edge of ack 
						if nack_byte = '1' then							send <= '0' ; 
							reg_state <= next_reg ;
						elsif  ack_byte = '0'  then
		 					reg_state <= send_data ;
		 				end if ;
		 			when send_data => --send register value
		 				if  ack_byte = '1'  then
		 					send <= '0' ; 
		 					reg_state <= wait_ack1 ; 
							reg_addr <= (reg_addr + 1) ;
						end if;
						
					when wait_ack1 => -- wait for ack
					  if nack_byte = '1' then
								  send <= '0' ; 
								  reg_state <= next_reg ;
						elsif  ack_byte = '0'  then
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




	process(clock, resetn)
		 begin
			if resetn = '0' then
				hsynct <= '0' ;
				vsynct <= '0' ;
				pxclkt <= '0' ;
		 	elsif  clock'event and clock = '1'  then
				hsynct <= NOT href ; -- changing href into hsync
				vsynct <= vsync ;
				pxclkt <= pxclk ;
			end if ;
	end process ;

	
	 
pixel_counter : simple_counter
	 generic map(NBIT => 2)
    port map( clk => pxclkt, 
           resetn => resetn, 
           sraz => NOT href,
           en => '1',
			  load => '0',
			  E => "00",
           Q => cpt_nb_pixel
			  );
	

	process(clock, resetn)
	begin
		if resetn = '0' then
			first_pixeln <= '0' ;
		elsif clock'event and clock = '1' then
			if href = '0' then
				first_pixeln <= '0' ;
			elsif cpt_nb_pixel /= "00"  then
				first_pixeln <= '1' ;
			end if ;
		end if ;
	end process ;


	 with cpt_nb_pixel select
		pixel_clock_out_t <=  first_pixeln when "00" , 
									 '1' when  "10" , 
									 '0' when others ;	 
	
	 with cpt_nb_pixel select
		en_ylatch <=  (href)when  "00" ,
						  '1' when  "10" ,
						  '0' when others ;
						  
	 with cpt_nb_pixel select
		en_ulatch <=  '1' when  "01" ,
						  '0' when others ;
						  
	 with cpt_nb_pixel select
		en_vlatch <=  '1' when "11"  ,
						  '0' when others ;

	
    hsync_out <= hsynct AND (NOT pixel_clock_out_t) ;	
	 vsync_out <= vsynct AND (NOT pixel_clock_out_t);
	 pixel_clock_out <= pixel_clock_out_t ;
						  
end systemc ;
