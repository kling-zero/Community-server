package com.zeroone.star.sccommunity.entity.buildingfee;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("business_meter_water")
public class BusinessMeterWater {
    private String feeId;
    //上期度数", example = "0.00")
    private String preDegrees;
    //本期度数", example = "0.00")
    private String curDegrees;
    //本期读表时间", example = "2022-10-15 03:00:50")
    private Date curReadingTime;
    //value = "抄表单价", example = "0.00")
    @TableField(value = "price")
    private String mwPrice;
    private Date preReadingTime;
}
