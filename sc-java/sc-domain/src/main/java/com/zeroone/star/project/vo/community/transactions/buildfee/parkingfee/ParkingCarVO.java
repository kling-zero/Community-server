package com.zeroone.star.project.vo.community.transactions.buildfee.parkingfee;

import com.zeroone.star.project.vo.community.transactions.buildfee.FeeAttrVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel("停车费用显示对象")
public class ParkingCarVO {
    @ApiModelProperty(value = "金额", example = "-1.00")
    private String amount;
    @ApiModelProperty(value = "当前欠费金额", example = "0.00")
    private String amountOwed;
    @ApiModelProperty(value = "批次ID", example = "122022101592257751")
    private String batchId;
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "计算公式 1001 面积*单价+附加费 2002 固定费用", example = "5005")
    private String computingFormula;
    @ApiModelProperty(value = "费用ID", example = "922022092269180222")
    private String configId;
    @ApiModelProperty(value = "结束时间", example = "2022-10-14 00:00:00")
    private Date endTime;
    @ApiModelProperty(value = "截止时间", example = "2022-10-14 00:00:00")
    private Date deadlineTime;
    @ApiModelProperty(value = "费用详情")
    private List<FeeAttrVO> feeAttrVO;

}
