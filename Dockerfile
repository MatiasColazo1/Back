FROM amazoncorretto:11-alpine-jdk
MAINTAINER matias
COPY target/matias-0.0.1-SNAPSHOT.jar  MatiasApplication.jar
ENTRYPOINT ["java","-jar","/MatiasApplication.jar"]
