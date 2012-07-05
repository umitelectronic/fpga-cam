#include <linux/init.h>
#include <linux/module.h>
#include <linux/pci.h>
#include <linux/interrupt.h>
#include <linux/fs.h>
#include <linux/slab.h>
#include <linux/ioctl.h>
#include <asm/uaccess.h>   /* copy_to_user */

#include "hw_cm_per.h"
#include "hw_gpmc.h"
#include "soc_AM335x.h"



/* Use 'p' as magic number */
#define PAPILIO_FIFO_IOC_MAGIC 'p'
/* Please use a different 8-bit number in your code */
#define PAPILIO_FIFO_RESET _IO(PAPILIO_FIFO_IOC_MAGIC, 0)


#define PAPILIO_FIFO_PEEK _IOR(PAPILIO_FIFO_IOC_MAGIC, 1, short)
#define PAPILIO_FIFO_NB_FREE _IOR(PAPILIO_FIFO_IOC_MAGIC, 2, short)
#define PAPILIO_FIFO_NB_AVAILABLE _IOR(PAPILIO_FIFO_IOC_MAGIC, 3, short)


#define FPGA_BASE_ADDR	 0x09000000
#define NB_FREE_OFFSET	1
#define NB_AVAILABLE_OFFSET	2
#define PEEK_OFFSET	3
#define READ_OFFSET	0
#define WRITE_OFFSET	0


#define HWREG(x)	(*((volatile unsigned int *)(x)))
#define FPGAREG(x)	(*((volatile unsigned short *)(x)))


char * gDrvrName = "papilio_fifo";
unsigned char gDrvrMajor = 0 ;
unsigned char gDrvrMinor = 0 ;
unsigned char nbDevices  = 1 ;


void setupGPMCClock(void) ;
void setupGPMCNonMuxed(void) ;
unsigned short int getNbFree(void);
unsigned short int getNbAvailable(void);



void setupGPMCClock(void){
	printk("Configuring Clock for GPMC \n");   

	//enable clock to GPMC module
	HWREG(SOC_PRCM_REGS + CM_PER_GPMC_CLKCTRL/4 ) |=
			CM_PER_GPMC_CLKCTRL_MODULEMODE_ENABLE;
	//check to see if enabled
	printk("CM_PER_GPMC_CLKCTRL value :%x \n", HWREG(SOC_PRCM_REGS + 
	CM_PER_GPMC_CLKCTRL/4)); 
	while((HWREG(SOC_PRCM_REGS + CM_PER_GPMC_CLKCTRL/4) & 
	CM_PER_GPMC_CLKCTRL_IDLEST) != (CM_PER_GPMC_CLKCTRL_IDLEST_FUNC << CM_PER_GPMC_CLKCTRL_IDLEST_SHIFT));
	printk("GPMC clock is running \n");
}

