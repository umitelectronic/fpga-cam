#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/mman.h>
#include <errno.h>

#define MEM_BASE_ADDR	 0x09000000



int main(int argc, char ** argv){
	int fd ;
	int i, page_size ;
	unsigned short fifo_state, fifo_data ;
	volatile unsigned short * gpmc_pointer ; 

	unsigned short dummy_data [10] ;

	fd = open("/dev/mem", O_RDWR | O_SYNC);
	if(fd == -1){
		perror("Error opening file");
		printf("error opening /dev/mem \n");
		exit(EXIT_FAILURE);
	}


	page_size = getpagesize();
	printf("page size is : %d \n", page_size);

	gpmc_pointer = (volatile unsigned short *) mmap(0, page_size, 
PROT_READ | 
	PROT_WRITE, 
	MAP_SHARED ,fd, 
	MEM_BASE_ADDR);
	if(gpmc_pointer == -1){
		printf("cannot allocate pointer on %x \n", MEM_BASE_ADDR);
		exit(EXIT_FAILURE);
	}
	printf("pointer allocated with address %x \n", gpmc_pointer);
	fifo_state = gpmc_pointer[4];
	printf("fifo size is %d \n", fifo_state);
	for(i = 0 ; i < 512 ; i ++){
		gpmc_pointer[0] = i ;
	}
	fifo_state = gpmc_pointer[6];
	printf("fifo nb available %d \n", fifo_state);
	for(i = 0 ; i < fifo_state ; i ++){
		fifo_data = gpmc_pointer[0] ;
		printf("reading %x from fifo \n", fifo_data);
	}
	munmap((void *) gpmc_pointer, page_size);
	close(fd);
	return 0 ;
}
