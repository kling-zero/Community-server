package com.zeroone.star.project.vo.community.transactions.buildfee.owefees;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("缴费传输数据对象")
public class PayFeesVO {
    @ApiModelProperty(value = "结束时间", example = "2022-10-14 00:00:00")
    private Date endTime;
    @ApiModelProperty(value = "费用Id", example = "902022101476217398")
    private String feeId;
    @ApiModelProperty(value = "打折率", example = "1")
    private String primeRate;
    @ApiModelProperty(value = "实收金额", example = "1000")
    private String receivedAmount;
    @ApiModelProperty(value = "开始时间", example = "2022-10-14 00:00:00")
    private Date startTime;
}
