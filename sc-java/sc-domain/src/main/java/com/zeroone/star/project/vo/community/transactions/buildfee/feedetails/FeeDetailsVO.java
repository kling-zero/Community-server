package com.zeroone.star.project.vo.community.transactions.buildfee.feedetails;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("缴费历史显示对象")
public class FeeDetailsVO {
    @ApiModelProperty(value = "结束时间", example = "2022-10-14 00:00:00")
    private Date endTime;
    @ApiModelProperty(value = "开始时间", example = "2022-10-14 00:00:00")
    private Date startTime;
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "创建时间", example = "2022-10-14 00:00:00")
    private Date createTime;
    @ApiModelProperty(value = "周期，以月为单位", example = "6")
    private String cycles;
    @ApiModelProperty(value = "保证金ID", example = "800.00")
    private String detailId;
    @ApiModelProperty(value = "费用ID", example = "902022101699947987")
    private String feeId;
    @ApiModelProperty(value = "打折率", example = "1")
    private String primeRate;
    @ApiModelProperty(value = "应收金额", example = "1000")
    private String receivableAmount;
    @ApiModelProperty(value = "实收金额", example = "30.00")
    private String receivedAmount;
    @ApiModelProperty(value = "状态，1001 待支付 2002 支付完成 3003 支付失败 4004 已退", example = "1001")
    private String state;
    @ApiModelProperty(value = "备注",example = "备注")
    private String remark;


    //缴费历史中没有显示以下信息
//    @ApiModelProperty(value = "状态", example = "收费状态中")
//    private String stateName;
    //    @ApiModelProperty(value = "费用项名称", example = "物业缴费测试101")
//    private String feeName;
}
