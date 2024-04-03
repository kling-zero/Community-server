package com.zeroone.star.reportmanagement.entity;

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
 * @author j4
 * @since 2022-10-23
 */
@Getter
@Setter
@TableName("r_repair_setting")
public class RRepairSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 工单设置ID
     */
    private String settingId;

    /**
     * 业务ID
     */
    private String bId;

    /**
     * 报修类型
     */
    private String repairType;

    /**
     * 报修类型名称
     */
    private String repairTypeName;

    /**
     * 派单方式 t_dict 100 抢单 200 指派 300 轮训
     */
    private String repairWay;

    /**
     * 小区分片ID
     */
    private String communityId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 数据状态
     */
    private String statusCd;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 是否为公共区域
     */
    private String publicArea;

    /**
     * 是否收费 T为是 F为否
     */
    private String payFeeFlag;

    /**
     * 收费范围，如30元至50元
     */
    private String priceScope;

    /**
     * 回访标识 001 都不回访 002 已评价不回访 003 都回访
     */
    private String returnVisitFlag;

    /**
     * 报修设置类型
     */
    private String repairSettingType;


}
