#ifndef ADD_16_H
#define ADD_16_H

#include "systemc.h"



SC_MODULE (adder_16) {

	sc_in<sc_lv<16> > IN1, IN2;
	sc_out<sc_lv<16> > OUT;

	void add_process();

	SC_CTOR(adder_16) {
		SC_METHOD(add_process);
		sensitive << IN1;
		sensitive << IN2;
	}

};

#endif
