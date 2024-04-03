package com.zeroone.star.sclogin.fallback;

import com.zeroone.star.project.dto.login.Oauth2TokenDTO;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.sclogin.service.OAuthService;
import lombok.AllArgsConstructor;

import java.util.Map;

/**
 * @Description 授权服务降级实现
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@AllArgsConstructor
public class OAuthServiceImpl implements OAuthService {
    private Throwable throwable;

    private void setMessage(JsonVO<?> vo) {
        if (throwable.getMessage() != null) {
            vo.setMessage(throwable.getMessage());
        } else {
            vo.setMessage(throwable.getClass().toGenericString());
        }
    }

    @Override
    public JsonVO<Oauth2TokenDTO> postAccessToken(Map<String, String> parameters) {
        JsonVO<Oauth2TokenDTO> vo = JsonVO.fail(null);
        setMessage(vo);
        return vo;
    }


}
