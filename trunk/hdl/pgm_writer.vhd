----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    10:00:14 10/16/2012 
-- Design Name: 
-- Module Name:    pgm_writer - Behavioral 
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
library STD;
use STD.textio.all;                     -- basic I/O

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;
use IEEE.std_logic_textio.all;          -- I/O for logic types

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity pgm_writer is
	generic(WRITE_PATH : STRING );
port(
 		clk : in std_logic; 
 		resetn : in std_logic; 
 		pixel_clock, hsync, vsync : in std_logic; 
 		value_in : in std_logic_vector(15 downto 0 )
);
end pgm_writer;

architecture Behavioral of pgm_writer is
file pgmfile           : text OPEN write_mode IS WRITE_PATH;

signal hsync_old, hsync_re : std_logic ;
begin

	PROCESS (clk, resetn)
    VARIABLE vDataout     : integer;   -- variable written to line 
    VARIABLE vDataoutline : line;                     -- line variable written to file
	 BEGIN
		if resetn = '0' then
			
		elsif clk'event and clk = '1' then 
			if hsync_re = '1' then 
				writeline (pgmfile, vDataoutline);
			elsif pixel_clock = '1' and hsync = '0' then 
				 if signed(value_in) > 0 then
					vDataout := to_integer(signed(value_in)); 
				 else
					vDataout := 0; 
				 end if ;
				 write (vDataoutline, vDataout);               -- write variable to line 
				 write (vDataoutline, string'(", "));               -- write variable to line
			end if ;
		end if ;
  END PROCESS;
  
  PROCESS (clk, resetn)
	 BEGIN
		if resetn = '0' then
			hsync_old <= '0' ;
		elsif clk'event and clk = '1' then  
			hsync_old <= hsync; 
		end if ;
  END PROCESS;
  hsync_re <= hsync and (NOT hsync_old);

end Behavioral;

