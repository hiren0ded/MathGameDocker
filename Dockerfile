FROM openjdk:8
VOLUME /tmp
ADD /codebuild/output/src177602298/src/github.com/hiren0ded/MathGameDocker/target/math-game-service.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
