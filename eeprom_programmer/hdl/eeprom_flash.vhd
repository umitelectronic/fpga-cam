
-- Description: 
--
-- Dependencies: 
--
-- Revision: 
-- Revision 0.01 - File Created
-- Additional Comments: 
--
----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

library work;
use work.camera.all ;
use WORK.GENERIC_COMPONENTS.ALL ;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity eeprom_flash is
port( CLK : in std_logic;
		ARAZB	:	in std_logic;
		TXD	:	out std_logic;
		RXD   :	in std_logic;
		
		
		--camera interface
		CAM_XCLK	:	out std_logic;
		CAM_SIOC, CAM_SIOD	:	inout std_logic; 
		CAM_DATA	:	out std_logic_vector(7 downto 0);
		CAM_PCLK, CAM_HREF, CAM_VSYNC	:	in std_logic;
		CAM_RESET	:	out std_logic ;
		
		--LCD interface
		LCD_RS, LCD_CS, LCD_WR, LCD_RD:	out std_logic;
		LCD_DATA :	out std_logic_vector(15 downto 0);
		
		--FIFO interface
		FIFO_CS, FIFO_WR, FIFO_RD, FIFO_A0:	out std_logic;
		FIFO_DATA :	out std_logic_vector(7 downto 0)
		
);
end eeprom_flash;


architecture Structural of eeprom_flash is

	COMPONENT dcm24
	PORT(
		CLKIN_IN : IN std_logic;          
		CLKDV_OUT : OUT std_logic;
		CLK0_OUT : OUT std_logic
		);
	END COMPONENT;

	COMPONENT dcm96
	PORT(
		CLKIN_IN : IN std_logic;          
		CLKFX_OUT : OUT std_logic;
		CLKIN_IBUFG_OUT : OUT std_logic;
		CLK0_OUT : OUT std_logic
		);
	END COMPONENT;
	
	component uart_tx is
    port (            data_in : in std_logic_vector(7 downto 0);
                 write_buffer : in std_logic;
                 reset_buffer : in std_logic;
                 en_16_x_baud : in std_logic;
                   serial_out : out std_logic;
                  buffer_full : out std_logic;
             buffer_half_full : out std_logic;
                          clk : in std_logic);
    end component;
	 
	 
	 component uart_rx is
    port (            serial_in : in std_logic;
                       data_out : out std_logic_vector(7 downto 0);
                    read_buffer : in std_logic;
                   reset_buffer : in std_logic;
                   en_16_x_baud : in std_logic;
            buffer_data_present : out std_logic;
                    buffer_full : out std_logic;
               buffer_half_full : out std_logic;
                            clk : in std_logic);
    end component;
	 
	 
   component ee_commands
	 port (
    clk          : in  std_logic;       -- System clock
    arazb        : in  std_logic;       -- Reset input

    data_in      : in  std_logic_vector(7 downto 0);  -- RS232 data in
    data_present : in  std_logic;       -- RS232 data are present
    data_read    : out std_logic;       -- Read data from then RS232 fifo
    
    data_out     : out std_logic_vector(7 downto 0);  -- Data out to the RS232
    data_write   : out std_logic;       -- Write signal to the RS232 transceiver

    SDA          : inout std_logic;     -- EEPROM SDA signal
    SCL          : inout std_logic;     -- EEPROM SCL signal
	 
	 State		  : out std_logic_vector(3 downto 0));
   end component;

	signal clk_24, clk_96, clk_48, clk_1_8 : std_logic ;
	signal baud_count, arazb_delayed, clk0 : std_logic ;
	constant arazb_delay : integer := 1000000 ;
	signal arazb_time : integer range 0 to 1048576 := arazb_delay ;
	signal baud_rate_divider : integer range 0 to 53 := 0 ;

	signal pixel_y_from_interface, pixel_u_from_interface, pixel_v_from_interface : std_logic_vector(7 downto 0);
	signal pixel_from_ds : std_logic_vector(7 downto 0);
	
	signal pixel_from_conv : std_logic_vector(7 downto 0);
	signal binarized_pixel , binarized_pixel_y , binarized_pixel_u , binarized_pixel_v  : std_logic_vector(7 downto 0);
	signal pixel_from_erode : std_logic_vector(7 downto 0);
	signal pixel_from_dilate : std_logic_vector(7 downto 0);
	signal pixel_from_square: std_logic_vector(7 downto 0);
	signal pixel_from_blob: std_logic_vector(7 downto 0);
	
	signal raw_data : std_logic_vector(7 downto 0 );
	signal raw_data_available : std_logic := '0' ;
	signal read_raw_data : std_logic ;
	
	signal data_to_send : std_logic_vector(7 downto 0);
	signal data_to_read : std_logic_vector(7 downto 0);
	signal send_signal, tx_buffer_full, read_signal, data_present	:	std_logic ;
	signal pxclk_from_interface, href_from_interface, vsync_from_interface : std_logic ;
	signal pxclk_from_bin, href_from_bin, vsync_from_bin : std_logic ;
	signal pxclk_from_ds, href_from_ds, vsync_from_ds : std_logic ;
	signal pxclk_from_conv, href_from_conv, vsync_from_conv : std_logic ;
	signal pxclk_from_erode, href_from_erode, vsync_from_erode : std_logic ;
	signal pxclk_from_dilate, href_from_dilate, vsync_from_dilate : std_logic ;
	signal pxclk_from_blob, href_from_blob, vsync_from_blob : std_logic ;
	signal pxclk_from_square, href_from_square, vsync_from_square : std_logic ;
	signal blobx, bloby : unsigned(9 downto 0);
	
	signal configuration_registers :  register_array(0 to 5) ;
	
	signal fifo_empty, fifo_wr0, send_data, tx1_buffer_full : std_logic ;
	signal fifo_input, fifo_output : std_logic_vector(7 downto 0);
	
	signal i2c_scl, i2c_sda : std_logic;
	begin


