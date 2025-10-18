# 1단계: 빌드
FROM gradle:8.3-jdk17 AS builder
WORKDIR /app
COPY . .
RUN ./gradlew clean build --no-daemon

# 2단계: 실행 이미지
FROM openjdk:17-jdk-slim
WORKDIR /app
ARG JAR_FILE=build/libs/app.jar
COPY --from=builder /app/${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]