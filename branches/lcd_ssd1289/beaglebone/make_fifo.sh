#!/bin/sh

./addr_mux.sh
insmod papilio_fifo.ko 
mknod /dev/papilio0 c 246 0
