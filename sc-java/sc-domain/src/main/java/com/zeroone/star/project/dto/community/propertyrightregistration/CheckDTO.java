package com.zeroone.star.project.dto.community.propertyrightregistration;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@ApiModel("产权登记审核")
public class CheckDTO {
    @ApiModelProperty(value = "主键id", example = "102022101540201672")
    private String prrId;
    @ApiModelProperty(value = "房屋id", example = "752022101002411137")
    private String roomId;
    @ApiModelProperty(value = "姓名", example = "丽丽了")
    private String name;
    @ApiModelProperty(value = "联系方式", example = "15549065730")
    private String link;
    @ApiModelProperty(value = "身份证", example = "333333333333333333")
    private String idCard;
    @ApiModelProperty(value = "地址", example = "Shanghai")
    private String address;
    @ApiModelProperty(value = "状态", example = "1")
    private String state;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createTime;
    @ApiModelProperty(value = "社区id", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "备注",example = "null")
    private String remark;

}
