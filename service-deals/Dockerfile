FROM openjdk:17-alpine

WORKDIR /opt/server

COPY ./target/service-deals-0.0.1-SNAPSHOT.jar service-deals.jar

EXPOSE 8093

ENTRYPOINT ["java", "-jar","service-deals.jar"]