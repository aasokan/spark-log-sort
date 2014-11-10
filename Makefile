# MakeFile

all: clean package

test: clean
	mvn test

clean:
	mvn clean
	rm -rf *.jar

package:
	mvn package -DskipTests

jar: package