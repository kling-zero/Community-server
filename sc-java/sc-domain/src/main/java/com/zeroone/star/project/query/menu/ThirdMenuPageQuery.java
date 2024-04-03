package com.zeroone.star.project.query.menu;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

@ApiModel("三级菜单分页查询对象")
@Data
public class ThirdMenuPageQuery extends PageQuery {

    @ApiParam(required = true)
    @ApiModelProperty(value = "父级菜单(二级菜单)ID", example = "3")
    private Integer parentMenuId;

    @ApiModelProperty(value = "权限ID", example = "6")
    private Integer id;

    @ApiModelProperty(value = "权限名称", example = "修改手机菜单权限")
    private String name;
}
