package com.zeroone.star.schp.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author anmux
 * @since 2022-10-18
 */
@Getter
@Setter
@TableName("n_notice")
public class NNotice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 通知ID
     */
    private String noticeId;

    /**
     * 业务ID
     */
    private String bId;

    /**
     * 通知标题
     */
    private String title;

    /**
     * 类型 1000 业主通知，1001员工通知，1002小区通知
     */
    private String noticeTypeCd;

    /**
     * 通知内容
     */
    @TableField("context")
    private String message;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 开始时间
     */
    @TableField("start_time")
    private LocalDateTime releaseDate;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 数据状态，详细参考c_status表，S 保存，0, 在用 1失效
     */
    private String statusCd;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 对象类型
     */
    private String objType;

    /**
     * 对象ID
     */
    private String objId;

    /**
     * 状态 1000 待通知 2000 通知中  3000 通知完成
     */
    private String state;


}
