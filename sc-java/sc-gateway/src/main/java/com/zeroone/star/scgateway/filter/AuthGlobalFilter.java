package com.zeroone.star.scgateway.filter;

import cn.hutool.core.util.StrUtil;
import com.nimbusds.jose.JWSObject;
import com.zeroone.star.project.constant.RedisConstant;
import com.zeroone.star.project.utils.redis.RedisUtils;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.scgateway.handler.CommonSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.text.ParseException;

/**
 * @Description 将登录用户的JWT转化成用户信息的全局过滤器
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@Component
@Slf4j
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private RedisTemplate redisTemplate;


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 获取token
        String token = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (StrUtil.isEmpty(token)) {
            return chain.filter(exchange);
        }


        try {
            //从token中解析用户信息并设置到Header中去
            String realToken = token.replace("Bearer ", "");

            // 从redis中查询当前token是否存在（是否注销）
            String userTokenKey = RedisConstant.USER_TOKEN + ":" + realToken;
            log.info("AuthGlobalFilter#filter userTokenKey: {}", userTokenKey);
            if (!redisUtils.isExist(userTokenKey)) {
                log.info("AuthGlobalFilter#filter 当前Token不存在，拦截请求");
                // 拦截请求
                return CommonSender.sender(exchange, ResultStatus.UNAUTHORIZED, null);
            }

            JWSObject jwsObject = JWSObject.parse(realToken);
            String userStr = jwsObject.getPayload().toString();
            log.info("AuthGlobalFilter.filter() user:{}", userStr);

            // 构造新的请求，并封装参数
            // 将从token解析到用户信息存入到request中，以便后序的处理
            ServerHttpRequest request = exchange.getRequest().mutate().header("user", userStr).build();
            exchange = exchange.mutate().request(request).build();

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

