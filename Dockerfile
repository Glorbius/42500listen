FROM openjdk:8-jdk-alpine

COPY target/analizator*.jar /analizator.jar


CMD ["java","-jar","/analizator.jar"]

