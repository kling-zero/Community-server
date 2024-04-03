package com.zeroone.star.project.vo.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("三级菜单展示对象")
@Data
public class ThirdMenuVO {

    @ApiModelProperty(value = "权限ID", example = "1")
    private Integer id;

    @ApiModelProperty(value = "权限名称", example = "保存手机菜单")
    private String name;

    @ApiModelProperty(value = "链接地址", example = "/admin.html#/pages/admin/housekeepingTypeManage")
    private String linkUrl;

    @ApiModelProperty(value = "管理员ID",example = "1")
    private Integer roleId;

    @ApiModelProperty(value = "管理员名称",example = "超级管理员")
    private String roleName;

    @ApiModelProperty(value = "创建时间", example = "2022-10-16 21:18:44")
    private String createTime;


}
