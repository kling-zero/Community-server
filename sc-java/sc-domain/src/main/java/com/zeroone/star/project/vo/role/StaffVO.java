package com.zeroone.star.project.vo.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel("查询员工显示对象")
@Data
public class StaffVO {

    @ApiModelProperty(value = "地址", example = "xxx地方")
    private String address;

    @ApiModelProperty(value = "年龄", example = "0")
    private Integer age;

    @ApiModelProperty(value = "邮箱", example = "10294561@qq.con")
    private String email;

    @ApiModelProperty(value = "levelCd", example = "00")
    private String levelCd;

    @ApiModelProperty(value = "通过手机登录", example = "false")
    private boolean loginByPhone;

    @ApiModelProperty(value = "名字", example = "admin")
    private String name;

    @ApiModelProperty(value = "性别", example = "0")
    private String sex;

    @ApiModelProperty(value = "statusCD", example = "0")
    private String statusCd;

    @ApiModelProperty(value = "电话", example = "18686868686")
    private String tel;

    @ApiModelProperty(value = "用户Id", example = "123")
    private String userId;
}
