FROM amazoncorretto:11-alpine-jdk
MAINTAINER matias
COPY target/matias-0.0.1-SNAPSHOT.jar matias-app.jar
ENTRYPOINT ["java","-jar","/matias-app.jar"]
