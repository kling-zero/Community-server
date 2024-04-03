package com.zeroone.star.project.query.rolePrivilege;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("不与角色关联的小区查询对象")
public class RoleCommunityQuery extends PageQuery {

    @NotBlank(message = "角色ID不能为空")
    @ApiModelProperty(value = "角色Id", example = "123")
    private String roleId;

    @ApiModelProperty(value = "小区名称", example = "测试小区")
    private String name;

}
