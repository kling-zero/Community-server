package com.zeroone.star.project.query.menu;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("一级菜单分页查询对象")
@Data
public class FirstMenuPageQuery extends PageQuery {

    @ApiModelProperty(value = "菜单组名", example = "首页")
    private String name;

    @ApiModelProperty(value = "商户名称", example = "运营团队")
    private String roleName;

    @ApiModelProperty(value = "是否启用 0 禁用 1 启用", example = "1")
    private Integer isEnable;

}
