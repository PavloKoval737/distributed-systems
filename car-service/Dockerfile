FROM openjdk:17-alpine

WORKDIR /opt/server

COPY ./target/car-service-0.0.1-SNAPSHOT.jar carService.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar","carService.jar"]