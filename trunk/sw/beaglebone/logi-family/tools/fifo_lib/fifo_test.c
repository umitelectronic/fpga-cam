#include "fifolib.h"


int main(int argc, char ** argv){
	fifo_open(0);
	fifo_open(1);
	printf("fifo 0 is %d large and contains %d tokens \n", fifo_getSize(0), fifo_getNbAvailable(0));
	printf("fifo 1 is %d large and contains %d tokens \n", fifo_getSize(1), fifo_getNbAvailable(1));
	fifo_close(1);
	fifo_close(0);
}
