package com.zeroone.star.project.query.rolePrivilege;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("角色功能查询对象")
public class RoleFunctionQuery extends PageQuery {

    @NotBlank(message = "权限组ID不能为空")
    @ApiModelProperty(value = "权限组ID", example = "6002022101554840002")
    private String pgId;

    @NotBlank(message = "小区ID不能为空")
    @ApiModelProperty(value = "小区ID", example = "2022081539020475")
    private String communityId;

}
