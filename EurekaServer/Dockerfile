FROM openjdk:8
EXPOSE 8080
ADD target/eureka-docker.jar eureka-docker.jar
ENTRYPOINT ["java","-jar","/eureka-docker.jar"]