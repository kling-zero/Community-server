package com.zeroone.star.project.query.community.transactions.buildingfee;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("根据抄表类型查询数据对象")
public class MRQDataQuery {
    @NotBlank
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;

    @NotBlank
    @ApiModelProperty(value = "对象ID", example = "752022102842210172")
    private String objId;

    @NotBlank
    @ApiModelProperty(value = "对象类型", example = "类型 1001 房屋 2002 车位")
    private String objType;

    @ApiModelProperty(value = "抄表类型", example = "102022090813867155")
    private String meterType;
}
