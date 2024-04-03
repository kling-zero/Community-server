package com.zeroone.star.scgateway.handler;

import com.zeroone.star.project.vo.ResultStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Description 没有登录或token过期时下发消息
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@Component
public class RestfulAuthenticationEntryPoint implements ServerAuthenticationEntryPoint {
    @Override
    public Mono<Void> commence(ServerWebExchange exchange, AuthenticationException e) {
        return CommonSender.sender(exchange, ResultStatus.UNAUTHORIZED, e.getMessage());
    }
}
