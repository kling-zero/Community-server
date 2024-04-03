package com.zeroone.star.project.vo.community.transactions.buildfee.payfee;

import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("缴费显示对象")
public class PayFeeVO extends PageVO {
    @ApiModelProperty(value = "保证金ID", example = "800.00")
    private String detailId;
    @ApiModelProperty(value = "数据状态，S保存 0在用 1失效", example = "0")
    private String statusCd;
}
