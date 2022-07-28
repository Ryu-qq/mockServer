FROM openjdk:11 AS builder
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew build

FROM openjdk:11
COPY --from=builder build/libs/login-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9030
ENTRYPOINT ["java", "-jar","/app.jar"]