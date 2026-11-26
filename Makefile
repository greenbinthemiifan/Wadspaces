.PHONY: help build run version clean

help:
	@echo "WadSpaces development commands"
	@echo "  make build    Compile and package the application"
	@echo "  make run      Show the wdsp help"
	@echo "  make version  Print the wdsp version"
	@echo "  make clean    Remove Gradle build output"

build:
	gradle build

run:
	gradle run --args="--help"

version:
	gradle run --args="--version"

clean:
	gradle clean
