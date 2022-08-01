FROM docker.io/maven:3-eclipse-temurin-17-focal AS build
WORKDIR /usr/src/myapp
COPY . .
RUN mvn clean package

FROM docker.io/eclipse-temurin:17-jre AS deploy
WORKDIR /usr/src/myapp
COPY --from=build /usr/src/myapp/target/dvdrentalpos-*.jar dvdrentalpos.jar

ENV MYSQL_HOST=localhost
ENV MYSQL_PORT=3306
ENV MYSQL_DATABASE=sakila
ENV MYSQL_USERNAME=root
ENV MYSQL_PASSWORD=

EXPOSE 8888

ENTRYPOINT java -Dspring.profiles.active=container -jar /usr/src/myapp/dvdrentalpos.jar

