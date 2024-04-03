package com.zeroone.star.scoauth2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description Redis初始化
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@Configuration
@ComponentScan({"com.zeroone.star.project.config.redis", "com.zeroone.star.project.utils.redis"})
public class RedisInit {
}
