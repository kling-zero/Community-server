package com.zeroone.star.project.dto.community.roomRenovation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("添加房屋装修基本信息")
public class SaveBasicDTO {
    @ApiModelProperty(value = "房屋ID", example = "752022100987340783")
    private String roomId;
    @ApiModelProperty(value = "联系人", example = "EricWang")
    private String personName;
    @ApiModelProperty(value = "主要负责人", example = "qqqq")
    private String personMain;
    @ApiModelProperty(value = "联系人电话", example = "13365170222")
    private String personTel;
    @ApiModelProperty(value = "负责人电话", example = "13365170222")
    private String personMainTel;
    @ApiModelProperty(value = "装修开始时间", example = "2022-10-10 00:00:00")
    private LocalDateTime createTime;
    @ApiModelProperty(value = "装修结束时间", example = "2022-10-10 00:00:00")
    private LocalDateTime endTime;
    @ApiModelProperty(value = "是否延期", example = "Y")
    private String isPostpone;
    @ApiModelProperty(value = "状态", example = "3000")
    private String state;
}
