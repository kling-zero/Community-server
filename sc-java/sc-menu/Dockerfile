FROM openjdk:8
MAINTAINER 01star
ADD target/sc-menu-1.0.0-SNAPSHOT.jar app.jar
CMD java -Xmx256m -Xms256m -jar app.jar --spring.profiles.active=test --spring.cloud.nacos.discovery.ip=81.68.66.123 --logging.file.path=/tmp/logs/spring-boot