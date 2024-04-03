package com.zeroone.star.project.vo.management;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: Kong
 * @License: (C) Copyright 2005-2019, xxx Corporation Limited.
 * @Contact: xxx@xxx.com
 * @Date: 2022-10-23 9:06
 * @Version: 1.0
 * @Description: 下拉框里的 城市列表
 */
@Data
@ApiModel("城市清单显示对象")
public class CityAreaVO {

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "id（不重要）")
    private Integer id;

    /**
     * 城市编码
     */
    @ApiModelProperty(value = "城市编码",example = "110100")
    private String areaCode;

    /**
     * 城市名称
     */
    @ApiModelProperty(value = "城市名称")
    private String areaName;

    /**
     * 101 省级 202 市州 303 区县
     */
    @ApiModelProperty(value = "城市级别",example = "101 省级 202 市州 303 区县")
    private String areaLevel;

    /**
     * 父级城市编码
     */
    @ApiModelProperty(value = "父级城市编码",example = "北京市东城区的父级：北京市110000")
    private String parentAreaCode;

    /**
     * 父级城市名称
     */
    @ApiModelProperty(value = "父级城市名称",example = "北京市")
    private String parentAreaName;

    /**
     * 经度
     */
    @ApiModelProperty(value = "经度",example = "101")
    private String lon;

    /**
     * 维度
     */
    @ApiModelProperty(value = "维度",example = "101")
    private String lat;

}