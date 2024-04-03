package com.zeroone.star.schp.entity;

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
 * @author 子美
 * @since 2022-10-17
 */
@Getter
@Setter
@TableName("building_room")
public class BuildingRoom implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 房屋ID
     */
    private String roomId;

    /**
     * 业务ID
     */
    private String bId;

    /**
     * 房屋编号
     */
    private String roomNum;

    /**
     * 单元ID
     */
    private String unitId;

    /**
     * 层数
     */
    private String layer;

    /**
     * 室
     */
    private Integer section;

    /**
     * 户型
     */
    private String apartment;

    /**
     * 建筑面积
     */
    private BigDecimal builtUpArea;

    /**
     * 算费系数
     */
    private BigDecimal feeCoefficient;

    /**
     * 用户ID
     */
    private String userId;

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
     * 房屋状态，如房屋出售等，请查看state 表
     */
    private String state;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 房屋类型
     */
    private String roomType;

    /**
     * 房屋类型 110 住宅房屋，119 办公室 120 宿舍
     */
    private String roomSubType;

    /**
     * 室内面积
     */
    private BigDecimal roomArea;

    /**
     * 租金
     */
    private BigDecimal roomRent;


}
