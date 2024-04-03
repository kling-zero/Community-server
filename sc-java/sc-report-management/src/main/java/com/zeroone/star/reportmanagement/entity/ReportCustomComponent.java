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
@TableName("report_custom_component")
public class ReportCustomComponent implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组件ID
     */
    private String componentId;

    /**
     * 组件名称
     */
    private String name;

    /**
     * 组件组 C是普通组件 Q 查询条件组件
     */
    private String componentGroup;

    /**
     * 组件类型,组件组 为C时 1001 表格，2002 饼状图 等等 组件组为Q 3003 input 4004 select 5005 日期 等等
     */
    private String componentType;

    /**
     * 查询方式 1、sql,2、java
     */
    private String queryModel;

    /**
     * 执行java脚本代码
     */
    private String javaScript;

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
     * 执行sql
     */
    private String componentSql;


}
