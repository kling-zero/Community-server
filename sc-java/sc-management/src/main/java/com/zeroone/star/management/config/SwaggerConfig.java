package com.zeroone.star.management.config;

import com.zeroone.star.project.config.swagger.SwaggerCore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @Description Swagger配置
 * @Author Kong
 * @Copy &copy;
 * @Address
 */
@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {
    @Bean
    public Docket management(){
        return SwaggerCore.defaultDocketBuilder("数据管理模块","com.zeroone.star.management.controller","management");
    }
}
