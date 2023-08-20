FROM openjdk:8
EXPOSE 8080
ADD target/restaurant-docker.jar restaurant-docker.jar
ENTRYPOINT ["java","-jar","/restaurant-docker.jar"]