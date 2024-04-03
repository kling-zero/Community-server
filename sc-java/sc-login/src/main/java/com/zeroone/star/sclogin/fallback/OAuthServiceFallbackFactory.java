package com.zeroone.star.sclogin.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Description 授权服务异常回调工厂
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@Component
public class OAuthServiceFallbackFactory implements FallbackFactory<OAuthServiceImpl> {
    @Override
    public OAuthServiceImpl create(Throwable throwable) {
        return new OAuthServiceImpl(throwable);
    }
}
