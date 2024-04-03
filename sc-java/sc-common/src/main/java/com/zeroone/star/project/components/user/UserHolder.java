package com.zeroone.star.project.components.user;

import cn.hutool.core.convert.Convert;
import cn.hutool.json.JSONObject;
import com.zeroone.star.project.components.jwt.JwtComponent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description 获取登录用户信息
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@Component
public class UserHolder {
    @Resource
    JwtComponent jwtComponent;

    /**
     * 从请求头中获取用户信息
     *
     * @return 用户信息
     */
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public UserDTO getCurrentUser() throws Exception {
        //从Header中获取用户信息
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (servletRequestAttributes == null) {
            return null;
        }

        // 获取请求Request
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String userStr = request.getHeader("user");

        //不是通过网关过来的，那么执行解析验证JWT
        if (userStr == null) {
            //从token中解析用户信息并设置到Header中去
            String realToken = request.getHeader("Authorization").replace("Bearer ", "");
            userStr = jwtComponent.defaultRsaVerify(realToken);
        }

        // 将JSON数据解析为User类
        JSONObject userJsonObject = new JSONObject(userStr);
        return UserDTO.builder()
                .id(Convert.toInt(userJsonObject.get("id")))
                .username(userJsonObject.getStr("user_name"))
                .isEnabled(Convert.toByte(1))
                .roles(Convert.toList(String.class, userJsonObject.get("authorities")))
                .build();
    }


    /**
     * @author Suci
     * @createTime 2022/10/18 下午 3:57
     * @desc 获取当前用户token
     */
    public String getCurrentUserToken() throws Exception {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (servletRequestAttributes == null) {
            return null;
        }

        // 获取请求Request中的token
        HttpServletRequest request = servletRequestAttributes.getRequest();
        return request.getHeader("Authorization").replace("Bearer ", "");
    }
}
