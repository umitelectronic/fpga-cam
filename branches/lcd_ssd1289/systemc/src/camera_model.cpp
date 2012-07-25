#include "camera_model.h"

unsigned int camera_regs[256];
unsigned int px_count, line_count, byte_count;

#define BYTE_PER_PIXEL 2

unsigned int getY1at(unsigned int xpos, unsigned int ypos) {
	return 64;
}

unsigned int getY2at(unsigned int xpos, unsigned int ypos) {
	return 128;
}

unsigned int getUat(unsigned int xpos, unsigned int ypos) {
	return 0xAA;
}

unsigned int getVat(unsigned int xpos, unsigned int ypos) {
	return 0x55;
}
void camera_model::sccb_interface() {
	if (sccb_wr.posedge()) {
		camera_regs[sccb_index.read()] = sccb_data.read().to_uint();
		cout << "Writing " << sccb_data.read() << " to reg "
				<< sccb_index.read() << endl;
	}
}

void camera_model::video_timing_generator() {
	if (clock.posedge()) {
		pix_clk.write(1);

	} else if (clock.negedge()) {
		pix_clk.write(0);

		if (px_count < 640 * BYTE_PER_PIXEL && line_count >= 17
				&& line_count < 497) {
			href.write(1);
		} else if (line_count <= 17
				|| line_count >= 497 || px_count >= 640*BYTE_PER_PIXEL) {href
			.write(0);
		}

		if (line_count < 3) {
			vsync.write(1);
		} else {
			vsync.write(0);
		}

		switch (byte_count) {
		case 0:
			data.write(getY1at(px_count, line_count));
			break;
		case 1:
			data.write(getUat(px_count, line_count));
			break;
		case 2:
			data.write(getY2at(px_count, line_count));
			break;
		case 3:
			data.write(getVat(px_count, line_count));
			break;
		default:
			break;
		}
		if (byte_count < 3) {
			byte_count++;
		} else {
			byte_count = 0;
		}

		px_count++;
		if (px_count == 784 * BYTE_PER_PIXEL) {
			px_count = 0;
			byte_count = 0 ;
			line_count++;
		}
		if (line_count > 510) {
			line_count = 0;
		}
	}
}



