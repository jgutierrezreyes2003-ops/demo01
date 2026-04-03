# Etapa 1: Construcción
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
# AQUI ESTA LA MAGIA: Forzamos a Spring Boot a crear el manifest
RUN mvn clean package spring-boot:repackage -DskipTests
# Mantenemos el truco para agarrar el bueno
RUN mv $(ls -S target/*.jar | head -n 1) target/app-final.jar

# Etapa 2: Ejecución
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/app-final.jar app.jar
EXPOSE 8885
ENTRYPOINT ["java", "-jar", "app.jar"]