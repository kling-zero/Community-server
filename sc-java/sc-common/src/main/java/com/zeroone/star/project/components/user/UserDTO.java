package com.zeroone.star.project.components.user;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @Description 用户数据
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@Data
@Builder
public class UserDTO {
    /**
     * 用户编号
     */
    private Integer id;

    // 用户ID
    private String userId;

    /**
     * 用户名称
     */
    private String username;

    // Email
    private String email;

    // Address
    private String address;

    // location_cd  用户地区
    private String locationCD;

    private Integer age;

    // sex  0:male   1:female
    private String sex;

    // tellphone 电话
    private String tel;

    // level_cd 用户级别
    private String levelCd;

    // b_id 业务ID
    private String bId;

    // 数据状态
    private String statusCd;

    // 评分
    private String score;

    /**
     * 是否启用
     */
    private Byte isEnabled;
    /**
     * 用户拥有角色列表
     */
    private List<String> roles;
}
