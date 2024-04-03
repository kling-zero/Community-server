package com.zeroone.star.sccommunity.entity.reprintreceipt;

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
 * @author night
 * @since 2022-10-24
 */
@Getter
@Setter
@TableName("pay_fee")
public class PayFee implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 费用ID
     */
    private String feeId;

    /**
     * 业务ID
     */
    private String bId;

    /**
     * 费用类型，物业费，停车费
     */
    private String feeTypeCd;

    @TableField(exist = false)
    private String feeType;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 付款方ID
     */
    private String payerObjId;

    /**
     * 收款方ID
     */
    private String incomeObjId;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 总金额，如物业费，停车费等没有总金额的，填写为-1.00
     */
    private BigDecimal amount;

    /**
     * 创建用户ID
     */
    private String userId;

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
     * 费用标识 1003006 为周期性费用 2006012 为一次性费用
     */
    private String feeFlag;

    /**
     * 状态 2007001收费未开始 2008001 收费中状态 2009001 收费结束
     */
    private String state;

    /**
     * 费用项ID
     */
    private String configId;

    /**
     * 付费对象类型 3333 房屋 6666 是车位
     */
    private String payerObjType;

    /**
     * 批次ID
     */
    private String batchId;

    //房屋
    @TableField(exist = false)
    private String roomName;

    @TableField(exist = false)
    private String parkingNum;

    @TableField(exist = false)
    private String businessName;

    @TableField(exist = false)
    private String ownerName;

    @TableField(exist = false)
    private String feeName;

}
