package com.zeroone.star.project.dto.rolePrivilege.roleCommunity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 */
@ApiModel("角色和小区关联数据对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleAssCommunityDTO {

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id", example = "1", required = true)
    private String roleId;

    /**
     * 小区集合
     */
    @ApiModelProperty(value = "小区DTO集合", example = "[1,2]", required = true)
    private List<CommunityDTO> communityDTOList;

}
