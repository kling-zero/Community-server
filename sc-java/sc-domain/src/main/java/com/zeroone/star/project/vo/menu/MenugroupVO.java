package com.zeroone.star.project.vo.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 姓名:李惟
 * 内容:
 * 注释:
 */

@Data
@ApiModel("菜单组显示对象")
public class MenugroupVO  implements Serializable {

    @ApiModelProperty(value = "菜单ID", example = "800201904002")
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
    @ApiModelProperty(value = "菜单地址", example = "/menu")
    private String linkUrl;

}
