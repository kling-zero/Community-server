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
 * @author derrick
 * @since 2022-10-23
 */
@Getter
@Setter
@TableName("fee_combo")
public class FeeCombo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 套餐ID
     */
    private String comboId;

    /**
     * 套餐名称
     */
    private String comboName;

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
