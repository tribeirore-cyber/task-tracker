# Use a minimal base image with Java 17 JDK for building
FROM eclipse-temurin:17-jdk-alpine as builder

# Set the working directory
WORKDIR /app

# Copy the pom.xml first and download dependencies
# This leverages Docker's caching mechanism so dependencies are not re-downloaded on every build
COPY pom.xml .
RUN apk add --no-cache maven # Install Maven in the base image for the build process

# Copy the source code and build the application
COPY src ./src
RUN mvn package -DskipTests # Build the Maven project, skipping tests for now

# Use a smaller base image for the final stage
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy the application JAR file built in the previous stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port the Spring Boot application runs on
EXPOSE 8080

# Command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
