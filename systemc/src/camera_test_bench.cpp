#include "systemc.h"
#include "i2c_master.h"
#include "camera_model.h"


int sc_main(int argc, char* argv[]) {
	sc_signal<bool> clock;
	sc_signal<bool> arazb;
	sc_signal<bool> send, rcv;
	sc_signal_resolved scl;
	sc_signal_resolved sda;
	sc_signal<bool> dispo;
	sc_signal<sc_lv<8> > data;
	sc_signal<sc_lv<8> > pixel;
	sc_signal<sc_lv<7> > addr;
	sc_signal<bool> h,v,p;
	int i = 0;

	i2c_master i2c_master0("i2c_master0");
	i2c_master0.clock(clock);
	i2c_master0.arazb(arazb);
	i2c_master0.data(data);
	i2c_master0.slave_addr(addr);
	i2c_master0.send(send);
	i2c_master0.rcv(rcv);
	i2c_master0.sda(sda);
	i2c_master0.scl(scl);
	i2c_master0.dispo(dispo);


	camera_model camera0("camera0");
	camera0.scl(scl);
	camera0.sda(sda);
	camera0.clock(clock);
	camera0.data(pixel);
	camera0.href(h);
	camera0.vsync(v);
	camera0.pix_clk(p);
	sc_start(1);

	// Open VCD file
	sc_trace_file *wf = sc_create_vcd_trace_file("camera");
	// Dump the desired signals
	sc_trace(wf, clock, "clock");
	sc_trace(wf, arazb, "arazb");
	sc_trace(wf, sda, "sda");
	sc_trace(wf, scl, "scl");
	sc_trace(wf, data, "data");
	sc_trace(wf, addr, "slave_addr");
	sc_trace(wf, send, "send");
	sc_trace(wf, rcv, "rcv");
	sc_trace(wf, dispo, "dispo");
	sc_trace(wf, pixel, "pixel");
	sc_trace(wf, h, "href");
	sc_trace(wf, p, "pxclk");
	sc_trace(wf, v, "vsync");
	send = 0;
	rcv = 0;
	data = 0x055;
	addr = 0x040;
	for (i = 0; i < 2; i++) {
		clock = 0;
		sc_start(1);
		clock = 1;
		sc_start(1);
	}
	send = 1;
	for (i = 0; i < 2; i++) {
		clock = 0;
		sc_start(1);
		clock = 1;
		sc_start(1);
	}
	send = 0;
	while (!dispo.read()) {
		clock = 0;
		sc_start(1);
		clock = 1;
		sc_start(1);
	}
	for (i = 0; i < 1000000; i++) {
		clock = 0;
		sc_start(1);
		clock = 1;
		sc_start(1);
	}
	cout << "@" << sc_time_stamp() << " Terminating simulation\n" << endl;
	sc_close_vcd_trace_file(wf);
	return 0; // Terminate simulation

}
