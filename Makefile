all:
	javac src/start/Main.java && java src/start.Main
clean:
        $(RM) *.class
