#!/bin/sh
chmod 777 addr_mux.sh
./addr_mux.sh
make
./serial_fpga_loader ./logibone_canny.bit
cd config_gpmc
make
./setup_gpmc
cd ../jpeg_grabber
make
