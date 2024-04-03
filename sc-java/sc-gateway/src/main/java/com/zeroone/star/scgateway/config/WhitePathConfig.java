package com.zeroone.star.scgateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description 网关白名单配置
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@Data
@Component
@ConfigurationProperties(prefix="secure.white")
public class WhitePathConfig {
    private List<String> urls;
}
