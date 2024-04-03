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
@TableName("business_repair_user")
public class BusinessRepairUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 报修派单ID
     */
    private String ruId;

    /**
     * 报修ID
     */
    private String repairId;

    /**
     * 业务Id
     */
    private String bId;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 员工处理状态，请查看t_dict 表
     */
    private String state;

    /**
     * 报修内容
     */
    private String context;

    /**
     * 数据状态，添加ADD，修改MOD 删除DEL
     */
    private String operate;

    /**
     * 当前处理员工
     */
    private String staffId;

    /**
     * 当前处理员工名称
     */
    private String staffName;

    /**
     * 上一节点处理员工
     */
    private String preStaffId;

    /**
     * 上一节点处理员工名称
     */
    private String preStaffName;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 事件，startUser 开始用户 auditUser 审核处理员工
     */
    private String repairEvent;

    /**
     * 上一节点处理ID
     */
    private String preRuId;


}
