#include "down_scaler.h"

void down_scaler::update_output() {
	pixel_data_out.write(line_ram_data_out.read().range(11, 3)); // shifted by 3 for division by 8
	add_temp.write(
			add_result.read().to_uint() + pixel_data_in.read().to_uint());
}

void down_scaler::down_scaler_process() {
	if (!arazb.read()) {
		nb_line_accumulated.write(0);
		nb_pix_accumulated.write(0);
		add_result.write(0);
		state.write(wait_line);
	} else {
		if (clk.posedge()) {
			vsync_out.write(vsync.read());
			switch (state.read()) {
			case wait_line:
				pixel_clock_out.write(0);
				line_ram_en.write(SC_LOGIC_0);
				line_ram_we.write(SC_LOGIC_0);
				if (vsync.read()) {
					nb_line_accumulated.write(0);
					nb_pix_accumulated.write(0);
					hsync_out.write(1);
					line_ram_addr.write(0);
				} else if (!hsync.read()) {
					state.write(wait_pixel);
				}
				break;
			case wait_pixel:
				line_ram_en.write(SC_LOGIC_0);
				line_ram_we.write(SC_LOGIC_0);
				if (hsync.read()) {
					line_ram_addr.write(0);
					nb_pix_accumulated.write(0);
					if (nb_line_accumulated.read() == 7) {
						nb_line_accumulated.write(0);
						add_result.write(0);
						hsync_out.write(1);
					} else {
						hsync_out.write(0);
						nb_line_accumulated.write(
								nb_line_accumulated.read() + 1);
					}
					line_ram_we.write(SC_LOGIC_0);
					state.write(wait_line);
				} else if (pixel_clock.read()) {
					pixel_clock_out.write(0);
					hsync_out.write(0);
					if (nb_pix_accumulated.read().to_uint() == 0) {
						add_result.write(
								("00000000", pixel_data_in.read()).to_uint());
					} else if (nb_pix_accumulated.read().to_uint() == 7) {
						if (nb_line_accumulated.read() == 0) {
							line_ram_data_in.write(
									sc_lv<16>(add_temp.read().range(11, 3)));
						} else {
							line_ram_data_in.write(
									sc_lv<16>(
											add_temp.read().range(11, 3).to_uint()
													+ line_ram_data_out.read().to_uint()));
						}
						line_ram_we.write(SC_LOGIC_1);
						line_ram_en.write(SC_LOGIC_1);
					} else {
						add_result.write(add_temp);
					}
					state.write(write_pixel);
				}
				break;
			case write_pixel:
				line_ram_we.write(SC_LOGIC_0);
				line_ram_en.write(SC_LOGIC_0);
				if (!pixel_clock.read()) {
					if (nb_line_accumulated.read() == 7
							&& nb_pix_accumulated.read() == 7) {
						pixel_clock_out.write(1);
					} else {
						pixel_clock_out.write(0);
					}
					if (nb_pix_accumulated.read().to_uint() == 7) {
						line_ram_addr.write(line_ram_addr.read().to_uint() + 1);
						nb_pix_accumulated.write(0);
					} else {
						if (nb_pix_accumulated.read().to_uint() != 0) {
							line_ram_en.write(SC_LOGIC_1);
						}
						nb_pix_accumulated.write(nb_pix_accumulated.read() + 1);
					}
					state.write(wait_pixel);
				}
				break;
			default:

				break;
			}
		}

	}
}

