package com.zeroone.star.sclogin.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/*
    Login模块 Redis配置类
    将Common模块的Redis Bean进行注入
 */
@Configuration
@ComponentScan({"com.zeroone.star.project.config.redis", "com.zeroone.star.project.utils.redis"})
public class RedisInit {
}
