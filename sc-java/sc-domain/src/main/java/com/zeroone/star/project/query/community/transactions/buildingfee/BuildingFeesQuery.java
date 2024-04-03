package com.zeroone.star.project.query.community.transactions.buildingfee;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("房屋费用查询对象")
public class BuildingFeesQuery extends PageQuery {
    @NotBlank
    @ApiModelProperty(value = "小区ID", example = "2022081539020475")
    private String communityId;
    @ApiModelProperty(value = "付款人对象Id", example = "752022082030880010")
    private String payerObjId;
    @ApiModelProperty(value = "付款人对象类型", example = "3333")
    private String payerObjType;
    @ApiModelProperty(value = "费用类型ID", example = "888800010001")
    private String feeTypeCd;
    @ApiModelProperty(value = "收费项目ID", example = "922022082242960041")
    private String configId;
    @ApiModelProperty(value = "状态", example = "2008001")
    private String state;
    @ApiModelProperty(value = "房屋所有者Id")
    private String ownerId;
}
