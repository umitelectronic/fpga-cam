#ifndef I2C_SLAVE_H
#define I2C_SLAVE_H

#define SLAVE_WRITE_ADDR 0x84
#define SLAVE_READ_ADDR 0x81

SC_MODULE (i2c_slave) {

	sc_inout<sc_lv<8> > data;
	sc_inout< sc_uint<8> > index;
	sc_out<sc_logic> rd, wr ;
	sc_in_resolved scl;
	sc_inout_resolved sda;
	enum slave_state {
		detect_start, rx_addr, ack_addr, ack_byte, detect_ack,nack, tx_byte, rx_byte, detect_stop
	};
	sc_signal<slave_state> state;
	sc_signal<sc_lv<8> > data_i;
	sc_signal<bool> tx_rxb, new_bit;
	sc_signal<sc_uint<8> > bit_count;

	void run_i2c();

	SC_CTOR(i2c_slave) {
		SC_METHOD(run_i2c);
		sensitive << scl;
		sensitive << sda;
	}

};

#endif
