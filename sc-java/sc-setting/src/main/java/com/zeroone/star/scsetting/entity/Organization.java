package com.zeroone.star.scsetting.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@TableName("u_org")
public class Organization implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "org_Id", type = IdType.AUTO)
    private String orgId;

    private String bId;

    private String storeId;

    private String orgName;

    private String orgLevel;

    private String parentOrgId;

    private String description;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private String statusCd;

    private String belongCommunityId;

    private String allowOperation;
}
