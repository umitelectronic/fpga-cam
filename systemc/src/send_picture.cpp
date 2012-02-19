#include "send_picture.h"



void send_picture::end_sig_mux(){
	if(select_end.read().to_uint() == 1){
		end_sig.write(!vsync.read());
	}else if(select_end.read().to_uint() == 2){
		end_sig.write(vsync.read() || !hsync.read());
	}else{
		end_sig.write(!pixel_clock.read());
	}
}


void send_picture::update_is_control_char() {
	isControlChar.write(
			sc_logic(
					(pixel_data_in.read() == HSYNC_CHAR)
							|| (pixel_data_in.read() == VSYNC_CHAR)));
}

void send_picture::send_picture_process() {

	if (!arazb.read()) {
		state.write(wait_pixel);
	} else if (clk.posedge()) {
		switch (state.read()) {
		case wait_pixel:
			send.write(SC_LOGIC_0);
			if (pixel_clock.read()) {
				data_out.write(
						(pixel_data_in.read().range(7, 1), pixel_data_in.read()[0]
								| isControlChar.read()));
				select_end.write(0);
				state.write(write_data);
			} else if (vsync.read()) {
				data_out.write(VSYNC_CHAR);
				select_end.write(1);
				state.write(write_data);
			} else if (hsync.read()) {
				data_out.write(HSYNC_CHAR);
				select_end.write(2);
				state.write(write_data);
			}
			break;
		case write_data:
			send.write(SC_LOGIC_1);
			state.write(wait_sync);
			break;
		case wait_sync:
			send.write(SC_LOGIC_0);
			if(end_sig.read()){
				state.write(wait_pixel);
			}
			break;
		default:
			state.write(wait_pixel);
			break;

		}
	}else if (clk.negedge()) {
		switch(state){
			case write_data :
				send.write(SC_LOGIC_1);
			break ;
			default :
				send.write(SC_LOGIC_0);
			break;
		}
	}
}

