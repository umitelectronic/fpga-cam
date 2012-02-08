library IEEE;
        use IEEE.std_logic_1164.all;
        use IEEE.std_logic_arith.all;
        use IEEE.numeric_bit.all;
        use IEEE.numeric_std.all;
        use IEEE.std_logic_signed.all;
        use IEEE.std_logic_unsigned.all;

entity i2c_master is
	port(
 		clock : in std_logic; 
 		arazb : in std_logic; 
 		slave_addr : in std_logic_vector(6 downto 0 ); 
 		data : inout std_logic_vector(7 downto 0 ); 
 		send : in std_logic; 
 		rcv : in std_logic; 
 		scl : inout std_logic; 
 		sda : inout std_logic; 
 		dispo, ack_byte : out std_logic
	); 
end i2c_master;

architecture systemc of i2c_master is
	constant QUARTER_BIT : integer := 4; 
	constant HALF_BIT : integer := 8; 
	constant FULL_BIT : integer := 16; 
	TYPE master_state IS (IDLE, I2C_START, TX_ADDR, ACK_ADDR, TX_BYTE, RX_BYTE, ACK, I2C_STOP) ; 
	signal state : master_state ; 
	signal tick_count : std_logic_vector(7 downto 0 ) ; 
	signal bit_count : std_logic_vector(7 downto 0 ) ; 
	signal slave_addr_i : std_logic_vector(7 downto 0 ) ; 
	signal data_i : std_logic_vector(7 downto 0 ) ; 
	signal send_rvcb : std_logic ;
	begin
	
	
	-- run_i2c
	process(arazb, clock)
		 begin
		 	case state   is
		 		when idle => 
		 			scl <= 'Z' ;
		 			sda <= 'Z' ;
		 			dispo <= '1' ;
		 			ack_byte <= '0' ;
		 			if  send = '1'  OR  rcv = '1'  then
		 				slave_addr_i <= (slave_addr   & rcv  ) ; 
		 				send_rvcb <= send ; 
		 				state <= i2c_start ; 
		 				tick_count <= (others => '0') ; 
		 				bit_count <= (others => '0') ;
		 			end if ;
		 		when i2c_start => 
		 			dispo <= '0' ;
		 			ack_byte <= '0' ;
		 			if  tick_count < QUARTER_BIT  then
		 				scl <= 'Z' ; 
		 				sda <= 'Z' ; 
		 				tick_count <= tick_count + 1 ;
		 			elsif  tick_count < HALF_BIT  then
		 				scl <= 'Z' ; 
		 				sda <= '0' ; 
		 				tick_count <= tick_count + 1 ;
		 			else
		 				tick_count <= (others => '0') ; 
		 				scl <= '0' ; 
		 				state <= tx_addr ;
		 			end if ;
		 		when tx_addr => 
		 			dispo <= '0' ;
		 			ack_byte <= '0' ;
		 			if  bit_count < 8  then
		 				if  tick_count < HALF_BIT  then
		 					scl <= '0' ; 
		 					if  slave_addr_i(7) = '1'  then
		 						sda <= 'Z' ;
		 					else
		 						sda <= '0' ;
		 					end if ; 
		 					tick_count <= tick_count + 1 ;
		 				elsif  tick_count < FULL_BIT  then
		 					scl <= 'Z' ; 
		 					if  slave_addr_i(7) = '1'  then
		 						sda <= 'Z' ;
		 					else
		 						sda <= '0' ;
		 					end if ; 
		 					tick_count <= tick_count + 1 ;
		 				else
		 					slave_addr_i <= (slave_addr_i(6 downto 0)   & '0'  ) ; 
		 					bit_count <= bit_count + 1 ; 
		 					tick_count <= (others => '0') ;
		 				end if ;
		 			else
		 				bit_count <= (others => '0') ; 
		 				scl <= '0' ; 
		 				state <= ack_addr ;
		 			end if ;
		 		when ack_addr => 
		 			dispo <= '0' ;
		 			ack_byte <= '0' ;
		 			if  tick_count < HALF_BIT  then
		 				scl <= '0' ; 
		 				sda <= 'Z' ; 
		 				tick_count <= tick_count + 1 ;
		 			elsif  tick_count < FULL_BIT  then
		 				scl <= 'Z' ; 
		 				sda <= 'Z' ; 
		 				tick_count <= tick_count + 1 ;
		 			else
		 				tick_count <= (others => '0') ; 
		 				if  sda = '0'  then
		 					if  send_rvcb = '1'  then
		 						data_i <= data ; 
		 						state <= tx_byte ;
		 					else
		 						data <= data_i ; 
		 						state <= rx_byte ;
		 					end if ;
		 				else
		 					state <= i2c_stop ;
		 				end if ;
		 			end if ;
		 		when tx_byte => 
		 			dispo <= '0' ;
		 			ack_byte <= '0' ;
		 			if  bit_count < 8  then
		 				if  tick_count < HALF_BIT  then
		 					scl <= '0' ; 
		 					if  data_i(7) = '1'  then
		 						sda <= 'Z' ;
		 					else
		 						sda <= '0' ;
		 					end if ; 
		 					tick_count <= tick_count + 1 ;
		 				elsif  tick_count < FULL_BIT  then
		 					scl <= 'Z' ; 
		 					if  data_i(7) = '1'  then
		 						sda <= 'Z' ;
		 					else
		 						sda <= '0' ;
		 					end if ; 
		 					tick_count <= tick_count + 1 ;
		 				else
		 					data_i <= (data_i(6 downto 0)   & '0'  ) ; 
		 					bit_count <= bit_count + 1 ; 
		 					tick_count <= (others => '0') ;
		 				end if ;
		 			else
		 				bit_count <= (others => '0') ; 
		 				scl <= '0' ; 
		 				state <= ack ;
		 			end if ;
		 		when rx_byte => 
		 			dispo <= '0' ;
		 			ack_byte <= '0' ;
		 			if  bit_count < 8  then
		 				if  tick_count < HALF_BIT  then
		 					scl <= '0' ; 
		 					sda <= 'Z' ; 
		 					tick_count <= tick_count + 1 ;
		 				elsif  tick_count < FULL_BIT  then
		 					scl <= 'Z' ; 
		 					data_i <= (data_i(7 downto 1)   & sda  ) ; 
		 					tick_count <= tick_count + 1 ;
		 				else
		 					data_i <= (data_i(6 downto 0)   & '0'  ) ; 
		 					bit_count <= bit_count + 1 ; 
		 					tick_count <= (others => '0') ;
		 				end if ;
		 			else
		 				bit_count <= (others => '0') ; 
		 				scl <= '0' ; 
		 				state <= ack ;
		 			end if ;
		 		when ack => 
		 			dispo <= '0' ;
		 			ack_byte <= '1' ;
		 			if  tick_count < HALF_BIT  then
		 				scl <= '0' ; 
		 				sda <= 'Z' ; 
		 				tick_count <= tick_count + 1 ;
		 			elsif  tick_count < FULL_BIT  then
		 				scl <= 'Z' ; 
		 				sda <= 'Z' ; 
		 				tick_count <= tick_count + 1 ;
		 			else
		 				tick_count <= (others => '0') ; 
		 				if  sda = '0'  AND (( send = '1'  AND  send_rvcb = '1' ) OR ( rcv = '1'  AND  NOT send_rvcb = '1' )) then
		 					if  send_rvcb = '1'  then
		 						data_i <= data ; 
		 						state <= tx_byte ;
		 					else
		 						data <= data_i ; 
		 						state <= rx_byte ;
		 					end if ;
		 				else
		 					state <= i2c_stop ;
		 				end if ;
		 			end if ;
		 		when i2c_stop => 
		 			dispo <= '1' ;
		 			ack_byte <= '0' ;
		 			if  tick_count < HALF_BIT  then
		 				scl <= '0' ; 
		 				sda <= '0' ; 
		 				tick_count <= tick_count + 1 ;
		 			elsif  tick_count < HALF_BIT + QUARTER_BIT  then
		 				scl <= 'Z' ; 
		 				sda <= '0' ; 
		 				tick_count <= tick_count + 1 ;
		 			elsif  tick_count < FULL_BIT  then
		 				scl <= 'Z' ; 
		 				sda <= 'Z' ; 
		 				tick_count <= tick_count + 1 ;
		 			else
		 				tick_count <= (others => '0') ; 
		 				state <= idle ;
		 			end if ;
		 		when others => 
		 			state <= idle ;
		 	end case ;
		 end process;  
	
end systemc ;