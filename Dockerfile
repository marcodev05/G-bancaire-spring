FROM openjdk:11  //adoptopenjdk/openjdk11:alpine-jre

ADD target/bank-project.jar bank-project.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "bank-project.jar"