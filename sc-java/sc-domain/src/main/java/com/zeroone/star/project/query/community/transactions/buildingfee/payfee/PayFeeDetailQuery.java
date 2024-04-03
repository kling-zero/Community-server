package com.zeroone.star.project.query.community.transactions.buildingfee.payfee;


import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("查询支付服务对象")
public class PayFeeDetailQuery extends PageVO {

    @ApiModelProperty(value = "表名称", example = "pay_fee_detail")
    private String name;

    @ApiModelProperty(value = "类型 prime_rate为表字段说明，指支付方式", example = "prime_rate")
    private String type;
}
