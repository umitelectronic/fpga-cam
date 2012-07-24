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


#define SEND_SIZE	2048

int main(int argc, char ** argv){
	int fd ;
	long start_time, end_time ;
	double diff_time ;
	struct timespec cpu_time ;
	int i, page_size, nbRead ; 
	char readWord [2];

	unsigned char dummy_data [SEND_SIZE + 1] ;
	unsigned char receive_data [SEND_SIZE + 1] ; 
	dummy_data[SEND_SIZE] = '\0' ;
	receive_data[SEND_SIZE] = '\0' ;
	for(i = 0 ; i < SEND_SIZE ; i ++){
		dummy_data[i] = i + 255;
		printf("%x, ", dummy_data[i]);
	}
	printf("\n");
	fd = open("/dev/papilio0", O_RDWR | O_SYNC);
	if(fd == -1){
		perror("Error opening file");
		printf("error opening /dev/papilio0 \n");
		exit(EXIT_FAILURE);
	}
	printf("issuing reset to fifo \n");
	ioctl(fd, PAPILIO_FIFO_RESET);
	printf("fifo has nb %d free places \n", ioctl(fd, PAPILIO_FIFO_NB_FREE));
	printf("fifo has nb %d available tokens \n", ioctl(fd, PAPILIO_FIFO_NB_AVAILABLE));
	printf("fifo peek %d \n", ioctl(fd, PAPILIO_FIFO_PEEK));
	printf("writing to fifo \n");
	write(fd, dummy_data, SEND_SIZE);
	printf("fifo has %d available tokens \n", ioctl(fd, PAPILIO_FIFO_NB_AVAILABLE));
	getchar();
	nbRead = read(fd, receive_data, SEND_SIZE);
	printf("%d effective reads \n", nbRead);
	dummy_data[nbRead] = '\0';
	unsigned int errors = 0 ;
	for(i = 0 ; i < SEND_SIZE ; i ++){
		if(dummy_data[i] != receive_data[i]){
			errors ++ ;
		} 
		printf("%x, ", receive_data[i]); 
	}
	printf("\n");
	printf("%d errors", errors);
	
	close(fd);
	return 0 ;
}
