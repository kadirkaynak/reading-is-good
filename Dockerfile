FROM openjdk:11
ADD target/reading-is-good-docker.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]