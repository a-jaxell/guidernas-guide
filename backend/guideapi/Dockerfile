FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package -DskipTests

EXPOSE 8080
ARG DB_URL
ARG MYSQL_PASSWORD
ARG MYSQL_USERNAME
ENV DB_URL=$DB_URL \
    MYSQL_PASSWORD=$MYSQL_PASSWORD \
    MYSQL_USERNAME=$MYSQL_USERNAME

CMD ["java", "-jar", "target/guideapi-0.0.1-SNAPSHOT.jar"]

