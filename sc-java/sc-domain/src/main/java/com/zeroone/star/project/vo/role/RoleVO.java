package com.zeroone.star.project.vo.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@ApiModel("新建角色成功显示对象")
@Data
public class RoleVO {
    /**
     * 角色编号
     */
    @ApiModelProperty(value = "角色唯一编号", example = "1")
    private String roleId;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称", example = "保安")
    private String username;

    /**
     * 角色描述
     */
    @ApiModelProperty(value = "角色描述", example = "安保人员")
    private String desc;
}
