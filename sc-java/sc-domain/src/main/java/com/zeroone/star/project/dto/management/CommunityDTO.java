package com.zeroone.star.project.dto.management;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: Kong
 * @License: (C) Copyright 2005-2019, xxx Corporation Limited.
 * @Contact: xxx@xxx.com
 * @Date: 2022-10-12 21:53
 * @Version: 1.0
 * @Description: 小区信息传输对象，用于接收前端发送参数的封装
 */
@Data
@ApiModel("小区数据传输对象")
public class CommunityDTO {
    @ApiModelProperty(value = "小区名称",example = "泉城花园",required = true)
    private String communityName;

    @ApiModelProperty(value = "小区地区 下拉框选择的地址",example = "630104",required = true)
    private Integer areaAddress;

    @ApiModelProperty(value = "小区地址 文本框输入的详细地址",example = "北京省北京市东城区飞机路",required = true)
    private String address;

    @ApiModelProperty(value = "附近地标",example = "人民广场旁",required = true)
    private String nearbyLandmarks;

    @ApiModelProperty(value = "联系方式",example = "172623123",required = true)
    private Integer tel;

    @ApiModelProperty(value = "城市编码",example = "630104",required = true)
    private Integer cityCode;

    @ApiModelProperty(value = "缴费周期",example = "12",required = true)
    private Integer payFeeMonth;

    @ApiModelProperty(value = "每月单价",example = "10.0",required = true)
    private Float feePrice;


    //缺社区编码attr
}