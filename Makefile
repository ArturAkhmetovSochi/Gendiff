.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 8.5

clean:
	make -C app clean

build:
	make -C app build

install:
	make -C app clean install

run-dist:
	make -C app run-dist

run:
	./gradlew run

test:
	make -C app test

report:
	make -C app report

lint:
	make -C app lint

check-deps:
	./gradlew dependencyUpdates -Drevision=release

build-run:	build run

.PHONY: build