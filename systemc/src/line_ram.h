#ifndef LINE_RAM_H
#define LINE_RAM_H

#include "systemc.h"



SC_MODULE (line_ram) {

	sc_in_clk clk ;
	sc_in<sc_logic> we, en;
	sc_out<sc_lv<16> > data_out;
	sc_in<sc_lv<16> > data_in;
	sc_in<sc_uint<7> > addr;

	sc_signal<sc_lv<16> > ram [80] ;

	
	void ram_process();


	SC_CTOR(line_ram) {
		SC_METHOD(ram_process);
		sensitive << clk;
	}

};

#endif
