#include <unistd.h>
#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/mman.h>
#include <errno.h>
#include <time.h>
#include <linux/ioctl.h>

#include "jpeg_func.h"


/* Use 'p' as magic number */
#define LOGIBONE_FIFO_IOC_MAGIC 'p'
/* Please use a different 8-bit number in your code */
#define LOGIBONE_FIFO_RESET _IO(LOGIBONE_FIFO_IOC_MAGIC, 0)


#define LOGIBONE_FIFO_PEEK _IOR(LOGIBONE_FIFO_IOC_MAGIC, 1, short)
#define LOGIBONE_FIFO_NB_FREE _IOR(LOGIBONE_FIFO_IOC_MAGIC, 2, short)
#define LOGIBONE_FIFO_NB_AVAILABLE _IOR(LOGIBONE_FIFO_IOC_MAGIC, 3, short)


#define GRAB_SIZE ((320*240) * 2)

int min(int a, int b){
	if(a > b ){
		return b ;	
	}
	return a ;
}

int main(int argc, char ** argv){
	int fd;

	long start_time, end_time ;
	double diff_time ;
	struct timespec cpu_time ;

	FILE * jpeg_fd ;
	FILE * raw_file ;
	int i, hsync_count = 0 ; ;
	unsigned short testVsync = 0 ; 
	unsigned char vsyncFound = 0 ;
	unsigned char hsyncFound = 0 ;
	unsigned int pos = 0 ;
	unsigned char reception_buffer[GRAB_SIZE] ; 
	unsigned char image_buffer[(320*240)] ; //monochrome frame buffer
	

	fd = open("/dev/logibone0", O_RDWR | O_SYNC);
	jpeg_fd  = fopen("./grabbed_frame.jpg", "w");
	//raw_fd = fopen("./raw_data.txt", "w");
	if(fd == -1 || jpeg_fd == NULL){
		perror("Error opening file");
		printf("error opening /dev/LOGIBONE0 \n");
		exit(EXIT_FAILURE);
	}
	printf("issuing reset to fifo \n");
	//ioctl(fd, LOGIBONE_FIFO_RESET);
	clock_gettime(CLOCK_REALTIME, &cpu_time);
	start_time = cpu_time.tv_nsec ;
	//while(pos < GRAB_SIZE){
		i = read(fd, &reception_buffer[pos], GRAB_SIZE);	
		//if(i > 0){	
		//	pos += i;	
		//}
	//}
	pos = i ;
	if(i < 0){
		printf("error in grabing \n");
	}
	clock_gettime(CLOCK_REALTIME, &cpu_time);
	end_time = cpu_time.tv_nsec ;
	diff_time = end_time - start_time ;
	diff_time = diff_time/1000000000 ;
	printf("transffered %d bytes in %f s : %f B/s \n", GRAB_SIZE, diff_time, GRAB_SIZE/diff_time);
	
	pos = 0 ;
	vsyncFound = 0 ;
	i = 0 ;
	while(!vsyncFound && i < GRAB_SIZE){
		unsigned short * shortVal ;
		shortVal = &reception_buffer[i];
		if(*shortVal == 0xAA55){
			vsyncFound = 1 ;
			printf("vsync found ! \n");
			memcpy(image_buffer, &reception_buffer[i+2], 320*240 );
		}
		i ++ ;
	}
	write_jpegfile(image_buffer, 320, 240, jpeg_fd, 100);
	close(fd);
	fclose(jpeg_fd);
	return 0 ;
}
