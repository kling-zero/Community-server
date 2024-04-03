package com.zeroone.star.management.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 *  业务实体类
 * </p>
 * @author 寒兔丶、jiemo
 * @since 2022-10-18
 */
@Getter
@Setter
@TableName("c_business")
public class CBusiness implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业务Id
     */
    private String bId;

    /**
     * 订单ID
     */
    private String oId;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private String businessTypeCd;

    /**
     * 完成时间
     */
    private LocalDate finishTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 数据状态，详细参考c_status表
     */
    private String statusCd;


}
