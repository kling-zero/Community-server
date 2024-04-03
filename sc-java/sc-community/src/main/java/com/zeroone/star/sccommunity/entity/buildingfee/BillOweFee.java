package com.zeroone.star.sccommunity.entity.buildingfee;

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
 * @author 今日运势大吉
 * @since 2022-10-21
 */
@Getter
@Setter
@TableName("bill_owe_fee")
public class BillOweFee implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 欠费主键
     */
    private String oweId;

    /**
     * 账单ID
     */
    private String billId;

    /**
     * 费用ID
     */
    private String feeId;

    /**
     * 账期欠费金额
     */
    private BigDecimal billAmountOwed;

    /**
     * 当前欠费金额
     */
    private BigDecimal amountOwed;

    /**
     * 费用结束时间，当时跑账单时的费用结束时间
     */
    private LocalDateTime feeEndTime;

    /**
     * 业主ID
     */
    private String ownerId;

    /**
     * 业主名称
     */
    private String ownerName;

    /**
     * 业主联系电话
     */
    private String ownerTel;

    /**
     * 付费对象名称 如 1栋1单元1室 或者 1号停车场1号车位
     */
    private String payerObjName;

    /**
     * 付费对象类型 3333 房屋 6666 是车位
     */
    private String payerObjType;

    /**
     * 分片键，小区ID
     */
    private String communityId;

    /**
     * 状态 1000 未交费，2000 已缴费
     */
    private String state;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 截止时间
     */
    private LocalDateTime deadlineTime;


}
