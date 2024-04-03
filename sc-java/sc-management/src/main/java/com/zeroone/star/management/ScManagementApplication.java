package com.zeroone.star.management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.zeroone.star.management.mapper")
public class ScManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScManagementApplication.class, args);
    }

}
