FROM openjdk:17-jdk-alpine 
VOLUME /tmp 
EXPOSE 8081 
ADD ${JAR_FILE} app.jar 
ENTRYPOINT ["java", "-jar", ""] 
