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
#include "fifolib.h"


#define IMAGE_WIDTH 320
#define IMAGE_HEIGHT 240

#define TRANSFER_SIZE 1024


int min(int a, int b){
	if(a > b ){
		return b ;	
	}
	return a ;
}

int main(int argc, char ** argv){
	int fifo_fd ;
	unsigned char * inputImage ;
	long start_time, end_time, intermediate1, intermediate2 ;
	double diff_time ;
	struct timespec cpu_time ;

	FILE * jpeg_fd ;
	FILE * raw_file ;
	int i, res ;
	unsigned char image_buffer[(320*240)] ; //monochrome frame buffer
	fifo_fd = fifo_open();
	// pointer to gpmc is allocated
	jpeg_fd  = fopen("./grabbed_frame.jpg", "w");
	if(jpeg_fd == NULL){
		perror("Error opening output file");
		exit(EXIT_FAILURE);
	}
	printf("output file openened \n");
	printf("loading input file : %s \n", argv[1]);
	res = read_jpeg_file( argv[1], &inputImage);
	if(res < 0){
		perror("Error opening input file");
		exit(EXIT_FAILURE);
	}
	
	fifo_reset(fifo_fd);
	printf("free : %d \n", fifo_getNbFree(fifo_fd));
	clock_gettime(CLOCK_REALTIME, &cpu_time);
	start_time = cpu_time.tv_nsec ;
	 for(i = 0 ; i < ((IMAGE_HEIGHT*IMAGE_WIDTH)/TRANSFER_SIZE) ; i ++){
		clock_gettime(CLOCK_REALTIME, &cpu_time);
        	intermediate1 = cpu_time.tv_nsec ; 
		if( fifo_write(fifo_fd, (void *) &inputImage[i*TRANSFER_SIZE], TRANSFER_SIZE) < 0) printf("transfer error \n") ;
                clock_gettime(CLOCK_REALTIME, &cpu_time);
		intermediate2 = cpu_time.tv_nsec ;
		diff_time = intermediate2 - intermediate1 ;                                 
        	diff_time = diff_time/1000000000 ;
		printf("%f B/s \n", ((int) TRANSFER_SIZE)/diff_time);
		//while(fifo_getNbAvailable(fifo_fd) < TRANSFER_SIZE) ;//printf("%d \n", fifo_getNbAvailable(fifo_fd));
		if( fifo_read(fifo_fd, (void *)  &image_buffer[i*TRANSFER_SIZE], TRANSFER_SIZE) < 0) printf("transfer error \n");
        }
	clock_gettime(CLOCK_REALTIME, &cpu_time);
	printf("available : %d \n", fifo_getNbAvailable(fifo_fd));
	end_time = cpu_time.tv_nsec ;
	diff_time = end_time - start_time ;
	diff_time = diff_time/1000000000 ;
	printf("transffered %d bytes in %f s : %f B/s \n", 2 * 
IMAGE_WIDTH * 
IMAGE_HEIGHT, diff_time, (IMAGE_WIDTH * IMAGE_HEIGHT * 2)/diff_time);
	write_jpegfile(image_buffer, 320, 240, jpeg_fd, 100);
	close(fifo_fd);
	fclose(jpeg_fd);
	return 0 ;
}
