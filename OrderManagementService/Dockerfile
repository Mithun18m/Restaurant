FROM openjdk:8
EXPOSE 8080
ADD target/order-dockerr.jar order-docker.jar
ENTRYPOINT ["java","-jar","/order-docker.jar"]