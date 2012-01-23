//#ifndef REGISTER_ROM_H
//#define REGISTER_ROM_H

#include "systemc.h"



SC_MODULE (register_rom) {

	sc_out<sc_uint<16> > data;
	sc_in<sc_uint<8> > addr;

	//sc_uint<16> rom [256] ;




	SC_CTOR(register_rom) {
		//init_rom();
		SC_METHOD(rom_process);
		sensitive << addr;
	};

	void rom_process();
	void init_rom();

};

//#endif
