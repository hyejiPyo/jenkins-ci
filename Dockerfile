# 1단계: 빌드 (Jenkins가 빌드하므로 불필요하다면 생략 가능)
# FROM gradle:8.3-jdk17 AS builder
# WORKDIR /app
# COPY . .
# RUN ./gradlew clean build --no-daemon

# 2단계: 실행 이미지
FROM openjdk:17-jdk-slim

WORKDIR /app

# Jenkins가 빌드한 JAR을 복사 (Jenkins 빌드 아티팩트 경로 기준)
COPY build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
