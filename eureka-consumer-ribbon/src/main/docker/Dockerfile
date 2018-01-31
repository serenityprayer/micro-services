FROM java:8-alpine
VOLUME /tmp
ADD eureka-consumer-ribbon-0.0.1.jar app.jar
#RUN bash -c 'touch /app.jar'
EXPOSE 9011
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
