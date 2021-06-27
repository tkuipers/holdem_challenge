#!/usr/bin/env bash

mkdir -p /tmp/tkuipers
cat - | ./gradlew run -Dorg.gradle.logging.level=quiet