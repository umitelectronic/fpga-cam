----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    16:45:50 10/16/2012 
-- Design Name: 
-- Module Name:    HARRIS_LINE_ACC - Behavioral 
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

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity HARRIS_LINE_ACC is
generic(NB_LINE : positive := 4);
port(clk, resetn : in std_logic ;
	  rewind_acc	:	in std_logic ;
	  wr_acc	:	in std_logic ;
	  gradx_square_in, grady_square_in, gradxy_in: in signed(15 downto 0);
	  gradx_square_out, grady_square_out, gradxy_out: out vec_16s
	  )
end HARRIS_LINE_ACC;

architecture RTL of HARRIS_LINE_ACC is
type vec_16s is array(0 to NB_LINE) of signed(15 downto 0);
begin


end RTL;

