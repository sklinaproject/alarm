FROM openjdk:11.0-slim
COPY build/libs/*SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Xmx400M","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","--spring.profiles.active=dev"]
