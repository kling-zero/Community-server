package com.zeroone.star.scstore.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2022-10-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("s_store")
public class Store implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商店ID
     */
    @TableId(value = "store_id", type = IdType.ASSIGN_ID)
    private String storeId;

    /**
     * 业务ID
     */
    private String bId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 店铺名称
     */
    private String name;

    /**
     * 店铺地址
     */
    private String address;

    /**
     * 电话
     */
    @TableField("tel")
    private String phone;

    @TableField("store_type_cd")
    private String type;

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
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField(exist = false)
    private LocalDateTime foundationDay;

    @TableField(exist = false)
    private String juridicalPerson;

    /**
     * 数据状态，详细参考c_status表，S 保存，0, 在用 1失效
     */
    private String statusCd;

    /**
     * 48001 商户正常状态 48002 限制商户登录
     */
    private String state;


}
