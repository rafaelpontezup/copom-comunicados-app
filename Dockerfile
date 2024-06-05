FROM maven:3-eclipse-temurin-11 as builder

RUN mkdir app
COPY . ./app

WORKDIR app
RUN mvn clean package

FROM openjdk:11 as final
COPY --from=builder /app/target/*-final.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
