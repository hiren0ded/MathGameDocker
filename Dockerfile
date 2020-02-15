FROM openjdk:8
ADD ./target/math-game-service.jar math-game-service.jar
EXPOSE 5000
ENTRYPOINT ["java","-jar","math-game-service.jar"]