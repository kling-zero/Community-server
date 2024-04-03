package com.zeroone.star.project.dto.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

@ApiModel("三级菜单数据传输对象")
@Data
public class ThirdMenuDTO {
    @ApiModelProperty(value = "权限ID", example = "1")
    private Integer id;

    @ApiModelProperty(value = "权限名称", example = "修改手机菜单权限")
    private String name;

    @ApiModelProperty(value = "链接地址", example = "/admin.html#/pages/admin/housekeepingTypeManage")
    private String linkUrl;

    @ApiModelProperty(value = "管理员名称", example = "普通管理员")
    private String roleName;

    @ApiModelProperty(value = "创建时间", example = "2022-10-16 21:18:44")
    private String createTime;

    @ApiModelProperty(value = "描述", example = "修改手机菜单")
    private String description;

    @ApiModelProperty(value = "父级菜单id", example = "3")
    private Integer parentMenuId;
}
