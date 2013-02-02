#!/bin/sh
./addr_mux.sh
make
./serial_fpga_loader logibone_mining.bit
cd config_gpmc
make
./setup_gpmc
cd ../
opkg install python-json python-mmap
#sudo apt-get install python-json python-mmap
echo "wait for the following script to end"
echo "result should be {21, 51, 51, 14}"
python logibone.py
echo "complete config.py with your worker configuration"
echo "then launch python logibone_miner.py"

