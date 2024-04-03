package com.zeroone.star.schp.entity;

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
 * @author 子美
 * @since 2022-10-17
 */
@Getter
@Setter
@TableName("s_store")
public class SStore implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商店ID
     */
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
    private String tel;

    private String storeTypeCd;

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
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 数据状态，详细参考c_status表，S 保存，0, 在用 1失效
     */
    private String statusCd;

    /**
     * 48001 商户正常状态 48002 限制商户登录
     */
    private String state;


}
