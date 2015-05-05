################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/Reverse\ String.cpp 

OBJS += \
./src/Reverse\ String.o 

CPP_DEPS += \
./src/Reverse\ String.d 


# Each subdirectory must supply rules for building sources it contributes
src/Reverse\ String.o: ../src/Reverse\ String.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"src/Reverse String.d" -MT"src/Reverse\ String.d" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


