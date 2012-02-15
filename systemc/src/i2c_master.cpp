#include "systemc.h"
#include "i2c_master.h"

#define QUARTER_BIT 4
#define HALF_BIT 8
#define FULL_BIT 16

void i2c_master::run_i2c() {
	switch (state.read()) {
	case idle:
		scl.write(SC_LOGIC_Z);
		sda.write(SC_LOGIC_Z);
		dispo.write(1);
		ack_byte.write(0);
		if (send.read() || rcv.read()) {
			slave_addr_i.write((slave_addr.read(), rcv.read()));
			send_rvcb.write(send.read());
			state.write(i2c_start);
			tick_count.write(0);
			bit_count.write(0);
			cout << "loading addr " << slave_addr.read() << endl;
			cout << "loading data " << data.read() << endl;
		}
		break;
	case i2c_start:
		//cout << "start  " << endl;
		dispo.write(0);
		ack_byte.write(0);
		if (tick_count.read() < QUARTER_BIT) {
			scl.write(SC_LOGIC_Z);
			sda.write(SC_LOGIC_Z);
			tick_count.write(tick_count.read() + 1);
		} else if (tick_count.read() < HALF_BIT) {
			scl.write(SC_LOGIC_Z);
			sda.write(SC_LOGIC_0);
			tick_count.write(tick_count.read() + 1);
		} else {
			tick_count.write(0);
			scl.write(SC_LOGIC_0);
			state.write(tx_addr);
		}
		break;
	case tx_addr:
		dispo.write(0);
		ack_byte.write(0);
		if (bit_count.read() < 8) {
			if (tick_count.read() < HALF_BIT) {
				scl.write(SC_LOGIC_0);
				if (slave_addr_i.read()[7] == SC_LOGIC_1) {
					//cout << "sending bit 1 " << endl;
					sda.write(SC_LOGIC_Z);
				} else {
					//cout << "sending bit 0 " << endl;
					sda.write(SC_LOGIC_0);
				}
				tick_count.write(tick_count.read() + 1);
			} else if (tick_count.read() < FULL_BIT) {
				scl.write(SC_LOGIC_Z);
				if (slave_addr_i.read()[7] == SC_LOGIC_1) {
					sda.write(SC_LOGIC_Z);
				} else {
					sda.write(SC_LOGIC_0);
				}
				tick_count.write(tick_count.read() + 1);
			} else {
				slave_addr_i.write(
						(slave_addr_i.read().range(6, 0), SC_LOGIC_0));
				bit_count.write(bit_count.read() + 1);
				tick_count.write(0);
			}
		} else {
			bit_count.write(0);
			scl.write(SC_LOGIC_0);
			state.write(ack_addr);
		}
		break;
	case ack_addr:
		//cout << "ack addr  " << endl;
		dispo.write(0);
		ack_byte.write(0);
		if (tick_count.read() < HALF_BIT) {
			scl.write(SC_LOGIC_0);
			sda.write(SC_LOGIC_Z);
			tick_count.write(tick_count.read() + 1);
		} else if (tick_count.read() < FULL_BIT) {
			scl.write(SC_LOGIC_Z);
			sda.write(SC_LOGIC_Z);
			tick_count.write(tick_count.read() + 1);
		} else {
			tick_count.write(0);
			if (sda.read() == SC_LOGIC_0) {
				cout << "ack received  " << endl;
				if (send_rvcb.read()) {
					data_i.write(data.read());
					state.write(tx_byte);
				} else {
					data.write(data_i.read());
					state.write(rx_byte);
				}

			} else {
				state.write(i2c_stop);
			}
		}
		break;
	case tx_byte:
		//cout << "tx byte " << endl;
		dispo.write(0);
		ack_byte.write(0);
		if (bit_count.read() < 8) {
			if (tick_count.read() < HALF_BIT) {
				scl.write(SC_LOGIC_0);
				if (data_i.read()[7] == SC_LOGIC_1) {
					sda.write(SC_LOGIC_Z);
				} else {
					sda.write(SC_LOGIC_0);
				}
				tick_count.write(tick_count.read() + 1);
			} else if (tick_count.read() < FULL_BIT) {
				scl.write(SC_LOGIC_Z);
				if (data_i.read()[7] == SC_LOGIC_1) {
					sda.write(SC_LOGIC_Z);
				} else {
					sda.write(SC_LOGIC_0);
				}
				tick_count.write(tick_count.read() + 1);
			} else {
				data_i.write((data_i.read().range(6, 0), SC_LOGIC_0));
				bit_count.write(bit_count.read() + 1);
				tick_count.write(0);
			}
		} else {
			bit_count.write(0);
			scl.write(SC_LOGIC_0);
			state.write(ack);
		}
		break;
	case rx_byte:
		//cout << "rx byte " << endl;
		dispo.write(0);
		ack_byte.write(0);
		if (bit_count.read() < 8) {
			if (tick_count.read() < HALF_BIT) {
				scl.write(SC_LOGIC_0);
				sda.write(SC_LOGIC_Z);
				tick_count.write(tick_count.read() + 1);
			} else if (tick_count.read() < FULL_BIT) {
				scl.write(SC_LOGIC_Z);
				data_i.write((data_i.read().range(7, 1), sda.read()));
				tick_count.write(tick_count.read() + 1);
			} else {
				data_i.write((data_i.read().range(6, 0), SC_LOGIC_0));
				bit_count.write(bit_count.read() + 1);
				tick_count.write(0);
			}
		} else {
			bit_count.write(0);
			scl.write(SC_LOGIC_0);
			state.write(ack);
		}
		break;
	case ack:
		//cout << "ack " << endl;
		dispo.write(0);
		ack_byte.write(1);
		if (tick_count.read() < HALF_BIT) {
			scl.write(SC_LOGIC_0);
			sda.write(SC_LOGIC_Z);
			tick_count.write(tick_count.read() + 1);
		} else if (tick_count.read() < FULL_BIT) {
			scl.write(SC_LOGIC_Z);
			sda.write(SC_LOGIC_Z);
			tick_count.write(tick_count.read() + 1);
		} else {
			tick_count.write(0);
			if (sda.read() == SC_LOGIC_0
					&& ((send.read() && send_rvcb.read())
							|| (rcv.read() && !send_rvcb.read()))) {
				if (send_rvcb.read()) {
					data_i.write(data.read());
					state.write(tx_byte);
				} else {
					data.write(data_i.read());
					state.write(rx_byte);
				}

			} else {
				state.write(i2c_stop);
			}
		}
		break;
	case i2c_stop:
		//cout << "stop " << endl;
		dispo.write(1);
		ack_byte.write(0);
		if (tick_count.read() < HALF_BIT) {
			scl.write(SC_LOGIC_0);
			sda.write(SC_LOGIC_0);
			tick_count.write(tick_count.read() + 1);
		} else if (tick_count.read() < HALF_BIT + QUARTER_BIT) {
			scl.write(SC_LOGIC_Z);
			sda.write(SC_LOGIC_0);
			tick_count.write(tick_count.read() + 1);
		} else if (tick_count.read() < FULL_BIT) {
			scl.write(SC_LOGIC_Z);
			sda.write(SC_LOGIC_Z);
			tick_count.write(tick_count.read() + 1);
		} else {
			tick_count.write(0);
			state.write(idle);
		}
		break;
	default:
		state.write(idle);
		break;
	}
}