void setupGPMCNonMuxed(void){
	unsigned int temp = 0;
	unsigned short int csNum = 1 ;	

	printk("Configuring GPMC for muxed access \n");	

	printk("gpmc regs pointer allocated with address %x \n", SOC_GPMC_0_REGS);

	printk("GPMC_REVISION value :%x \n", HWREG(SOC_GPMC_0_REGS + GPMC_REVISION/4)); 
	HWREG(SOC_GPMC_0_REGS + GPMC_SYSCONFIG/4 ) |= GPMC_SYSCONFIG_SOFTRESET;
	printk("Trying to reset GPMC \n"); 
	printk("GPMC_SYSSTATUS value :%x \n", HWREG(SOC_GPMC_0_REGS + GPMC_SYSSTATUS/4)); 
	while((HWREG(SOC_GPMC_0_REGS + GPMC_SYSSTATUS/4) & 
		GPMC_SYSSTATUS_RESETDONE) == GPMC_SYSSTATUS_RESETDONE_RSTONGOING){
		//sleep(1);
		printk("GPMC_SYSSTATUS value :%x \n", HWREG(SOC_GPMC_0_REGS + 
		GPMC_SYSSTATUS/4));
	}
	printk("GPMC reset \n");
	temp = HWREG(SOC_GPMC_0_REGS + GPMC_SYSCONFIG/4);
	temp &= ~GPMC_SYSCONFIG_IDLEMODE;
	temp |= GPMC_SYSCONFIG_IDLEMODE_NOIDLE << GPMC_SYSCONFIG_IDLEMODE_SHIFT;
	HWREG(SOC_GPMC_0_REGS + GPMC_SYSCONFIG/4) = temp;
	HWREG(SOC_GPMC_0_REGS + GPMC_IRQENABLE/4) = 0x0;
	HWREG(SOC_GPMC_0_REGS + GPMC_TIMEOUT_CONTROL/4) = 0x0;

	HWREG(SOC_GPMC_0_REGS + GPMC_CONFIG1(csNum)/4) = (0x0 |
	(GPMC_CONFIG1_0_DEVICESIZE_SIXTEENBITS <<
		GPMC_CONFIG1_0_DEVICESIZE_SHIFT ) |
	(GPMC_CONFIG1_0_ATTACHEDDEVICEPAGELENGTH_FOUR <<
		GPMC_CONFIG1_0_ATTACHEDDEVICEPAGELENGTH_SHIFT ) |
	(0x0 << 8 ));	//Address/Data not multiplexed


	HWREG(SOC_GPMC_0_REGS + GPMC_CONFIG2(csNum)/4) =  (0x0 |
	(0) |	// CS_ON_TIME
	(4 << GPMC_CONFIG2_0_CSRDOFFTIME_SHIFT) |	// CS_DEASSERT_RD
	(4 << GPMC_CONFIG2_0_CSWROFFTIME_SHIFT));	//CS_DEASSERT_WR

	HWREG(SOC_GPMC_0_REGS + GPMC_CONFIG3(csNum)/4) = (0x0 |
	(0 << GPMC_CONFIG3_0_ADVONTIME_SHIFT) | //ADV_ASSERT
	(0 << GPMC_CONFIG3_0_ADVRDOFFTIME_SHIFT) | //ADV_DEASSERT_RD
	(0 << GPMC_CONFIG3_0_ADVWROFFTIME_SHIFT)); //ADV_DEASSERT_WR

	HWREG(SOC_GPMC_0_REGS + GPMC_CONFIG4(csNum)/4) = (0x0 |
	(0 << GPMC_CONFIG4_0_OEONTIME_SHIFT) |	//OE_ASSERT
	(4 << GPMC_CONFIG4_0_OEOFFTIME_SHIFT) |	//OE_DEASSERT
	(0 << GPMC_CONFIG4_0_WEONTIME_SHIFT)| //WE_ASSERT
	(4 << GPMC_CONFIG4_0_WEOFFTIME_SHIFT)); //WE_DEASSERT

	HWREG(SOC_GPMC_0_REGS + GPMC_CONFIG5(csNum)/4) = (0x0 |
	(5 << GPMC_CONFIG5_0_RDCYCLETIME_SHIFT)|	//CFG_5_RD_CYCLE_TIM
	(5 << GPMC_CONFIG5_0_WRCYCLETIME_SHIFT)|	//CFG_5_WR_CYCLE_TIM
	(3 << GPMC_CONFIG5_0_RDACCESSTIME_SHIFT));  // CFG_5_RD_ACCESS_TIM

	HWREG(SOC_GPMC_0_REGS + GPMC_CONFIG6(csNum)/4) = (0x0 |
	(0 << //GPMC_CONFIG6_0_CYCLE2CYCLESAMECSEN_C2CDELAY
			GPMC_CONFIG6_0_CYCLE2CYCLESAMECSEN_SHIFT) |
	(0 << GPMC_CONFIG6_0_CYCLE2CYCLEDELAY_SHIFT) | //CYC2CYC_DELAY
	(0 << GPMC_CONFIG6_0_WRDATAONADMUXBUS_SHIFT)| //WR_DATA_ON_ADMUX
	(0 << GPMC_CONFIG6_0_WRACCESSTIME_SHIFT));  //CFG_6_WR_ACCESS_TIM

	HWREG(SOC_GPMC_0_REGS + GPMC_CONFIG7(csNum)/4) =
	(0x09 << GPMC_CONFIG7_0_BASEADDRESS_SHIFT) | //CFG_7_BASE_ADDR
	(0x1 << GPMC_CONFIG7_0_CSVALID_SHIFT) |
	(0x0f << GPMC_CONFIG7_0_MASKADDRESS_SHIFT);  //CFG_7_MASK

}


int papilio_fifo_open(struct inode *inode, struct file *filp)
{
    printk("%s: Open: module opened\n",gDrvrName);
    return 1;
}

