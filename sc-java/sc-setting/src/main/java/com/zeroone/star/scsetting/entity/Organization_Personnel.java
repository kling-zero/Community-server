package com.zeroone.star.scsetting.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@TableName("u_org_staff_rel")
public class Organization_Personnel implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "rel_id", type = IdType.AUTO)
    private String relId;
    private String bId;
    private String orgId;
    private String staffId;
    private String relCd;
    private LocalDateTime createTime;
    private String status_cd;
    private String storeId;
}
