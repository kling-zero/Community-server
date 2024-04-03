package com.zeroone.star.project.dto.community.roomRenovation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("删除房屋基本信息传输数据对象")
public class DeleteBasicDTO {
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
    @ApiModelProperty(value = "装修公司", example = "qqq")
    private String renovationCompany;
    @ApiModelProperty(value = "房屋名称", example = "21-01-501")
    private String roomName;
    @ApiModelProperty(value = "装修ID", example = "172022100943551097")
    private String rId;

    @ApiModelProperty(value = "数据状态", example = "0")
    private String statusCd;
}
