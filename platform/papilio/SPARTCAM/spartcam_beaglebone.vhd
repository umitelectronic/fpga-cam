----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    14:14:22 06/21/2012 
-- Design Name: 
-- Module Name:    spartcam_beaglebone - Behavioral 
-- Project Name: 
-- Target Devices: 
-- Tool versions: 
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

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

library work ;
use work.generic_components.all ;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity spartcam_beaglebone is
port( CLK : in std_logic;
		ARAZB	:	in std_logic;
		TXD	:	out std_logic;
		RXD   :	in std_logic;
		
		
		--camera interface
		CAM_XCLK	:	out std_logic;
		CAM_SIOC, CAM_SIOD	:	inout std_logic; 
		CAM_DATA	:	in std_logic_vector(7 downto 0);
		CAM_PCLK, CAM_HREF, CAM_VSYNC	:	in std_logic;
		CAM_RESET	:	out std_logic ;
		
		--LCD interface
		BEAGLE_ALE, BEAGLE_CSN, BEAGLE_WRN, BEAGLE_OEN:	in std_logic;
		BEAGLE_DATA :	inout std_logic_vector(15 downto 0);
		
		--FIFO interface
		FIFO_CS, FIFO_WR, FIFO_RD, FIFO_A0:	out std_logic;
		FIFO_DATA :	out std_logic_vector(7 downto 0)
		
);
end spartcam_beaglebone;

architecture Behavioral of spartcam_beaglebone is

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
signal clk_24, clk_96, clk_48, clk_1_8 : std_logic ;
	signal baud_count, arazb_delayed, clk0, cam_reset_delayed : std_logic ;
	signal baud_rate_divider : integer range 0 to 53 := 0 ;
	signal data_to_send, fifo_output : std_logic_vector(15 downto 0);
	signal data_to_read, fifo_input : std_logic_vector(15 downto 0);
	signal send_signal, send_addr, send_data,tx_buffer_full, read_signal, data_present	:	std_logic ;
	
	signal mem_ad, bus_addr, bus_data : std_logic_vector(15 downto 0);
	signal bus_wr, bus_rd : std_logic ;
	signal fifoB_wr, fifoA_rd, fifoA_empty, fifoA_full, fifoB_empty, fifoB_full : std_logic ;
begin

--comment connections below when using pins
	FIFO_CS <= 'Z' ;
	FIFO_WR <= 'Z' ; 
	FIFO_RD <= 'Z' ; 
	FIFO_A0 <= 'Z' ;
	FIFO_DATA <= (others => 'Z')  ;
	TXD <= 'Z' ;
	
	CAM_RESET <= arazb ;
	CAM_XCLK <= clk_24 ;
--		CAM_PCLK, CAM_HREF, CAM_VSYNC	:	in std_logic;
	
	CAM_SIOC <= 'Z' ;
	CAM_SIOD <= 'Z' ;




	reset0: reset_generator 
	generic map(HOLD_0 => 500000)
	port map(clk => clk0, 
		arazb => ARAZB ,
		arazb_0 => arazb_delayed
	 );

	Inst_dcm96: dcm96 PORT MAP(
		CLKIN_IN => clk,
		CLKFX_OUT => clk_96, 
		CLKIN_IBUFG_OUT => clk0
	);	


	Inst_dcm24: dcm24 PORT MAP(
		CLKIN_IN => clk_96,
		CLKDV_OUT => clk_24
	);


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


mem_interface0 : muxed_addr_interface
generic map(ADDR_WIDTH => 16 , DATA_WIDTH => 16)
port map(clk => clk_96 , arazb => arazb_delayed ,
	  data	=> BEAGLE_DATA ,
	  wrn => BEAGLE_WRN, oen => BEAGLE_OEN, addr_en_n => BEAGLE_ALE,  csn => BEAGLE_CSN ,
	  data_bus	=> bus_data ,
	  addr_bus	=> bus_addr ,
	  wr => bus_wr, rd => bus_rd
);






 bi_fifo0 : fifo_peripheral 
			generic map(BASE_ADDR => 0, WIDTH => 16, SIZE => 32)
			port map(
          clk => clk_96,
          arazb => arazb_delayed,
          addr_bus => bus_addr,
          wr_bus => bus_wr,
          rd_bus => bus_rd,
          wrB => fifoB_wr,
          rdA => fifoA_rd,
          data_bus => bus_data,
          inputB => fifo_input,
          outputA => fifo_output,
          emptyA => fifoA_empty,
          fullA => fifoA_full,
          emptyB => fifoB_empty,
          fullB => fifoB_full
        );


fifoA_rd <= '0' ;--NOT tx_buffer_full when bus_wr = '0' else
				--'0' ;
fifo_input <= data_to_read ;


delay_rd0 : generic_latch 
	 generic map(NBIT => 1)
    port map( clk => clk_96 ,
           arazb => arazb ,
           sraz => '0' ,
           en => '1' ,
           d(0) => fifoA_rd ,
           q(0) => send_data) ;

send_addr <= bus_wr ;

send_signal <= send_addr  ;

data_to_send <= bus_addr ;--when send_addr = '1' else
					 --fifo_output ;

	uart_tx0 : uart_tx 
    port map (   data_in => data_to_send(7 downto 0), 
                 write_buffer => send_signal,
                 reset_buffer => NOT arazb_delayed, 
                 en_16_x_baud => clk_1_8,
					  buffer_half_full => tx_buffer_full,
                 serial_out => TXD,
                 clk => clk_96);



delay_wr0 : generic_latch 
	 generic map(NBIT => 1)
    port map( clk => clk_96 ,
           arazb => arazb ,
           sraz => '0' ,
           en => '1' ,
           d(0) => data_present ,
           q(0) => fifoB_wr) ;


	uart_rx0 : uart_rx 
    port map(            serial_in => RXD,
                       data_out => data_to_read(7 downto 0),
                    read_buffer => read_signal,
                   reset_buffer => NOT arazb_delayed,
                   en_16_x_baud => clk_1_8,
            buffer_data_present => data_present,
                            clk => clk_96);

read_signal <= (NOT fifoB_full) when data_present = '1' else
			  '0' ;

end Behavioral;

