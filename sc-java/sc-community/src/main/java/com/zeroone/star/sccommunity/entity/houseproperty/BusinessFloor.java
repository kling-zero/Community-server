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
 * @since 2022-10-22
 */
@Getter
@Setter
@TableName("business_floor")
public class BusinessFloor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 楼ID
     */
    private String floorId;

    /**
     * 业务Id
     */
    private String bId;

    /**
     * 楼编号
     */
    private String floorNum;

    /**
     * 小区楼名称
     */
    private String name;

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
     * 数据状态，添加ADD，修改MOD 删除DEL
     */
    private String operate;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 建筑面积
     */
    private BigDecimal floorArea;

    /**
     * 楼栋加入排序
     */
    private Integer seq;


}
