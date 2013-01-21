#Compiler to use
CC=gcc
#Compiler Flags
CFLAGS=-c #-Wall
#Linker Flags
LDFLAGS= -ljpeg -lrt

all: logibone_demo

logibone_demo: logibone_image_demo.o jpeg_func.o fifolib.o
	$(CC) -o logibone_demo logibone_image_demo.o jpeg_func.o fifolib.o $(LDFLAGS) 

logibone_image_demo.o: logibone_image_demo.c
	$(CC) $(CFLAGS) logibone_image_demo.c

jpeg_func.o: jpeg_func.c
	$(CC) $(CFLAGS) jpeg_func.c

fifolib.o: fifolib.c
	$(CC) $(CFLAGS) fifolib.c

clean:
	rm -rf *o logibone_demo
