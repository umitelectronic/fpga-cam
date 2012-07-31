library IEEE;
        use IEEE.std_logic_1164.all;
		  use IEEE.std_logic_signed.all;
		  use ieee.math_real.log2;
		  use ieee.math_real.ceil;
		  use ieee.numeric_std.all;
		  
library WORK ;
use work.generic_components.all ;

PACKAGE camera IS
component i2c_master is
	port(
 		clock : in std_logic; 
 		resetn : in std_logic; 
 		slave_addr : in std_logic_vector(6 downto 0 ); 
 		data_in : in std_logic_vector(7 downto 0 );
		data_out : out std_logic_vector(7 downto 0 );  
 		send : in std_logic; 
 		rcv : in std_logic;
                hold : in std_logic;
 		scl : inout std_logic; 
 		sda : inout std_logic; 
 		dispo, ack_byte, nack_byte : out std_logic
	); 
end component;

component register_rom is
	port(
		clk,en : in std_logic;
 		data : out std_logic_vector(15 downto 0 ); 
 		addr : in std_logic_vector(7 downto 0 )
	); 
end component;

type FRAME_FORMAT is (VGA, QVGA);
constant QVGA_WIDTH : natural := 320;
constant VGA_WIDTH : natural := 640;
constant QVGA_HEIGHT : natural := 240;
constant VGA_HEIGHT : natural := 480;

type CAMERA_TYPE is (OV7670, OV7725);


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

component yuv_camera_interface is
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
end component;

component rgb565_camera_interface is
	generic(FORMAT : FRAME_FORMAT := QVGA);
	port(
 		clock : in std_logic; 
 		i2c_clk : in std_logic; 
 		resetn : in std_logic; 
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
	generic(SCALING_FACTOR : natural := 8; INPUT_WIDTH : natural := 640; INPUT_HEIGHT : natural := 480 );
	port(
 		clk : in std_logic; 
 		resetn : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_clock_out, hsync_out, vsync_out : out std_logic; 
 		pixel_data_in : in std_logic_vector(7 downto 0 ); 
 		pixel_data_out : out std_logic_vector(7 downto 0 )
	); 
end component;


component line_ram is
	generic(LINE_SIZE : natural := 640; ADDR_SIZE : natural := 10);
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
 		resetn : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_data_in : in std_logic_vector(7 downto 0 ); 
 		data_out : out std_logic_vector(7 downto 0 ); 
		output_ready : in std_logic;
 		send : out std_logic
	); 
end component;


component MAC16 is
port(clk, sraz : in std_logic;
	  add_subb	:	in std_logic;
	  A, B	:	in signed(15 downto 0);
	  RES	:	out signed(31 downto 0) 
);
end component;

component SAC16 is
port(clk, sraz : in std_logic;
	  A, B	:	in signed(15 downto 0);
	  RES	:	out signed(31 downto 0)  
);
end component;



type register_array is array (natural range <>) of std_logic_vector(7 downto 0);

type row3 is array (0 to 2) of signed(8 downto 0);
type mat3 is array (0 to 2) of row3;

type irow3 is array (0 to 2) of integer range -256 to 255;
type imat3 is array (0 to 2) of irow3;


type duplet is array (0 to 1) of integer range 0 to 3;
type index_array is array (0 to 8) of duplet ;


component block3X3 is
		generic(LINE_SIZE : natural := 640);
		port(
			clk : in std_logic; 
			resetn : in std_logic; 
			pixel_clock, hsync, vsync : in std_logic; 
			pixel_data_in : in std_logic_vector(7 downto 0 ); 
			new_block : out std_logic ;
			block_out : out mat3);
end component;

component block3X3v2 is
		generic(WIDTH: natural := 640;
		  HEIGHT: natural := 480);
		port(
			clk : in std_logic; 
			resetn : in std_logic; 
			pixel_clock, hsync, vsync : in std_logic; 
			pixel_data_in : in std_logic_vector(7 downto 0 ); 
			new_block : out std_logic ;
			block_out : out mat3);
end component;

component conv3x3 is
generic(KERNEL : imat3 := ((1, 2, 1),(0, 0, 0),(-1, -2, -1));
		  NON_ZERO	: index_array := ((0, 0), (0, 1), (0, 2), (2, 0), (2, 1), (2, 2), (3, 3), (3, 3), (3, 3) ); -- (3, 3) indicate end  of non zero values
		  IS_POWER_OF_TWO : natural := 0 -- (3, 3) indicate end  of non zero values
		  );
port(
 		clk : in std_logic; 
 		resetn : in std_logic; 
 		new_block : in std_logic ;
		block3x3 : in mat3;
		new_conv : out std_logic ;
		busy : out std_logic ;
 		abs_res : out std_logic_vector(7 downto 0 );
		raw_res : out signed(15 downto 0 )
);
end component;

