package com.zeroone.star.project.dto.community.transactions.buildingfee;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("修改费用传输数据对象")
public class UpdateFeeDTO {
    @ApiModelProperty(value = "费用ID", example = "902022101468217574")
    private String feeId;
    @ApiModelProperty(value = "结束时间", example = "2022-10-14 00:00:00")
    private Date endTime;
    @ApiModelProperty(value = "开始时间", example = "2022-10-14 00:00:00")
    private Date startTime;
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "计算公式 1001 面积*单价+附加费 2002 固定费用", example = "5005")
    private String computingFormula;
    @ApiModelProperty(value = "费用标识 1003006 为周期性费用 2006012 为一次性费用", example = "1003006")
    private String feeFlag;
    @ApiModelProperty(value = "状态周期")
    private String rateCycle;
    @ApiModelProperty(value = "状态")
    private String rate;
    @ApiModelProperty(value = "状态开始时间")
    private String rateStartTime;
    @ApiModelProperty(value = "折扣终止时间", example = "2022-10-14 00:00:00")
    private String maxEndTime;
}
