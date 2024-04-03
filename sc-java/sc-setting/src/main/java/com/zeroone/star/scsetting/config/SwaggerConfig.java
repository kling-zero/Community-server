package com.zeroone.star.scsetting.config;


import com.zeroone.star.project.config.swagger.SwaggerCore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;


@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {
    @Bean
    public Docket setting() {
        return SwaggerCore.defaultDocketBuilder("组织及系统设置模块", "com.zeroone.star.scsetting.controller", "setting");
    }
}
