FROM openjdk:21-jdk-slim
VOLUME /tmp
COPY target/item-service.jar item-service.jar
ENTRYPOINT ["java", "-jar", "/item-service.jar"]
