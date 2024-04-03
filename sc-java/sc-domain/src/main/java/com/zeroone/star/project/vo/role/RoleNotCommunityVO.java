package com.zeroone.star.project.vo.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel("查询角色关联的所有小区显示对象")
@Data
public class RoleNotCommunityVO {

    @ApiModelProperty(value = "小区编号", example = "测试地址")
    private String address;

    @ApiModelProperty(value = "小区ID", example = "0")
    private String communityId;

    @ApiModelProperty(value = "小区名称", example = "测试小区")
    private String name;

}
