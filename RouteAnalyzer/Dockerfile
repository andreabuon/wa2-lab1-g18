FROM eclipse-temurin:23 AS builder
WORKDIR ./app
COPY ./ ./

# Build the application
RUN ./gradlew --no-daemon shadowJar


# Use a smaller base image
FROM eclipse-temurin:23-jre
COPY --from=builder ./app/build/libs/* /bin/runner/run.jar

# Run the application
CMD ["java", "-jar", "/bin/runner/run.jar"]

EXPOSE 8080
