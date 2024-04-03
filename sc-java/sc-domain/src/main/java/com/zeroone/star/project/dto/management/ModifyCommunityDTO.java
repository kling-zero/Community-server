package com.zeroone.star.project.dto.management;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: MFM
 * @License: (C) Copyright 2005-2019, xxx Corporation Limited.
 * @Contact: xxx@xxx.com
 * @Date: 2022年10月18日 18:12
 * @Version: 1.0
 * @Description: 修改小区信息传输对象，用于接收前端发送参数的封装
 */

@Data
public class ModifyCommunityDTO {
    @ApiModelProperty(value = "小区Id", example = "2022081539020475")
    private String communityId;

    @ApiModelProperty(value = "小区名称", example = "泉城花园")
    private String name;

//    @ApiModelProperty(value = "小区地区 下拉框选择的地址", example = "630104")
//    private Integer areaAddress;

    @ApiModelProperty(value = "小区地址 文本框输入的详细地址", example = "北京省北京市东城区飞机路")
    private String address;

    @ApiModelProperty(value = "附近地标", example = "人民广场旁")
    private String nearbyLandmarks;

    @ApiModelProperty(value = "联系方式", example = "172623123")
    private Integer tel;

    @ApiModelProperty(value = "城市编码", example = "630104")
    private Integer cityCode;

    @ApiModelProperty(value = "缴费周期", example = "12")
    private Integer payFeeMonth;

    @ApiModelProperty(value = "每月单价", example = "10.0")
    private Float feePrice;
}
