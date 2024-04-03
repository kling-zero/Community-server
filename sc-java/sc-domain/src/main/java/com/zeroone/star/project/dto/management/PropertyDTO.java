package com.zeroone.star.project.dto.management;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;
import java.util.List;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: Kong、nmh
 * @License: (C) Copyright 2005-2019, xxx Corporation Limited.
 * @Contact: xxx@xxx.com
 * @Date: 2022-10-12 21:53
 * @Version: 1.0
 * @Description: 物业信息传输对象，用于接收前端发送参数的封装
 */
@Data
@ApiModel("物业数据传输对象")
public class PropertyDTO {

    @ApiModelProperty(value = "物业id", example = "102022081507340423")
    private String StoreId;

    @ApiModelProperty(value = "物业名称", example = "哈哈物业")
    private String storeName;

    @ApiModelProperty(value = "小区id 数组")
    private List<String> communityIds;

    @ApiModelProperty(value = "用户id", example = "30518939884421922816")
    private String userId;

    @NotBlank(message = "地址不能为空")
    @ApiModelProperty(value = "地址", example = "哈哈街吊111号")
    private String address;

    @NotBlank(message = "法人不能为空")
    @ApiModelProperty(value = "公司法人", example = "那么娟")
    private String corporation;


    @NotNull(message = "成立日期不能为空")
    @ApiModelProperty(value = "成立日期", example = "2022-02-02")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date date;

    @ApiModelProperty(value = "是否为所有功能", example = "false")
    private Boolean isAll;

    @ApiModelProperty(value = "小区选中的功能的id 数组")
    private List<String> groupIds;

    @ApiModelProperty(value = "小区名称", example = "哈哈物业")
    private String communityName;

    @NotBlank(message = "电话不能为空")
    @ApiModelProperty(value = "电话", example = "110")
    private String tel;

    @NotBlank(message = "地标不能为空")
    @ApiModelProperty(value = "地标", example = "智星大厦旁")
    private String nearybyLandmarks;

//    @ApiModelProperty(value = "staffId", example = "staffIdexample")
//    private String staffId;

    @ApiModelProperty(value = "memberId", example = "102022081507340423")
    private String memberId;


//    @NotNull(message = "地表不能为空")
//    @ApiModelProperty(value = "地标", example = "肯德只因旁边")
//    private String[] cityCodes;
//    @NotNull(message = "要求不能为空")
//    @ApiModelProperty(value = "要求", example = "肯德只因旁边")
//    private String[] pid;
}