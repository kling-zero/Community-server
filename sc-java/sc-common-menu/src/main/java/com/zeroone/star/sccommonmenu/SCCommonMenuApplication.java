package com.zeroone.star.sccommonmenu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2WebMvc
public class SCCommonMenuApplication {

    public static void main(String[] args) {
        SpringApplication.run(SCCommonMenuApplication.class, args);
    }

   
}
