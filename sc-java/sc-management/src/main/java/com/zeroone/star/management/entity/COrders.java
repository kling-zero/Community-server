package com.zeroone.star.management.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author jiemo
 * @since 2022-10-17
 */
@Getter
@Setter
@TableName("c_orders")
public class COrders implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    private String oId;

    /**
     * 应用ID
     */
    private String appId;

    private String extTransactionId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 外部系统请求时间
     */
    private String requestTime;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 订单类型，参考c_order_type表
     */
    private String orderTypeCd;

    /**
     * 订单完成时间
     */
    private LocalDate finishTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 数据状态，详细参考c_status表
     */
    private String statusCd;


}
