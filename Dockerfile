FROM openjdk:17-alpine
WORKDIR /monitor
ENV profile=docker
COPY build/libs/monitor-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.profiles.active=${profile}", "-jar","./app.jar"]


