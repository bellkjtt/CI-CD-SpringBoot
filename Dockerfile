FROM openjdk:17-jdk-slim
ARG JAR_FILE=build/libs/*.jar
ARG PROFILES
ARG ENV
ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILES}", "-Dserver.env=${ENV}", "-jar", "app.jar]


