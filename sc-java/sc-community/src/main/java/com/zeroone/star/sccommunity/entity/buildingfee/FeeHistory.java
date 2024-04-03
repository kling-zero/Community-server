package com.zeroone.star.sccommunity.entity.buildingfee;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@TableName("`pay_fee_detail`")
public class FeeHistory {
    //应收金额", example = "1000")
    private String receivableAmount;
    //实收金额", example = "30.00")
    private String receivedAmount;
    //结束时间", example = "2022-10-14 00:00:00")
    private Date endTime;
    //开始时间", example = "2022-10-14 00:00:00")
    private Date startTime;
    //创建时间", example = "2022-10-14 00:00:00")
    private Date createTime;
    //状态，1001 待支付 2002 支付完成 3003 支付失败 4004 已退", example = "1001")
    private String state;
    //周期，以月为单位", example = "6")
    private String cycles;
    //缴费ID", example = "9120221024228812301")
    private String detailId;
    //小区ID", example = "2022090665021542")
    private String communityId;
    //费用ID", example = "902022101699947987")
    private String feeId;
    //支付方式", example = "1")
    private String primeRate;
    //备注
    private String remark;


    //费用项名称"物业缴费测试101"
//    @TableField(exist = false)
//    private String feeName;
    //状态"收费状态中"
//    @TableField(exist = false)
//    private String stateName;
}
