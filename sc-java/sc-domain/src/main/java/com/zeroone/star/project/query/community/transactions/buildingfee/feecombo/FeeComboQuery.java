package com.zeroone.star.project.query.community.transactions.buildingfee.feecombo;

import com.zeroone.star.project.query.PageQuery;
import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("费用套餐查询对象")
public class FeeComboQuery extends PageVO {
    @NotBlank
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;

    @ApiModelProperty(value = "套餐名称", example = "优惠套餐A")
    private String comboName;
}
