FROM maven:3.5.2-jdk-8-alpine as BUILD
WORKDIR /app
COPY pom.xml /app/
COPY src /app/src/
RUN mvn clean package -DskipTests

FROM alpine
WORKDIR /app
COPY --from=BUILD /app/target/*.jar  application.jar
ENTRYPOINT ["java", "-jar", "/application.jar"]