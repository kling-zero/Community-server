package com.zeroone.star.project.query.repair.demoquery;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("报修设置查询")
public class RepairSettingQuery {
    @ApiModelProperty(value = "报修状态", example = "待回访")
    private String state;

    //派单方式
    @ApiModelProperty(value = "派单方式", example = "200")
    private String repairWay;

    //派单类型(自增键)
    @ApiModelProperty(value = "派单类型", example = "832022082224860071")
    private String ruId;

}
