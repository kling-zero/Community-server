package com.zeroone.star.project.vo.community.transactions.buildfee.feecombo;

import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("费用套餐显示对象")
public class FeeComboVO extends PageVO {
    @ApiModelProperty(value = "套餐ID", example = "102022101228286563")
    private String comboId;
    @ApiModelProperty(value = "套餐名称", example = "优惠套餐A")
    private String comboName;
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "创建时间", example = "2022-10-16 14:00:16")
    private Date createTime;
    @ApiModelProperty(value = "备注", example = "无")
    private String remark;
    @ApiModelProperty(value = "数据状态，S保存 0在用 1失效", example = "0")
    private String statusCd;
}
