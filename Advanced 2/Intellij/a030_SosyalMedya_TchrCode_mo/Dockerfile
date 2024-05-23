FROM amazoncorretto:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
CMD apt-get update -y  # (this line might not be appropriate here, depending on the use case - chatgpt)
ENTRYPOINT ["java", "-jar", "/app.jar"]