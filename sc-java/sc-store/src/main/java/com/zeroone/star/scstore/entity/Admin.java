package com.zeroone.star.scstore.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 商户管理员实体类
 */
@Data
public class Admin extends User{

    private String propertyId;

    private String propertyCompanyName;

    private String status;

    private LocalDateTime createTime;
}
