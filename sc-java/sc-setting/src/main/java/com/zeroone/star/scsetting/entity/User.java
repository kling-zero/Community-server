package com.zeroone.star.scsetting.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;

/**
 * @Auther: MFM
 */

@Data
@TableName("u_user")
public class User {
    private static final long serialVersionUID = 1L;

    private String userId;

    private String name;

    private String email;

    private String address;

    private String password;

    private String locationCd;

    private int age;

    private String sex;

    private String tel;

    private String levelCd;

    private String bId;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    private String statusCd;

}

/**
 * -- auto-generated definition
 * create table u_user
 * (
 * id          int auto_increment comment 'id'
 * primary key,
 * user_id     varchar(30)                          not null comment '用户ID',
 * name        varchar(50)                          not null comment '名称',
 * email       varchar(30)                          null comment '邮箱地址',
 * address     varchar(200)                         null comment '现居住地址',
 * password    varchar(128)                         null comment '用户密码，加密过后',
 * location_cd varchar(8)                           null comment '用户地区，编码详见 u_location',
 * age         int                                  null comment '用户年龄',
 * sex         varchar(1)                           null comment '性别，0表示男孩 1表示女孩',
 * tel         varchar(11)                          not null,
 * level_cd    varchar(2) default '0'               not null comment '用户级别,关联user_level',
 * b_id        varchar(30)                          null comment '业务ID',
 * create_time timestamp  default CURRENT_TIMESTAMP not null comment '创建时间',
 * status_cd   varchar(2) default '0'               not null comment '数据状态，详细参考c_status表，S 保存，0, 在用 1失效',
 * score       varchar(200)                         null comment '评分',
 * constraint user_id
 * unique (user_id)
 * )
 */