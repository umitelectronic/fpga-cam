#ifndef DOWN_SCALER_H
#define DOWN_SCALER_H

#include "systemc.h"
#include "line_ram.h"


enum scaler_state {
	wait_line, wait_pixel, write_pixel
};

SC_MODULE (down_scaler) {

	sc_in_clk clk;
	sc_in<bool> arazb ;
	sc_in<bool> pixel_clock, hsync, vsync;
	sc_out<bool> pixel_clock_out, hsync_out, vsync_out;
	sc_in<sc_lv<8> > pixel_data_in;
	sc_out<sc_lv<8> > pixel_data_out;

	sc_signal<sc_uint<7> > line_ram_addr;
	sc_signal<sc_lv<16> > line_ram_data_in, line_ram_data_out;
	sc_signal<sc_logic> line_ram_en, line_ram_we;

	sc_signal<sc_uint<16> > add_result ;
	sc_signal<sc_uint<16> > add_temp ;

	sc_signal<sc_uint<4> > nb_line_accumulated ;
	sc_signal<sc_uint<4> > nb_pix_accumulated ;

	sc_signal<scaler_state> state ;


	line_ram line_ram0;

	void down_scaler_process();
	void update_output();

	SC_CTOR(down_scaler):line_ram0("line_ram0") {

		line_ram0.clk(clk);
		line_ram0.addr(line_ram_addr);
		line_ram0.data_in(line_ram_data_in);
		line_ram0.data_out(line_ram_data_out);
		line_ram0.en(line_ram_en);
		line_ram0.we(line_ram_we);

		SC_METHOD(down_scaler_process);
		sensitive << clk;
		sensitive << arazb;

		SC_METHOD(update_output);
		sensitive << line_ram_data_out;
		sensitive << add_result ;
		sensitive << pixel_data_in ;
	}

};

#endif
