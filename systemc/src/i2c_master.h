#ifndef I2C_MASTER_H
#define I2C_MASTER_H



SC_MODULE (i2c_master) {

	sc_in_clk clock;
	sc_in<bool> arazb;
	sc_in<sc_lv<7> > slave_addr;
	sc_inout<sc_lv<8> > data;
	sc_in<bool> send;
	sc_in<bool> rcv;
	sc_inout_resolved scl;
	sc_inout_resolved sda;
	sc_out<bool> dispo, ack_byte;

	enum master_state {
		idle, i2c_start, tx_addr, ack_addr, tx_byte, rx_byte, ack, i2c_stop
	};

	sc_signal<master_state> state;
	sc_signal<sc_uint<8> > tick_count;
	sc_signal<sc_uint<8> > bit_count;
	sc_signal<sc_lv<8> > slave_addr_i;
	sc_signal<sc_lv<8> > data_i;
	sc_signal<bool> send_rvcb;

	void run_i2c();

	SC_CTOR(i2c_master) {
		SC_METHOD(run_i2c);
		sensitive << arazb;
		sensitive << clock.pos();
	}

};

#endif
