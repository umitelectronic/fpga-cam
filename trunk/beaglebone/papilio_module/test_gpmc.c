#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/mman.h>
#include <errno.h>
#include <time.h>
#include <linux/ioctl.h>



/* Use 'p' as magic number */
#define PAPILIO_FIFO_IOC_MAGIC 'p'
/* Please use a different 8-bit number in your code */
#define PAPILIO_FIFO_RESET _IO(PAPILIO_FIFO_IOC_MAGIC, 0)


#define PAPILIO_FIFO_PEEK _IOR(PAPILIO_FIFO_IOC_MAGIC, 1, short)
#define PAPILIO_FIFO_NB_FREE _IOR(PAPILIO_FIFO_IOC_MAGIC, 2, short)
#define PAPILIO_FIFO_NB_AVAILABLE _IOR(PAPILIO_FIFO_IOC_MAGIC, 3, short)


int main(int argc, char ** argv){
	int fd ;
	long start_time, end_time ;
	double diff_time ;
	struct timespec cpu_time ;
	int i, page_size ; 

	unsigned short dummy_data [512] ;
	for(i = 0 ; i < 512 ; i ++){
		dummy_data[i] = i ;
	}

	fd = open("/dev/papilio0", O_RDWR | O_SYNC);
	if(fd == -1){
		perror("Error opening file");
		printf("error opening /dev/papilio0 \n");
		exit(EXIT_FAILURE);
	}
	printf("issuing reset to fifo \n");
	ioctl(fd, PAPILIO_FIFO_RESET);
	printf("fifo has nb %d free places \n", ioctl(fd, PAPILIO_FIFO_NB_FREE));
	printf("writing 512 short int \n");
	clock_gettime(CLOCK_REALTIME, &cpu_time);
	start_time = cpu_time.tv_nsec ;
	write(fd, dummy_data, 512*sizeof(unsigned short));
	clock_gettime(CLOCK_REALTIME, &cpu_time);
	end_time = cpu_time.tv_nsec ;
	diff_time = end_time - start_time ;
	diff_time = diff_time/1000000000 ;
	printf("transfer_started at %d, ended at %d \n", start_time, 
end_time);
	printf("transffered %d bytes in %f s : %f B/s \n", 
512*sizeof(unsigned short), diff_time, (512 * sizeof(unsigned 
short))/diff_time);


	printf("reading 512 short int \n");
	clock_gettime(CLOCK_REALTIME, &cpu_time);
	start_time = cpu_time.tv_nsec ;
	read(fd, dummy_data, 512*sizeof(unsigned short));
	clock_gettime(CLOCK_REALTIME, &cpu_time);
	end_time = cpu_time.tv_nsec ;
	diff_time = end_time - start_time ;
	diff_time = diff_time/1000000000 ;
	printf("transfer_started at %d, ended at %d \n", start_time, 
end_time);
	printf("transffered %d bytes in %f s : %f B/s \n", 
512*sizeof(unsigned short), diff_time, (512 * sizeof(unsigned 
short))/diff_time);


	close(fd);
	return 0 ;
}
