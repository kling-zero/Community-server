package com.zeroone.star.project.vo.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel("查询角色关联的所有小区显示对象")
@Data
public class RoleCommunityVO {

    @ApiModelProperty(value = "小区ID", example = "0")
    private String communityId;

    @ApiModelProperty(value = "小区名称", example = "测试小区")
    private String communityName;

    @ApiModelProperty(value = "角色ID", example = "0123")
    private String roleId;

}
