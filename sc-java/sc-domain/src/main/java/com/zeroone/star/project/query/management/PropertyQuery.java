package com.zeroone.star.project.query.management;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @Author: Freasy Kong
 * @License: (C) Copyright 2005-2019, xxx Corporation Limited.
 * @Contact: xxx@xxx.com
 * @Date: 2022-10-13-17-44
 * @Version: 1.0
 * @Description:
 */
//done
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("物业查询对象")
public class PropertyQuery extends PageQuery {
//    private String appId;
//    private String componentCode;
//    private String componentMethod;
//    private String userId;
//    private String userName;

    @ApiModelProperty(value = "商户id",example = "102022081507340423")
    private String storeId;

    @ApiModelProperty(value = "物业公司名称",example = "演示物业")
    private String name;

    @ApiModelProperty(value = "电话",example = "18909711443")
    private String tel;

}
