package com.zeroone.star.project.dto.setting;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @BelongsProject: zero-one-smart-community
 * @BelongsPackage: com.zeroone.star.project.dto.setting.dto
 * @Author: sensfloron
 * @CreateTime: 2022-10-17  18:20
 * @Description: 添加员工信息的数据传输对象
 * @Version: 1.0
 */

@Data
public class MemberInfoDto {

    @NotBlank(message = "员工名称不能为空")
    @ApiModelProperty(value = "员工名称（2-10位）")
    private String name;

    @ApiModelProperty(value = "员工岗位")
    private String job;

    @NotBlank(message = "员工手机号不能为空")
    @Pattern(regexp = "^((\\d2,3)|(\\d{3}\\-))?1\\d{1}\\d{9}$", message = "请填写正确的手机号")
    @ApiModelProperty(value = "员工手机号")
    private String tel;


    @ApiModelProperty(value = "员工性别")
    private String sex;

    @Email(message = "邮箱格式有误")
    @ApiModelProperty(value = "员工邮箱")
    private String phoneNum;

    @ApiModelProperty(value = "关联组织")
    private String organization;

    @ApiModelProperty(value = "家庭住址")
    private String address;

    // TODO 上传头像后填充url到表单
    @ApiModelProperty(value = "头像附件文件路径")
    private String imageUrl;
}
