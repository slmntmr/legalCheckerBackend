FROM eclipse-temurin:17-jdk-slim

WORKDIR /app

COPY . .

RUN chmod +x ./mvnw

RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/legalchecker-0.0.1-SNAPSHOT.jar"]
