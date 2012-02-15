#include "adder_16.h"



void adder_16::add_process() {
	OUT.write(sc_lv<16>(IN1.read().to_uint() + IN2.read().to_uint()));
}