--comment connections below when using pins
	LCD_RS <= 'Z' ;
	LCD_CS <= 'Z' ; 
	LCD_WR <= 'Z' ; 
	LCD_RD <= 'Z' ;
	LCD_DATA <= (others => 'Z')  ;
	FIFO_CS <= 'Z' ;
	FIFO_WR <= 'Z' ; 
	FIFO_RD <= 'Z' ; 
	FIFO_A0 <= 'Z' ;
	FIFO_DATA(7 downto 6) <= (others => 'Z')  ;
	CAM_XCLK <= 'Z';
	CAM_DATA <= (others => 'Z');

        -- Put a spy on the I2C communication
        FIFO_DATA(4) <= i2c_scl;
        FIFO_DATA(5) <= i2c_sda;

	process(clk0, arazb) -- reset process
	begin
          if arazb = '0' then
            arazb_time <= arazb_delay;
          elsif clk0'event and clk0 = '1' then
            if arazb_time = 0 then
              arazb_delayed <= '1' ;
            else
              arazb_delayed <= '0';
              arazb_time <= arazb_time - 1 ;
            end if;
          end if;
	end process;
	
	process(clk_96) -- clk div for uart 3Mbs process
	begin
	if clk_96'event and clk_96 = '1' then
          if baud_count = '1' then
            baud_count <= '0' ;
            clk_48 <= '1';
          else
            baud_count <= '1';
            clk_48 <= '0';
          end if;
	end if;
	end process;
	
	
	process(clk_96)
        begin
          if clk_96'event and clk_96='1' then
            if baud_rate_divider=52 then
              baud_rate_divider <= 0;
              clk_1_8 <= '1';
            else
              baud_rate_divider <= baud_rate_divider + 1;
              clk_1_8 <= '0';
            end if;
          end if;
	end process;

	CAM_RESET <= data_present ;
	
	CAM_SIOC <= i2c_scl ;
	CAM_SIOD <= i2c_sda ;

	Inst_dcm96: dcm96 PORT MAP(
          CLKIN_IN => clk,
          CLKFX_OUT => clk_96, 
          CLKIN_IBUFG_OUT => clk0
	);	
	
	fifo_8x8_0 : fifo_Nx8         -- Output fifo
          generic map(N =>8)
          port map(
            clk => clk_96, 
            arazb => arazb_delayed,
            sraz => '0',
            wr => fifo_wr0 , 
            rd => NOT tx_buffer_full, 
            data_rdy => send_data,
            data_out => data_to_send,  
            data_in => fifo_input
            ); 

	ee_interp : ee_commands
	 port map (
           clk => clk_96,
           arazb => arazb,
           data_in => data_to_read,
           data_present => data_present,
           data_read => read_signal,
           data_out => fifo_input,
           data_write => fifo_wr0,
           SDA => i2c_sda,
           SCL => i2c_scl,
           State => FIFO_DATA(3 downto 0)
	 );

	uart_tx0 : uart_tx 
          port map (
            data_in => data_to_send, 
            write_buffer => send_data,
            reset_buffer => NOT arazb_delayed, 
            en_16_x_baud => clk_48,
            serial_out => TXD,
            clk => clk_96,
            buffer_half_full => tx_buffer_full);
        
	uart_rx0 : uart_rx 
          port map(
            serial_in => RXD,
            data_out => data_to_read,
            read_buffer => read_signal,
            reset_buffer => NOT arazb_delayed,
            en_16_x_baud => clk_48,
            buffer_data_present => data_present,
            clk => clk_96);


end Structural;
