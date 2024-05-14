From eclipse-temurin:17-jdk-focal
WORKDIR /app
COPY .mvn/ ./mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src
CMD ["./gradlew", "bootRun"]
EXPOSE 8081