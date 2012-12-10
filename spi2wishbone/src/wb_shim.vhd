----------------------------------------------------------------------------------
-- Company: 		 N/A
-- Engineer: 		 Brian Wiec
-- Create Date:    16:02:13 12/08/2012 
-- Design Name: 	 spi2wishbone
-- Module Name:    wb_shim - Behavioral 
-- Project Name: 	 Mark-1
-- Target Devices: xc6slx9
-- Tool versions:  ISE 14.3
-- Description:	 This module implements the shim/glue logic between the
--						 spi_slave module and the Wishbone interface (from the Wishbone
--						 B4 spec)
-- Dependencies:   None
-- Revision:
--						 - Revision 1.01 - 12/08/12 - Meets timing at 125MHz
--						 - Revision 1.00 - 12/08/12 - Behavioral Simulation Verified
-- 					 - Revision 0.01 - File Created
-- Additional Comments: 
--						 - tgc signal kept to support future implementation of burst 
--							transfers
--	To Do:
--						 - Add another wishbone interface for sending data from CPU to 
--							FPGA
----------------------------------------------------------------------------------

library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity wb_shim is
	generic
	(   
        N    		 : positive := 32; 			-- Wishbone data width AND SPI serial data length
		  ADDR_WIDTH : positive := 32; 			-- Width of wishbone address bus
		  ADDR 		 : unsigned := X"00000000" -- Address that WB master presents on the interface during transactitons
	);
	port 
	(
		----- SPI User Interface Signals -----	
		spi_di_req_i   : in  std_logic;                                       	 -- preload lookahead data request line
		spi_di_o 		: out std_logic_vector (N-1 downto 0) := (others => 'X'); -- parallel load data in (clocked in on rising edge of clk_i)
		spi_wren_o 	   : out std_logic 							  := 'X';             -- user data write enable
		spi_wr_ack_i   : in  std_logic;                                       	 -- write acknowledge
		spi_do_valid_i : in  std_logic;                                     		 -- do_o data valid strobe, valid during one clk_i rising edge.
		spi_do_i 		: in  std_logic_vector (N-1 downto 0);                    -- parallel output (clocked out on falling clk_i)
       
		----- Wishbone Interface Signals -----
		wb_clk    : in  std_logic;
		wb_rst 	 : in  std_logic;
		wb_adr_o0 : out std_logic_vector (ADDR_WIDTH-1 downto 0); -- Address output
		wb_dat_i0 : in  std_logic_vector (N-1 			  downto 0); -- Data input
		wb_we_o 	 : out std_logic;											 -- Indicates if current bus cycle is a write or a read. 1 = Write, 0 = Read
		wb_sel_o0 : out std_logic;											 -- Byte enables. Width depends on granulatity of data
		wb_stb_o  : out std_logic;											 -- Indicates valid transfer cycle
		wb_ack_i  : in  std_logic; 										 -- Acknowledge from slave
		wb_cyc_o  : out std_logic; 										 -- Indicates a valid bus cycle is in process
		wb_tgc_o  : out std_logic	 										 -- Cycle tag, eventually to support burst transfers. Qualified by stb
	);
	end wb_shim;

architecture Behavioral of wb_shim is

	----- Internal Signals -----
   type STATE_TYPE is 
	(
		IDLE, 	-- Waiting for spi_slave module to request data from user logic
		REQ_DATA -- Requesting data from user logic on the WB interface
	);
   signal state   : STATE_TYPE;
begin

	----- Constant assignments -----
	wb_adr_o0 <= std_logic_vector(ADDR);
	wb_we_o	 <= '0'; -- Always performing a read
	wb_sel_o0 <= '1'; -- Since granularity is the entire data interface, just set to 1;
	wb_tgc_o  <= '0'; -- Currently, only single transfers per request are supported
	
	----- Controller -----
	fsm : process (wb_clk)
	begin
		if rising_edge(wb_clk) then
			if (wb_rst = '1') then
				state <= IDLE;
			else
				-- Default assignments
				state 	  <= state;
				wb_cyc_o   <= '0';
				wb_stb_o   <= '0';
				spi_wren_o <= '0';
				
				case state is
					when IDLE =>
						if (spi_di_req_i = '1') then -- spi_slave module ready to accept data
							state <= REQ_DATA;
						else
							state <= IDLE;
						end if;
					when REQ_DATA =>
						wb_cyc_o  <= '1';
						wb_stb_o  <= '1';
						spi_di_o  <= wb_dat_i0;
						
						if (wb_ack_i = '1') then -- wb slave is presenting valid data
							spi_wren_o <= '1';
							state 	  <= IDLE;
						else
							spi_wren_o <= '0';
							state 	  <= REQ_DATA;
						end if;
					when others =>
						state 	  <= IDLE;
						wb_cyc_o   <= 'X';
						wb_stb_o   <= 'X';
						spi_wren_o <= 'X';
				end case;
			end if;
		end if;
	end process;

end Behavioral;