component sobel3x3 is
generic(WIDTH: natural := 640;
		  HEIGHT: natural := 480);
port(
 		clk : in std_logic; 
 		resetn : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_clock_out, hsync_out, vsync_out : out std_logic; 
 		pixel_data_in : in std_logic_vector(7 downto 0 ); 
 		pixel_data_out : out std_logic_vector(7 downto 0 )

);
end component;


component gauss3x3 is
generic(WIDTH: natural := 640;
		  HEIGHT: natural := 480);
port(
 		clk : in std_logic; 
 		resetn : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_clock_out, hsync_out, vsync_out : out std_logic; 
 		pixel_data_in : in std_logic_vector(7 downto 0 ); 
 		pixel_data_out : out std_logic_vector(7 downto 0 )

);
end component;

component binarization is
generic(INVERT : natural := 0; VALUE : std_logic_vector(7 downto 0) := X"FF");
port( 
 		pixel_data_in : in std_logic_vector(7 downto 0) ;
		upper_bound	:	in std_logic_vector(7 downto 0);
		lower_bound	:	in std_logic_vector(7 downto 0);
		pixel_data_out : out std_logic_vector(7 downto 0) 
);
end component;


component synced_binarization is
port( clk	:	in std_logic ;
		resetn	:	in std_logic ;
		pixel_clock, hsync, vsync : in std_logic; 
		pixel_clock_out, hsync_out, vsync_out : out std_logic; 
 		pixel_data_1 : in std_logic_vector(7 downto 0) ;
		pixel_data_2 : in std_logic_vector(7 downto 0) ;
		pixel_data_3 : in std_logic_vector(7 downto 0) ;
		upper_bound_1	:	in std_logic_vector(7 downto 0);
		upper_bound_2	:	in std_logic_vector(7 downto 0);
		upper_bound_3	:	in std_logic_vector(7 downto 0);
		lower_bound_1	:	in std_logic_vector(7 downto 0);
		lower_bound_2	:	in std_logic_vector(7 downto 0);
		lower_bound_3	:	in std_logic_vector(7 downto 0);
		pixel_data_out : out std_logic_vector(7 downto 0) 
);
end component;

component threshold is
generic(INVERT : natural := 0; VALUE : std_logic_vector(7 downto 0) := X"FF");
port( 
 		pixel_data_in : in std_logic_vector(7 downto 0) ;
		threshold	:	in std_logic_vector(7 downto 0);
		pixel_data_out : out std_logic_vector(7 downto 0) 
);
end component;

component erode3x3 is
generic(INVERT : natural := 0; 
		  VALUE : std_logic_vector(7 downto 0) := X"FF";
		  WIDTH: natural := 640;
		  HEIGHT: natural := 480);
port(
 		clk : in std_logic; 
 		resetn : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_clock_out, hsync_out, vsync_out : out std_logic; 
 		pixel_data_in : in std_logic_vector(7 downto 0 ); 
 		pixel_data_out : out std_logic_vector(7 downto 0 )

);
end component;


component dilate3x3 is
generic(INVERT : natural := 0; 
		  VALUE : std_logic_vector(7 downto 0) := X"FF";
		  WIDTH: natural := 640;
		  HEIGHT: natural := 480);
port(
 		clk : in std_logic; 
 		resetn : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_clock_out, hsync_out, vsync_out : out std_logic; 
 		pixel_data_in : in std_logic_vector(7 downto 0 ); 
 		pixel_data_out : out std_logic_vector(7 downto 0 )

);
end component;

 
type pix_neighbours is array (0 to 3) of unsigned(7 downto 0);

component neighbours is
		generic(LINE_SIZE : natural := 640);
		port(
			clk : in std_logic; 
			resetn, sraz : in std_logic; 
			add_neighbour, next_line : in std_logic; 
			neighbour_in : in unsigned(7 downto 0 );
			neighbours : out pix_neighbours);
end component;

component blobs is
	generic(NB_BLOB : positive:= 16);
	port(
		clk, resetn, sraz : in std_logic ;
		blob_index : in unsigned(7 downto 0);
		next_blob_index : out unsigned(7 downto 0);
		blob_index_to_merge : in unsigned(7 downto 0);
		true_blob_index : out unsigned(7 downto 0);
		add_pixel : in std_logic ;
		new_blob : in std_logic ;
		merge_blob : in std_logic ;
		pixel_posx, pixel_posy : in unsigned(9 downto 0);
		
		blob_data : out std_logic_vector(7 downto 0);
		oe : in std_logic ;
		send_blob	:	out std_logic 
	);
 
