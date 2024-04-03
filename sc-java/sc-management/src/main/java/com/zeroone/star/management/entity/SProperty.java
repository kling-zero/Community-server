package com.zeroone.star.management.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;

@Data
public class SProperty {

    private String address;
    private String corporation;
    private Date createTime;
    private String foundingTime;
    private String mapX;
    private String mapY;
    private String name;
    private String state;
    private String statusCd;
    private String storeId;
    private String storeTypeCd;
    private String tel;
    private String password;
    private String userId;
}