int papilio_fifo_release(struct inode *inode, struct file *filp)
{
    printk("%s: Release: module released\n",gDrvrName);
    return 1;
}


unsigned short int getNbAvailable(void){
	return FPGAREG(FPGA_BASE_ADDR + NB_AVAILABLE_OFFSET) ;
}

unsigned short int getNbFree(void){
	return FPGAREG(FPGA_BASE_ADDR + NB_FREE_OFFSET) ;
}

ssize_t papilio_fifo_write(struct file *filp, const char *buf, size_t count,
                       loff_t *f_pos)
{
    unsigned short int * writeBuffer ;
    unsigned short int nbFree ;
    unsigned short int index ;
    unsigned int ret ;
    writeBuffer = (unsigned short int *) kmalloc(count, GFP_KERNEL);
    // Now it is safe to copy the data from user space.
    if ( copy_from_user(writeBuffer, buf, count) )  {
        ret = -1;
        printk("%s: papilio_fifo write: Failed copy to user.\n",gDrvrName);
        goto exit;
    }
    nbFree = getNbFree();
    printk("%d data slots are free to write \n", nbFree);
    for(index = 0 ; index < nbFree && index < count; index ++){
    	FPGAREG(FPGA_BASE_ADDR + WRITE_OFFSET) = writeBuffer[index];
    }
    kfree(writeBuffer);
    ret = index ;
    exit:
      return (ret);
}


ssize_t papilio_fifo_read(struct file *filp, char *buf, size_t count, loff_t *f_pos)
{
     unsigned short int * readBuffer ;
    unsigned short int nbAvailable ;
    unsigned short int index ; 
    unsigned int ret ;
    readBuffer = (unsigned short int *) kmalloc(count, GFP_KERNEL);
    nbAvailable = getNbAvailable();
    printk("%d data are available to read \n", nbAvailable);
    for(index = 0 ; index < nbAvailable && index < count; index ++){
    	readBuffer[index] = FPGAREG(FPGA_BASE_ADDR + READ_OFFSET);
    }
   
    // Now it is safe to copy the data to user space.
    if ( copy_to_user(buf, readBuffer, index) )  {
        ret = -1;
        goto exit;
    }

    kfree(readBuffer);
    ret = index ;
    exit:
      return ret;
}


int papilio_fifo_ioctl(struct inode *inode, struct file *filp, unsigned int cmd, unsigned long arg){
	switch(cmd){
		case PAPILIO_FIFO_RESET :
			return 0 ;
		case PAPILIO_FIFO_PEEK :
			return  FPGAREG(FPGA_BASE_ADDR + PEEK_OFFSET) ;
		case PAPILIO_FIFO_NB_FREE :
			return getNbFree() ;
		case PAPILIO_FIFO_NB_AVAILABLE :
			return getNbAvailable() ;
		default: /* redundant, as cmd was checked against MAXNR */
			return -ENOTTY;
	}
}

struct file_operations papilio_fifo_ops = {
    .read =   papilio_fifo_read,
    .write =  papilio_fifo_write,
    .compat_ioctl =  papilio_fifo_ioctl,
    .open =   papilio_fifo_open,
    .release =  papilio_fifo_release,
};


static int papilio_fifo_init(void)
{
	dev_t dev = 0;
	int result ;
	if (gDrvrMajor) {
		dev = MKDEV(gDrvrMajor, gDrvrMinor);
		result = register_chrdev(gDrvrMajor, gDrvrName, &papilio_fifo_ops);
	} else {
		result = alloc_chrdev_region(&dev, gDrvrMinor, nbDevices, gDrvrName);
		gDrvrMajor = MAJOR(dev);
	}
	if (result < 0) {
		printk(KERN_WARNING "%s: can't get major %d\n",gDrvrName,gDrvrMajor);
		return result;
	}
	printk(KERN_INFO"%s: Init: module registered\n", gDrvrName);

	printk("%s driver is loaded\n", gDrvrName);

	return 0;
}

static void papilio_fifo_exit(void)
{
    unregister_chrdev(gDrvrMajor, gDrvrName);

    printk(/*KERN_ALERT*/ "%s driver is unloaded\n", gDrvrName);
}


MODULE_LICENSE("Dual BSD/GPL");
MODULE_AUTHOR("Jonathan Piat <piat.jonathan@gmail.com>");

module_init(papilio_fifo_init);
module_exit(papilio_fifo_exit);
