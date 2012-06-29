#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/mman.h>
#include <errno.h>
#include "hw_cm_per.h"
#include "hw_gpmc.h"
#include "soc_AM335x.h"

#define MEM_BASE_ADDR	 0x09000000


#define HWREG(x)	(*((volatile unsigned int *)(x)))

void setupGPMCClock(void){
 
   printf("Configuring Clock for GPMC \n");   
   sleep(1);
   int fd = open("/dev/mem", O_RDWR | O_SYNC);   
	
   volatile unsigned int * prcm_reg_pointer = (volatile unsigned int 
*) mmap(0, getpagesize(), PROT_READ | PROT_WRITE, MAP_SHARED ,fd, 
SOC_PRCM_REGS);
   if(prcm_reg_pointer == -1){
 	printf( "%s\n", strerror( errno ) );
	printf("cannot allocate pointer SOC_PRCM_REGS at %x \n", SOC_PRCM_REGS);
	exit(EXIT_FAILURE);
   }
	
  //enable clock to GPMC module
    HWREG(prcm_reg_pointer + CM_PER_GPMC_CLKCTRL/4 ) |=
        		CM_PER_GPMC_CLKCTRL_MODULEMODE_ENABLE;
    //check to see if enabled
   printf("CM_PER_GPMC_CLKCTRL value :%x \n", HWREG(prcm_reg_pointer + 
CM_PER_GPMC_CLKCTRL/4)); 
   while((HWREG(prcm_reg_pointer + CM_PER_GPMC_CLKCTRL/4) & 
CM_PER_GPMC_CLKCTRL_IDLEST) !=
        		(CM_PER_GPMC_CLKCTRL_IDLEST_FUNC << 
CM_PER_GPMC_CLKCTRL_IDLEST_SHIFT));
   printf("GPMC clock is running \n");
   munmap((void *) prcm_reg_pointer, getpagesize());
   close(fd);
}

