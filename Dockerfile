FROM openjdk:11 AS builder
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew build

FROM openjdk:11
COPY --from=builder build/libs/api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9000
ENTRYPOINT ["java","-Dspring.profiles.active=${SERVER_MODE}","-jar","/app.jar"]