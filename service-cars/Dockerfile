FROM openjdk:17-alpine

WORKDIR /opt/server

COPY ./target/service-cars-0.0.1-SNAPSHOT.jar service-cars.jar

EXPOSE 8091

ENTRYPOINT ["java", "-jar","service-cars.jar"]