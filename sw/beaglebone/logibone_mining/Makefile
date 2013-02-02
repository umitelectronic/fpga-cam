#Compiler to use
CC=gcc
#Compiler Flags
CFLAGS=-c #-Wall

all: serial_fpga_loader

setup_gpmc: serial_fpga_loader.o
	$(CC) -o serial_fpga_loader serial_fpga_loader.o

setup_gpmc.o: serial_fpga_loader.c
	$(CC) $(CFLAGS) serial_fpga_loader.c


clean:
	rm -rf *o serial_fpga_loader
