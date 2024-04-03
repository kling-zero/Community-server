package com.zeroone.star.sccommunity.entity.buildingfee;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("business_community")
public class BusinessCommunity {
    private String feePrice;
}
