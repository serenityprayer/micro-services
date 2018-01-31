FROM java:8-alpine
VOLUME /tmp
ADD eureka-consumer-0.0.1.jar app.jar
#RUN bash -c 'touch /app.jar'
EXPOSE 9010
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
