FROM openjdk:21-jdk-slim
ARG JAR_FILE_PATH=app/build/libs/*.jar
COPY ${JAR_FILE_PATH} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]