# Use OpenJDK 17
FROM eclipse-temurin:17-jdk

WORKDIR /app
COPY target/pipeline-architecture-0.0.1-SNAPSHOT.jar pipeline-architecture.jar

ENTRYPOINT ["java", "-jar", "pipeline-architecture.jar"]