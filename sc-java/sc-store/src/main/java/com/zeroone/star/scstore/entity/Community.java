package com.zeroone.star.scstore.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author night
 * @since 2022-10-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("s_community")
public class Community implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 小区ID
     */
    @TableId(value = "community_id", type = IdType.ASSIGN_ID)
    private String communityId;

    /**
     * 业务ID
     */
    private String b_id;

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
    private String nearby_landmarks;

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
    private BigDecimal community_area;

    /**
     * 联系方式
     */
    private String tel;

    /**
     * 缴费周期
     */
    private Long pay_fee_month;

    /**
     * 缴费周期
     */
    private BigDecimal fee_price;


}
