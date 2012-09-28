;;-----------------------------------------------------------------------------
;;	File:		dscr.asm
;;	Contents:	This file contains descriptor data tables.  
;;
;;	Copyright (c) 1997 AnchorChips, Inc. All rights reserved
;;-----------------------------------------------------------------------------

.module DSCR

DSCR_DEVICE		=	1	;; Descriptor type: Device
DSCR_CONFIG		=	2	;; Descriptor type: Configuration
DSCR_STRING		=	3	;; Descriptor type: String
DSCR_INTRFC		=	4	;; Descriptor type: Interface
DSCR_ENDPNT		=	5	;; Descriptor type: Endpoint
DSCR_DEVQUAL	=	6	;; Descriptor type: Device Qualifier

DSCR_DEVICE_LEN		=	18
DSCR_CONFIG_LEN		=	9
DSCR_INTRFC_LEN		=	9
DSCR_ENDPNT_LEN		=	7
DSCR_DEVQUAL_LEN	=	10

ET_CONTROL	=	0	;; Endpoint type: Control
ET_ISO		=	1	;; Endpoint type: Isochronous
ET_BULK		=	2	;; Endpoint type: Bulk
ET_INT		=	3	;; Endpoint type: Interrupt

.globl	_DeviceDscr, _DeviceQualDscr, _HighSpeedConfigDscr, _FullSpeedConfigDscr, _StringDscr, _UserDscr

.area	CSEG	(CODE)

;;-----------------------------------------------------------------------------
;; Global Variables
;;-----------------------------------------------------------------------------

_DeviceDscr:
DeviceDscr:
	.db	deviceDscrEnd - DeviceDscr		;; Descriptor length
	.db	DSCR_DEVICE						;; Decriptor type
	.dw	0x0002							;; Specification Version (BCD)
	.db	0x00  							;; Device class
	.db	0x00							;; Device sub-class
	.db	0x00							;; Device sub-sub-class
	.db	64								;; Maximum packet size
	.dw	0xB404							;; Vendor ID
	.dw	0x0410							;; Product ID (Sample Device)
	.dw	0x0100							;; Product version ID
	.db	1								;; Manufacturer string index
	.db	2								;; Product string index
	.db	0								;; Serial number string index
	.db	1								;; Number of configurations
deviceDscrEnd:

_DeviceQualDscr:
DeviceQualDscr:
	.db	deviceQualDscrEnd - DeviceQualDscr	;; Descriptor length
	.db	DSCR_DEVQUAL						;; Decriptor type
	.dw	0x0002								;; Specification Version (BCD)
	.db	0x00								;; Device class
	.db	0x00								;; Device sub-class
	.db	0x00								;; Device sub-sub-class
	.db	64									;; Maximum packet size
	.db	1									;; Number of configurations
	.db	0									;; Reserved
deviceQualDscrEnd:

_HighSpeedConfigDscr:
	.db	DSCR_CONFIG_LEN											;; Descriptor length
	.db	DSCR_CONFIG												;; Descriptor type
	.db	(HighSpeedConfigDscrEnd - _HighSpeedConfigDscr) % 256	;; Total Length (LSB)
	.db	(HighSpeedConfigDscrEnd - _HighSpeedConfigDscr) / 256	;; Total Length (MSB)
	.db	1														;; Number of interfaces
	.db	1														;; Configuration number
	.db	0														;; Configuration string
	.db	0b10100000												;; Attributes (b7 - buspwr, b6 - selfpwr, b5 - rwu)
	.db	50														;; Power requirement (div 2 ma)

;; Interface Descriptor
	.db	DSCR_INTRFC_LEN		;; Descriptor length
	.db	DSCR_INTRFC			;; Descriptor type
	.db	0					;; Zero-based index of this interface
	.db	0					;; Alternate setting
	.db	3					;; Number of end points 
	.db	0xff				;; Interface class
	.db	0x00				;; Interface sub class
	.db	0x00				;; Interface sub sub class
	.db	0					;; Interface descriptor string index
      
;; Endpoint Descriptor(O_2)
	.db	DSCR_ENDPNT_LEN		;; Descriptor length
	.db	DSCR_ENDPNT			;; Descriptor type
	.db	0x02				;; Endpoint number, and direction
	.db	ET_BULK				;; Endpoint type
	.db	0x00				;; Maximun packet size (LSB)
	.db	0x02				;; Max packect size (MSB)
	.db	0x00				;; Polling interval

