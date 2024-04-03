package com.zeroone.star.project.constant;

/**
 * @Description Redis相关常量
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
public interface RedisConstant {
    /**
     * 角色资源映射Map的key
     */
    String RESOURCE_ROLES_MAP = "AUTH:RESOURCE_ROLES";

    /**
     * @author Suci
     * @createTime 上午 11:16
     * @desc 验证码前缀
     */
    String CAPTCHA = "CAPTCHA:LOGIN";


    String USER_TOKEN = "AUTH:USER_TOKEN";
}
