package com.zeroone.star.project.vo.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("一级菜单展示对象")
@Data
public class FirstMenuVO {
    @ApiModelProperty(value = "编号", example = "1")
    private Integer id;

    @ApiModelProperty(value = "菜单名", example = "首页")
    private String name;

    @ApiModelProperty(value = "链接地址", example = "/")
    private String linkUrl;

    @ApiModelProperty(value = "商户名称", example = "运营团队")
    private String roleName;

    @ApiModelProperty(value = "描述", example = "删除手机菜单权限")
    private String description;

    @ApiModelProperty(value = "是否启用 0 禁用 1 启用", example = "1")
    private Integer isEnable;

    @ApiModelProperty(value = "优先级", example = "10")
    private Integer priority;

    @ApiModelProperty(value = "菜单组图标", example = "fa")
    private String icon;

}
