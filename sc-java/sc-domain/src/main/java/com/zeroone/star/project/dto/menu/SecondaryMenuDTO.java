package com.zeroone.star.project.dto.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xcx
 * @date
 */
@Data
@ApiModel("二级菜单输数据对象")
public class SecondaryMenuDTO {
    @ApiModelProperty(value = "菜单组ID", example = "800201904002" ,required = true)
    private Integer parentMenuId;
    @ApiModelProperty(value = "菜单名称", example = "权限",required = true)
    private String name;
    @ApiModelProperty(value = "菜单地址", example = "/menu",required = true)
    private String linkUrl;
    @ApiModelProperty(value = "序列", example = "10",required = true)
        private Integer priority;
    @ApiModelProperty(value = "是否显示", example = "1",required = true)
    private String isEnable;
    @ApiModelProperty(value = "菜单描述", example = "权限管理")
    private String description;
    @ApiModelProperty(value = "菜单组名称", example = "权限",required = true)
    private String parentMenuName;
    @ApiModelProperty(value = "归属商户", example = "开发团队",required = true)
    private String roleName;
}
