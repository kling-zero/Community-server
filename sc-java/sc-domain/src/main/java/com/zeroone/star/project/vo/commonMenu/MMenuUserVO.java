package com.zeroone.star.project.vo.commonMenu;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel("常用菜单查询显示对象")
public class MMenuUserVO implements Serializable {
    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String muId;


    /**
     * 员工ID
     */
    @ApiModelProperty(value = "员工ID")
    private String staffId;

    /**
     * 菜单名称
     */
    @ApiModelProperty(value = "菜单名称")
    private String name;

    /**
     * 图标
     */
    @ApiModelProperty(value = "图标")
    private String icon;

    /**
     * 打开地址
     */
    @ApiModelProperty(value = "打开地址")
    private String url;

    /**
     * 列顺序
     */
    @ApiModelProperty(value = "列顺序")
    private Integer seq;


    /**
     * 数据状态，详细参考c_status表，0在用，1失效
     */
    @ApiModelProperty(value = "数据状态，详细参考c_status表，0在用，1失效")
    private String statusCd;

}
