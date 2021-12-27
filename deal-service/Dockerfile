FROM openjdk:17-alpine

WORKDIR /opt/server

COPY ./target/deal-service-0.0.1-SNAPSHOT.jar dealService.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar","dealService.jar"]