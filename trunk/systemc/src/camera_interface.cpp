#include "camera_interface.h"
#include "systemc.h"

#define NB_REGS	255

unsigned int regs[256];

void camera_interface::sccb_interface() {
	i2c_data.write(regs[reg_count.read()]);
	i2c_addr.write(I2C_ADDR);
	if (dispo.negedge()) {
		reg_count.write(reg_count.read() + 1);
	}
	if (reg_count.read() < NB_REGS) {
		send.write(dispo.read());
	}else{
		send.write(0);
	}

}
void camera_interface::pixel_interface() {
	if (pclock.posedge()) {
		if (href.read() && !vsync.read() && pclock.read()) {
			switch (pix_state.read()) {
			case Y1:
				y2_delay.write(pixel_data.read());
				new_pix.write(valid_pixel.read());
				pix_state.write(U1);
				break;
			case U1:
				y_data.write(y1_delay.read());
				u_data.write(u_delay.read());
				v_data.write(v_delay.read());
				u_delay.write(pixel_data.read());
				new_pix.write(0);
				pix_state.write(Y2);
				break;
			case Y2:
				y1_delay.write(pixel_data.read());
				new_pix.write(valid_pixel.read());
				pix_state.write(V1);
				break;
			case V1:
				y_data.write(y2_delay.read());
				u_data.write(u_delay.read());
				v_data.write(pixel_data.read());
				v_delay.write(pixel_data.read());
				valid_pixel.write(1);
				new_pix.write(0);
				pix_state.write(Y1);
				break;
			default:
				pix_state.write(Y1);
				break;
			}
		} else if (!href.read() || vsync.read()) {
			pix_state.write(Y1);
			valid_pixel.write(0);
		}
	}

}

