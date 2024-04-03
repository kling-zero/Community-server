package com.zeroone.star.project.dto.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 姓名:李惟
 * 内容:
 * 注释:
 */
@Data
@ApiModel("菜单组传输数据对象")
public class MenugroupDTO{
    @ApiModelProperty(value = "菜单组ID", example = "800201904002")
    private Integer Id;
    @ApiModelProperty(value = "菜单名称", example = "权限")
    private String name;
    @ApiModelProperty(value = "图标", example = "fa fa-diamond")
    private String icon;
    @ApiModelProperty(value = "归属商户", example = "开发团队")
    private String roleName;
    @ApiModelProperty(value = "序列", example = "10")
    private Integer priority;
    @ApiModelProperty(value = "菜单描述", example = "权限管理")
    private String description;
    @ApiModelProperty(value = "数据状态", example = "0")
    private String isEnable;
    @ApiModelProperty(value = "菜单地址", example = "/menu")
    private String linkUrl;


}
