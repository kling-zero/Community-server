package com.zeroone.star.project.dto.setting;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MenuRoleDTO {
    @ApiModelProperty(value = "角色ID")
    private int roleID;

    @ApiModelProperty(value = "菜单ID")
    private int menuID;
}
