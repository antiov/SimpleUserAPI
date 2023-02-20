FROM openjdk:11-ea-28

ARG JAR_FILE=./target/*.jar

COPY ${JAR_FILE} api.jar

CMD ["java", "-jar", "api.jar"]