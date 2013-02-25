#!/bin/sh
chmod 777 addr_mux_mark1.sh
./addr_mux_mark1.sh
make
./serial_loader mark1_beaglebone_mining.bit
cd config_gpmc
make
./setup_gpmc
cd ../
#opkg install python-json python-mmap
sudo apt-get install python-json python-mmap
echo "wait for the following script to end"
echo "result should be : nonce :7a33330e "
python logibone.py
echo "1) Create an account on mining pool (tested on btcguild and bitlc)"
echo "2) Configure a worker on the pool website"
echo "3) Fill config.py with your worker configuration"
echo "4) Launch python logibone_miner.py and wait to get rich ..."
echo "INFO: the hashrate (~1.8MHash/s) is intentionnaly limited to prevent the FPGA from overheating."
echo "Because of the low hashrate (compared to bigger FPGA or ASIC), expect to wait some time before getting a valid share ..."

