FROM openjdk:18-ea-11-jdk-alpine3.15
VOLUME /tmp
ADD ./target/protocolo-0.0.1-SNAPSHOT.jar protocolo-image.jar
EXPOSE 8003
ENTRYPOINT ["java", "-jar", "/protocolo-image.jar"]
