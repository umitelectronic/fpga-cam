#include "register_rom.h"
#include "camera-registers.h"


void register_rom::rom_process() {
	//printf("Reading rom at %d with value %x \n", addr.read(), ov7670_yuv_regs[addr.read()][0]);
	//cout << "Reading rom at " << addr.read()<< " with value " <<   ov7670_yuv_regs[addr.read()][0] << endl;
	data.write(rom[addr.read().to_uint()].read());
	cout << "Writing data  " << rom[addr.read().to_uint()] << " to port " << endl;
}

/*
void register_rom::init_rom() {
	unsigned int i = 0;
	while (i < 256 && !(ov7670_yuv_regs[i][0] == 0xff && ov7670_yuv_regs[i][1] == 0xff)) {
		unsigned int word = ov7670_yuv_regs[i][1]  ;
		word = (word << 8) + ov7670_yuv_regs[i][0];
		rom[i] = sc_lv<16>(word);
		i ++ ;
	}
}
*/
