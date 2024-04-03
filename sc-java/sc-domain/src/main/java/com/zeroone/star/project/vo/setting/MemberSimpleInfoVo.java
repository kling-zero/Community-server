package com.zeroone.star.project.vo.setting;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @BelongsProject: zero-one-smart-community
 * @BelongsPackage: com.zeroone.star.scsetting.entity.vo
 * @Author: sensfloron
 * @CreateTime: 2022-10-14  22:25
 * @Description: TODO 员工详细信息
 * @Version: 1.0
 */
public class MemberSimpleInfoVo implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "员工编号id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "员工名称")
    private String name;

    @ApiModelProperty(value = "员工性别")
    private String sex;

    @ApiModelProperty(value = "员工手机号")
    private String telPhone;

    @ApiModelProperty(value = "员工邮箱")
    private String phoneNum;

    @ApiModelProperty(value = "关联组织")
    private String organization;

    @ApiModelProperty(value = "岗位")
    private String job;

    @ApiModelProperty(value = "员工住址")
    private String address;



}

    // community_id     varchar(30)
    //     b_id             varchar(30)    default '-1'
    //     name             varchar(100)
    //     address          varchar(200)
    //     nearby_landmarks varchar(200)
    //     city_code        varchar(12)
    //     map_x            varchar(20)
    //     map_y            varchar(20)
    //     create_time      timestamp      default CURRENT_TIMESTAMP
    //     status_cd        varchar(2)     default '0'
    //     state            varchar(4)     default '1000'
    //     community_area   decimal(10, 2) default 0.00
    //     tel              varchar(200)
    //     pay_fee_month    bigint         default 12
    //     fee_price        decimal(10, 2) default 0.00

