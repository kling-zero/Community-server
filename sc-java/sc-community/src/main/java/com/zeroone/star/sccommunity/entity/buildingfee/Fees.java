package com.zeroone.star.sccommunity.entity.buildingfee;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.FeeAttrVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@TableName("pay_fee")
public class Fees{
    //费用Id", example = "902022101476217398")
    private String feeId;
    //费用标识 1003006 为周期性费用 2006012 为一次性费用", example = "1003006")
    private String feeFlag;
    //费用类型", example = "888800010015")
    private String feeTypeCd;
    //费用类型", example = "物业费")
    @TableField(exist = false)
    private String feeTypeCdName;
    //付款方ID", example = "888800010001")
    private String payerObjId;
    //收款方ID", example = "752022082030880010")
    private String incomeObjId;
    //结束时间", example = "2022-10-14 00:00:00")
    private Date endTime;
    //开始时间", example = "2022-10-14 00:00:00")
    private Date startTime;
    //总金额", example = "-1.00")
    private String amount;
    //用户ID", example = "-1")
    private String userId;
    //小区ID", example = "2022090665021542")
    private String communityId;
    //费用项ID", example = "922022092269180222")
    private String configId;
    //批次ID", example = "122022101592257751")
    private String batchId;
    //状态，1001 待支付 2002 支付完成 3003 支付失败 4004 已退", example = "1001")
    private String state;
    //付费对象类型，3333房屋，6666车位", example = "3333")
    private String payerObjType;
//table--->pay_fee_config
    //费用项名称", example = "物业缴费测试101")
    @TableField(exist = false)
    private String feeName;
    //每平米收取的单价", example = "0")
    @TableField(exist = false)
    private String squarePrice;
    //附加费用", example = "200")
    @TableField(exist = false)
    private String additionalAmount;
    //计算公式 1001 面积*单价+附加费 2002 固定费用", example = "5005")
    @TableField(exist = false)
    private String computingFormula;
    //缴费周期", example = "12")
    @TableField(exist = false)
    private String paymentCycle;
    //付费类型", example = "2100")
    @TableField(exist = false)
    private String paymentCd;
    //默认费用 只能修改 不能做删除 T 标识是默认 F 不是默认", example = "F")
    @TableField(exist = false)
    private String isDefault;
 //table ---> pay_fee_config_discount
    //折扣终止时间", example = "2022-10-14 00:00:00")
    @TableField(exist = false)
    private Date maxEndTime;
//table --- > business_meter_water(通过fee_id)
    //上期度数", example = "0.00")
    @TableField(exist = false)
    private String preDegrees;
    //本期度数", example = "0.00")
    @TableField(exist = false)
    private String curDegrees;
    //本期读表时间", example = "2022-10-15 03:00:50")
    @TableField(exist = false)
    private Date curReadingTime;
    //value = "抄表单价", example = "0.00")
    @TableField(exist = false)
    private String mwPrice;
    //上期读表时间", example = "2022-10-15 13:39:49")
    @TableField(exist = false)
    private Date preReadingTime;
 //table--->report_owe_fee
    //当前欠费金额", example = "0.00")
    @TableField(exist = false)
    private String amountOwed;
    //截止时间", example = "2022-10-15 13:23:16")
    @TableField(exist = false)
    private Date deadlineTime;
    //付费对象名称", example = "1栋1单元1室")
    @TableField(exist = false)
    private String payerObjName;
    //费用详情列表", example = "业主名称：张三")
    @TableField(exist = false)
    private List<FeeAttrVO> feeAttrs;
    //费用项标识", example = "一次性费用")
    @TableField(exist = false)
    private String feeFlagName;
    //状态", example = "收费状态中")
    @TableField(exist = false)
    private String stateName;
//费用单价", example = "30.0")--->business_community
    @TableField(exist = false)
    private String feePrice;

//一下数据找不到
    /*
    //订单总价格", example = "1000")
    @TableField(exist = false)
    private String feeTotalPrice;
    //离线缴费开关", example = "3")
    @TableField(exist = false)
    private String offlinePayFeeSwitch;
    //实收金额开关", example = "1")
    @TableField(exist = false)
    private String receivedAmountSwitch;
    //value = "", example = "1")
    @TableField(exist = false)
    private String val;
     */
}
