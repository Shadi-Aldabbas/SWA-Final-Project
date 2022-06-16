FROM openjdk:17-jdk-slim-buster
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} voting-service.jar
ENTRYPOINT ["java","-jar","/voting-service.jar"]
EXPOSE 8082
