package com.zeroone.star.project.dto.rolePrivilege.roleFunction;

import com.zeroone.star.project.dto.rolePrivilege.roleCommunity.CommunityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 */
@ApiModel("角色和功能关联数据对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleAssFunctionDTO {

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色(权限组)id", example = "6002022101554840002", required = true)
    private String pgId;

    /**
     * 功能集合
     */
    @ApiModelProperty(value = "功能DTO集合", example = "[{'functionId'='1','functionName'='查看所有员工信息'},{}]", required = true)
    private List<FuncitonDTO> funcitonDTOList;

}
