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
@TableName("r_repair_type_user")
public class RRepairTypeUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 工单设置ID
     */
    private String typeUserId;

    /**
     * 业务ID
     */
    private String bId;

    /**
     * 报修类型
     */
    private String repairType;

    /**
     * 员工ID
     */
    private String staffId;

    /**
     * 员工名称
     */
    private String staffName;

    /**
     * 小区分片ID
     */
    private String communityId;

    /**
     * 状态 9999 在线 8888 离线 t_dict 表
     */
    private String state;

    /**
     * 描述，一般为状态变更描述
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


}
