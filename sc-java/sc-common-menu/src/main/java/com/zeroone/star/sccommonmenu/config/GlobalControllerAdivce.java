package com.zeroone.star.sccommonmenu.config;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.login.LoginVO;
import com.zeroone.star.sccommonmenu.model.BaseContext;
import com.zeroone.star.sccommonmenu.model.exception.MenuUserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理器
 */
@Slf4j
@ResponseBody
@ControllerAdvice//(annotations = {RestController.class, Controller.class})
public class GlobalControllerAdivce {

    @Resource
    private RestTemplate restTemplate;

    @Value("${loginPort}")
    private  String port;

    @ModelAttribute
    public void setCruuentUserId(HttpServletRequest request) {
//        String userId = request.getParameter("userId");
        String userId = request.getHeader("userId");
        log.info("当前请求为：" + request.getRequestURI() + " " + request.getMethod() + ": userId：" + userId);
        if (!StringUtils.isEmpty(userId)) {
            BaseContext.setCurrentId(userId);
        }
    }

    @ExceptionHandler(MenuUserException.class)
    public JsonVO<String> categoryExcpetionHandler(MenuUserException ex) {
        log.error(ex.getMessage());
        return JsonVO.fail(ex.getMessage());
    }

}

