# Use an official JDK base image
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy the project files into the container
COPY . /app

# Install Maven (if you don’t have Maven Wrapper)
RUN apt update && apt install -y maven

# Package the Spring Boot app (skip tests to speed up)
RUN apt update && apt install -y maven && mvn clean package -DskipTests

# Set the port to be used by the container (Render uses PORT env)
EXPOSE 8080

# Run the packaged Spring Boot application
CMD ["java", "-jar", "target/ai-recipe-generator-0.0.1-SNAPSHOT.jar"]