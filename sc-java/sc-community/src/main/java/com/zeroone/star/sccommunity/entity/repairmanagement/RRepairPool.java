package com.zeroone.star.sccommunity.entity.repairmanagement;

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
 * @author Gerins
 * @since 2022-10-15
 */
@Getter
@Setter
@TableName("r_repair_pool")
public class RRepairPool implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 报修ID
     */
    private String repairId;

    /**
     * 业务ID
     */
    private String bId;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 报修类型
     */
    private String repairType;

    /**
     * 报修人姓名
     */
    private String repairName;

    /**
     * 手机号
     */
    private String tel;

    /**
     * 报修内容
     */
    private String context;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 报修状态，请查看state 表
     */
    private String state;

    /**
     * 数据状态
     */
    private String statusCd;

    /**
     * 报修对象类型 001 小区 002 楼栋 003 单元 004 房屋
     */
    private String repairObjType;

    /**
     * 报修对象ID
     */
    private String repairObjId;

    /**
     * 报修对象名称
     */
    private String repairObjName;

    /**
     * 预约时间
     */
    private LocalDateTime appointmentTime;

    /**
     * 维修类型  1001有偿服务  1002无偿服务
     */
    private String maintenanceType;

    /**
     * 报修渠道  D员工代客报修  T电话报修 Z业主自主保修
     */
    private String repairChannel;

    /**
     * 维修物料
     */
    private String repairMaterials;

    /**
     * 费用明细：单价*数量=总价
     */
    private String repairFee;

    /**
     * 支付方式1、现金2、微信转账3、微信公众号4支付宝
     */
    private String payType;


}
