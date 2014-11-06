# MakeFile

all: clean package

test: clean
	mvn test

clean:
	mvn clean

package:
	mvn package