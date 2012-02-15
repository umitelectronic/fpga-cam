#ifndef CAMERA_MODEL_H
#define CAMERA_MODEL_H

#define I2C_ADDR 0x42

#include "systemc.h"
#include "i2c_slave.h"

SC_MODULE (camera_model) {

	sc_in_clk clock;
	sc_inout_rv<8> data;
	sc_in_resolved scl;
	sc_inout_resolved sda;
	sc_out<bool> pix_clk, href, vsync;



	sc_signal<sc_lv<8> > sccb_data;
	sc_signal<sc_uint<8> > sccb_index;
	sc_signal<sc_logic> sccb_wr, sccb_rd;
	i2c_slave i2c_slave0;
	unsigned int test_int;

	void sccb_interface();
	void video_timing_generator();

	SC_CTOR(camera_model) :
			i2c_slave0("i2c_slave0") {
		i2c_slave0.sda(sda);
		i2c_slave0.scl(scl);
		i2c_slave0.data(sccb_data);
		i2c_slave0.index(sccb_index);
		i2c_slave0.wr(sccb_wr);
		i2c_slave0.rd(sccb_rd);
		SC_METHOD(sccb_interface);
		sensitive << sccb_wr;
		sensitive << sccb_rd;
		SC_METHOD(video_timing_generator);
		sensitive << clock;
	}

};

#endif
