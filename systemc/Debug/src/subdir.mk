################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/camera_model.cpp \
../src/i2c_master.cpp \
../src/i2c_master_test_bench.cpp \
../src/i2c_slave.cpp \
../src/i2c_slave_test_bench.cpp 

OBJS += \
./src/camera_model.o \
./src/i2c_master.o \
./src/i2c_master_test_bench.o \
./src/i2c_slave.o \
./src/i2c_slave_test_bench.o 

CPP_DEPS += \
./src/camera_model.d \
./src/i2c_master.d \
./src/i2c_master_test_bench.d \
./src/i2c_slave.d \
./src/i2c_slave_test_bench.d 


# Each subdirectory must supply rules for building sources it contributes
src/%.o: ../src/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -I/usr/lib64/systemc-2.2/include -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


