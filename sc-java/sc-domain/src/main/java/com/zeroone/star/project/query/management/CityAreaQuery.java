package com.zeroone.star.project.query.management;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: Kong
 * @License: (C) Copyright 2005-2019, xxx Corporation Limited.
 * @Contact: xxx@xxx.com
 * @Date: 2022-10-23 9:16
 * @Version: 1.0
 * @Description:
 */
@Data
@ApiModel("城市列表查询对象")
public class CityAreaQuery {

    @NotBlank(message = "城市级别不能为空")
    @ApiModelProperty(value = "查询城市级别 (101 省级 202 市州 303 区县)",example = "101",required = true)
    Integer areaLevel;

    @NotBlank(message = "父级城市编码")
    @ApiModelProperty(value = "父级城市编码（上一级）(北京市东城区的父级城市编码为 北京市编码110000) (省的父城市编码为 0)",example = "0",required = true)
    Integer parentAreaNode;

}