package com.zeroone.star.project.vo;

/**
 * @Description 响应码枚举
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
public enum ResultStatus {
    /***/
    UNAUTHORIZED("暂未登录或TOKEN已经过期", 401),
    FORBIDDEN("没有相关权限", 403),
    SERVER_ERROR("服务器错误", 9994),
    PARAMS_INVALID("上传参数异常", 9995),
    CONTENT_TYPE_ERR("ContentType错误",9996),
    API_UN_IMPL("功能尚未实现", 9997),
    SERVER_BUSY("服务器繁忙", 9998),
    FAIL("操作失败", 9999),
    SUCCESS("操作成功"),
    WRONG_CAPTCHA("验证码错误", 9993),
    ROLE_UN_FOUND("未查询到相关商户", 9992),
    SUCCESS_UPDATE_PASSWORD("修改密码成功",2200),
    ERROR_OLD_PASSWORD("旧密码错误",2201),
    FAIL_UPDATE_PASSWORD("修改密码失败",2201)

    ;

    private String message;
    private int code;

    ResultStatus(String message, int code) {
        this.message = message;
        this.code = code;
    }

    ResultStatus(String message) {
        this(message, 10000);
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
