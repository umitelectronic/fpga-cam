#include "systemc.h"
#include "i2c_slave.h"

void i2c_slave::run_i2c() {
	switch (state.read()) {
	case detect_start:
		cout << "waiting for start " << endl;
		cout << "scl= " << scl.read() << "sda= " << sda.read() << endl;
		rd.write(SC_LOGIC_0);
		wr.write(SC_LOGIC_0);
		if (scl.read() == SC_LOGIC_Z && sda.read() == SC_LOGIC_0) {
			state.write(rx_addr);
			new_bit.write(0);
			cout << "start detected " << endl;
		}
		break;
	case rx_addr:
		//cout << "receiving address" << endl;
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
			//cout << "address received " << data_i.read() << endl;
			if (data_i.read() == SLAVE_READ_ADDR) {
				tx_rxb.write(1);
				state.write(ack_addr);
			} else if (data_i.read() == SLAVE_WRITE_ADDR) {
				tx_rxb.write(0);
				state.write(ack_addr);
			} else {
				state.write(nack);
			}
			new_bit.write(0);
			bit_count.write(0);
		}
		break;
	case ack_addr:
		//cout << "sending ack " << endl;
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
		rd.write(SC_LOGIC_0);
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
			state.write(detect_ack);
		}
		if (data_i.read()[7] == SC_LOGIC_1) {
			sda.write(SC_LOGIC_Z);
		} else {
			sda.write(SC_LOGIC_Z);
		}
		break;
	case rx_byte:
		//cout << "rx_byte" << endl;
		wr.write(SC_LOGIC_0);
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
			} else {
				if (data_i.read()[0] == SC_LOGIC_0
						&& sda.read() == SC_LOGIC_Z) {
					//cout << "stop condition detected !" << endl;
					bit_count.write(0);
					index.write(0);
					sda.write(SC_LOGIC_Z);
					state.write(detect_start);
				}
			}
		} else {
			cout << "byte received " << data_i.read() << endl;
			if (scl.read() == SC_LOGIC_0) {
				//cout << "sending ack " << endl;
				sda.write(SC_LOGIC_0);
			}
			bit_count.write(0);
			index.write(index.read() + 1);
			state.write(ack_byte);
		}
		break;
	case ack_byte:
		data.write(data_i.read());
		wr.write(SC_LOGIC_1);
		if (scl.read() == SC_LOGIC_Z) {
			new_bit.write(0);
			state.write(rx_byte);
		}
		break;
	case nack:
		cout << "sending nack " << endl;
		sda.write(SC_LOGIC_Z);
		break;
	case detect_stop:
		break;
	default:
		state.write(detect_start);
		break;
	}
}
