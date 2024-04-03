package com.zeroone.star.project.vo.management;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;


@Data
@ApiModel("缴费清单")
public class PayFeeVO {

    @ApiModelProperty(value = "费用类型")
    private String feeTypeCdName;

    @ApiModelProperty(value = "费用项目")
    private String feeName;

    @ApiModelProperty(value = "付费方")
    private String payObjName;

    @ApiModelProperty(value = "缴费ID")
    private String detailId;

    @ApiModelProperty(value = "支付方式")
    private String primeRate;

    @ApiModelProperty(value = "付费周期")
    private Long cycles;

    @ApiModelProperty(value = "应付金额")
    private Long receivableAmount;

    @ApiModelProperty(value = "实付金额")
    private Long receivedAmount;

    @ApiModelProperty(value = "操作人")
    private String userName;

    @ApiModelProperty(value = "缴费时间")
    private Date createTime;


}
