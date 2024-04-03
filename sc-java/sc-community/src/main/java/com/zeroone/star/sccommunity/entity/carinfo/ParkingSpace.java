package com.zeroone.star.sccommunity.entity.carinfo;

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
 * @author night
 * @since 2022-10-20
 */
@Getter
@Setter
@TableName("parking_space")
public class ParkingSpace implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 车位ID
     */
    private String psId;

    /**
     * 业务ID
     */
    private String bId;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 车位编号
     */
    private String num;

    /**
     * 停车场ID
     */
    private String paId;

    @TableField(exist = false)
    private String parkingArea;

    /**
     * 车位状态 出售 S，出租 H ，空闲 F
     */
    private String state;

    /**
     * 车位面积
     */
    private BigDecimal area;

    /**
     * 备注
     */
    private String remark;

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
     * 1：普通车位  2：子母车位  3：豪华车位
     */
    private String parkingType;


}
