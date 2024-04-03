package com.zeroone.star.sccommunity.entity.complaintmanagement;

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
 * @author Gerins
 * @since 2022-10-16
 */
@Getter
@Setter
@TableName("workflow_audit_message")
public class WorkflowAuditMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 审核ID
     */
    private String auditId;

    /**
     * 业务类型
     */
    private String businessType;

    /**
     * 审核业务key
     */
    private String businessKey;

    /**
     * 审核人ID
     */
    private String auditPersonId;

    /**
     * 审核人
     */
    private String auditPerson;

    /**
     * 审核人电话
     */
    private String auditLink;

    /**
     * 状态 1100 审核通过 1200 审核不通过
     */
    private String state;

    /**
     * 审核内容
     */
    private String message;

    /**
     * 分片ID
     */
    private String shareId;

    /**
     * 分片类型 2020 根据小区分片 3030 根据商户ID
     */
    private String shareType;

    /**
     * 上级审核
     */
    private String preAuditId;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 数据状态，详细参考t_dict表，0, 在用 1失效
     */
    private String statusCd;


}
