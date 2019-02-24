build:
	mkdir -p bin
	javac -d bin -cp src:.:lib/* src/fr/main/Game.java

run:
	java -cp bin:/:lib/* -Djava.library.path=res/natives fr.main.Game

clean:
	rm -r -f bin/*

.PHONY: build run clean
