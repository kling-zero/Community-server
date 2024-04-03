package com.zeroone.star.project.dto.community.roomRenovation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("查询详细信息传输对象")
public class SelectDetailDTO {
    @ApiModelProperty(value = "装修ID", example = "172022100943551097")
    private String rId;
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;

}
