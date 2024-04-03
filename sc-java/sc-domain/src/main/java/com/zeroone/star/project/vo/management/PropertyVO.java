package com.zeroone.star.project.vo.management;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;

/**
 * @Author: Kong
 * @License: (C) Copyright 2005-2019, xxx Corporation Limited.
 * @Contact: xxx@xxx.com
 * @Date: 2022-10-13 9:51
 * @Version: 1.0
 * @Description: 物业信息显示对象
 */
@Data
@ApiModel("物业显示对象")
public class PropertyVO {
    @ApiModelProperty(value = "物业地址",example = "哈哈街吊111号")
    private String address;
    @ApiModelProperty(value = "公司法人",example = "张三")
    private String corporation;
    @ApiModelProperty(value = "创建时间",example = "2022-10-22")
    private Date createTime;
    @ApiModelProperty(value = "成立日期",example = "2022-10-22")
    private String foundingTime;
    @ApiModelProperty(value = "地区x坐标",example = "101")
    private String mapX;
    @ApiModelProperty(value = "地区y坐标",example = "101")
    private String mapY;
    @ApiModelProperty(value = "物业名称",example = "哈哈物业")
    private String name;
    @ApiModelProperty(value = "业务状态 1000 为待审核 1200审核拒绝",example = "1000")
    private String state;
    @ApiModelProperty(value = "数据状态 S 保存，0, 在用 1失效",example = "0")
    private String statusCd;
    @ApiModelProperty(value = "商户ID 商户代指物业、开发团队等等",example = "102022081507340423")
    private String storeId;
    @ApiModelProperty(value = "商户种类编码",example = "800900000003")
    private String storeTypeCd;
    @ApiModelProperty(value = "商户种类名称",example = "物业")
    private String storeTypeName;
    @ApiModelProperty(value = "电话",example = "110")
    private String tel;
    @ApiModelProperty(value = "用户密码",example = "随机密码例：123122")
    private String password;
    @ApiModelProperty(value = "用户ID",example = "30518939884421922816")
    private String userId;

//    @ApiModelProperty(value = "小区名称")
//    private String page;
//    @ApiModelProperty(value = "小区名称")
//    private String records;
//    @ApiModelProperty(value = "小区名称")
//    private String row;
//    @ApiModelProperty(value = "")
//    private String total;

}