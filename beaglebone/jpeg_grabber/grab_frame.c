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
#define PAPILIO_FIFO_IOC_MAGIC 'p'
/* Please use a different 8-bit number in your code */
#define PAPILIO_FIFO_RESET _IO(PAPILIO_FIFO_IOC_MAGIC, 0)


#define PAPILIO_FIFO_PEEK _IOR(PAPILIO_FIFO_IOC_MAGIC, 1, short)
#define PAPILIO_FIFO_NB_FREE _IOR(PAPILIO_FIFO_IOC_MAGIC, 2, short)
#define PAPILIO_FIFO_NB_AVAILABLE _IOR(PAPILIO_FIFO_IOC_MAGIC, 3, short)


#define GRAB_SIZE ((320*240) * 3)

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
	int i, hsync_count = 0 ; ;
	unsigned short testVsync = 0 ; 
	unsigned char vsyncFound = 0 ;
	unsigned int pos = 0 ;
	unsigned char reception_buffer[GRAB_SIZE] ; 
	unsigned char image_buffer[(320*240)] ; //monochrome frame buffer
	

	fd = open("/dev/papilio0", O_RDWR | O_SYNC);
	jpeg_fd  = fopen("./grabbed_frame.jpg", "w");
	if(fd == -1 || jpeg_fd == NULL){
		perror("Error opening file");
		printf("error opening /dev/papilio0 \n");
		exit(EXIT_FAILURE);
	}
	printf("issuing reset to fifo \n");
	ioctl(fd, PAPILIO_FIFO_RESET);
	/*while(testVsync != 0xAA55){
		read(fd, &testVsync, sizeof(unsigned short));	
	}
	printf("found vsync !");*/
	clock_gettime(CLOCK_REALTIME, &cpu_time);
	start_time = cpu_time.tv_nsec ;
	while(pos < GRAB_SIZE){
		i = read(fd, &reception_buffer[pos], min(1024*(sizeof(unsigned short)), (GRAB_SIZE - pos)));	
		if(i > 0){	
			pos += i;	
		}
	}
	clock_gettime(CLOCK_REALTIME, &cpu_time);
	end_time = cpu_time.tv_nsec ;
	diff_time = end_time - start_time ;
	diff_time = diff_time/1000000000 ;
	printf("transffered %d bytes in %f s : %f B/s \n", GRAB_SIZE, diff_time, GRAB_SIZE/diff_time);
	
	pos = 0 ;
	vsyncFound = 0 ;
	for(i = 0 ; i < GRAB_SIZE && pos < (320*240) ; i +=2){
		unsigned short * shortVal ;
		shortVal = &reception_buffer[i] ;
		if(vsyncFound == 0 && *shortVal == 0xAA55){
			printf("found vsync ! \n");			
			vsyncFound = 1 ;
		}else if(vsyncFound == 1 && *shortVal == 0x55AA){
			hsync_count ++ ;
			memcpy(&image_buffer[pos], &reception_buffer[i+2], 320*sizeof(unsigned char));
			pos += 320 ;
		}
	}
	printf("found %d hsync \n", hsync_count);
	write_jpegfile(image_buffer, 320, 240, jpeg_fd, 100);
	close(fd);
	fclose(jpeg_fd);
	return 0 ;
}
