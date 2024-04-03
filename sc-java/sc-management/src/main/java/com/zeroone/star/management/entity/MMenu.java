package com.zeroone.star.management.entity;

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
 * @author Kong
 * @since 2022-10-16
 */
@Getter
@Setter
@TableName("m_menu")
public class MMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    private String mId;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单组ID
     */
    private String gId;

    /**
     * 打开地址
     */
    private String url;

    /**
     * 列顺序
     */
    private Integer seq;

    /**
     * 权限ID
     */
    private String pId;

    /**
     * 菜单描述
     */
    private String description;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 数据状态，详细参考c_status表，0在用，1失效
     */
    private String statusCd;

    /**
     * 菜单页面是否显示 Y显示N不显示
     */
    private String isShow;


}
