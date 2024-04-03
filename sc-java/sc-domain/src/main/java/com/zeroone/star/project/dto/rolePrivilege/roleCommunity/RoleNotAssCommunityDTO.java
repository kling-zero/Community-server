package com.zeroone.star.project.dto.rolePrivilege.roleCommunity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 */
@ApiModel("角色和小区关联数据对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleNotAssCommunityDTO {

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id", example = "1", required = true)
    private String roleId;

    /**
     * 小区Id数组
     */
    @ApiModelProperty(value = "小区Id", example = "2", required = true)
    private String communityId;

}
