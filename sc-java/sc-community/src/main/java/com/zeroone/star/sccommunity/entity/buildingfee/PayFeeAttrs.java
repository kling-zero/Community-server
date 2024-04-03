package com.zeroone.star.sccommunity.entity.buildingfee;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 今日运势大吉
 * @since 2022-10-21
 */
@Getter
@Setter
@TableName("pay_fee_attrs")
public class PayFeeAttrs implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 费用ID
     */
    private String feeId;

    /**
     * 业务Id
     */
    private String bId;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 属性id
     */
    private String attrId;

    /**
     * 规格id,参考spec表
     */
    private String specCd;

    /**
     * 属性值
     */
    private String value;

    /**
     * 数据状态，详细参考c_status表，S 保存，0, 在用 1失效
     */
    private String statusCd;


}
