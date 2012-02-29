library IEEE;
        use IEEE.std_logic_1164.all;
        use IEEE.std_logic_unsigned.all;
library work;
        use work.camera.all ;

entity fifo_64x8 is
	port(
 		clk, arazb : in std_logic; 
 		wr, rd : in std_logic; 
		empty, full, data_rdy : out std_logic ;
 		data_out : out std_logic_vector(7 downto 0 ); 
 		data_in : in std_logic_vector(7 downto 0 )
	); 
end fifo_64x8;

architecture systemc of fifo_64x8 is
 
	signal wr_addr, rd_addr, byte_count, ram_addr : std_logic_vector(5 downto 0) ;
	signal fullt, emptyt : std_logic ;
	begin
	
	ram_8_0 : ram_8x64
		port map ( 
			clk => clk, 
			addr => ram_addr, 
			data_in => data_in, 
			data_out => data_out, 
			en => (rd OR wr),
			we => wr
		); 
		
	-- fifo process
	process(clk, arazb)
		 begin
			if arazb = '0' then
				wr_addr <= (others => '0');
				rd_addr <= (others => '0');
				byte_count <= (others => '0');
				data_rdy <= '0' ;
		 	elsif  clk'event and clk = '1' then
				if  wr = '1'  and fullt = '0' then
					ram_addr <= wr_addr ; 
					wr_addr <= wr_addr + 1 ;
					byte_count <= byte_count + 1 ;
				elsif rd = '1' and wr = '0' and emptyt = '0' then
					ram_addr <= rd_addr ; 
					rd_addr <= rd_addr + 1 ;
					byte_count <= byte_count - 1 ;
					data_rdy <= '1' ;
				else
					data_rdy <= '0' ;
				end if ;
			end if;
	end process;
	
	fullt <= '1' when byte_count = 80 else
			  '0' ;
	
	emptyt <= '1' when byte_count = 0 else
			   '0' ;
				
	full <= fullt ;
	empty <= emptyt ;
	
end systemc ;