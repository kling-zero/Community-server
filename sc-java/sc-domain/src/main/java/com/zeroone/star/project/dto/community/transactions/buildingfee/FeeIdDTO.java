package com.zeroone.star.project.dto.community.transactions.buildingfee;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("费用Id传输数据对象")
public class FeeIdDTO {
    @ApiModelProperty(value = "小区ID", example = "2022081539020475")
    String communityId;
    @ApiModelProperty(value = "费用Id", example = "902022082275630050")
    String feeId;
}
