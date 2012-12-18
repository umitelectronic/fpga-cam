//-----------------------------------------------------------------------------
//   File:      main.c
//   Contents:  Hooks required to implement USB peripheral function.
//
//
//-----------------------------------------------------------------------------
// Copyright 2003, Cypress Semiconductor Corporation
//-----------------------------------------------------------------------------
#ifndef SDCC
  #pragma noiv               // Do not generate interrupt vectors
#endif

#include "fx2.h"
#include "fx2regs.h"
#include "syncdly.h"            // SYNCDELAY macro
#include "fx2fw.h"

typedef unsigned char u8;
typedef signed char s8;
typedef unsigned short u16;
typedef signed short s16;
typedef unsigned long u32;
typedef signed long s32;

#define GPIFTRIGRD 4
#define GPIF_EP2 0
#define GPIF_EP4 1
#define GPIF_EP6 2
#define GPIF_EP8 3

extern BOOL GotSUD;             // Received setup data flag
extern BOOL Sleep;
extern BOOL Rwuen;
extern BOOL Selfpwr;

BYTE Configuration;             // Current configuration
BYTE AlternateSetting;          // Alternate settings
BOOL enum_high_speed = FALSE;       // flag to let firmware know FX2 enumerated at high speed

#define VR_NAKALL_ON    0xD0
#define VR_NAKALL_OFF   0xD1

//-----------------------------------------------------------------------------
// Task Dispatcher hooks
//   The following hooks are called by the task dispatcher.
//-----------------------------------------------------------------------------

/*
void tty_out(s8 *s){
	u8 i=0;
	while(s[i]){
		if(s[i]=='\n'){
			SBUF0=0x0d;
		}
		else{
			SBUF0=s[i];
		}
		i++;
		for(;;){
			if(TI==1) break;
		}
		TI=0;
	}
}

const s8 hexchar[16]={
'0','1','2','3','4','5','6','7',
'8','9','A','B','C','D','E','F'
};

void tty_hex(u8 u){
	u8 s[3];
	s[0]=hexchar[u>>4];
	s[1]=hexchar[u & 0x0f];
	s[2]=0;
	tty_out(s);
}
*/


void TD_Init(void)             // Called once at startup
{ 
//	unsigned char i;

  // set the CPU clock to 48MHz
  CPUCS = ((CPUCS & ~bmCLKSPD) | bmCLKSPD1);
  SYNCDELAY; 

/*
	//serial port init
	UART230=0x01;	//port0 set 230/115K baud
	SCON0    = 0x50; // 0101 0000 mode=1, REN_1=1
	TI       = 0;
	for(i=0;i<100;i++){
		SBUF0=i+0x20;
		for(;;){
			if(TI==1) break;
		}
		TI=0;
	}
*/
  // we are just using the default values, yes this is not necessary...
  EP1OUTCFG = 0xA0;
  EP1INCFG = 0xA0;
  SYNCDELAY;                    // see TRM section 15.14
  EP2CFG = 0xA3;				// triple out
  SYNCDELAY;                    
  EP4CFG = 0x00;
  SYNCDELAY;                    
  EP6CFG = 0xE3;				// triple in
  SYNCDELAY;                    
  EP8CFG = 0xA0;				// double out

  
  // since the defaults are double buffered we must write dummy byte counts twice
  SYNCDELAY;                    
  EP2BCL = 0x80;                // arm EP2OUT by writing byte count w/skip.
  SYNCDELAY;                    
  EP2BCL = 0x80;
  SYNCDELAY;                    
  EP2BCL = 0x80;
  SYNCDELAY;                    
  EP8BCL = 0x80;                // arm EP4OUT by writing byte count w/skip.
  SYNCDELAY;                    
  EP8BCL = 0x80;    

  // enable dual autopointer feature
  AUTOPTRSETUP=0x07;

  Rwuen = TRUE;                 // Enable remote-wakeup

#ifdef SDCC
  {
    // wait
    WORD i;
    for(i = 0; i < 30000; i++);
  }
#endif
}


u8 wait=0,mode,flow;
u16 frame_cnt,cmd_cnt=0,out_cnt;
u8 xdata FlowStates[36];

