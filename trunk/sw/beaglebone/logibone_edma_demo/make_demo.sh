#!/bin/sh
./addr_mux.sh
cd jpeg_grabber
make
cd ../edma_module
insmod logibone_edma_fifo.ko
mknod /dev/logibone0 c 246 0

