#!/bin/sh

# configuring mux
echo 0x20 > /sys/kernel/debug/omap_mux/gpmc_ad0
echo 0x20 > /sys/kernel/debug/omap_mux/gpmc_ad1
echo 0x20 > /sys/kernel/debug/omap_mux/gpmc_ad10
echo 0x20 > /sys/kernel/debug/omap_mux/gpmc_ad11
echo 0x20 > /sys/kernel/debug/omap_mux/gpmc_ad12
echo 0x20 > /sys/kernel/debug/omap_mux/gpmc_ad13
echo 0x20 > /sys/kernel/debug/omap_mux/gpmc_ad14
echo 0x20 > /sys/kernel/debug/omap_mux/gpmc_ad15
echo 0x20 > /sys/kernel/debug/omap_mux/gpmc_ad2
echo 0x20 > /sys/kernel/debug/omap_mux/gpmc_ad3
echo 0x20 > /sys/kernel/debug/omap_mux/gpmc_ad4
echo 0x20 > /sys/kernel/debug/omap_mux/gpmc_ad5
echo 0x20 > /sys/kernel/debug/omap_mux/gpmc_ad6
echo 0x20 > /sys/kernel/debug/omap_mux/gpmc_ad7
echo 0x20 > /sys/kernel/debug/omap_mux/gpmc_ad8
echo 0x20 > /sys/kernel/debug/omap_mux/gpmc_ad9


echo 0x27 > /sys/kernel/debug/omap_mux/lcd_data0
echo 0x27 > /sys/kernel/debug/omap_mux/lcd_data1
echo 0x27 > /sys/kernel/debug/omap_mux/lcd_data2
echo 0x27 > /sys/kernel/debug/omap_mux/lcd_data3
echo 0x27 > /sys/kernel/debug/omap_mux/lcd_data4
echo 0x27 > /sys/kernel/debug/omap_mux/lcd_data5
echo 0x27 > /sys/kernel/debug/omap_mux/lcd_data6
echo 0x27 > /sys/kernel/debug/omap_mux/lcd_data7


#echo 0x27 > /sys/kernel/debug/omap_mux/i2c0_sda
#echo 0x27 > /sys/kernel/debug/omap_mux/uart1_rxd
echo 0x27 > /sys/kernel/debug/omap_mux/spi0_sclk
echo 0x27 > /sys/kernel/debug/omap_mux/spi0_d1




echo 0x17 > /sys/kernel/debug/omap_mux/mcasp0_fsx
echo 0x17 > /sys/kernel/debug/omap_mux/mcasp0_aclkx

echo 110 > /sys/class/gpio/export #SERIAL CONFIG CLK
echo 111 > /sys/class/gpio/export #SERIAL CONFIG DATA OUT

echo out > /sys/class/gpio/gpio110/direction #clock is out
echo 0 > /sys/class/gpio/gpio110/value #clock is zero

echo out > /sys/class/gpio/gpio111/direction #data is out
echo 0 > /sys/class/gpio/gpio111/value #data is zero



echo 0x00 > /sys/kernel/debug/omap_mux/gpmc_advn_ale
#echo 0x00 > /sys/kernel/debug/omap_mux/gpmc_ben0_cle
#echo 0x04 > /sys/kernel/debug/omap_mux/gpmc_ben1
echo 0x00 > /sys/kernel/debug/omap_mux/gpmc_clk
#echo 0x20 > /sys/kernel/debug/omap_mux/gpmc_csn0
echo 0x20 > /sys/kernel/debug/omap_mux/gpmc_csn1
#echo 0x20 > /sys/kernel/debug/omap_mux/gpmc_csn2
#echo 0x20 > /sys/kernel/debug/omap_mux/gpmc_csn3
echo 0x20 > /sys/kernel/debug/omap_mux/gpmc_oen_ren
#echo 0x20 > /sys/kernel/debug/omap_mux/gpmc_wait0
echo 0x20 > /sys/kernel/debug/omap_mux/gpmc_wen
#echo 0x20 > /sys/kernel/debug/omap_mux/gpmc_wpn





# CLKOUT2 - gpio0_20
echo 20 > /sys/class/gpio/export 
echo out > /sys/class/gpio/gpio20/direction
echo 0 > /sys/class/gpio/gpio20/value
#echo 20 > /sys/class/gpio/unexport
# GPMC_DIR - gpio1_28
echo 60 > /sys/class/gpio/export 
echo out > /sys/class/gpio/gpio60/direction
echo 0 > /sys/class/gpio/gpio60/value
#echo 60 > /sys/class/gpio/unexport
# CSN1 - Chip select 1 - gpio1_30
echo 62 > /sys/class/gpio/export 
echo out > /sys/class/gpio/gpio62/direction
echo 1 > /sys/class/gpio/gpio62/value
#echo 62 > /sys/class/gpio/unexport
# GPMC CLK - GPIO 2_1 - NOT USED
echo 65 > /sys/class/gpio/export
echo out > /sys/class/gpio/gpio65/direction
echo 1 > /sys/class/gpio/gpio65/value
#echo 65 > /sys/class/gpio/unexport
# LATCH ENABLE GPIO 2_2 
echo 66 > /sys/class/gpio/export
echo out > /sys/class/gpio/gpio66/direction
echo 1 > /sys/class/gpio/gpio66/value
#echo 66 > /sys/class/gpio/unexport
# READ ENABLE gpio_2_3
echo 67 > /sys/class/gpio/export
echo out > /sys/class/gpio/gpio67/direction
echo 1 > /sys/class/gpio/gpio67/value
#echo 67 > /sys/class/gpio/unexport
# WRITE ENABLE gpio_2_4
echo 68 > /sys/class/gpio/export
echo out > /sys/class/gpio/gpio68/direction
echo 1 > /sys/class/gpio/gpio68/value
#echo 68 > /sys/class/gpio/unexport
# BEN0 - gpio 2_5 - NOT USED
#echo 69 > /sys/class/gpio/export
#echo out > /sys/class/gpio/gpio69/direction
#echo 0 > /sys/class/gpio/gpio69/value
#echo 69 > /sys/class/gpio/unexport
