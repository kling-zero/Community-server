package com.zeroone.star.project.dto.community.roomRenovation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@ApiModel("房屋基本信息传输数据对象")
public class RoomBasicDTO {
    private String roomId;
    @ApiModelProperty(value = "联系人", example = "EricWang")
    private String personName;
    @ApiModelProperty(value = "主要负责人", example = "qqqq")
    private String personMain;
    @ApiModelProperty(value = "联系人电话", example = "13365170222")
    private String personTel;
    @ApiModelProperty(value = "负责人电话", example = "13365170222")
    private String personMainTel;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "装修开始时间", example = "2022-10-10 00:00:00")
    private LocalDateTime createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
    @ApiModelProperty(value = "是否违规", example = "Y")
    private String isViolation;
}
