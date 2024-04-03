package com.zeroone.star.scgateway.filter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * @Description 跨域过滤器
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@Component
public class CorsFilter implements WebFilter {
    @SuppressWarnings("NullableProblems")
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        // 判断是否跨域
        if (CorsUtils.isCorsRequest(request)) {
            ServerHttpResponse response = exchange.getResponse();
            HttpHeaders headers = response.getHeaders();

            // 给请求头header设置参数，让其能够通过跨域请求
            headers.set(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");                  // 通过所有区域
            headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "*");      // 放行所有header
            headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "*");      // 放行所有方法
            headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "false");
            headers.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "*");
            headers.add(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "3600");

            if (request.getMethod() == HttpMethod.OPTIONS) {
                // 客户端发起Option请求，询问是否支持跨域请求。返回支持即可OK
                response.setStatusCode(HttpStatus.OK);
                return Mono.empty();
            }
        }
        return chain.filter(exchange);
    }
}
