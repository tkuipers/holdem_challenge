#!/bin/sh

if ! command -v java &> /dev/null
then
    JAVA_VERSION=$(java -version 2>&1 | head -1 | cut -d'"' -f2 | sed 's/^1\.//' | cut -d'.' -f1)
    if [ "$JAVA_VERSION"="14" ]; then
        echo "Java 14 detected, using gradle to run the program"
	cat - | ./gradlew run
    fi
elif command -v docker &> /dev/null; then
	echo "Docker found, using it to execute program"
	docker build -t tkuipers:interview .
	cat - | docker run -i tkuipers:interview
fi
