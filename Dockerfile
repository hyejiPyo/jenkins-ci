# 1단계: Gradle로 빌드 (Builder 이미지)
FROM gradle:8.3-jdk17 AS builder

# 캐싱을 위해 종속성 먼저 복사
COPY build.gradle settings.gradle /app/
WORKDIR /app
RUN gradle clean build --no-daemon || return 0

# 소스 복사 및 빌드
COPY . /app
RUN gradle clean build --no-daemon

# 2단계: 실행 이미지
FROM openjdk:17-jdk-slim

# 작업 디렉토리 생성
WORKDIR /app

# 빌드된 JAR 파일 복사
COPY --from=builder /app/build/libs/*.jar app.jar

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]
