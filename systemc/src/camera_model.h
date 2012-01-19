#ifndef CAMERA_MODEL_H
#define CAMERA_MODEL_H

#include "systemc.h"

#define I2C_ADDR 0x40

SC_MODULE (camera_model) {

	sc_in_clk clock;
	sc_inout<sc_lv<8> > data;
	sc_in<sc_logic> scl;
	sc_inout<sc_logic> sda;
	sc_out<bool> pix_clk, hsync, vsync;

	sc_signal<sc_uint<8> > i2c_buffer;

	void i2c_slave();

	SC_CTOR(camera_model) {
		SC_METHOD(i2c_slave);
		sensitive << scl;
	}

};

#endif
