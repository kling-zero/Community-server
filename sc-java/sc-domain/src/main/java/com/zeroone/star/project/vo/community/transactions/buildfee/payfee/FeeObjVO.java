package com.zeroone.star.project.vo.community.transactions.buildfee.payfee;

import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.FeeAttrVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel("订单收费对象显示对象")
public class FeeObjVO extends PageVO {
    @ApiModelProperty(value = "附加费用", example = "800.00")
    private String additionalAmount;
    @ApiModelProperty(value = "金额", example = "-1.00")
    private String amount;
    @ApiModelProperty(value = "业务ID", example = "-1")
    private String bId;
    @ApiModelProperty(value = "批次ID", example = "122022101668807986")
    private String batchId;
    @ApiModelProperty(value = "周期类别，001-每年每月每日，002-每月每日，003-每日", example = "002")
    private String billType;
    @ApiModelProperty(value = "周期名", example = "每月1日")
    private String billTypeName;
    @ApiModelProperty(value = "建筑面积", example = "124.00")
    private String builtUpArea;
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "计算公式 1001 面积*单价+附加费 2002 固定费用", example = "2002")
    private String computingFormula;
    @ApiModelProperty(value = "自定义公式内容", example = ",")
    private String computingFormulaText;
    @ApiModelProperty(value = "费用结束时间", example = "2023-11-01 00")
    private Date configEndTime;
    @ApiModelProperty(value = "费用Id", example = "922022101175295767")
    private String configId;
    @ApiModelProperty(value = "费用开始时间", example = "2022-10-01 00")
    private Date configStartTime;
    @ApiModelProperty(value = "总数", example = "0,")
    private int count;
    @ApiModelProperty(value = "截止时间", example = "2023-04-07 00")
    private Date deadlineTime;
    @ApiModelProperty(value = "结束时间", example = "2022-02-01 00")
    private Date endTime;
    @ApiModelProperty(value = "费用标识 1003006 为周期性费用 2006012 为一次性费用", example = "1003006")
    private String feeFlag;
    @ApiModelProperty(value = "费用项标识", example = "一次性费用")
    private String feeFlagName;
    @ApiModelProperty(value = "费用Id", example = "902022101476217398")
    private String feeId;
    @ApiModelProperty(value = "费用项名称", example = "物业缴费测试101")
    private String feeName;
    @ApiModelProperty(value = "费用单价", example = "800")
    private int feePrice;
    @ApiModelProperty(value = "订单总价格", example = "0")
    private int feeTotalPrice;
    @ApiModelProperty(value = "费用类型", example = "物业费")
    private String feeTypeCdName;
    @ApiModelProperty(value = "开始时间", example = "2022-10-14 00:00:00")
    private Date startTime;
    @ApiModelProperty(value = "每平米收取的单价", example = "0")
    private String squarePrice;
    @ApiModelProperty(value = "状态", example = "收费状态中")
    private String stateName;
    @ApiModelProperty(value = "费用类型", example = "888800010015")
    private String feeTypeCd;
    @ApiModelProperty(value = "收款方ID", example = "1020220906622991416")
    private String incomeObjId;
    @ApiModelProperty(value = "默认费用 只能修改 不能做删除 T 标识是默认 F 不是默认", example = "F")
    private String isDefault;
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
    @ApiModelProperty(value = "实收金额开关", example = "1")
    private String receivedAmountSwitch;
    @ApiModelProperty(value = "状态，1001 待支付 2002 支付完成 3003 支付失败 4004 已退", example = "1001")
    private String state;
    @ApiModelProperty(value = "用户ID", example = "-1")
    private String userId;
    @ApiModelProperty(value = "", example = "1")
    private String val;
    @ApiModelProperty(value = "折扣终止时间", example = "2023-04-07 00")
    private Date maxEndTime;
    @ApiModelProperty(value = "欠费", example = "0")
    private int oweFee;
    @ApiModelProperty(value = "欠费业主", example = "he71")
    private String ownerName;
    @ApiModelProperty(value = "数据状态，S保存 0在用 1失效", example = "0")
    private String statusCd;
    @ApiModelProperty(value = "费用详情显示对象")
    private List<FeeAttrVO> feeAttr;
}
