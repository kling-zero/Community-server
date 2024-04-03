package com.zeroone.star.management.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author j4
 * @since 2022-10-16
 */
@Getter
@Setter
@TableName("s_community")
public class SCommunity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 小区ID
     */
    @TableId(value = "community_id", type = IdType.AUTO)
    private String communityId;

    /**
     * 业务ID
     */
    private String bId;

    /**
     * 小区名称
     */
    private String name;

    /**
     * 小区地址
     */
    private String address;

    /**
     * 地标，如王府井北60米
     */
    private String nearbyLandmarks;

    /**
     * 根据定位获取城市编码
     */
    private String cityCode;

    /**
     * 地区 x坐标
     */
    private String mapX;

    /**
     * 地区 y坐标
     */
    private String mapY;

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
     * '业务状态 1000 为待审核 1200审核拒绝'
     */
    private String state;

    /**
     * 小区面积
     */
    private BigDecimal communityArea;

    /**
     * 联系方式
     */
    private String tel;

    /**
     * 缴费周期
     */
    private Long payFeeMonth;

    /**
     * 缴费周期
     */
    private BigDecimal feePrice;


}
