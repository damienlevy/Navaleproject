all:
	javac -Xlint start/Main.java && java start.Main	
clean:
	$(RM) *.class
