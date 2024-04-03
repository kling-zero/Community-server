package com.zeroone.star.scgateway;

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
public class ScGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScGatewayApplication.class, args);
    }

}
