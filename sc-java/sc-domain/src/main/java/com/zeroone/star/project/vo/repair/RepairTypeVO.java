package com.zeroone.star.project.vo.repair;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("报修类型视图对象")//显示给界面的
public class RepairTypeVO {
    @ApiModelProperty(value = "报修类型", example = "102022082220310068")
    private String repairType;
}