;; Endpoint Descriptor(O_4)
	.db	DSCR_ENDPNT_LEN		;; Descriptor length
	.db	DSCR_ENDPNT			;; Descriptor type
	.db	0x08				;; Endpoint number, and direction
	.db	ET_BULK				;; Endpoint type
	.db	0x00				;; Maximun packet size (LSB)
	.db	0x02				;; Max packect size (MSB)
	.db	0x00				;; Polling interval

;; Endpoint Descriptor(I_6)
	.db	DSCR_ENDPNT_LEN		;; Descriptor length
	.db	DSCR_ENDPNT			;; Descriptor type
	.db	0x86				;; Endpoint number, and direction
	.db	ET_BULK				;; Endpoint type
	.db	0x00				;; Maximun packet size (LSB)
	.db	0x02				;; Max packect size (MSB)
	.db	0x00				;; Polling interval

HighSpeedConfigDscrEnd:   

_FullSpeedConfigDscr:
	.db	DSCR_CONFIG_LEN											;; Descriptor length
	.db	DSCR_CONFIG												;; Descriptor type
	.db	(FullSpeedConfigDscrEnd - _FullSpeedConfigDscr) % 256	;; Total Length (LSB)
	.db	(FullSpeedConfigDscrEnd - _FullSpeedConfigDscr) / 256	;; Total Length (MSB)
	.db	1														;; Number of interfaces
	.db	1														;; Configuration number
	.db	0														;; Configuration string
	.db	0b10100000												;; Attributes (b7 - buspwr, b6 - selfpwr, b5 - rwu)
	.db	50														;; Power requirement (div 2 ma)

;; Interface Descriptor
	.db	DSCR_INTRFC_LEN		;; Descriptor length
	.db	DSCR_INTRFC			;; Descriptor type
	.db	0					;; Zero-based index of this interface
	.db	0					;; Alternate setting
	.db	3					;; Number of end points 
	.db	0xff				;; Interface class
	.db	0x00				;; Interface sub class
	.db	0x00				;; Interface sub sub class
	.db	0					;; Interface descriptor string index

;; Endpoint Descriptor(O_2)
	.db	DSCR_ENDPNT_LEN		;; Descriptor length
	.db	DSCR_ENDPNT			;; Descriptor type
	.db	0x02				;; Endpoint number, and direction
	.db	ET_BULK				;; Endpoint type
	.db	0x40				;; Maximun packet size (LSB)
	.db	0x00				;; Max packect size (MSB)
	.db	0x00				;; Polling interval

;; Endpoint Descriptor(O_4)
	.db	DSCR_ENDPNT_LEN		;; Descriptor length
	.db	DSCR_ENDPNT			;; Descriptor type
	.db	0x08				;; Endpoint number, and direction
	.db	ET_BULK				;; Endpoint type
	.db	0x40				;; Maximun packet size (LSB)
	.db	0x00				;; Max packect size (MSB)
	.db	0x00				;; Polling interval

;; Endpoint Descriptor(I_6)
	.db	DSCR_ENDPNT_LEN		;; Descriptor length
	.db	DSCR_ENDPNT			;; Descriptor type
	.db	0x86				;; Endpoint number, and direction
	.db	ET_BULK				;; Endpoint type
	.db	0x40				;; Maximun packet size (LSB)
	.db	0x00				;; Max packect size (MSB)
	.db	0x00				;; Polling interval

FullSpeedConfigDscrEnd:

_StringDscr:
StringDscr:
StringDscr0:
	.db	StringDscr0End-StringDscr0		;; String descriptor length
	.db	DSCR_STRING
	.db	0x04,0x04
StringDscr0End:

StringDscr1:	
	.db	StringDscr1End-StringDscr1		;; String descriptor length
	.db	DSCR_STRING
	.ascii 'F'
	.db 0x00
	.ascii '2'
	.db	0x00
	.ascii 'F'
	.db	0x00
	.ascii 'W'
	.db	0x00
StringDscr1End:

StringDscr2:	
	.db	StringDscr2End-StringDscr2		;; Descriptor length
	.db	DSCR_STRING
	.ascii 'V'
	.db	0x00
	.ascii '1'
	.db	0x00
	.ascii '0'
	.db	0x00
	.ascii '0'
	.db	0x00
StringDscr2End:

_UserDscr:
UserDscr:
	.dw	0x0000

