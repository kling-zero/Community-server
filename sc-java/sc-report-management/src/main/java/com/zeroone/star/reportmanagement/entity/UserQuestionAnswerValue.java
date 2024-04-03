package com.zeroone.star.reportmanagement.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
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
@TableName("user_question_answer_value")
public class UserQuestionAnswerValue implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String userTitleId;

    /**
     * 答案问卷ID
     */
    private String userQaId;

    /**
     * 问卷ID
     */
    private String qaId;

    /**
     * 题目ID
     */
    private String titleId;

    /**
     * 答案类型，1002 自评 2003 他人评价
     */
    private String answerType;

    /**
     * 答案ID
     */
    private String valueId;

    /**
     * 答案内容
     */
    private String valueContent;

    /**
     * 3306 是小区，3307 是商户
     */
    private String objType;

    /**
     * 对象ID
     */
    private String objId;

    /**
     * 得分
     */
    private BigDecimal score;

    /**
     * 答题者
     */
    private String personId;

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