void flow_change(u8 i){
	u8 *ptr;
	i=3 & (GPIFWFSELECT >> i);
	if(i!=flow){
		ptr=FlowStates+i+(i<<3);
		FLOWSTATE	= *(ptr++);
		FLOWLOGIC	= *(ptr++);
		FLOWEQ0CTL	= *(ptr++);
		FLOWEQ1CTL	= *(ptr++);
		FLOWHOLDOFF	= *(ptr++);
		FLOWSTB		= *(ptr++);
		FLOWSTBEDGE = *(ptr++);
		FLOWSTBHPERIOD = *(ptr++);
		flow=i;
	}
}

void TD_Poll(void){
	u8 i,j;
	if(wait & 0x80){
		if(!(GPIFTRIG & 0x80)) return;
	}
	else if(wait){
		if((USBFRAMEL!=LSB(frame_cnt))||(USBFRAMEH!=MSB(frame_cnt))) return;
	}
	wait=0;
	if(!(EP2468STAT & bmEP8EMPTY)){
		if(cmd_cnt==0){
			cmd_cnt=(EP8BCH<<8)+EP8BCL;
			AUTOPTR1H=MSB( &EP8FIFOBUF );
        	AUTOPTR1L=LSB( &EP8FIFOBUF );
			AUTOPTRH2=MSB( &EP6FIFOBUF );
        	AUTOPTRL2=LSB( &EP6FIFOBUF );
			out_cnt=0;
		}
		for(;;){
			switch(XAUTODAT1){
			case CMD_MODE:
				mode=XAUTODAT1;
				j=(mode>>3)&1;
				cmd_cnt--;

				FIFORESET = 0x80;  // set NAKALL bit to NAK all transfers from host
				SYNCDELAY;
				FIFORESET = 0x02;  // reset EP2 FIFO
				SYNCDELAY;
				FIFORESET = 0x06;  // reset EP6 FIFO
				SYNCDELAY;
				FIFORESET = 0x00;  // clear NAKALL bit to resume normal operation
				SYNCDELAY;

				EP2FIFOCFG = 0x00|j; // allow core to see zero to one transition of auto out bit
				SYNCDELAY;
				EP2FIFOCFG = 0x10|j; // auto out mode, disable PKTEND zero length send, word ops
				SYNCDELAY;
				EP6FIFOCFG = 0x08|j; // auto in mode, disable PKTEND zero length send, word ops
				SYNCDELAY;
				EP4FIFOCFG = EP8FIFOCFG = j;	// for 8/16bit mode

				//alternate init
				PORTACFG = 0;
				PORTCCFG = 0;
				OEC = 0;
				PORTECFG = 0;
				OEE = 0;

				if((mode&7)==0){		//PIO mode
					IFCONFIG = 0xe0;	//clk-inter, 48MHz, clk-oe
				}
				else if((mode&7)==1){	//FIFO mode
					FIFOPINPOLAR = 0x03;
					PINFLAGSAB = 0xe8;		//FLAGB:EP6-FF FLAGA:EP2-EF
					PINFLAGSCD = 0x0a;		//FLAGC:EP6-EF FLAGD:default
					PORTACFG = 0x40;
					IFCONFIG = 0xeb;	//(1110-1011) clk-inter, 48MHz, clk-oe, ASYNC, FIFO-slave
				}
				else{				//GPIF mode
					if(mode & 0x10){	// use addr
						PORTCCFG = 0xFF;    // [7:0] as alt. func. GPIFADR[7:0]
						OEC = 0xFF;         // and as outputs
						PORTECFG |= 0x80;   // [8] as alt. func. GPIFADR[8]
						OEE |= 0x80;        // and as output
						GPIFADRH = 0x00;    // bits[7:1] always 0
						SYNCDELAY;
						GPIFADRL = 0x00;    // point to PERIPHERAL address 0x0000
					}
					else{
						PORTCCFG = 0;
						OEC = 0;
						PORTECFG = 0;
						OEE = 0;
					}
					EP2GPIFFLGSEL = 0x01; // For EP2OUT, GPIF uses EF flag
					SYNCDELAY;
					EP6GPIFFLGSEL = 0x02; // For EP6IN, GPIF uses FF flag
				}
				break;
			case CMD_GPIF:
				GPIFABORT = 0xFF;  // abort any waveforms pending
				i=XAUTODAT1;
				if(mode & 0x40){	//GPIF STATE(PE0-2) DEBUG
					i = i | 0x04;
				}
				else{
					i = i & ~0x04;
				}
				IFCONFIG = i;

				GPIFREADYCFG = XAUTODAT1;
				GPIFCTLCFG = XAUTODAT1;
				GPIFIDLECS = XAUTODAT1;
				GPIFIDLECTL = XAUTODAT1;
				i=XAUTODAT1;	//skip InitData[ 4 ]
				GPIFWFSELECT = XAUTODAT1;
				GPIFREADYSTAT = XAUTODAT1;
				cmd_cnt-=(1+7);
				break;
			case CMD_WAVE:
				//wave form
				AUTOPTRH2 = 0xE4;
				AUTOPTRL2 = 0x00;
 				for(i=0;i<128;i++){
					XAUTODAT2 = XAUTODAT1;
				}
				cmd_cnt-=(32*4);
				break;
			case CMD_WAVE0:
				AUTOPTRL2 = 0x00;
				goto WAVE_IN;
			case CMD_WAVE1:
				AUTOPTRL2 = 0x20;
				goto WAVE_IN;
			case CMD_WAVE2:
				AUTOPTRL2 = 0x40;
				goto WAVE_IN;
			case CMD_WAVE3:
				AUTOPTRL2 = 0x60;
WAVE_IN:
				AUTOPTRH2 = 0xE4;
 				for(i=0;i<32;i++){
					XAUTODAT2 = XAUTODAT1;
				}
				cmd_cnt-=32;
				break;
			case CMD_FLOW:
				//flow state
				AUTOPTRH2=MSB( &FlowStates );
    	    	AUTOPTRL2=LSB( &FlowStates );
				for(i=0;i<4*9;i++){
					XAUTODAT2 = XAUTODAT1;
				}
				AUTOPTRH2=MSB( &FlowStates );
    	    	AUTOPTRL2=LSB( &FlowStates );
				FLOWSTATE	= XAUTODAT2;
				FLOWLOGIC	= XAUTODAT2;
				FLOWEQ0CTL	= XAUTODAT2;
				FLOWEQ1CTL	= XAUTODAT2;
				FLOWHOLDOFF	= XAUTODAT2;
				FLOWSTB		= XAUTODAT2;
				FLOWSTBEDGE = XAUTODAT2;
				FLOWSTBHPERIOD = XAUTODAT2;
				flow=0;
				cmd_cnt-=(9*4);
				break;
			case CMD_WFSEL:
				for(;;) if(GPIFTRIG & 0x80) break;
				GPIFWFSELECT = XAUTODAT1;
				cmd_cnt--;
				break;
			case CMD_ADSET:
				GPIFADRL = XAUTODAT1;
				SYNCDELAY;
				GPIFADRH = XAUTODAT1;    // bits[7:1] always 0
				cmd_cnt-=2;
				break;
			case CMD_CPUCS:
				CPUCS = XAUTODAT1;
				cmd_cnt--;
				break;
			case CMD_USBCS:
				XAUTODAT2=USBCS;
				out_cnt++;
				break;
			case CMD_SWRITE:
				for(;;) if(GPIFTRIG & 0x80) break;
				if(mode & 0x20) flow_change(6);
				if(mode & 0x08){
					XGPIFSGLDATH = XAUTODAT1;
					cmd_cnt--;
				}
				XGPIFSGLDATLX = XAUTODAT1;		// trigger GPIF Single Word Write transaction
				cmd_cnt--;
				break;
			case CMD_SREAD:
				for(;;) if(GPIFTRIG & 0x80) break;
				if(mode & 0x20) flow_change(4);
				i=XGPIFSGLDATLX;					//dummy
				for(;;) if(GPIFTRIG & 0x80) break;
				if(mode & 0x08){
					XAUTODAT2=XGPIFSGLDATH;
					out_cnt++;
				}
				XAUTODAT2=XGPIFSGLDATLNOX;
				out_cnt++;
				break;
			case CMD_BWRITE:
				for(;;) if(GPIFTRIG & 0x80) break;
				if(mode & 0x20) flow_change(2);
				GPIFTCB0=XAUTODAT1;
				SYNCDELAY;
				GPIFTCB1=XAUTODAT1;
				SYNCDELAY;
				cmd_cnt-=2;
				GPIFTRIG=GPIF_EP2;
				break;
			case CMD_BREAD:
				for(;;) if(GPIFTRIG & 0x80) break;
				if(mode & 0x20) flow_change(0);
				GPIFTCB0=XAUTODAT1;
				SYNCDELAY;
				GPIFTCB1=XAUTODAT1;
				SYNCDELAY;
				cmd_cnt-=2;
				GPIFTRIG = GPIFTRIGRD | GPIF_EP6; // launch GPIF FIFO READ Transaction to EP6 FIFO
				break;
			case CMD_OEA:
				OEA=XAUTODAT1;
				cmd_cnt--;
				break;
			case CMD_OEB:
				OEB=XAUTODAT1;
				cmd_cnt--;
				break;
			case CMD_OEC:
				OEC=XAUTODAT1;
				cmd_cnt--;
				break;
			case CMD_OED:
				OED=XAUTODAT1;
				cmd_cnt--;
				break;
			case CMD_OEE:
				OEE=XAUTODAT1;
				cmd_cnt--;
				break;
			case CMD_INA:
				XAUTODAT2=IOA;
				out_cnt++;
				break;
			case CMD_INB:
				XAUTODAT2=IOB;
				out_cnt++;
				break;
			case CMD_INC:
				XAUTODAT2=IOC;
				out_cnt++;
				break;
			case CMD_IND:
				XAUTODAT2=IOD;
				out_cnt++;
				break;
			case CMD_INE:
				XAUTODAT2=IOE;
				out_cnt++;
				break;
			case CMD_OUTA:
				IOA=XAUTODAT1;
				cmd_cnt--;
				break;
			case CMD_OUTB:
				IOB=XAUTODAT1;
				cmd_cnt--;
				break;
			case CMD_OUTC:
				IOC=XAUTODAT1;
				cmd_cnt--;
				break;
			case CMD_OUTD:
				IOD=XAUTODAT1;
				cmd_cnt--;
				break;
			case CMD_OUTE:
				IOE=XAUTODAT1;
				cmd_cnt--;
				break;
			case CMD_WAIT:
				frame_cnt=USBFRAMEL+(USBFRAMEH<<8)+XAUTODAT1+1;
				cmd_cnt--;
				wait=1;
				break;
			case CMD_NOP:
				j=XAUTODAT1;
				cmd_cnt--;
				for(i=0;i<j;i++){
					_nop_( );
				}
				break;
			default:
				break;
			}
			cmd_cnt--;
			if(cmd_cnt==0){
				if(out_cnt){
					EP6BCH=MSB(out_cnt);
					SYNCDELAY;
					EP6BCL=LSB(out_cnt);
					SYNCDELAY;
				}
				EP8BCL=0x80;
				break;
			}
			if(wait){
				break;
			}
		}
	}
}

