#ifndef CAMERA_MODEL_H
#define CAMERA_MODEL_H

#include "systemc.h"
#include "i2c_master.h"

#define I2C_ADDR 0x40
SC_MODULE (camera_interface) {

	sc_in_clk clock;
	sc_in_clk pclock;
	sc_in_clk i2c_clk ;
	sc_in<bool> arazb;
	sc_inout_rv<8> pixel_data;
	sc_inout<sc_lv<8> > y_data;
	sc_inout<sc_lv<8> > u_data;
	sc_inout<sc_lv<8> > v_data;
	sc_inout_resolved scl;
	sc_inout_resolved sda;
	sc_out<bool> new_pix, new_line, new_frame;
	sc_in<bool> pxclk, href, vsync;


	enum pixel_state {
		Yinit,Y1,U1,Y2,V1
		};

	sc_signal<sc_lv<8> > i2c_data;
	sc_signal<sc_lv<8> > i2c_addr;
	sc_signal<bool> send;
	sc_signal<bool> rcv;
	sc_signal<bool> dispo;
	sc_signal<pixel_state > pix_state;


	sc_signal<sc_lv<8> > y_delay, u_delay, v_delay;

	sc_signal<sc_logic> sccb_wr, sccb_rd;
	i2c_master i2c_master0;

	void sccb_interface();
	void pixel_interface();

	SC_CTOR(camera_interface) :
		i2c_master0("i2c_master0") {
		i2c_master0.sda(sda);
		i2c_master0.scl(scl);
		i2c_master0.data(i2c_data);
		i2c_master0.send(send);
		i2c_master0.rcv(rcv);
		i2c_master0.dispo(dispo);

		SC_METHOD(sccb_interface);
		sensitive << dispo;

		SC_METHOD(pixel_interface);
		sensitive << pclock.pos();
	}

};

#endif
