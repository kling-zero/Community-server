# 该镜像需要依赖的基础镜像
FROM openjdk:8
# 指定维护者的名字
MAINTAINER night
# 将当前target目录下的jar包复制到docker容器中
ADD target/sc-community-1.0.0-SNAPSHOT.jar app.jar
# 设置容器启动执行指令
CMD java -Xms256m -Xms256m -jar app.jar --spring.profiles.active=test \
    --logging.file.path=/tmp/logs/spring-boot

