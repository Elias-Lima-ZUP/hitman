FROM openjdk:17.0.2-jdk-slim as builder

WORKDIR /app
COPY . .
RUN ./gradlew build

FROM openjdk:17.0.2-jdk-slim

WORKDIR /app
COPY --from=builder /app/build/libs/*.jar ./app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]