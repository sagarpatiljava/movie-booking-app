FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} movie-service.jar
ENTRYPOINT ["java","-jar","/movie-service.jar"]
EXPOSE 8083