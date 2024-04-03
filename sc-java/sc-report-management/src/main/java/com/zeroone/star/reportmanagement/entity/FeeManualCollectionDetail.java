package com.zeroone.star.reportmanagement.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author j4
 * @since 2022-10-23
 */
@Getter
@Setter
@TableName("fee_manual_collection_detail")
public class FeeManualCollectionDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 明细ID
     */
    private String detailId;

    /**
     * 托收ID
     */
    private String collectionId;

    /**
     * 费用ID,-1自定义 和费用不关联
     */
    private String feeId;

    /**
     * 费用名称
     */
    private String feeName;

    /**
     * 托收开始时间
     */
    private LocalDateTime startTime;

    /**
     * 托收结束时间
     */
    private LocalDateTime endTime;

    /**
     * 托收金额
     */
    private BigDecimal amount;

    /**
     * 1010 托收中，2020 已缴费 3030 作废
     */
    private String state;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 数据状态
     */
    private String statusCd;


}
