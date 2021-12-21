FROM amazoncorretto:11-alpine-jdk
MAINTAINER dc
COPY target/main-0.0.1-SNAPSHOT.war main-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java","-jar","/main-0.0.1-SNAPSHOT.war"]
