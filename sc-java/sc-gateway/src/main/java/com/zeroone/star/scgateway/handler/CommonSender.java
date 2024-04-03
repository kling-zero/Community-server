package com.zeroone.star.scgateway.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.ResultStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @Description 通用消息发送工具类
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */

@Slf4j
public
class CommonSender {
    public static Mono<Void> sender(ServerWebExchange exchange, ResultStatus resultStatus, String data){
        // 获取并处理响应
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.OK);
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);


        ObjectMapper mapper = new ObjectMapper();   // fastjson处理
        String body = "";
        try {
            // 将data和返回值封成body字符串
            body = mapper.writeValueAsString(JsonVO.create(data, resultStatus));
        } catch (JsonProcessingException e1) {
            log.error("CommonSender#sender failed, e: {}", e1.getMessage());
            e1.printStackTrace();
        }
        DataBuffer buffer =  response.bufferFactory().wrap(body.getBytes(StandardCharsets.UTF_8));
        return response.writeWith(Mono.just(buffer));
    }
}
