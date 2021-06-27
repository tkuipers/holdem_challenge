FROM adoptopenjdk/openjdk14

COPY . .
RUN chmod +x ./gradlew
RUN mkdir -p /tmp/log/

ENTRYPOINT ["./gradlew", "run"]