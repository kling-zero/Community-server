package com.zeroone.star.project.vo.community.transactions.buildfee;

import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@ApiModel("费用显示对象")
@NoArgsConstructor
@AllArgsConstructor
public class FeesVO {
    @ApiModelProperty(value = "费用类型，物业费，停车费", example = "902022101476217398")
    private String feeId;
    @ApiModelProperty(value = "费用项名称", example = "物业缴费测试101")
    private String feeName;
    @ApiModelProperty(value = "费用项标识", example = "一次性费用")
    private String feeFlagName;
    @ApiModelProperty(value = "费用类型", example = "物业费")
    private String feeTypeCdName;
    @ApiModelProperty(value = "订单总价格", example = "1000")
    private String feeTotalPrice;
    @ApiModelProperty(value = "结束时间", example = "2022-10-14 00:00:00")
    private Date endTime;
    @ApiModelProperty(value = "开始时间", example = "2022-10-14 00:00:00")
    private Date startTime;
    @ApiModelProperty(value = "折扣终止时间", example = "2022-10-14 00:00:00")
    private Date maxEndTime;
    @ApiModelProperty(value = "附加费用", example = "200")
    private BigDecimal additionalAmount;
    @ApiModelProperty(value = "每平米收取的单价", example = "0")
    private BigDecimal squarePrice;
    @ApiModelProperty(value = "状态", example = "收费状态中")
    private String stateName;
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
    @ApiModelProperty(value = "本期度数", example = "0.00")
    private String curDegrees;
    @ApiModelProperty(value = "本期读表时间", example = "2022-10-15 03:00:50")
    private Date curReadingTime;
    @ApiModelProperty(value = "截止时间", example = "2022-10-15 13:23:16")
    private Date deadlineTime;
    @ApiModelProperty(value = "费用标识 1003006 为周期性费用 2006012 为一次性费用", example = "1003006")
    private String feeFlag;
    @ApiModelProperty(value = "费用单价", example = "30.0")
    private String feePrice;
    @ApiModelProperty(value = "费用类型", example = "888800010015")
    private String feeTypeCd;
    @ApiModelProperty(value = "收款方ID", example = "1020220906622991416")
    private String incomeObjId;
    @ApiModelProperty(value = "默认费用 只能修改 不能做删除 T 标识是默认 F 不是默认", example = "F")
    private String isDefault;
    @ApiModelProperty(value = "", example = "0.00")
    private String mwPrice;
    @ApiModelProperty(value = "离线缴费开关", example = "3")
    private String offlinePayFeeSwitch;
    @ApiModelProperty(value = "付款放ID", example = "752022100910441032")
    private String payerObjId;
    @ApiModelProperty(value = "付费对象名称", example = "1栋1单元1室")
    private String payerObjName;
    @ApiModelProperty(value = "付费对象类型，3333房屋，6666车位", example = "3333")
    private String payerObjType;
    @ApiModelProperty(value = "付费类型", example = "2100")
    private String paymentCd;
    @ApiModelProperty(value = "缴费周期", example = "12")
    private String paymentCycle;
    @ApiModelProperty(value = "上期度数", example = "0.00")
    private String preDegrees;
    @ApiModelProperty(value = "上期读表时间", example = "2022-10-15 13:39:49")
    private Date preReadingTime;
    @ApiModelProperty(value = "实收金额开关", example = "1")
    private String receivedAmountSwitch;
    @ApiModelProperty(value = "状态，1001 待支付 2002 支付完成 3003 支付失败 4004 已退", example = "1001")
    private String state;
    @ApiModelProperty(value = "用户ID", example = "-1")
    private String userId;
    @ApiModelProperty(value = "", example = "1")
    private String val;
    @ApiModelProperty(value = "费用详情列表", example = "业主名称：张三")
    private List<FeeAttrVO> feeAttrs;
}
