package com.zeroone.star.sccommunity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@MapperScan(value = "com.zeroone.star.sccommunity.mapper")
public class ScCommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScCommunityApplication.class, args);
    }

}
