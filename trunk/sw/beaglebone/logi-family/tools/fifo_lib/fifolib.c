#include "fifolib.h"


int fifo_open(){
	int fd = open("/dev/logibone0", O_RDWR | O_SYNC);
	if(fd == -1){
		perror("Error opening file");
		printf("error opening /dev/papilio0 \n");
	}
	ioctl(fd, PAPILIO_FIFO_MODE) ;
	return fd ;
}

int fifo_write(int fd, char * data, unsigned int count){
	return write(fd, data, count);
}

int fifo_read(int fd, char * data, unsigned int count){
	return read(fd, data, count);
}

void fifo_reset(int fd){
	printf("issuing reset to fifo \n");
	ioctl(fd, LOGIBONE_FIFO_RESET);
}

unsigned int fifo_getNbFree(int fd){
 return ioctl(fd, LOGIBONE_FIFO_NB_FREE);
}


unsigned int fifo_getNbAvailable(int fd){
	return ioctl(fd, PAPILIO_FIFO_NB_AVAILABLE);
}

