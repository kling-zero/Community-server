package com.zeroone.star.project.components.jwt.exception;

/**
 * @Description Token过期异常定义
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
public class JwtExpiredException extends RuntimeException {
    public JwtExpiredException(String message) {
        super(message);
    }
}
