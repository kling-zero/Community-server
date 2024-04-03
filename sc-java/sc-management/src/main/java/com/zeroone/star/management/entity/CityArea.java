package com.zeroone.star.management.entity;

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
 * @author kong
 * @since 2022-10-23
 */
@Getter
@Setter
@TableName("city_area")
public class CityArea implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 城市编码
     */
    private String areaCode;

    /**
     * 城市名称
     */
    private String areaName;

    /**
     * 101 省级 202 市州 303 区县
     */
    private String areaLevel;

    /**
     * 父级城市编码
     */
    private String parentAreaCode;

    /**
     * 父级城市名称
     */
    private String parentAreaName;

    /**
     * 经度
     */
    private String lon;

    /**
     * 维度
     */
    private String lat;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 数据状态 0 有效 1失效
     */
    private String statusCd;


}
