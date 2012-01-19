#include "systemc.h"
#include "i2c_master.h"



int sc_main(int argc, char* argv[]) {
	sc_signal<bool> clock;
	sc_signal<bool> arazb;
	sc_signal<bool> send, rcv;
	sc_signal_resolved scl;
	sc_signal_resolved sda;
	sc_signal<bool> dispo;
	sc_signal<sc_lv<8> > data;
	sc_signal<sc_lv<7> > addr;

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





	sc_start(1);

	// Open VCD file
	sc_trace_file *wf = sc_create_vcd_trace_file("i2c_master");
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
	for (i = 0; i < 10; i++) {
		clock = 0;
		sc_start(1);
		clock = 1;
		sc_start(1);
	}
	cout << "@" << sc_time_stamp() << " Terminating simulation\n" << endl;
	sc_close_vcd_trace_file(wf);
	return 0; // Terminate simulation

}
