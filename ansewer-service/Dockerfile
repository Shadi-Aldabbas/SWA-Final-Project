FROM openjdk:17-jdk-slim-buster
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} answer-service.jar
ENTRYPOINT ["java","-jar","/answer-service.jar"]
EXPOSE 8080