#!/bin/sh
./addr_mux.sh
cd config_gpmc
make
./setup_gpmc
cd ../
opkg install python-curses python-json python-mmap
#apt-get install python-curses python-json python-mmap
echo "wait for the following script to end"
echo "result should be {21, 51, 51, 14}"
python Logibone.py
echo "complete config.py with your worker configuration"
echo "then launch python logibone_miner.py"

