#include "systemc.h"
#include "i2c_slave.h"

#define SLAVE_WRITE_ADDR "10000000"
#define SLAVE_READ_ADDR "10000001"

void i2c_slave::run_i2c() {
	switch (state.read()) {
	case detect_start:
		cout << "waiting for start " << endl;
		cout << "scl= "<<scl.read()<< "sda= " << sda.read() << endl;
		if (scl.read() == SC_LOGIC_Z && sda.read() == SC_LOGIC_0) {
			state.write(rx_addr);
			new_bit.write(0);
			cout << "start detected " << endl;
		}
		break;
	case rx_addr:
		cout << "receiving address" << endl;
		if (bit_count.read() < 8) {
			if (scl.read() == SC_LOGIC_0) {
				sda.write(SC_LOGIC_Z);
				data_i.write((data_i.read().range(6, 0), SC_LOGIC_0));
				new_bit.write(1);
			} else if (scl.read() == SC_LOGIC_Z && new_bit.read()) {
				new_bit.write(0);
				bit_count.write(bit_count.read() + 1);
				if (sda.read() == SC_LOGIC_Z) {
					data_i.write((data_i.read().range(7, 1), SC_LOGIC_1));
				} else {
					data_i.write((data_i.read().range(7, 1), SC_LOGIC_0));
				}
			}
		} else {
			cout << "address received " << data_i.read() <<endl;
			if (data_i.read() == SLAVE_READ_ADDR) {
				tx_rxb.write(1);
				state.write(ack);
			} else if (data_i.read() == SLAVE_WRITE_ADDR) {
				tx_rxb.write(0);
				state.write(ack);
			} else {
				state.write(nack);
			}
			new_bit.write(0);
			bit_count.write(0);
		}
		break;
	case ack:
		cout << "sending ack " <<endl;
		data.write(data_i.read());
		if (!new_bit.read()) {
			if (scl.read() == SC_LOGIC_0) {
				sda.write(SC_LOGIC_0);
				new_bit.write(1);
			} else {
				new_bit.write(1);
			}
		} else {
			new_bit.write(0);
			state.write(rx_byte);
		}
		break;
	case tx_byte:
		if (bit_count.read() < 8) {
			if (scl.read() == SC_LOGIC_0 && !new_bit.read()) {
				new_bit.write(1);
				data_i.write((data_i.read().range(6, 0), SC_LOGIC_0));
				bit_count.write(bit_count.read() + 1);
			} else if (scl.read() == SC_LOGIC_Z && new_bit.read()) {
				new_bit.write(0);
			}
		} else {
			bit_count.write(0);
			state.write(ack);
		}
		if (data_i.read()[7] == SC_LOGIC_1) {
			sda.write(SC_LOGIC_Z);
		} else {
			sda.write(SC_LOGIC_Z);
		}
		break;
	case rx_byte:
		if (bit_count.read() < 8) {
			if (scl.read() == SC_LOGIC_0) {
				sda.write(SC_LOGIC_Z);
				data_i.write((data_i.read().range(6, 0), SC_LOGIC_0));
				new_bit.write(1);
			} else if (scl.read() == SC_LOGIC_Z && new_bit.read()) {
				new_bit.write(0);
				bit_count.write(bit_count.read() + 1);
				if (sda.read() == SC_LOGIC_Z) {
					data_i.write((data_i.read().range(7, 1), SC_LOGIC_1));
				} else {
					data_i.write((data_i.read().range(7, 1), SC_LOGIC_0));
				}
			}
		} else {
			cout << "byte received " << data_i.read() <<endl;
			bit_count.write(0);
			state.write(ack);
		}
		break;
	case nack:
		cout << "sending nack " << endl;
		sda.write(SC_LOGIC_Z);
		break;
	case detect_stop:
		cout << "stop " << endl;
		state.write(detect_start);
		break;
	default:
		state.write(detect_start);
		break;
	}
}
