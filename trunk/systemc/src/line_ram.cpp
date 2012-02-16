#include "line_ram.h"



void line_ram::ram_process() {
	if(clk.posedge()){
		if(en.read() == SC_LOGIC_1){
			if(we.read() == SC_LOGIC_1){
				ram[addr.read().to_int()].write(data_in.read());
				data_out.write(data_in.read());
//				cout << " Writing data at address " <<  addr.read().to_uint() << " with value " << data_in.read() << endl ;
			}else{
				data_out.write(ram[addr.read().to_uint()].read());
//				cout << " Reading data at address " <<  addr.read().to_uint() << " with value " << ram[addr.read().to_uint()] << endl ;
			}
		}
	}
}

