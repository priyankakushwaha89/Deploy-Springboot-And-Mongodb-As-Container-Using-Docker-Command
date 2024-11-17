FROM openjdk:21
ADD target/booktest.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]