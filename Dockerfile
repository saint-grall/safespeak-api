# Use a base image with JDK and Maven installed
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app

# Copy the project files to the container
COPY pom.xml .
COPY src ./src

# Build the project
RUN mvn clean package

# Create a smaller image with only the JAR file and JRE
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the JAR file from the build image
COPY --from=build /app/target/SafespeakAPI.jar .

# Expose the port your application runs on
EXPOSE 8080

# Command to run your application
CMD ["java", "-jar", "SafespeakAPI.jar"]
