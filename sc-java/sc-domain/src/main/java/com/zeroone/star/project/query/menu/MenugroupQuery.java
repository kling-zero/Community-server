package com.zeroone.star.project.query.menu;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 姓名:卷心菜
 * 内容:示例查询对象
 * 注释:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("菜单组查询对象")
public class MenugroupQuery extends PageQuery {

    @ApiModelProperty(value = "菜单名称", example = "权限")
    private String name;
    @ApiModelProperty(value = "菜单ID", example = "800201904002")
    private Integer Id;
    @ApiModelProperty(value = "图标", example = "fa fa-diamond")
    private String icon;
    @ApiModelProperty(value = "归属商户", example = "开发团队")
    private String roleName;
    @ApiModelProperty(value = "菜单组ID", example = "800201904002")
    private Integer parentMenuId;


}
