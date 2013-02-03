#!/bin/sh
./addr_mux.sh
./addr_mux.sh
./addr_mux.sh
cd config_gpmc
make
./setup_gpmc
cd ../jpeg_grabber
make
