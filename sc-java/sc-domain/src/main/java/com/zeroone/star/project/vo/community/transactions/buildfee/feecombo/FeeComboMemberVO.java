package com.zeroone.star.project.vo.community.transactions.buildfee.feecombo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@ApiModel("费用套餐对象显示对象")
public class FeeComboMemberVO {
    @ApiModelProperty(value = "费用项名称", example = "物业缴费测试101")
    private String feeName;
    @ApiModelProperty(value = "费用项标识", example = "一次性费用")
    private String feeFlagName;
    @ApiModelProperty(value = "费用类型", example = "物业费")
    private String feeTypeCdName;
    @ApiModelProperty(value = "结束时间", example = "2022-10-14 00:00:00")
    private String endTime;
    @ApiModelProperty(value = "开始时间", example = "2022-10-14 00:00:00")
    private String startTime;
    @ApiModelProperty(value = "附加费用", example = "200")
    private String additionalAmount;
    @ApiModelProperty(value = "每平米收取的单价", example = "0")
    private String squarePrice;
    @ApiModelProperty(value = "金额", example = "-1.00")
    private String amount;
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "计算公式 1001 面积*单价+附加费 2002 固定费用", example = "5005")
    private String computingFormula;
    @ApiModelProperty(value = "费用ID", example = "922022092269180222")
    private String configId;
    @ApiModelProperty(value = "费用标识 1003006 为周期性费用 2006012 为一次性费用", example = "1003006")
    private String feeFlag;
    @ApiModelProperty(value = "费用类型", example = "888800010015")
    private String feeTypeCd;
    @ApiModelProperty(value = "默认费用 只能修改 不能做删除 T 标识是默认 F 不是默认", example = "F")
    private String isDefault;
    @ApiModelProperty(value = "付费类型", example = "2100")
    private String paymentCd;
    @ApiModelProperty(value = "缴费周期", example = "12")
    private String paymentCycle;
    @ApiModelProperty(value = "周期类别，001-每年每月每日，002-每月每日，003-每日", example = "002")
    private String billType;
    @ApiModelProperty(value = "周期名", example = "每月1日")
    private String billTypeName;
    @ApiModelProperty(value = "自定义公式内容", example = "")
    private String computingFormulaText;
    @ApiModelProperty(value = "成员ID", example = "102022092716612477")
    private String memberId;
    @ApiModelProperty(value = "数据状态，S保存 0在用 1失效", example = "0")
    private String statusCd;


}
