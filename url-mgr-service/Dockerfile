FROM amazoncorretto:17.0.0
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar","–spring.config.location=/config/application.properties"]