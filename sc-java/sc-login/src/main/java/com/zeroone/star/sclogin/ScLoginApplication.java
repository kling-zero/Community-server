package com.zeroone.star.sclogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description 服务器启动入口
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ScLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScLoginApplication.class, args);
    }

}
