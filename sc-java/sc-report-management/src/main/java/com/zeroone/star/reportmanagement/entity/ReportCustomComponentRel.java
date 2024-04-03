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
@TableName("report_custom_component_rel")
public class ReportCustomComponentRel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 关系编号
     */
    private String relId;

    /**
     * 组件ID
     */
    private String componentId;

    /**
     * 报表编号
     */
    private String customId;

    /**
     * 组件序号
     */
    private Integer seq;

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
