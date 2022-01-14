FROM openjdk:17-alpine

WORKDIR /opt/server

COPY ./target/service-users-0.0.1-SNAPSHOT.jar service-users.jar

EXPOSE 8092

ENTRYPOINT ["java", "-jar","service-users.jar"]