#ifdef SDCC
  #define BOOL BYTE
#endif

BOOL TD_Suspend(void)          // Called before the device goes into suspend mode
{
   return(TRUE);
}

BOOL TD_Resume(void)          // Called after the device resumes
{
   return(TRUE);
}

//-----------------------------------------------------------------------------
// Device Request hooks
//   The following hooks are called by the end point 0 device request parser.
//-----------------------------------------------------------------------------

BOOL DR_GetDescriptor(void)
{
   return(TRUE);
}

BOOL DR_SetConfiguration(void)   // Called when a Set Configuration command is received
{
   Configuration = SETUPDAT[2];
   return(TRUE);            // Handled by user code
}

BOOL DR_GetConfiguration(void)   // Called when a Get Configuration command is received
{
   EP0BUF[0] = Configuration;
   EP0BCH = 0;
   EP0BCL = 1;
   return(TRUE);            // Handled by user code
}

BOOL DR_SetInterface(void)       // Called when a Set Interface command is received
{
   AlternateSetting = SETUPDAT[2];
   return(TRUE);            // Handled by user code
}

BOOL DR_GetInterface(void)       // Called when a Set Interface command is received
{
   EP0BUF[0] = AlternateSetting;
   EP0BCH = 0;
   EP0BCL = 1;
   return(TRUE);            // Handled by user code
}

