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
public class MemberFullInfoVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "员工编号id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "员工名称")
    private String name;

    @ApiModelProperty(value = "员工性别")
    private String sex;

    @ApiModelProperty(value = "员工手机号")
    private String tel;

    @ApiModelProperty(value = "员工邮箱")
    private String phoneNum;

    @ApiModelProperty(value = "关联组织")
    private String organization;

    @ApiModelProperty(value = "岗位")
    private String job;

    @ApiModelProperty(value = "关联小区")
    private String area;

    @ApiModelProperty(value = "关联角色")
    private String role;

    //private为关键字 这里应该是避免关键字故意写错
    @ApiModelProperty(value = "员工权限")
    private String privage;


}
