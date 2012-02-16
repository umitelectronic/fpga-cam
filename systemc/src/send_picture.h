#ifndef SEND_PICTURE_H
#define SEND_PICTURE_H

#include "systemc.h"

#define VSYNC_CHAR	0X55

#define HSYNC_CHAR	0xA9



SC_MODULE (send_picture) {

	sc_in_clk clk;
	sc_in<bool> arazb;
	sc_in<bool> pixel_clock, hsync, vsync;
	sc_in<sc_lv<8> > pixel_data_in;
	sc_out<sc_lv<8> > data_out;
	sc_out<sc_logic> send;

	enum send_state {
		wait_pixel, write_data, wait_sync
	};

	sc_signal<send_state> state;
	sc_signal<sc_logic> isControlChar;
	sc_signal<bool> end_sig;
	sc_signal<sc_lv<2> > select_end;

	void send_picture_process();
	void update_is_control_char();
	void end_sig_mux();

	SC_CTOR(send_picture) {
		SC_METHOD(send_picture_process);
		sensitive << clk;
		sensitive << arazb;
		SC_METHOD(update_is_control_char);
		sensitive << pixel_data_in;
		SC_METHOD(end_sig_mux);
		sensitive << pixel_clock;
		sensitive << hsync;
		sensitive << vsync;
		sensitive << select_end;
	}

};

#endif
