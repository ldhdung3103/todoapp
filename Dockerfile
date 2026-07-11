# syntax=docker/dockerfile:1

# Giai đoạn 1: Build ứng dụng bằng Maven và Java 17
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom trước để tận dụng Docker cache
COPY pom.xml .

RUN mvn -B dependency:go-offline

# Copy source code
COPY src ./src

# Build file JAR
RUN mvn -B clean package -DskipTests \
    && JAR_FILE=$(find target -maxdepth 1 -type f -name "*.jar" ! -name "original-*" | head -n 1) \
    && cp "$JAR_FILE" app.jar

# Giai đoạn 2: Chỉ dùng Java Runtime để chạy ứng dụng
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=build /app/app.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]