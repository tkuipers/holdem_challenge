FROM adoptopenjdk/openjdk14

COPY . .
RUN chmod +x ./gradlew
RUN mkdir -p /tmp/tkuipers/

ENTRYPOINT ["./gradlew", "run", "-Dorg.gradle.logging.level=quiet"]