void setupGPMCMuxed(void){
	unsigned int i ;   
	unsigned int temp = 0;
	unsigned short int csNum = 1 ;	
	
	printf("Configuring GPMC for mux access \n");	

	int fd = open("/dev/mem", O_RDWR | O_SYNC);

	volatile unsigned int * gpmc_reg_pointer = (volatile unsigned 
int *) mmap(0, getpagesize(), PROT_READ | PROT_WRITE, MAP_SHARED ,fd, 
SOC_GPMC_0_REGS);

	if(gpmc_reg_pointer == -1){
		printf( "%s\n", strerror( errno ) );
		printf("cannot allocate pointer gpmc_reg_pointer at %x \n", SOC_GPMC_0_REGS);
		exit(EXIT_FAILURE);
  	}  
	printf("gpmc regs pointer allocated with address %x \n", gpmc_reg_pointer);

	 //reset the GPMC module

	printf("GPMC_REVISION value :%x \n", HWREG(gpmc_reg_pointer + GPMC_REVISION/4)); 
 
    HWREG(gpmc_reg_pointer + GPMC_SYSCONFIG/4 ) |= GPMC_SYSCONFIG_SOFTRESET;
   printf("Trying to reset GPMC \n"); 
   printf("GPMC_SYSSTATUS value :%x \n", HWREG(gpmc_reg_pointer + GPMC_SYSSTATUS/4)); 
   while((HWREG(gpmc_reg_pointer + GPMC_SYSSTATUS/4) & 
GPMC_SYSSTATUS_RESETDONE) ==
        		GPMC_SYSSTATUS_RESETDONE_RSTONGOING){
 	printf("GPMC_SYSSTATUS value :%x \n", HWREG(gpmc_reg_pointer + 
GPMC_SYSSTATUS/4));
   }
   printf("GPMC reset \n");

    //Configure to no idle
    temp = HWREG(gpmc_reg_pointer + GPMC_SYSCONFIG/4);
    temp &= ~GPMC_SYSCONFIG_IDLEMODE;
    temp |= GPMC_SYSCONFIG_IDLEMODE_NOIDLE << GPMC_SYSCONFIG_IDLEMODE_SHIFT;
    printf("GPCM_SYSCONFIG value : %x \n", HWREG(gpmc_reg_pointer + 
GPMC_SYSCONFIG/4));
    HWREG(gpmc_reg_pointer + GPMC_SYSCONFIG/4) = temp;

    HWREG(gpmc_reg_pointer + GPMC_IRQENABLE/4) = 0x0;
    HWREG(gpmc_reg_pointer + GPMC_TIMEOUT_CONTROL/4) = 0x0;

    //configure for NOR and granularity x2
    HWREG(gpmc_reg_pointer + GPMC_CONFIG1(csNum)/4) = (0x0 |
    	(GPMC_CONFIG1_0_DEVICESIZE_SIXTEENBITS <<
    			GPMC_CONFIG1_0_DEVICESIZE_SHIFT ) |
	    (GPMC_CONFIG1_0_ATTACHEDDEVICEPAGELENGTH_FOUR <<
	    		GPMC_CONFIG1_0_ATTACHEDDEVICEPAGELENGTH_SHIFT ) |
	    (0x2 << 8 ));	//Address/Data Multiplex enable


    HWREG(gpmc_reg_pointer + GPMC_CONFIG2(csNum)/4) = (0x0 |
    	(1) |	// CS_ON_TIME
        (5 << GPMC_CONFIG2_0_CSRDOFFTIME_SHIFT) |	// CS_DEASSERT_RD
        (5 << GPMC_CONFIG2_0_CSWROFFTIME_SHIFT));	//CS_DEASSERT_WR

    HWREG(gpmc_reg_pointer + GPMC_CONFIG3(csNum)/4) = (0x0 |
        (0 << GPMC_CONFIG3_0_ADVONTIME_SHIFT) | //ADV_ASSERT
	    (2 << GPMC_CONFIG3_0_ADVRDOFFTIME_SHIFT) | //ADV_DEASSERT_RD
	    (2 << GPMC_CONFIG3_0_ADVWROFFTIME_SHIFT)); //ADV_DEASSERT_WR

    HWREG(gpmc_reg_pointer + GPMC_CONFIG4(csNum)/4) = (0x0 |
            (2 << GPMC_CONFIG4_0_OEONTIME_SHIFT) |	//OE_ASSERT
	    (5 << GPMC_CONFIG4_0_OEOFFTIME_SHIFT) |	//OE_DEASSERT
	    (1 << GPMC_CONFIG4_0_WEONTIME_SHIFT)| //WE_ASSERT
	    (5 << GPMC_CONFIG4_0_WEOFFTIME_SHIFT)); //WE_DEASSERT

    HWREG(gpmc_reg_pointer + GPMC_CONFIG5(csNum)/4) = (0x0 |
	    (6 << GPMC_CONFIG5_0_RDCYCLETIME_SHIFT)|	//CFG_5_RD_CYCLE_TIM
	    (5 << GPMC_CONFIG5_0_WRCYCLETIME_SHIFT)|	//CFG_5_WR_CYCLE_TIM
	    (0 << GPMC_CONFIG5_0_RDACCESSTIME_SHIFT));  // CFG_5_RD_ACCESS_TIM

    HWREG(gpmc_reg_pointer + GPMC_CONFIG6(csNum)/4) = (0x0 |
		(0 << //GPMC_CONFIG6_0_CYCLE2CYCLESAMECSEN_C2CDELAY
				GPMC_CONFIG6_0_CYCLE2CYCLESAMECSEN_SHIFT) |
		(0 << GPMC_CONFIG6_0_CYCLE2CYCLEDELAY_SHIFT) | //CYC2CYC_DELAY
	    (2 << GPMC_CONFIG6_0_WRDATAONADMUXBUS_SHIFT)| //WR_DATA_ON_ADMUX
	    (0 << GPMC_CONFIG6_0_WRACCESSTIME_SHIFT));  //CFG_6_WR_ACCESS_TIM

    HWREG(gpmc_reg_pointer + GPMC_CONFIG7(csNum)/4) =
        ( 0x09 << GPMC_CONFIG7_0_BASEADDRESS_SHIFT) | //CFG_7_BASE_ADDR
        (0x1 << GPMC_CONFIG7_0_CSVALID_SHIFT) |
        (0x0f << GPMC_CONFIG7_0_MASKADDRESS_SHIFT);  //CFG_7_MASK

     munmap((void *) gpmc_reg_pointer, getpagesize());

     close(fd);
}

int main(int argc, char ** argv){
	int fd ;
	int i, page_size ;
	volatile unsigned short * gpmc_pointer ; 

	unsigned short dummy_data [10] ;
	setupGPMCClock();
	setupGPMCMuxed();

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
	//memcpy((void *) gpmc_pointer, (void *) dummy_data, 
//10*sizeof(unsigned 
//short));
	gpmc_pointer[0] = 0x5555 ;
	//gpmc_pointer[0] = 0x5555 ;
	printf("nb free in fifo  %x \n", gpmc_pointer[1]);
	printf("nb available in fifo	%x \n", gpmc_pointer[2]);
	//printf("reading from fifo %x \n", gpmc_pointer[0]);	


	munmap((void *) gpmc_pointer, page_size);
	close(fd);
	return 0 ;
}
