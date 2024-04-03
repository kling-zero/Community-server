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
 * 费用收入表
 * </p>
 *
 * @author 今日运势大吉
 * @since 2022-10-25
 */
@Getter
@Setter
@TableName("import_fee")
public class ImportFee implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 导入ID
     */
    private String importFeeId;

    /**
     * 费用类型
     */
    private String feeTypeCd;

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
     * 数据状态，详细参考c_status表，S 保存，0, 在用 1失效
     */
    private String statusCd;

    /**
     * 备注
     */
    private String remark;


}
