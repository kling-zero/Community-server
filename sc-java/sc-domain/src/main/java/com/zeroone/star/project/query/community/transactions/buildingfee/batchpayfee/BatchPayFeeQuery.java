package com.zeroone.star.project.query.community.transactions.buildingfee.batchpayfee;

import com.zeroone.star.project.query.PageQuery;
import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("房屋费用查询对象")
public class BatchPayFeeQuery extends PageVO {
    @NotBlank
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;

    @ApiModelProperty(value = "付款人对象Id", example = "752022101002411137")
    private String payerObjId;

    @ApiModelProperty(value = "付款人对象类型", example = "3333")
    private String payerObjType;

    @ApiModelProperty(value = "状态", example = "2008001")
    private String state;

    @ApiModelProperty(value = "房屋所有者Id", example = "772022101005705404")
    private String ownerId;
}
