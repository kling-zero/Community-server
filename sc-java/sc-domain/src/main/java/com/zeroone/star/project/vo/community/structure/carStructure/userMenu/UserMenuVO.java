package com.zeroone.star.project.vo.community.structure.carStructure.userMenu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/14
 */
@Data
@ApiModel("查询所有单元楼层结构图")
public class UserMenuVO {
    @ApiModelProperty(value = "菜单组Id",example = "fa fa-bar-chart")
    private String icon;
    @ApiModelProperty(value = "编号",example = "102022090763567441")
    private String muId;
    @ApiModelProperty(value = "菜单名称",example = "我的小区")
    private String name;
    @ApiModelProperty(value = "列顺序",example = "1")
    private Integer seq;
    @ApiModelProperty(value = "员工ID",example = "302022090667451419")
    private String staffId;
    @ApiModelProperty(value = "数据状态",example = "0")
    private String statusCd;
    @ApiModelProperty(value = "打开地址",example = "/#/pages/common/enterCommunity")
    private String url;
}
