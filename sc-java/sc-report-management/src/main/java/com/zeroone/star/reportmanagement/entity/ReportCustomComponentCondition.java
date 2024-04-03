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
@TableName("report_custom_component_condition")
public class ReportCustomComponentCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 条件ID
     */
    private String conditionId;

    /**
     * 组件ID
     */
    private String componentId;

    /**
     * 名称
     */
    private String name;

    /**
     * 提示
     */
    private String holdpace;

    /**
     * 参数
     */
    private String param;

    /**
     * 类型 input 输入框
     */
    private String type;

    /**
     * 描述
     */
    private String remark;

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
     * 排序
     */
    private Integer seq;


}
