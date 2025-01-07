# Use a Java base image to build the app
FROM maven:3.8.4-openjdk-11-slim AS build

# Set working directory
WORKDIR /app

# Copy the pom.xml and install dependencies (for faster rebuilds)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of your project source code
COPY src ./src

# Build the application with Maven
RUN mvn clean package -DskipTests

# Use an OpenJDK base image for running the app
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build image
COPY --from=build /app/target/customer-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port (this is the default Spring Boot port)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
