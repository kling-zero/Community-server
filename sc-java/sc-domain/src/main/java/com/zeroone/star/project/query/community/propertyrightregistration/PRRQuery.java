package com.zeroone.star.project.query.community.propertyrightregistration;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("产权登记查询对象")
public class PRRQuery extends PageQuery {
    @ApiModelProperty(value = "楼层id", example = "732022100996851030")
    private String floorId;
    @ApiModelProperty(value = "楼层编号", example = "1")
    private String floorNum;
    @ApiModelProperty(value = "单元id", example = "742022100941011053")
    private String unitId;
    @ApiModelProperty(value = "单元编号", example = "0")
    private String unitNum;
    @ApiModelProperty(value = "房屋id", example = "752022101002411137")
    private String roomId;
    @ApiModelProperty(value = "房屋编号", example = "35679887thgsads")
    private String roomNum;
    @ApiModelProperty(value = "姓名", example = "丽丽了")
    private String name;
    @ApiModelProperty(value = "联系方式", example = "15549065730")
    private String link;
    @ApiModelProperty(value = "地址", example = "Shanghai")
    private String address;
    @ApiModelProperty(value = "身份证", example = "333333333333333333")
    private String idCard;
    @ApiModelProperty(value = "社区id", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "", example = "-1")
    private int page;
    @ApiModelProperty(value = "", example = "0")
    private int row;
    @ApiModelProperty(value = "状态", example = "1")
    private String state;
}
