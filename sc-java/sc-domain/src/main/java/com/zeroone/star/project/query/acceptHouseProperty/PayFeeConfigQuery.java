package com.zeroone.star.project.query.acceptHouseProperty;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/16
 */
@Data
@ApiModel("付费查询对象")
public class PayFeeConfigQuery extends PageQuery {
    @NotBlank(message = "费用Id不能为空")
    @ApiModelProperty(value = "费用Id",example = "922022081576780485")
    private String configId;

}
