package com.zeroone.star.sclogin.service;

import com.zeroone.star.project.dto.login.Oauth2TokenDTO;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.sclogin.fallback.OAuthServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Description 授权声明式服务接口
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@FeignClient(value = "${sn.auth}", fallbackFactory = OAuthServiceFallbackFactory.class)
public interface OAuthService {
    /**
     * 声明式调用授权服务
     * @param parameters 参数列表
     * @return 授权数据
     *
     * 在OAuth模块中，postAccessToken的形参有两个，这个函数相当于重写
     */
    @PostMapping("/oauth/token")
    JsonVO<Oauth2TokenDTO> postAccessToken(@RequestParam Map<String, String> parameters);


}
