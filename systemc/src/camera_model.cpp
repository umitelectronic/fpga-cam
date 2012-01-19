#include "camera_model.h"

unsigned int regs[256];
unsigned int px_count, line_count;

void camera_model::sccb_interface() {
	if (sccb_wr.posedge()) {
		regs[sccb_index.read()] = sccb_data.read().to_uint();
		cout << "Writing " << sccb_data.read() << " to reg "
				<< sccb_index.read() << endl;
	}
}

void camera_model::video_timing_generator() {
	if (clock.posedge()) {
		pix_clk.write(1);
		px_count++;
		if (px_count < 640 && line_count > 17 && line_count < 497) {
			href.write(1);
		} else if (line_count < 17 || line_count > 497) {
			href.write(0);
		}
		if(px_count > 784){
			px_count = 0;
			line_count++;
		}
		if (line_count < 3) {
			vsync.write(1);
		} else {
			vsync.write(0);
		}

		if (line_count > 510) {
			line_count = 0;
		}
	} else {
		pix_clk.write(0);
	}
}
