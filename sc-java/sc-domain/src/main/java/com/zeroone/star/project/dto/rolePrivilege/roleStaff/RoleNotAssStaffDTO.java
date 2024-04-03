package com.zeroone.star.project.dto.rolePrivilege.roleStaff;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 */
@ApiModel("角色和员工关联数据对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleNotAssStaffDTO {

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id", example = "1", required = true)
    private String roleId;

    /**
     * 员工id数组
     */
    @ApiModelProperty(value = "员工id", example = "2", required = true)
    private String staffId;

}
