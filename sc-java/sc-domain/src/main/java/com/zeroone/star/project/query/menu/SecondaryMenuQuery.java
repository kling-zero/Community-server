package com.zeroone.star.project.query.menu;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xcx
 * @date
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("二级菜单查询对象")
public class SecondaryMenuQuery  extends PageQuery {
    @ApiModelProperty(value = "菜单ID", example = "800201904002")
    private Integer Id;
    @ApiModelProperty(value = "菜单名称", example = "权限")
    private String name;
    @ApiModelProperty(value = "菜单组ID", example = "800201904002")
    private Integer parentMenuId;
    @ApiModelProperty(value = "菜单组名称", example = "权限")
    private String parentMenuName;
    @ApiModelProperty(value = "归属商户", example = "开发团队")
    private String roleName;
}
