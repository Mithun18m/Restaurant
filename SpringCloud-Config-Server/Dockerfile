FROM openjdk:8
EXPOSE 8080
ADD target/spring-cloud-docker.jar spring-cloud-docker.jar
ENTRYPOINT ["java","-jar","/spring-cloud-docker.jar"]