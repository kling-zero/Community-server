package com.zeroone.star.reportmanagement.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
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
@TableName("report_fee_month_statistics")
public class ReportFeeMonthStatistics implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 统计ID
     */
    private String statisticsId;

    /**
     * 年份
     */
    private Integer feeYear;

    /**
     * 月份
     */
    private Integer feeMonth;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 付费对象类型
     */
    private String objType;

    /**
     * 付费对象ID
     */
    private String objId;

    /**
     * 对象名称
     */
    private String objName;

    /**
     * 费用ID
     */
    private String feeId;

    /**
     * 费用名称
     */
    private String feeName;

    /**
     * 费用项ID
     */
    private String configId;

    /**
     * 应收
     */
    private BigDecimal receivableAmount;

    /**
     * 实收
     */
    private BigDecimal receivedAmount;

    /**
     * 欠费
     */
    private BigDecimal oweAmount;

    /**
     * 费用产生时间
     */
    private LocalDateTime feeCreateTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 数据状态
     */
    private String statusCd;

    /**
     * 费用截止时间
     */
    private LocalDateTime deadlineTime;

    /**
     * 当月时间
     */
    private LocalDate curMaxTime;

    /**
     * 历史欠费金额及上月欠费金额
     */
    private BigDecimal hisOweAmount;

    /**
     * 当月应收
     */
    private BigDecimal curReceivableAmount;

    /**
     * 当月实收
     */
    private BigDecimal curReceivedAmount;

    /**
     * 欠费追回
     */
    private BigDecimal hisOweReceivedAmount;

    /**
     * 预交费用
     */
    private BigDecimal preReceivedAmount;

    private String objNameNum;


}
