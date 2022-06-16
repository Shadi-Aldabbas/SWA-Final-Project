FROM openjdk:17-jdk-slim-buster
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} email-notification-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/email-notification-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 587
#
#FROM openjdk:10-jre-slim
#WORKDIR /app
#COPY ./target/<your-file>-<version>/SNAPSHOT.jar /app
#EXPOSE 8080
#
#CMD ["java", "-jar", "<your-file>-<version>/SNAPSHOT.jar"]