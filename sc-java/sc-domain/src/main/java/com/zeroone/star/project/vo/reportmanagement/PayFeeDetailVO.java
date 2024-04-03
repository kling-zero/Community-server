package com.zeroone.star.project.vo.reportmanagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: jiemo
 * @date: 2022/10/24 17:02
 * @description: 缴费明细表视图对象
 */
@Data
@ApiModel("缴费明细表视图对象")
public class PayFeeDetailVO {
    @ApiModelProperty(value = "订单号", example = "102022081609140007")
    private String oId;
    @ApiModelProperty(value = "房号", example = "1栋1单元1001室")
    private String objName;
    @ApiModelProperty(value = "业主id", example = "wuwx")
    private String ownerId;
    @ApiModelProperty(value = "业主名称", example = "张杰")
    private String ownerName;
    @ApiModelProperty(value = "收费项id", example = "922022082235500040")
    private String configId;
    @ApiModelProperty(value = "收费项", example = "间接收费测试")
    private String feeName;
    @ApiModelProperty(value = "费用类型", example = "888800010001")
    private String feeTypeCd;
    @ApiModelProperty(value = "费用类型名称", example = "物业费")
    private String feeTypeCdName;
    @ApiModelProperty(value = "费用状态", example = "1400")
    private String state;
    @ApiModelProperty(value = "费用状态名称", example = "正常")
    private String stateName;
    @ApiModelProperty(value = "支付方式", example = "微信二维码")
    private String primeRate;
    @ApiModelProperty(value = "开始时间", example = "2022-08-01 00:00:00")
    private Date startTime;
    @ApiModelProperty(value = "结束时间", example = "2022-09-30 00:00:00")
    private Date endTime;
    @ApiModelProperty(value = "应收金额", example = "999")
    private String receivableAmount;
    @ApiModelProperty(value = "实收金额", example = "999")
    private String receivedAmount;
    @ApiModelProperty(value = "减免金额", example = "0")
    private String deductionAmount;
    @ApiModelProperty(value = "优惠金额", example = "0")
    private String preferentialAmount;
    @ApiModelProperty(value = "滞纳金", example = "0")
    private String lateFee;
    @ApiModelProperty(value = "空置房打折金额", example = "0")
    private String vacantHousingDiscount;
    @ApiModelProperty(value = "空置房减免金额", example = "0")
    private String vacantHousingReduction;
    @ApiModelProperty(value = "面积", example = "11")
    private String builtUpArea;
    @ApiModelProperty(value = "车位", example = "101停车场1车位")
    private String psName;
}
