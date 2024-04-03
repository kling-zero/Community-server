package com.zeroone.star.project.dto.community.transactions.buildingfee;

import com.zeroone.star.project.vo.community.transactions.buildfee.owefees.PayFeesVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("欠费缴费传输数据对象")
public class PayOweFeeDTO {
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "备注", example = "无")
    private String remark;
    @ApiModelProperty(value = "提交缴费数据")
    private List<PayFeesVO> fees;
}
