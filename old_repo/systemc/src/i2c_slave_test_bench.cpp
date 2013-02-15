#include "systemc.h"
#include "i2c_master.h"
#include "i2c_slave.h"


int sc_main(int argc, char* argv[]) {
	sc_signal<bool> clock;
	sc_signal<bool> arazb;
	sc_signal<bool> send, rcv;
	sc_signal_resolved scl;
	sc_signal_resolved sda;
	sc_signal<bool> dispo;
	sc_signal<sc_lv<8> > data;
	sc_signal<sc_lv<8> > data_out;
	sc_signal<sc_uint<8> > index_out;
	sc_signal<sc_lv<7> > addr;
	sc_signal<sc_logic> rd, wr;
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


	i2c_slave i2c_slave0("i2c_slave0");
	i2c_slave0.scl(scl);
	i2c_slave0.sda(sda);
	i2c_slave0.data(data_out);
	i2c_slave0.wr(wr);
	i2c_slave0.rd(rd);
	i2c_slave0.index(index_out);
	sc_start(1);

	// Open VCD file
	sc_trace_file *wf = sc_create_vcd_trace_file("i2c_slave");
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
	sc_trace(wf, data_out, "data_out");
	sc_trace(wf, index_out, "index_out");
	sc_trace(wf, wr, "wr");
	sc_trace(wf, rd, "rd");
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
