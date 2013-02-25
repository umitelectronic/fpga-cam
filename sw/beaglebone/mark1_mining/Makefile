#Compiler to use
CC=gcc
#Compiler Flags
CFLAGS=-c #-Wall
#Linker Flags
LDFLAGS= #-lrt

all: serial_loader

serial_loader: serial_fpga_loader.o
	$(CC) -o  serial_loader serial_fpga_loader.o 

serial_fpga_loader.o: serial_fpga_loader.c
	$(CC) $(CFLAGS) serial_fpga_loader.c

clean:
	rm -rf *o serial_loader
