package com.zeroone.star.scsetting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @BelongsProject: zero-one-smart-community
 * @BelongsPackage: com.zeroone.star.scsetting
 * @Author: sensfloron
 * @CreateTime: 2022-10-14  22:06
 * @Description: Setting Start Application
 * @Version: 1.0
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ScSettingApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScSettingApplication.class, args);
    }
}
