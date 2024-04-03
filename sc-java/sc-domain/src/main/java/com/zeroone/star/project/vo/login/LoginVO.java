package com.zeroone.star.project.vo.login;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Description 登录显示数据对象
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@ApiModel("登录显示对象")
@Data
public class LoginVO {
    @ApiModelProperty(value = "用户唯一编号", example = "1")
    private Integer id;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "用户名", example = "admin")
    private String username;

    @ApiModelProperty(value = "是否启用 1 启用 0 禁用 ", example = "1")
    private Byte isEnabled;

    @ApiModelProperty(value = "用户角色列表", example = "['ADMIN','MANAGER']")
    private List<String> roles;

    @ApiModelProperty(value = "email", example = "1145141919@810.com")
    private String email;

    @ApiModelProperty(value = "用户地址", example = "下北泽野兽址")
    private String address;

    @ApiModelProperty(value = "用户地区", example = "下北泽小区")
    private String locationCD;

    @ApiModelProperty(value = "年龄", example = "24")
    private Integer age;

    @ApiModelProperty(value = "性别", example = "1")
    private String sex;

    @ApiModelProperty(value = "电话", example = "1145141919810")
    private String tel;

    @ApiModelProperty(value = "用户级别", example = "24")
    private String levelCd;

    @ApiModelProperty(value = "业务id", example = "114514")
    private String bId;

    @ApiModelProperty(value = "数据状态", example = "1")
    private String statusCd;

    @ApiModelProperty(value = "评分", example = "114514")
    private String score;


}
