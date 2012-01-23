#include "systemc.h"
#include "camera_model.h"
#include "camera_interface.h"

int sc_main(int argc, char* argv[]) {
	sc_signal<bool> clock;
	sc_signal<bool> arazb;
	sc_signal<bool> send, rcv;
	sc_signal_resolved scl;
	sc_signal_resolved sda;
	sc_signal<bool> dispo;
	sc_signal<sc_lv<8> > data_y, data_u, data_v;
	sc_signal_rv<8> pixel;
	sc_signal<bool> h, v, p, new_pix, new_line, new_frame;
	int i = 0;

	camera_model camera0("camera0");
	camera0.scl(scl);
	camera0.sda(sda);
	camera0.clock(clock);
	camera0.data(pixel);
	camera0.href(h);
	camera0.vsync(v);
	camera0.pix_clk(p);

	camera_interface camera_interface0("camera_interface0");
	camera_interface0.clock(clock);
	camera_interface0.arazb(arazb);
	camera_interface0.pixel_data(pixel);
	camera_interface0.vsync(v);
	camera_interface0.href(h);
	camera_interface0.pxclk(p);
	camera_interface0.pclock(clock);
	camera_interface0.sda(sda);
	camera_interface0.scl(scl);
	camera_interface0.i2c_clk(clock);
	camera_interface0.y_data(data_y);
	camera_interface0.u_data(data_u);
	camera_interface0.v_data(data_v);
	camera_interface0.new_pix(new_pix);
	camera_interface0.new_line(new_line);
	camera_interface0.new_frame(new_frame);

	sc_start(1);

	// Open VCD file
	sc_trace_file *wf = sc_create_vcd_trace_file("camera_interface");
	// Dump the desired signals
	sc_trace(wf, clock, "clock");
	sc_trace(wf, arazb, "arazb");
	sc_trace(wf, sda, "sda");
	sc_trace(wf, scl, "scl");
	sc_trace(wf, data_y, "data_y");
	sc_trace(wf, data_u, "data_u");
	sc_trace(wf, data_v, "data_v");
	sc_trace(wf, new_pix, "new_pix");
	sc_trace(wf, new_line, "new_line");
	sc_trace(wf, new_frame, "new_frame");
	sc_trace(wf, pixel, "pixel");
	sc_trace(wf, h, "href");
	sc_trace(wf, p, "pxclk");
	sc_trace(wf, v, "vsync");
	sc_trace(wf, pixel, "pixel");
	sc_trace(wf, camera_interface0.dispo, "dispo");
	sc_trace(wf, camera_interface0.ack_byte, "ack_byte");
	sc_trace(wf, camera_interface0.send, "send_reg_byte");

	for (i = 0; i < 2000000; i++) {
		clock = 0;
		sc_start(1);
		clock = 1;
		sc_start(1);
	}
	cout << "@" << sc_time_stamp() << " Terminating simulation\n" << endl;
	sc_close_vcd_trace_file(wf);
	return 0; // Terminate simulation

}
