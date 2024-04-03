package com.zeroone.star.project.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @Description 默认swagger配置
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {
    @Bean
    public Docket defaultApi() {
        return SwaggerCore.defaultDocketBuilder("默认", "com.zeroone.star", "default");
    }
}
