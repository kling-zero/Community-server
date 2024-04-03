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
@TableName("pay_fee_detail")
public class PayFeeDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 费用明细ID
     */
    private String detailId;

    /**
     * 业务ID
     */
    private String bId;

    /**
     * 费用ID
     */
    private String feeId;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 周期，以月为单位
     */
    private BigDecimal cycles;

    /**
     * 应收金额
     */
    private BigDecimal receivableAmount;

    /**
     * 应收金额
     */
    private BigDecimal receivedAmount;

    /**
     * 支付方式
     */
    private BigDecimal primeRate;

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
     * 数据状态，详细参考c_status表，S 保存，0, 在用 1失效
     */
    private String statusCd;

    /**
     * 用于退费状态参考字典表
     */
    private String state;

    /**
     * 费用开始时间
     */
    private LocalDateTime startTime;

    /**
     * 费用结束时间
     */
    private LocalDateTime endTime;


}
