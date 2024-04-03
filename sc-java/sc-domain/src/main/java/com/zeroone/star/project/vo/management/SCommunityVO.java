package com.zeroone.star.project.vo.management;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: CoderKled、Kong
 * @Date: 2022-10-13
 * @Version: 1.0
 * @Description: 小区信息显示对象
 */
@Data
@ApiModel("小区显示对象")
public class SCommunityVO {
    @ApiModelProperty(value = "小区地址", example = "宁德市")
    private String address;

    @ApiModelProperty(value = "小区ID", example = "2022081810340209")
    private String communityId;

    @ApiModelProperty(value = "小区名称", example = "万科")
    private String name;

    @ApiModelProperty(value = "城市名称 （cityCode）", example = "北京市东城区")
    private String cityName;

    @ApiModelProperty(value = "城市编码", example = "110101")
    private String cityCode;

    @ApiModelProperty(value = "附近地标", example = "蜀峰468")
    private String nearbyLandmarks;

    @ApiModelProperty(value = "联系方式", example = "110")
    private String tel;

    @ApiModelProperty(value = "业务状态编码 1000 为待审核 1200审核拒绝", example = "1100")
    private String state;

    @ApiModelProperty(value = "业务状态名称", example = "审核完成")
    private String stateName;

    @ApiModelProperty(value = "地区 x坐标", example = "101.33")
    private String mapX;

    @ApiModelProperty(value = "地区 y坐标", example = "101.33")
    private String mapY;

//    @ApiModelProperty(value = "数据状态", example = "审核完成")
//    private String status;//    @ApiModelProperty(value = "社区编码", example = "610066")
//    private String communityEncoding;
}