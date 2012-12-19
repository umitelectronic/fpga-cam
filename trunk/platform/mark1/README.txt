beaglebone_mark1_demo

demo 1 : Communication testing
The first project uses mark1_beaglebone_demo.vhd for top level design. This project is used to validate communication and evaluate bandwidth.
The architecture is made of a mux address interface, a fifo peripheral and an adressable latch. When writing to the fifo, the 16bit data is byte swapped (0xAA55 => 0x55AA) and written back to the output fifo. Thus when reading the fifo the design returns teh byte swapped data. When writing to the latch the 8 lsb control the mark1 leds. Reading the latch returns the dipswitch + push_button values (no debouncing).

Demo setup :
pre-requisite: A mark1 board, a beaglebone with demo image (http://downloads.angstrom-distribution.org/demo/beaglebone/) loaded onto sdcard. gcc installed on beaglebone (opkg install gcc).
FPGA side : 
1) compile the top level of the project and load the FPGA (project should not show error and some warning)
2) after loading nothing led(7) should be blinking on the MARK1
Beaglebone side:
1) copy the sw/beaglebone directory to your beaglebone home
2) connect to your beaglebone as root (through serial or ssh) and go to the scripts directory and execute the addr_mux.sh script
3) go to the config_gpmc folder and  compile setup_gpmc.c : gcc -o setup_gpmc setup_gpmc.c
4) execute setup_gpmc
5) press push button 0 on the MARK1 (reset)
6) go to the base directory and compile test_gpmc_fifo.c : gcc -o test_gpmc_fifo test_gpmc_fifo.c
7) execute test_gpmc_user, output should be
	pointer allocated with address ---
	fifo size is 1024
	fifo nb available is 512
8) compile test_gpmc_led.c : gcc -o test_gpmc_led test_gpmc_led.c
9) execute test_gpmc_led leds should be blinking 32 times


Troubleshooting:
If excuting the beaglebone scripts/code fails :
1) verify that you are root
2) ... mail me !

