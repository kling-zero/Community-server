package com.zeroone.star.project.dto.setting;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("员工数据传输对象")
public class PersonnelDto {

    @ApiModelProperty(value = "id", example = "")
    private Integer id;

    /**
     * 业务Id
     */
    @ApiModelProperty(value = "业务id", example = "1")
    private String bId;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户id", example = "1")
    private String userId;

    /**
     * 名称
     */
    @ApiModelProperty(value = "姓名", example = "张三")
    private String name;

    /**
     * 邮箱地址
     */
    @ApiModelProperty(value = "邮箱地址", example = "xxx@xx.com")
    private String email;

    /**
     * 现居住地址
     */
    @ApiModelProperty(value = "地址", example = "中国")
    private String address;

    /**
     * 用户密码，加密过后
     */
    @ApiModelProperty(value = "密码", example = "1")
    private String password;

    /**
     * 用户地区，编码详见 u_location
     */
    @ApiModelProperty(value = "用户地区", example = "地球")
    private String locationCd;

    /**
     * 用户年龄
     */
    @ApiModelProperty(value = "年龄", example = "18")
    private Integer age;

    /**
     * 性别，0表示男孩 1表示女孩
     */
    @ApiModelProperty(value = "性别", example = "男")
    private String sex;

    @ApiModelProperty(value = "电话", example = "10086")
    private String tel;

    /**
     * 用户级别,关联user_level
     */
    @ApiModelProperty(value = "用户级别", example = "1")
    private String levelCd;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 数据状态，添加ADD，修改MOD 删除DEL
     */
    @ApiModelProperty(value = "数据状态", example = "0")
    private String statusCd;

    /**
     * 评分
     */
    @ApiModelProperty(value = "评分", example = "100")
    private String score;

}
