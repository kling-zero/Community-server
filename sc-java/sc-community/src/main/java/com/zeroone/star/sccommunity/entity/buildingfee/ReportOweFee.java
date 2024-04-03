package com.zeroone.star.sccommunity.entity.buildingfee;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("report_owe_fee")
public class ReportOweFee {
    //当前欠费金额", example = "0.00")
    private String amountOwed;
    //截止时间", example = "2022-10-15 13:23:16")
    private Date deadlineTime;
    //付费对象名称", example = "1栋1单元1室")
    private String payerObjName;
}
