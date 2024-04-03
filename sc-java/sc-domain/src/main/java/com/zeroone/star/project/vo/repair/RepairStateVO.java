package com.zeroone.star.project.vo.repair;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("报修状态视图对象")//显示给界面的
public class RepairStateVO {
    @ApiModelProperty(value = "报修状态", example = "待回访")
    private String state;
}
