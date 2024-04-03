package com.zeroone.star.management.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author jiemo、nmh
 * @since 2022-10-17
 */
@Getter
@Setter
@TableName("s_community_member")
public class SCommunityMember implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "community_member_id", type = IdType.AUTO)
    private String communityMemberId;

    /**
     * 业务ID
     */
    private String bId;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 成员ID
     */
    private String memberId;

    /**
     * 成员类型见 community_member_type表
     */
    private String memberTypeCd;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 数据状态
     */
    private String statusCd;

    /**
     * 审核状态
     */
    private String auditStatusCd;

    /**
     * 起租时间
     */
    private LocalDateTime startTime;

    /**
     * 截租时间
     */
    private LocalDateTime endTime;


}
