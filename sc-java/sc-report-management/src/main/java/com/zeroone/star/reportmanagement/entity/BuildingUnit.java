package com.zeroone.star.reportmanagement.entity;

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
 * @author j4
 * @since 2022-10-23
 */
@Getter
@Setter
@TableName("building_unit")
public class BuildingUnit implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 单元ID
     */
    private String unitId;

    /**
     * 业务ID
     */
    private String bId;

    /**
     * 单元编号
     */
    private String unitNum;

    /**
     * 楼ID
     */
    private String floorId;

    /**
     * 总层数
     */
    private Integer layerCount;

    /**
     * 是否有电梯 1010有 2020 无
     */
    private String lift;

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
     * 单元面积
     */
    private BigDecimal unitArea;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 楼层数量
     */
    private String floorNum;

    /**
     * 楼栋加入排序
     */
    private Integer seq;


}
