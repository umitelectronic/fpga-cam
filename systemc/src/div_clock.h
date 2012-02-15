#ifndef DIV_CLOCK_H
#define DIV_CLOCK_H

#include "systemc.h"



SC_MODULE (div_clock) {

	sc_in_clk clk ;
	sc_out<bool> clk_2;

	
	void div_clock_process();


	SC_CTOR(div_clock) {
		SC_METHOD(div_clock_process);
		sensitive << clk;
	}

};

#endif
