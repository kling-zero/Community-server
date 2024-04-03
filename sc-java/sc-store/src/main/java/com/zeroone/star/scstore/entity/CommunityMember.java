package com.zeroone.star.scstore.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author night
 * @since 2022-10-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("s_community_member")
public class CommunityMember implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "community_member_id", type = IdType.ASSIGN_ID)
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
    private LocalDateTime createTime;

    /**
     * 数据状态
     */
    private String statusCd;

    /**
     * 审核状态
     */
    private String audit_statusCd;

    /**
     * 起租时间
     */
    private LocalDateTime startTime;

    /**
     * 截租时间
     */
    private LocalDateTime endTime;


}
