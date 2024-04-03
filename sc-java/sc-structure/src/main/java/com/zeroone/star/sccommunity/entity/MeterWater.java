package com.zeroone.star.sccommunity.entity;

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
 * @author 今日运势大吉
 * @since 2022-10-21
 */
@Getter
@Setter
@TableName("meter_water")
public class MeterWater implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String waterId;

    /**
     * 业务ID
     */
    private String bId;

    /**
     * 抄表类型
     */
    private String meterType;

    /**
     * 类型 1001 房屋 2002 车位
     */
    private String objType;

    /**
     * 对象ID，1001 是房屋 2002 是车位
     */
    private String objId;

    /**
     * 上期度数
     */
    private BigDecimal preDegrees;

    /**
     * 本期度数
     */
    private BigDecimal curDegrees;

    /**
     * 上期读表时间
     */
    private LocalDateTime preReadingTime;

    /**
     * 本期读表时间
     */
    private LocalDateTime curReadingTime;

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
     * 数据状态，详细参考c_status表，0, 在用 1失效
     */
    private String statusCd;

    /**
     * 度表署名
     */
    private String remark;

    /**
     * 费用ID
     */
    private String feeId;

    /**
     * 对象名称
     */
    private String objName;

    /**
     * 抄表单价
     */
    private BigDecimal price;


}
