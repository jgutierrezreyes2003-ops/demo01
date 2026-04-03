FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
RUN mv $(ls -S target/*.jar | head -n 1) target/app-final.jar

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
# Ahora copiamos exactamente el archivo que separamos, cero errores
COPY --from=build /app/target/app-final.jar app.jar
EXPOSE 8885
ENTRYPOINT ["java", "-jar", "app.jar"]