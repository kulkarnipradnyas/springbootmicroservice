FROM eclipse-temurin:17

LABEL mentainer=pradnya

WORKDIR /app

# Exposing the Application Port
EXPOSE 8080

COPY target/demo-0.0.1-SNAPSHOT.jar /app/new.jar

ENTRYPOINT ["java","-jar","new.jar"]
#["java","jar","stringboot-docker.jar"]