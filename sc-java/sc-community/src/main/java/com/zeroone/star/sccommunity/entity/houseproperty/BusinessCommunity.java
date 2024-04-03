package com.zeroone.star.sccommunity.entity.houseproperty;

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
 * @author suqier
 * @since 2022-10-23
 */
@Getter
@Setter
@TableName("business_community")
public class BusinessCommunity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 业务Id
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
     * 根据定位获取城市编码
     */
    private String cityCode;

    /**
     * 地标，如王府井北60米
     */
    private String nearbyLandmarks;

    /**
     * 地区 x坐标
     */
    private String mapX;

    /**
     * 地区 y坐标
     */
    private String mapY;

    /**
     * 月份
     */
    private Integer month;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 数据状态，添加ADD，修改MOD 删除DEL
     */
    private String operate;

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
