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
@ApiModel("通过套餐Id查询套餐对象")
public class FeeComboMemberByComboIdQuery extends PageVO {
    @NotBlank
    @ApiModelProperty(value = "套餐ID", example = "102022101228286563")
    private String comboId;
}
