package com.zeroone.star.project.query.management;
import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
/**
 * @Author: RitoQ CoderKled Kong
 * @License: (C) Copyright 2005-2019, xxx Corporation Limited.
 * @Contact: xxx@xxx.com
 * @Date: 2022-10-13 21:04
 * @Version: 1.0
 * @Description:
 */
//done
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("小区查询对象")
public class CommunityQuery extends PageQuery {


    @ApiModelProperty(value = "小区ID", example = "2022081539020475")
    private String communityId;

    @ApiModelProperty(value = "该小区的物业Id", example = "102022081507340423")
    private String storeId;

    @ApiModelProperty(value = "小区名称", example = "万科")
    private String name;

    @ApiModelProperty(value = "城市编码 表示省市区", example = "11010")
    private Integer cityCode;

//    @ApiModelProperty(value = "商户类型", example = "800900000001")
//    private Integer storeType;

    @ApiModelProperty(value = "memberId", example = "123")
    private Integer memberId;





}
