package com.zeroone.star.sccommunity.entity.structure;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 根据业主id查询欠费金额
 */
@Data
@TableName("fee_collection_detail")
public class FeeDetail {
    private String ownerId;
    private Double oweAmount;
}
