package com.zeroone.star.project.vo.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xcx
 * @date
 */
@Data
@ApiModel("二级菜单显示对象")
public class SecondaryMenuVO implements Serializable {
    @ApiModelProperty(value = "菜单ID", example = "800201904002")
    private Integer Id;
    @ApiModelProperty(value = "菜单名称", example = "权限")
    private String name;
    @ApiModelProperty(value = "菜单地址", example = "/menu")
    private String linkUrl;
    @ApiModelProperty(value = "菜单描述", example = "权限管理")
    private String description;
    @ApiModelProperty(value = "是否显示", example = "1")
    private String isEnable;
    @ApiModelProperty(value = "序列", example = "10")
    private Integer priority;
    @ApiModelProperty(value = "菜单组ID", example = "800201904002")
    private Integer parentMenuId;
    @ApiModelProperty(value = "菜单组名称", example = "权限")
    private String parentMenuName;
//    @ApiModelProperty(value = "图标", example = "fa fa-diamond")
//    private String icon;
    @ApiModelProperty(value = "归属商户", example = "开发团队")
    private String roleName;
}
