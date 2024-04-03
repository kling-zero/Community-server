package com.zeroone.star.project.dto.notify;

import lombok.Data;

/**
 * @Description 示例通知数据对象
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@Data
public class SampleNotifyDTO {
    /**
     * 客户端编号
     */
    private String clientId;

    /**
     * 通知消息内容
     */
    private String message;
}
