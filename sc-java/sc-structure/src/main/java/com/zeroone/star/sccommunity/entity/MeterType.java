package com.zeroone.star.sccommunity.entity;

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
 * @since 2022-10-21
 */
@Getter
@Setter
@TableName("meter_type")
public class MeterType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类型ID
     */
    private String typeId;

    /**
     * 名称
     */
    private String typeName;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 说明
     */
    private String remark;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 数据状态，详细参考c_status表，0, 在用 1失效
     */
    private String statusCd;


}
