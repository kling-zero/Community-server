package com.zeroone.star.project.oauth;

import com.zeroone.star.project.dto.login.Oauth2TokenDTO;
import com.zeroone.star.project.vo.JsonVO;

import java.security.Principal;
import java.util.Map;

/**
 * @Description 授权接口定义
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
public interface AuthApis {
    /**
     * 授权认证接口
     * @param principal  安全主体对象
     * @param parameters 传递参数
     * @return 响应结果
     */
    JsonVO<Oauth2TokenDTO> postAccessToken(Principal principal, Map<String, String> parameters);
}
