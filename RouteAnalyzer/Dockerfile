FROM eclipse-temurin:23 AS builder
WORKDIR /app
COPY . .

# Build the application
RUN ./gradlew shadowJar


# Use a smaller base image
FROM eclipse-temurin:23-jre
WORKDIR /app
COPY --from=builder /app/build/libs/app.jar /app

# Run the application
CMD ["java", "-jar", "/app/app.jar"]

EXPOSE 8080
