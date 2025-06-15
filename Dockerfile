# Stage 1: Build stage
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Copy project files into the build container
COPY . .

# Install Maven
RUN apt update && apt install -y maven

# Build the project and skip tests to speed up build
RUN mvn clean package -DskipTests

# Stage 2: Runtime stage
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/ai-recipe-generator-0.0.1-SNAPSHOT.jar app.jar

# Expose port your app listens on
EXPOSE 8080

# Run the Spring Boot app
CMD ["java", "-jar", "app.jar"]