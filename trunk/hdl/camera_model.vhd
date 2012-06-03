library IEEE;
        use IEEE.std_logic_1164.all;
        use IEEE.std_logic_unsigned.all;
library work;
        use work.all ;

entity camera_model is
	port(
 		clock : in std_logic; 
 		data : inout std_logic_vector(7 downto 0 ); 
 		scl : in std_logic; 
 		sda : inout std_logic; 
 		pix_clk, href, vsync : out std_logic
	); 
end camera_model;

architecture systemc of camera_model is
	constant I2C_ADDR : std_logic_vector(7 downto 0) := X"42"; 
	constant BYTE_PER_PIXEL : integer := 2; 
 
	variable test_int : unsigned(7 downto 0) ; 
	signal sccb_data : std_logic_vector(7 downto 0 ) ; 
	signal sccb_index : std_logic_vector(7 downto 0 ) ; 
	signal sccb_wr, sccb_rd : std_logic ;
	begin
	
	i2c_slave0 : i2c_slave
		port map ( 
			sda => sda, 
			scl => scl, 
			data => sccb_data, 
			index => sccb_index
		); 
	
	
end systemc ;
