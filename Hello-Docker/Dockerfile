FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
COPY . /app
ADD target/Hello-Docker-1.0.jar Hello-Docker-1.0.jar
ENTRYPOINT ["java","-jar","/Hello-Docker-1.0.jar"]