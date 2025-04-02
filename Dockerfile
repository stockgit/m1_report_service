FROM openjdk:21-jdk
ENV APP_FILE report-service-1.1-SNAPSHOT.jar
ENV APP_HOME /app
EXPOSE 8071
COPY target/$APP_FILE $APP_HOME/
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]