end component;


component blob_detection is
generic(LINE_SIZE : natural := 640);
port(
 		clk : in std_logic; 
 		resetn: in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic;
 		pixel_data_in : in std_logic_vector(7 downto 0 );
		blob_data : out std_logic_vector(7 downto 0);
		send_blob : out std_logic
		);
end component;

component draw_square is
port(
 		clk : in std_logic; 
 		resetn : in std_logic; 
		posx, posy, width, height : in unsigned(9 downto 0);
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_clock_out, hsync_out, vsync_out : out std_logic; 
 		pixel_data_in : in std_logic_vector(7 downto 0 ); 
 		pixel_data_out : out std_logic_vector(7 downto 0 )
	);
end component;

component pixel_counter is
		generic(POL : std_logic := '1'; MAX : positive := 640);
		port(
			clk : in std_logic; 
			resetn : in std_logic; 
			pixel_clock, hsync : in std_logic; 
			pixel_count : out std_logic_vector((nbit(MAX) - 1) downto 0 )
			);
end component;

component line_counter is
		generic(POL : std_logic := '1'; MAX : positive := 480);
		port(
			clk : in std_logic; 
			resetn : in std_logic; 
			hsync, vsync : in std_logic; 
			line_count : out std_logic_vector((nbit(MAX) - 1) downto 0 )
			);
end component;

component configuration_module is
generic(NB_REGISTERS : natural := 6);
port(
	clk, resetn : in std_logic ;
	input_data	:	in std_logic_vector(7 downto 0) ;
	read_data	:	out std_logic ;
	data_present	:	in std_logic ;
	vsync	:	in std_logic ;
	registers	: out register_array(0 to (NB_REGISTERS - 1))
);
end component;

component blob_sender is
generic(NB_BLOB : positive	:=	16);
	port(
		clk	:	in std_logic ;
		resetn	:	in std_logic ;
		oe : in std_logic ;
		clear_blob :	out std_logic ;
		ram_addr	:	out std_logic_vector(7 downto 0);
		ram_data_in		: in std_logic_vector(39 downto 0);
		blob_data : out std_logic_vector(7 downto 0); -- data of blob
		active	:	out std_logic ;
		send_blob	:	out std_logic 
	);
end component;


component video_switch is
generic(NB	:	positive := 2);
port(pixel_clock, hsync, vsync : in std_logic_vector(NB - 1 downto 0);
	  pixel_data	:	in slv8_array(NB - 1 downto 0);
	  pixel_clock_out, hsync_out, vsync_out : out std_logic ;
	  pixel_data_out	:	out std_logic_vector(7 downto 0);
	  channel	:	in std_logic_vector(7 downto 0)
);
end component;


component lcd_interface is
port(clk, resetn	:	in std_logic ;
	  addr	:	in std_logic_vector(7 downto 0) ;
	  data	:	in std_logic_vector(15 downto 0);
	  wr_data	:	in std_logic ;
	  set_addr	:	in std_logic ;
	  busy	:	out std_logic ;
	  lcd_rs, lcd_cs, lcd_rd, lcd_wr	:	 out std_logic;
	  lcd_data	:	out std_logic_vector(15 downto 0) );
end component;

component lcd_register_rom is
	port(
	   clk, en	:	in std_logic ;
 		data : out std_logic_vector(23 downto 0 ); 
 		addr : in std_logic_vector(7 downto 0 )
	); 
end component;

component lcd_controller is
port(
 		clk : in std_logic; 
 		resetn : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		pixel_r, pixel_g, pixel_b : in std_logic_vector(7 downto 0 );
		lcd_rs, lcd_cs, lcd_rd, lcd_wr	:	 out std_logic;
	   lcd_data	:	out std_logic_vector(15 downto 0) 
	); 
end component;

component graphic_generator is
port(clk, resetn : in  std_logic ;
	  pixel_clock_out, hsync_out, vsync_out : out		std_logic ;
	  pixel_r, pixel_g, pixel_b	:	out	 std_logic_vector(7 downto 0)
	  );
end component;


component yuv_rgb is
port( clk	:	in std_logic ;
		resetn	:	in std_logic ;
		pixel_clock, hsync, vsync : in std_logic; 
		pixel_clock_out, hsync_out, vsync_out : out std_logic; 
 		pixel_y : in std_logic_vector(7 downto 0) ;
		pixel_u : in std_logic_vector(7 downto 0) ;
		pixel_v : in std_logic_vector(7 downto 0) ;
		pixel_r : out std_logic_vector(7 downto 0) ;
		pixel_g : out std_logic_vector(7 downto 0)  ;
		pixel_b : out std_logic_vector(7 downto 0)  
);
end component;

END camera;
