#include "systemc.h"
#include "div_clock.h"

	
void div_clock::div_clock_process(){
	if(clk.posedge()){
		clk_2.write(not clk_2.read());
	}
}


