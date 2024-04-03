package com.zeroone.star.project.vo.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel("查询角色未关联的功能显示对象")
@Data
public class RoleNotFunctionVO {

    @ApiModelProperty(value = "功能ID", example = "0")
    private String functionId;

    @ApiModelProperty(value = "功能名称", example = "测试小区")
    private String functionName;

}
