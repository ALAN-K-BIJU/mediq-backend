# Use official Maven image to build the project
FROM maven:3.8-openjdk-17 AS build

# Set working directory in the container
WORKDIR /app

# Copy pom.xml and source code
COPY pom.xml /app
COPY src /app/src

# Run Maven build to package the app
RUN mvn clean package -DskipTests

# Use an openjdk runtime to run the application
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/mediq-backend-0.0.1-SNAPSHOT-jar-with-dependencies.jar /app/mediQ.jar



# Expose port 9090 (same as your local test)
EXPOSE 9090

# Run the application
ENTRYPOINT ["java", "-jar", "mediQ.jar"]
