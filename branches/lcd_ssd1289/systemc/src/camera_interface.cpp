#include "camera_interface.h"
#include "systemc.h"

#define NB_REGS	255

#define OV7670_I2C_ADDR 0x42

unsigned int regs[256];

void camera_interface::sccb_interface() {
	i2c_addr.write(OV7670_I2C_ADDR);
	if (!arazb) {
		reg_state.write(init);
	} else {
		switch (reg_state.read()) {
		case init:
			if (dispo.read()) {
				send.write(1);
				i2c_data.write(reg_data.read().range(15, 8));
				reg_state.write(send_addr);
			}
			break;
		case send_addr:
			if (ack_byte.read()) {
				cout << "Writing to addr " << reg_data.read().range(15, 8)
						<< " data " << reg_data.read().range(7, 0) << endl;
				send.write(1);
				i2c_data.write(reg_data.read().range(7, 0));
				reg_state.write(send_data);
			}
			break;
		case send_data:
			if (ack_byte.read()) {
				send.write(0);
				reg_state.write(next_reg);
				reg_addr.write(reg_addr.read().to_uint() + 1);
			}
			break;
		case next_reg:
			cout << "Next address is " << reg_addr.read() << endl;
			send.write(0);
			if ((!ack_byte.read()) && reg_data.read() != 0xFFFF && dispo.read()
					&& reg_addr.read().to_uint() < 255) {
				reg_state.write(send_addr);
				i2c_data.write(reg_data.read().range(15, 8));
				send.write(1);
			} else if (reg_addr.read().to_uint() >= 255
					|| reg_data.read() == 0xFFFF) {
				reg_state.write(stop);
			}
			break;
		case stop:
			send.write(0);
			reg_state.write(stop);
			break;
		default:
			reg_state.write(init);
			break;
		}
	}

}

void camera_interface::pixel_interface() {
	new_line.write(!href.read());
	new_frame.write(vsync.read());
	if (!arazb) {
		pix_state.write(Y1);
	} else if (clock.posedge()) {
		if (pxclk.read() && href.read() && !vsync.read()) {
			switch (pix_state.read()) {
			case Y1:
				y2_delay.write(pixel_data.read());
				new_pix.write(valid_pixel.read());
				next_state.write(U1);
				break;
			case U1:
				y_data.write(y1_delay.read());
				u_data.write(u_delay.read());
				v_data.write(v_delay.read());
				u_delay.write(pixel_data.read());
				new_pix.write(0);
				next_state.write(Y2);
				break;
			case Y2:
				y1_delay.write(pixel_data.read());
				new_pix.write(valid_pixel.read());
				next_state.write(V1);
				break;
			case V1:
				y_data.write(y2_delay.read());
				u_data.write(u_delay.read());
				v_data.write(pixel_data.read());
				v_delay.write(pixel_data.read());
				new_pix.write(0);
				valid_pixel.write(1);
				next_state.write(Y1);
				break;
			default:
				next_state.write(Y1);
				break;
			}
		} else if ((!pxclk.read()) && href.read() && !vsync.read()) {
			pix_state.write(next_state.read());
		} else {
			valid_pixel.write(0);
		}
	}

}

