################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/FirstBadVersion(FirstFound).cpp 

OBJS += \
./src/FirstBadVersion(FirstFound).o 

CPP_DEPS += \
./src/FirstBadVersion(FirstFound).d 


# Each subdirectory must supply rules for building sources it contributes
src/FirstBadVersion(FirstFound).o: ../src/FirstBadVersion(FirstFound).cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"src/FirstBadVersion(FirstFound).d" -MT"src/FirstBadVersion(FirstFound).d" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


