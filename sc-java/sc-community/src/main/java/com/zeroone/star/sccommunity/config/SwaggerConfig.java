package com.zeroone.star.sccommunity.config;

import com.zeroone.star.project.config.swagger.SwaggerCore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @Description Swagger配置
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {
    @Bean
    public Docket sample(){
        return SwaggerCore.defaultDocketBuilder("小区管理模块","com.zeroone.star.sccommunity.controller","community");
    }
}
