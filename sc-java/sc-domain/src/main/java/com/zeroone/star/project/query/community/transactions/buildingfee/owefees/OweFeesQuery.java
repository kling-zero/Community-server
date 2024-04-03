package com.zeroone.star.project.query.community.transactions.buildingfee.owefees;

import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("欠费缴费查询对象")
public class OweFeesQuery extends PageVO {
    @NotBlank
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;

    @ApiModelProperty(value = "付款人对象Id", example = "752022101002411137")
    private String payerObjId;

    @ApiModelProperty(value = "付款人对象类型", example = "3333")
    private String payerObjType;
}
