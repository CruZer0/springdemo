FROM maven:3.8-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
COPY mvnw /home/app
COPY ./.mvn /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:17-jdk
COPY --from=build /home/app/target/demo-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 8081
ENTRYPOINT [ "java", "-jar", "/usr/local/lib/demo.jar" ]
