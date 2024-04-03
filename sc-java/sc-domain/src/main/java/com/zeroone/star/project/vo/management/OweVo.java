package com.zeroone.star.project.vo.management;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("欠费明细表")
public class OweVo {

    @ApiModelProperty(value = "费用编号")
    private Integer feeTypeCdName;

    @ApiModelProperty(value = "费用编号")
    private Integer objName;

    @ApiModelProperty(value = "业主")
    private Integer ownerName;

}
