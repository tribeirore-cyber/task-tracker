FROM eclipse-temurin:17-jdk-alpine as builder

WORKDIR /app

COPY pom.xml .
RUN apk add --no-cache maven

COPY src ./src
RUN mvn package -DskipTests -Ddockerfile.skip=true

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]