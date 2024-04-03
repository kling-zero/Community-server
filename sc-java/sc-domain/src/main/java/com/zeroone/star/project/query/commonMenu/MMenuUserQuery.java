package com.zeroone.star.project.query.commonMenu;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("常用彩带查询对象")
public class MMenuUserQuery extends PageQuery {
    /**
     * 编号
     */
    @ApiModelProperty(value = "常用菜单ID", example = "102022101516380038")
    private String muId;

    /**
     * 菜单名称
     */
    @ApiModelProperty(value = "常用菜单名称", example = "我的小区")
    private String name;

    /**
     * 列顺序
     */
    @ApiModelProperty(value = "序列", example = "1")
    private Integer seq;
}
