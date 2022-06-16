FROM openjdk:17-jdk-slim-buster
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} email-notification-service.jar
ENTRYPOINT ["java","-jar","/email-notification-service.jar"]
EXPOSE 8089
