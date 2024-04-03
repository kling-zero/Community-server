package com.zeroone.star.scoauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description 服务器启动入口
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ScOauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(ScOauth2Application.class, args);
    }

}
