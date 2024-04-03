package com.zeroone.star.scgateway.config;

import cn.hutool.core.util.ArrayUtil;
import com.zeroone.star.project.constant.AuthConstant;
import com.zeroone.star.scgateway.authorization.AuthorizationManager;
import com.zeroone.star.scgateway.filter.AuthGlobalFilter;
import com.zeroone.star.scgateway.filter.CorsFilter;
import com.zeroone.star.scgateway.filter.WhitePathFilter;
import com.zeroone.star.scgateway.handler.RestfulAccessDeniedHandler;
import com.zeroone.star.scgateway.handler.RestfulAuthenticationEntryPoint;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

/**
 * @Description 资源服务器配置
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@AllArgsConstructor
@Configuration
@EnableWebFluxSecurity
public class ResourceServerConfig {
    private final AuthorizationManager authorizationManager;
    private final WhitePathConfig whitePathConfig;
    private final RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    private final RestfulAuthenticationEntryPoint restfulAuthenticationEntryPoint;
    private final WhitePathFilter whitePathFilter;
    private final CorsFilter corsFilter;

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        //跨域支持
        http.cors().and().csrf().disable();
        // 将跨域过滤器放在SECURITY_CONTEXT_SERVER_WEB_EXCHANGE过滤器之前
        http.addFilterAt(corsFilter, SecurityWebFiltersOrder.SECURITY_CONTEXT_SERVER_WEB_EXCHANGE);

        //jwt凭证转换器
        http.oauth2ResourceServer().jwt()
                .jwtAuthenticationConverter(jwtAuthenticationConverter());
        //自定义处理JWT请求头过期或签名错误的结果
        http.oauth2ResourceServer().authenticationEntryPoint(restfulAuthenticationEntryPoint);
        //对白名单路径，直接移除JWT请求头
        http.addFilterBefore(whitePathFilter, SecurityWebFiltersOrder.AUTHENTICATION);    // 将whitePathFilter过滤器置前

        // 对过滤器进行配置
        http.authorizeExchange()
                //白名单配置
                .pathMatchers(ArrayUtil.toArray(whitePathConfig.getUrls(), String.class)).permitAll()
                //OPTIONS预检请求直接放行
                .pathMatchers(HttpMethod.OPTIONS).permitAll()
                //鉴权管理器配置
                .anyExchange().access(authorizationManager)
                .and().exceptionHandling()
                //处理未授权
                .accessDeniedHandler(restfulAccessDeniedHandler)
                //处理未认证
                .authenticationEntryPoint(restfulAuthenticationEntryPoint);
        return http.build();
    }

    /*
        jwt处理方法
     */
    @Bean
    public Converter<Jwt, ? extends Mono<? extends AbstractAuthenticationToken>> jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        // 设置前缀
        jwtGrantedAuthoritiesConverter.setAuthorityPrefix(AuthConstant.AUTHORITY_PREFIX);
        // 设置JWT存储权限属性
        jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName(AuthConstant.AUTHORITY_CLAIM_NAME);

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
        return new ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter);
    }
}
