package com.zeroone.star.project.dto.commonMenu;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel("常用菜单查询传输数据对象")
public class MMenuUserDTO implements Serializable {

    /**
     * 编号
     */
    @ApiModelProperty(value = "常用菜单ID(删除必须加|添加不需加)", example = "102022101516380038")
    private String muId;

    /**
     * 菜单ID
     */
    @ApiModelProperty(value = "菜单ID(添加必须加|删除不需加)", example = "700201904008")
    private String mId;

    /**
     * 员工ID
     */
    @ApiParam(required = true)
    @NotNull(message = "员工ID不能为空")
    @ApiModelProperty(value = "员工ID",example = "302022081574590429")
    private String staffId;

    /**
     * 菜单名称
     */
    @ApiModelProperty(value = "常用菜单名称", example = "我的小区")
    private String name;

    /**
     * 图标
     */
    @ApiModelProperty(value = "图标",example = "fa fa-adjust")
    private String icon;

    /**
     * 打开地址
     */
    @ApiModelProperty(value = "打开地址",example = "/#/pages/property/simplifyAcceptance")
    private String url;

    @ApiModelProperty(value = "列排序",example = "1")
    private int seq;
}

