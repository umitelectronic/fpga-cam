library IEEE;
        use IEEE.std_logic_1164.all;
		  use ieee.math_real.log2;
		  use ieee.math_real.ceil;

PACKAGE camera IS
component i2c_master is
	port(
 		clock : in std_logic; 
 		arazb : in std_logic; 
 		slave_addr : in std_logic_vector(6 downto 0 ); 
 		data_in : in std_logic_vector(7 downto 0 );
		data_out : out std_logic_vector(7 downto 0 );  
 		send : in std_logic; 
 		rcv : in std_logic; 
 		scl : inout std_logic; 
 		sda : inout std_logic; 
 		dispo, ack_byte : out std_logic
	); 
end component;

component register_rom is
	port(
		clk,en : in std_logic;
 		data : out std_logic_vector(15 downto 0 ); 
 		addr : in std_logic_vector(7 downto 0 )
	); 
end component;

component yuv_register_rom is
	port(
		clk,en : in std_logic;
 		data : out std_logic_vector(15 downto 0 ); 
 		addr : in std_logic_vector(7 downto 0 )
	); 
end component;

component rgb565_register_rom is
	port(
		clk,en : in std_logic;
 		data : out std_logic_vector(15 downto 0 ); 
 		addr : in std_logic_vector(7 downto 0 )
	); 
end component;

component camera_interface is
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
end component;

component yuv_camera_interface is
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
end component;

component rgb565_camera_interface is
	port(
 		clock : in std_logic; 
 		i2c_clk : in std_logic; 
 		arazb : in std_logic; 
 		pixel_data : in std_logic_vector(7 downto 0 ); 
 		r_data : out std_logic_vector(7 downto 0 ); 
 		g_data : out std_logic_vector(7 downto 0 ); 
 		b_data : out std_logic_vector(7 downto 0 ); 
 		scl : inout std_logic; 
 		sda : inout std_logic; 
 		pixel_clock_out, hsync_out, vsync_out : out std_logic; 
 		pxclk, href, vsync : in std_logic
	); 
end component;

component down_scaler is
	port(
 		clk : in std_logic; 
 		arazb : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_clock_out, hsync_out, vsync_out : out std_logic; 
 		pixel_data_in : in std_logic_vector(7 downto 0 ); 
 		pixel_data_out : out std_logic_vector(7 downto 0 )
	); 
end component;


component line_ram is
	port(
 		clk : in std_logic; 
 		we, en : in std_logic; 
 		data_out : out std_logic_vector(15 downto 0 ); 
 		data_in : in std_logic_vector(15 downto 0 ); 
 		addr : in std_logic_vector(6 downto 0 )
	); 
end component;


component send_picture is
	port(
 		clk : in std_logic; 
 		arazb : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_data_in : in std_logic_vector(7 downto 0 ); 
 		data_out : out std_logic_vector(7 downto 0 ); 
 		send : out std_logic; 
		output_ready : in std_logic
	); 
end component;

component ram_8x64 is
	port(
 		clk : in std_logic; 
 		we, en : in std_logic; 
 		do : out std_logic_vector(7 downto 0 ); 
 		di : in std_logic_vector(7 downto 0 ); 
 		addr : in std_logic_vector(6 downto 0 )
	); 
end component;

component fifo_64x8 is
	port(
 		clk, arazb : in std_logic; 
 		wr, rd : in std_logic; 
		empty, full, data_rdy : out std_logic ;
 		data_out : out std_logic_vector(7 downto 0 ); 
 		data_in : in std_logic_vector(7 downto 0 )
	); 
end component;

component ram_Nx8 is
	generic(N : natural := 64; A : natural := 6);
	port(
 		clk : in std_logic; 
 		we, en : in std_logic; 
 		do : out std_logic_vector(7 downto 0 ); 
 		di : in std_logic_vector(7 downto 0 ); 
 		addr : in std_logic_vector( (A - 1) downto 0 )
	); 
end component;

component fifo_Nx8 is
	generic(N : natural := 64);
	port(
 		clk, arazb : in std_logic; 
 		wr, rd : in std_logic; 
		empty, full, data_rdy : out std_logic ;
 		data_out : out std_logic_vector(7 downto 0 ); 
 		data_in : in std_logic_vector(7 downto 0 )
	); 
end component;

END camera;