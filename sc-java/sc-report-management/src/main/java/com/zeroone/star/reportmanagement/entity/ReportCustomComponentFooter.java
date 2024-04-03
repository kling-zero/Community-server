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
@TableName("report_custom_component_footer")
public class ReportCustomComponentFooter implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 报表底部同步ID
     */
    private String footerId;

    /**
     * 组件ID
     */
    private String componentId;

    /**
     * 名称
     */
    private String name;

    /**
     * 查询方式 1、sql,2、java
     */
    private String queryModel;

    /**
     * 执行java脚本代码
     */
    private String javaScript;

    /**
     * 执行sql
     */
    private String componentSql;

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


}
