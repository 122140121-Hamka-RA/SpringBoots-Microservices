FROM openjdk:21-jdk-slim
VOLUME /tmp
COPY target/customer-service.jar customer-service.jar
ENTRYPOINT ["java", "-jar", "/customer-service.jar"]
