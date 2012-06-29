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


#define MEM_BASE_ADDR	 0x09000000


int main(int argc, char ** argv){
	int fd ;
	long start_time, end_time ;
	double diff_time ;
	struct timespec cpu_time ;
	int i, page_size ;
	volatile unsigned short * gpmc_pointer ; 

	unsigned short dummy_data [100] ;
	for(i = 0 ; i < 100 ; i ++){
		dummy_data[i] = i ;
	}

	fd = open("/dev/mem", O_RDWR | O_SYNC);
	if(fd == -1){
		perror("Error opening file");
		printf("error opening /dev/mem \n");
		exit(EXIT_FAILURE);
	}


	page_size = getpagesize();
	printf("page size is : %d \n", page_size);
	//sleep(1);
	gpmc_pointer = (volatile unsigned short *) mmap(0, page_size, PROT_READ | PROT_WRITE, 
	MAP_SHARED ,fd, 
	MEM_BASE_ADDR);
	if(gpmc_pointer == -1){
		printf("cannot allocate pointer on %x \n", MEM_BASE_ADDR);
		exit(EXIT_FAILURE);
	}
	printf("pointer allocated with address %x \n", gpmc_pointer);
	printf("nb free in fifo %d \n", gpmc_pointer[1]);
	printf("writing 100 short int \n");
	clock_gettime(CLOCK_REALTIME, &cpu_time);
	start_time = cpu_time.tv_nsec ;
	//memcpy((void *) gpmc_pointer, (void *) dummy_data, 100 * sizeof(unsigned short));
	for(i = 0 ; i < 100 ; i++){
		gpmc_pointer[0] = i ;
	}
	clock_gettime(CLOCK_REALTIME, &cpu_time);
	end_time = cpu_time.tv_nsec ;
	diff_time = end_time - start_time ;
	diff_time = diff_time/1000000000 ;
	printf("transfer_started at %d, ended at %d \n", start_time, 
end_time);
	printf("transffered %d bytes in %f s : %f B/s \n", 
100*sizeof(unsigned short), diff_time, (100 * sizeof(unsigned 
short))/diff_time);
	printf("nb free in fifo  %d \n", gpmc_pointer[1]);
	printf("nb available in fifo	%d \n", gpmc_pointer[2]);
	printf("reading from fifo : ");
	for( i = 0 ; i < 100 ; i ++ ){
		printf("%d, ", gpmc_pointer[0]);	
	}
	printf("\n");	
	printf("nb available in fifo %d \n", gpmc_pointer[2]);
	munmap((void *) gpmc_pointer, page_size);
	close(fd);
	return 0 ;
}
