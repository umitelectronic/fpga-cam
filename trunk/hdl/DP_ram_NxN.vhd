library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_unsigned.all;



entity DP_ram_NxN is
	 generic(SIZE : natural := 64 ; NBIT : natural := 8; ADDR_WIDTH : natural := 6);
    port (clk  : in std_logic;
          we   : in std_logic;
          a    : in std_logic_vector((ADDR_WIDTH - 1) downto 0);
          dpra : in std_logic_vector((ADDR_WIDTH - 1) downto 0);
          di   : in std_logic_vector((NBIT - 1)  downto 0);
          spo  : out std_logic_vector((NBIT - 1) downto 0);
          dpo  : out std_logic_vector((NBIT - 1) downto 0));
end DP_ram_NxN;


architecture syn of DP_ram_NxN is
    type ram_type is array (0 to (SIZE - 1)) of std_logic_vector ((NBIT - 1) downto 0);
    signal RAM : ram_type;
    signal read_a : std_logic_vector((ADDR_WIDTH - 1) downto 0);
    signal read_dpra : std_logic_vector((ADDR_WIDTH - 1) downto 0);
begin
    process (clk)
    begin
        if (clk'event and clk = '1') then
            if (we = '1') then
                RAM(conv_integer(a)) <= di;
            end if;
            read_a <= a;
            read_dpra <= dpra;
        end if;
    end process;
    spo <= RAM(conv_integer(read_a));
    dpo <= RAM(conv_integer(read_dpra));
end syn;