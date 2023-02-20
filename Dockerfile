FROM openjdk:20-ea-28-bullseye

ARG JAR_FILE=./target/*.jar

COPY ${JAR_FILE} api.jar

CMD ["java", "-jar", "api.jar"]