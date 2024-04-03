package com.zeroone.star.project.query.rolePrivilege;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("角色员工查询对象")
public class RoleStaffQuery extends PageQuery {
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "姓名", example = "张三")
    private String userName;

    @NotBlank(message = "角色ID不能为空")
    @ApiModelProperty(value = "角色Id", example = "123")
    private String roleId;

}
