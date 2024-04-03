package com.zeroone.star.project.dto.community.transactions.buildingfee;

import com.zeroone.star.project.vo.community.transactions.buildfee.FeeTypeCdsVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.payfee.OwnerAccountVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
@ApiModel("缴费传输数据对象")
public class PayFeeDTO {
    @ApiModelProperty(value = "附加费用", example = "800.00")
    private String additionalAmount;
    @ApiModelProperty(value = "建筑面积", example = "124.00")
    private String builtUpArea;
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "费用Id", example = "922022101175295767")
    private String configId;
    @ApiModelProperty(value = "结束时间", example = "2022-02-01 00")
    private Date endTime;
    @ApiModelProperty(value = "费用标识 1003006 为周期性费用 2006012 为一次性费用", example = "1003006")
    private String feeFlag;
    @ApiModelProperty(value = "费用Id", example = "902022101476217398")
    private String feeId;
    @ApiModelProperty(value = "费用项名称", example = "物业缴费测试101")
    private String feeName;
    @ApiModelProperty(value = "费用单价", example = "800")
    private int feePrice;
    @ApiModelProperty(value = "费用类型", example = "物业费")
    private String feeTypeCdName;
    @ApiModelProperty(value = "每平米收取的单价", example = "0")
    private String squarePrice;
    @ApiModelProperty(value = "费用类型", example = "888800010015")
    private String feeTypeCd;
    @ApiModelProperty(value = "离线缴费开关", example = "3")
    private String offlinePayFeeSwitch;
    @ApiModelProperty(value = "付款放ID", example = "752022100910441032")
    private String payerObjId;
    @ApiModelProperty(value = "付费对象名称", example = "1栋1单元1室")
    private String payerObjName;
    @ApiModelProperty(value = "付费对象类型，3333房屋，6666车位", example = "3333")
    private String payerObjType;
    @ApiModelProperty(value = "实收金额开关", example = "1")
    private String receivedAmountSwitch;
    @ApiModelProperty(value = "周期，以月为单位", example = "6")
    private String cycles;
    @ApiModelProperty(value = "打折率", example = "1")
    private String primeRate;
    @ApiModelProperty(value = "实收金额", example = "1000")
    private String receivedAmount;
    @ApiModelProperty(value = "临时周期", example = "12")
    private int tempCycles;
    @ApiModelProperty(value = "总缴费金额", example = "360.00")
    private String totalFeePrice;
    @ApiModelProperty(value = "实收金额", example = "360.00")
    private String receivedAmountNumber;
    @ApiModelProperty(value = "备注", example = "无")
    private String remark;
    @ApiModelProperty(value = "收据ID")
    private String receiptId;
    @ApiModelProperty(value = "展示结束时间")
    private String showEndTime;
    @ApiModelProperty(value = "必须金额")
    private String integralAmount;
    @ApiModelProperty(value = "现金金额")
    private String cashAmount;
    @ApiModelProperty(value = "优惠金额")
    private String couponAmount;
    @ApiModelProperty(value = "总折扣金额", example = "0")
    private int totalDiscountMoney;
    @ApiModelProperty(value = "固定签名", example = "1")
    private String toFixedSign;
    @ApiModelProperty(value = "创建时间", example = "2022-10-16 13")
    private Date createTime;
    @ApiModelProperty(value = "账户金额", example = "0")
    private int accountAmount;
    @ApiModelProperty(value = "视图账户金额", example = "0")
    private int viewAccountAmount;
    @ApiModelProperty(value = "扣除金额", example = "0")
    private int deductionAmount;
    @ApiModelProperty(value = "存款金额", example = "0")
    private int redepositAmount;
    @ApiModelProperty(value = "打印路径", example = "/print.html#/pages/property/printPayFeeXiangyun")
    private String printUrl;
    @ApiModelProperty(value = "支付类别", example = "common")
    private String payType;
    @ApiModelProperty(value = "授权码")
    private String authCode;
    @ApiModelProperty(value = "订单ID")
    private String orderId;
    @ApiModelProperty(value = "标记")
    private String flag;
    @ApiModelProperty(value = "服务结束时间")
    private String custEndTime;
    @ApiModelProperty(value = "账户信息显示对象")
    private List<OwnerAccountVO> accountList;
    @ApiModelProperty(value = "缴费周期显示对象")
    private List<Integer> paymentCycles;
    @ApiModelProperty(value = "支付类别展示对象")
    private List<FeeTypeCdsVO> primeRates;
}
