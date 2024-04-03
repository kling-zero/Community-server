package com.zeroone.star.project.query.community.transactions.buildingfee;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("查询抄表数据对象")
public class MeterReadingQuery {
    @NotBlank
    @ApiModelProperty(value = "页数", example = "1")
    private int page;
    @NotBlank
    @ApiModelProperty(value = "条数", example = "100")
    private int row;
    @NotBlank
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;
}
