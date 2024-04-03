package com.zeroone.star.schp.entity;

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
 * @author 子美
 * @since 2022-10-17
 */
@Getter
@Setter
@TableName("building_owner")
public class BuildingOwner implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业主成员ID
     */
    private String memberId;

    /**
     * 业主ID
     */
    private String ownerId;

    /**
     * 业务ID
     */
    private String bId;

    /**
     * 业主名称
     */
    private String name;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 联系人手机号
     */
    private String link;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 数据状态，详细参考c_status表，0, 在用 1失效
     */
    private String statusCd;

    /**
     * 1001 业主本人 1002 家庭成员
     */
    private String ownerTypeCd;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     * 业主 成员状态 1000 表示待审核，2000 审核完成  3000 拒绝审核 
     */
    private String state;

    /**
     * 业主标识 T是真实业主 F 是虚拟业主
     */
    private String ownerFlag;

    /**
     * 家庭住址
     */
    private String address;


}
