package com.zeroone.star.project.vo.management;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



/**
 * @Author: RitoQ
 * @License: (C) Copyright 2005-2019, xxx Corporation Limited.
 * @Contact: xxx@xxx.com
 * @Date: 2022-10-13 21:04
 * @Version: 1.0
 * @Description: 小区功能菜单显示对象
 */
@Data
@ApiModel("小区功能菜单显示对象")
public class SCommunityMenuVO {

    @ApiModelProperty(value="菜单id",example = "700201904001")
    private String menuId;
    @ApiModelProperty(value = "菜单名" ,example = "巡检、停车...")
    private String menuName;
    @ApiModelProperty(value = "菜单id" ,example = "800201904001")
    private String menuGroupId;
    @ApiModelProperty(value = "菜单组名",example = "组织")
    private String menuGroupName;
    @ApiModelProperty(value ="小区id",example = "2021081177860471")
    private String communityId;
    @ApiModelProperty(value ="小区名" ,example = "HC演示小区（请勿删除）")
    private String communityName;
    @ApiModelProperty(value ="小区功能菜单组id" ,example = "800201904009")
    private String groupCommunityId;
    @ApiModelProperty(value = "菜单图片" ,example = "fa-desktop")
    private String icon;
}
