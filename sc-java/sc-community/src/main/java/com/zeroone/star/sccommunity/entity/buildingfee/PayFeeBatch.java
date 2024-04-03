package com.zeroone.star.sccommunity.entity.buildingfee;

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
 * @author 今日运势大吉
 * @since 2022-10-24
 */
@Getter
@Setter
@TableName("pay_fee_batch")
public class PayFeeBatch implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 批次号
     */
    private String batchId;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 创建人
     */
    private String createUserId;

    /**
     * 创建人
     */
    private String createUserName;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 数据状态，详细参考c_status表，S 保存，0, 在用 1失效
     */
    private String statusCd;

    /**
     * 状态 2007001待审核 2008001 审核通过 2009001 审核失败
     */
    private String state;

    /**
     * 审核说明
     */
    private String msg;

    /**
     * 备注
     */
    private String remark;


}
