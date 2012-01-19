#include "camera_interface.h"
#include "systemc.h"

void camera_interface::sccb_interface() {

}
void camera_interface::pixel_interface() {
	if (pclock.posedge()) {
		if (href.read() && !vsync.read() && pclock.read()) {
			switch (pix_state.read()) {
			case Yinit:

			case Y1:
				u_data.write(u_delay);
				v_data.write(v_delay);
				y_delay.write(pixel_data);
				new_pix.write(1);
				break;
			case U1:
				u_delay.write(pixel_data);
				new_pix.write(0);
				break;
			case Y2:
				u_data.write(u_delay);
				v_data.write(v_delay);
				y_delay.write(pixel_data);
				new_pix.write(1);
				break;
			case V1:
				v_delay.write(pixel_data);
				new_pix.write(0);
				break;
			default:
				pix_state.write(Yinit);
				break;
			}
		} else if (!href.read() || vsync.read()) {
			pix_state.write(Yinit);
		}
	}

}

