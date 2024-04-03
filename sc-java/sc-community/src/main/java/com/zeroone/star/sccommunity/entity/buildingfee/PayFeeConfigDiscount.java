package com.zeroone.star.sccommunity.entity.buildingfee;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("pay_fee_config_discount")
public class PayFeeConfigDiscount {
    private String configId;

    //折扣终止时间", example = "2022-10-14 00:00:00")
    private Date paymaxEndTime;
}
