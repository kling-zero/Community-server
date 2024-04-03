package com.zeroone.star.project.dto.rolePrivilege;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 */
@ApiModel("添加/修改/删除角色数据对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id", example = "1", required = false)
    private String roleId;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称", example = "超级管理员", required = true)
    private String name;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "关键册", example = "SUPER_ADMIN", required = true)
    private String keyword;

    /**
     * 角色描述
     */
    @ApiModelProperty(value = "角色描述", example = "无", required = true)
    private String description;

}
