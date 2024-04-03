package com.zeroone.star.project.components.jwt.exception;

/**
 * @Description Token无效异常定义
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
public class JwtInvalidException extends RuntimeException {
    public JwtInvalidException(String message) {
        super(message);
    }
}
