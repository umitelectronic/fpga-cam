PACKAGE = fifo.bix

XDATA_START = 0x1000

ASFLGS = -olsxff
CFLGS = --opt-code-speed -mmcs51 -DXDATA_START=$(XDATA_START)
LDFLGS = --xram-loc $(XDATA_START)

SDCC_FRAMEWORK = /home/jpiat/development/personnel/fx2-projects/sdccFramework
INCLUDE_DIR = $(SDCC_FRAMEWORK)/include
LIB_DIR = $(SDCC_FRAMEWORK)/lib
BUILD_DIR = build_by_sdcc
CC = sdcc

HEX2BIX = objcopy -I ihex -O binary

SRCS_C = \
	fw.c slave.c
SRCS_ASM = \
	dscr.asm USBJmpTb.asm

OBJS = $(SRCS_C:.c=.rel) $(SRCS_ASM:.asm=.rel)

all : $(BUILD_DIR) $(PACKAGE)

$(BUILD_DIR)/%.rel : %.c
	$(CC) -c $(CFLGS) -I$(INCLUDE_DIR) -o $@ $<

$(BUILD_DIR)/%.rel : %.asm
	cp $< $(BUILD_DIR)
	cd $(BUILD_DIR)
	asx8051 -losg $(BUILD_DIR)/$<

$(PACKAGE:.bix=.ihx) : $(patsubst %,$(BUILD_DIR)/%,$(OBJS))
	$(CC) $(LDFLGS) -o $@ -L$(LIB_DIR) -l ezusb $^

%.hex : %.ihx
	cp $< $@

$(PACKAGE) : $(PACKAGE:.bix=.hex)
	$(HEX2BIX) --pad-to 8192 $< $(PACKAGE)

$(BUILD_DIR) :
	mkdir $@

clean :
	rm -f $(PACKAGE) $(BUILD_DIR)/*

run : all

.PHONY : clean all