BOOL DR_GetStatus(void)
{
   return(TRUE);
}

BOOL DR_ClearFeature(void)
{
   return(TRUE);
}

BOOL DR_SetFeature(void)
{
   return(TRUE);
}

BOOL DR_VendorCmnd(void)
{
  BYTE tmp;
  
  switch (SETUPDAT[1])
  {
     case VR_NAKALL_ON:
        tmp = FIFORESET;
        tmp |= bmNAKALL;      
        SYNCDELAY;                    
        FIFORESET = tmp;
        break;
     case VR_NAKALL_OFF:
        tmp = FIFORESET;
        tmp &= ~bmNAKALL;      
        SYNCDELAY;                    
        FIFORESET = tmp;
        break;
     default:
        return(TRUE);
  }

  return(FALSE);
}

//-----------------------------------------------------------------------------
// USB Interrupt Handlers
//   The following functions are called by the USB interrupt jump table.
//-----------------------------------------------------------------------------

// Setup Data Available Interrupt Handler
void ISR_Sudav(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 13
#endif
{
   GotSUD = TRUE;            // Set flag
   EZUSB_IRQ_CLEAR();
   USBIRQ = bmSUDAV;         // Clear SUDAV IRQ
}

void ISR_Sof(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 14
#endif
{
   EZUSB_IRQ_CLEAR();
   USBIRQ = bmSOF;            // Clear SOF IRQ
}

// Setup Token Interrupt Handler
void ISR_Sutok(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 15
#endif
{
   EZUSB_IRQ_CLEAR();
   USBIRQ = bmSUTOK;         // Clear SUTOK IRQ
}

void ISR_Susp(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 16
#endif
{
   Sleep = TRUE;
   EZUSB_IRQ_CLEAR();
   USBIRQ = bmSUSP;
}

void ISR_Ures(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 17
#endif
{
   // whenever we get a USB reset, we should revert to full speed mode
   pConfigDscr = pFullSpeedConfigDscr;
   ((CONFIGDSCR xdata *) pConfigDscr)->type = CONFIG_DSCR;
   pOtherConfigDscr = pHighSpeedConfigDscr;
   ((CONFIGDSCR xdata *) pOtherConfigDscr)->type = OTHERSPEED_DSCR;

   EZUSB_IRQ_CLEAR();
   USBIRQ = bmURES;         // Clear URES IRQ
}

void ISR_Highspeed(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 18
#endif
{
   if (EZUSB_HIGHSPEED())
   {
      pConfigDscr = pHighSpeedConfigDscr;
      ((CONFIGDSCR xdata *) pConfigDscr)->type = CONFIG_DSCR;
      pOtherConfigDscr = pFullSpeedConfigDscr;
      ((CONFIGDSCR xdata *) pOtherConfigDscr)->type = OTHERSPEED_DSCR;
   }

   EZUSB_IRQ_CLEAR();
   USBIRQ = bmHSGRANT;
}

void ISR_Ep0ack(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 19
#endif
{
}

void ISR_Stub(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 20
#endif
{
}
void ISR_Ep0in(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 21
#endif
{
}
void ISR_Ep0out(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 22
#endif
{
}
void ISR_Ep1in(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 23
#endif
{
}
void ISR_Ep1out(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 24
#endif
{
}
void ISR_Ep2inout(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 25
#endif
{
}
void ISR_Ep4inout(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 26
#endif
{
}
void ISR_Ep6inout(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 27
#endif
{
}
void ISR_Ep8inout(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 28
#endif
{
}
void ISR_Ibn(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 29
#endif
{
}
void ISR_Ep0pingnak(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 30
#endif
{
}
void ISR_Ep1pingnak(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 31
#endif
{
}
void ISR_Ep2pingnak(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 32
#endif
{
}
void ISR_Ep4pingnak(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 33
#endif
{
}
void ISR_Ep6pingnak(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 34
#endif
{
}
void ISR_Ep8pingnak(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 35
#endif
{
}

void ISR_Errorlimit(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 36
#endif
{
}
void ISR_Ep2piderror(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 37
#endif
{
}
void ISR_Ep4piderror(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 38
#endif
{
}
void ISR_Ep6piderror(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 39
#endif
{
}
void ISR_Ep8piderror(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 40
#endif
{
}

void ISR_Ep2pflag(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 41
#endif
{
}
void ISR_Ep4pflag(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 42
#endif
{
}
void ISR_Ep6pflag(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 43
#endif
{
}
void ISR_Ep8pflag(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 44
#endif
{
}
void ISR_Ep2eflag(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 45
#endif
{
}
void ISR_Ep4eflag(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 46
#endif
{
}
void ISR_Ep6eflag(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 47
#endif
{
}
void ISR_Ep8eflag(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 48
#endif
{
}
void ISR_Ep2fflag(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 49
#endif
{
}
void ISR_Ep4fflag(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 50
#endif
{
}
void ISR_Ep6fflag(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 51
#endif
{
}
void ISR_Ep8fflag(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 52
#endif
{
}
void ISR_GpifComplete(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 53
#endif
{
}
void ISR_GpifWaveform(void)
#ifndef SDCC
  interrupt 0
#else
  interrupt 54
#endif
{
}
