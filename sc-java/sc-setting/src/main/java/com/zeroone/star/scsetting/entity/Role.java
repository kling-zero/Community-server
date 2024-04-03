package com.zeroone.star.scsetting.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Role {
    private Integer id;

    private String name;

    private String keyword;

    private String description;

    private Date createTime;

    private Integer store_type_id;
}
