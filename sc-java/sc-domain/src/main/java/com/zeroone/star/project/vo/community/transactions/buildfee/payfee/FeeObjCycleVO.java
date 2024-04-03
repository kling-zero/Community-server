package com.zeroone.star.project.vo.community.transactions.buildfee.payfee;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("根据周期查询订单收费对象显示对象")
public class FeeObjCycleVO extends FeeObjVO{
    @ApiModelProperty(value = "本期度数", example = "0.00")
    private String curDegrees;
    @ApiModelProperty(value = "本期读表时间", example = "2022-10-15 03:00:50")
    private Date curReadingTime;
    @ApiModelProperty(value = "周期，单位月", example = "12")
    private String cycle;
}
