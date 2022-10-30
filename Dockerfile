FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} shopping-cart-app-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/shopping-cart-app-0.0.1-SNAPSHOT.jar"]