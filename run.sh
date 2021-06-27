#!/usr/bin/env bash

if ! which -v java &> /dev/null; then
  JAVA_VERSION=$(java -version 2>&1 | head -1 | cut -d'"' -f2 | sed 's/^1\.//' | cut -d'.' -f1)
  if [ "$JAVA_VERSION" = "14" ]; then
      printf "Java 14 detected, using gradle to run the program"
      cat - | ./run/RunGradle.sh
  fi
elif command -v docker &> /dev/null; then
	printf "Docker found, using it to execute program"
	cat - | ./run/RunDocker.sh
fi
