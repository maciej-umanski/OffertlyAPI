FROM maven:latest AS build
COPY src src
COPY pom.xml pom.xml
RUN mvn -f pom.xml clean package

FROM openjdk:17-jdk-slim AS run
COPY --from=build /target/offertlyapi-0.0.1-SNAPSHOT.jar offertlyapi-0.0.1-SNAPSHOT.jar
CMD ["java","-Xmx512m","-jar","offertlyapi-0.0.1-SNAPSHOT.jar"]