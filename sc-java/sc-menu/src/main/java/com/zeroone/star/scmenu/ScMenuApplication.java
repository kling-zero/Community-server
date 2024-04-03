package com.zeroone.star.scmenu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ScMenuApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScMenuApplication.class, args);
    }

}
