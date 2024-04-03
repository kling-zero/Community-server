package com.zeroone.star.sccommunity.entity.houseproperty;

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
 * @author suqier
 * @since 2022-10-23
 */
@Getter
@Setter
@TableName("building_owner_attr")
public class BuildingOwnerAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    private String bId;

    /**
     * 属性id
     */
    private String attrId;

    /**
     * 业主ID
     */
    private String memberId;

    /**
     * 规格id,参考spec表
     */
    private String specCd;

    /**
     * 属性值
     */
    private String value;

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
     * 小区ID 分片ID
     */
    private String communityId;

    /**
     * 是否展示在list页面 Y 是 N 不是
     */
    private String listShow;


}
