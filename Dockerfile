FROM openjdk:17
EXPOSE 8080
ADD target/gses2.app.jar gses2.app.jar
ENTRYPOINT ["java", "-jar", "/gses2.app.jar"]