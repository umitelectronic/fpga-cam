#ifndef REGISTER_ROM_H
#define REGISTER_ROM_H

#include "systemc.h"



SC_MODULE (register_rom) {

	sc_out<sc_lv<16> > data;
	sc_in<sc_lv<8> > addr;

	sc_signal<sc_lv<16> > rom [256] ;

	
	void rom_process();
	void init_rom();


	SC_CTOR(register_rom) {
		SC_METHOD(rom_process);
		sensitive << addr;
	}

};

#endif
