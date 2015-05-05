################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/FirstFoundBadVersion(FirstFound).cpp 

OBJS += \
./src/FirstFoundBadVersion(FirstFound).o 

CPP_DEPS += \
./src/FirstFoundBadVersion(FirstFound).d 


# Each subdirectory must supply rules for building sources it contributes
src/FirstFoundBadVersion(FirstFound).o: ../src/FirstFoundBadVersion(FirstFound).cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O3 -Wall -c -fmessage-length=0 -MMD -MP -MF"src/FirstFoundBadVersion(FirstFound).d" -MT"src/FirstFoundBadVersion(FirstFound).d" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


