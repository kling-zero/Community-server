package com.zeroone.star.project.vo.community.propertyrightregistration;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("审核对象")
public class CheckVO {
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
    @ApiModelProperty(value = "社区id", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "备注",example = "null")
    private String remark;
}
