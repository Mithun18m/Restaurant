FROM openjdk:8
EXPOSE 8080
ADD target/customer-docker.jar customer-docker.jar
ENTRYPOINT ["java","-jar","/customer-docker.jar"]