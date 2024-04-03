package com.zeroone.star.sccommunity.entity.houseproperty;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author suqier
 * @since 2022-10-25
 */
@Getter
@Setter
@TableName("account_bank")
public class AccountBank implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 银行ID
     */
    private String bankId;

    /**
     * 账号
     */
    private String bankCode;

    /**
     * 持卡人
     */
    private String personName;

    /**
     * 手机号
     */
    private String personTel;

    /**
     * 开户行
     */
    private String bankName;

    /**
     * 商铺ID
     */
    private String shopId;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 数据状态，详细参考c_status表，S 保存，0, 在用 1失效
     */
    private String statusCd;


}
