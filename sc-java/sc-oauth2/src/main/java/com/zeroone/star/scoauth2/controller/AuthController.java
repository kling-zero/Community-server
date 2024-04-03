package com.zeroone.star.scoauth2.controller;

import com.zeroone.star.project.dto.login.Oauth2TokenDTO;
import com.zeroone.star.project.oauth.AuthApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.ResultStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

/**
 * @Description 认证服务相关接口
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@RestController
@RequestMapping("oauth")
@Slf4j
public class AuthController implements AuthApis {
    private final TokenEndpoint tokenEndpoint;

    private final ConsumerTokenServices consumerTokenServices;

    @Autowired
    public AuthController(TokenEndpoint tokenEndpoint, ConsumerTokenServices consumerTokenServices) {
        this.tokenEndpoint = tokenEndpoint;
        this.consumerTokenServices = consumerTokenServices;
    }

    @Override
    @PostMapping("token")
    public JsonVO<Oauth2TokenDTO> postAccessToken(Principal principal, @RequestParam Map<String, String> parameters) {
        //调用oAuth2AccessToken的postAccessToken接口来刷新或颁发token
        OAuth2AccessToken oAuth2AccessToken;
        try {
            oAuth2AccessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
        } catch (Exception e) {
            return JsonVO.create(null, ResultStatus.FAIL.getCode(), "postAccessToken:" + e.getClass().getSimpleName() + ":" + e.getMessage());
        }
        if (oAuth2AccessToken != null) {
            Oauth2TokenDTO oauth2TokenDto = new Oauth2TokenDTO(
                    oAuth2AccessToken.getValue(),
                    oAuth2AccessToken.getRefreshToken().getValue(),
                    "Bearer ",
                    oAuth2AccessToken.getExpiresIn(),
                    parameters.get("client_id"));
            return JsonVO.create(oauth2TokenDto, ResultStatus.SUCCESS);
        }
        return JsonVO.create(null, ResultStatus.FAIL.getCode(), "oAuth2AccessToken为null");
    }
}
