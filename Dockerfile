FROM openjdk:17
LABEL maintainer="gukhong@gmail.com"
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=build/libs/portfolio-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} portfolio-gukhong.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/portfolio-gukhong.jar"]