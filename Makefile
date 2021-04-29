.PHONY: all compile clean test

export JAVA_HOME ?= /usr/lib/jvm/java-11-openjdk/

CRAP :=


all: compile

compile:
	mvn compile

clean:
	mvn clean
	rm -f $(wildcard $(CRAP))

test:
	mvn clean test
