package com.zeroone.star.project.dto.community.transactions.buildingfee;

import com.zeroone.star.project.vo.community.transactions.buildfee.FeesVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("批量缴费传输数据对象")
public class BatchPayFeeDTO {
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;

    @ApiModelProperty(value = "费用显示对象")
    private List<FeesVO> fees;
}
