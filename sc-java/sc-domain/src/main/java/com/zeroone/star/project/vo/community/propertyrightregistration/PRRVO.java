package com.zeroone.star.project.vo.community.propertyrightregistration;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("产权登记显示对象")
public class PRRVO {
    @ApiModelProperty(value = "地址", example = "Shanghai")
    private String address;
    @ApiModelProperty(value = "社区id", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "创建者", example = "-1")
    private String createUser;
    @ApiModelProperty(value = "楼层id", example = "732022100996851030")
    private String floorId;
    @ApiModelProperty(value = "楼层编号", example = "1")
    private String floorNum;
    @ApiModelProperty(value = "身份证", example = "333333333333333333")
    private String idCard;
    @ApiModelProperty(value = "联系方式", example = "15549065730")
    private String link;
    @ApiModelProperty(value = "姓名", example = "丽丽了")
    private String name;
    @ApiModelProperty(value = "", example = " -1")
    private int page;
    @ApiModelProperty(value = "主键id", example = "102022101540201672")
    private String prrId;
    @ApiModelProperty(value = "", example = " 0")
    private int records;
    @ApiModelProperty(value = "房屋id", example = "752022101002411137")
    private String roomId;
    @ApiModelProperty(value = "房屋编号", example = "35679887thgsads")
    private String roomNum;
    @ApiModelProperty(value = "", example = "0")
    private int row;
    @ApiModelProperty(value = "审核状态", example = "1")
    private String state;
    @ApiModelProperty(value = "审核信息", example = "审核通过")
    private String stateName;
    @ApiModelProperty(value = "", example = "0")
    private String statusCd;
    @ApiModelProperty(value = "", example = " 0")
    private int total;
    @ApiModelProperty(value = "单元id", example = "742022100941011053")
    private String unitId;
    @ApiModelProperty(value = "单元编号", example = "0")
    private String unitNum;

}
