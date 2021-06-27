#!/usr/bin/env bash

docker build -t tkuipers:interview .
cat - | docker run -i tkuipers:interview