package com.zeroone.star.reportmanagement.entity;

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
 * @author j4
 * @since 2022-10-23
 */
@Getter
@Setter
@TableName("report_info_answer_value")
public class ReportInfoAnswerValue implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String anValueId;

    /**
     * 答案问卷ID
     */
    private String userAnId;

    /**
     * 问卷ID
     */
    private String settingId;

    /**
     * 题目ID
     */
    private String titleId;

    /**
     * 答案ID
     */
    private String valueId;

    /**
     * 答案内容
     */
    private String valueContent;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 数据状态，详细参考c_status表，S 保存，0, 在用 1失效
     */
    private String statusCd;


}
