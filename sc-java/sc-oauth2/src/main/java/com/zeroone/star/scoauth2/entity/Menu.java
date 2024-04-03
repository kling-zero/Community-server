package com.zeroone.star.scoauth2.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 菜单
 * </p>
 *
 * @author 阿伟
 */
@Getter
@Setter
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 菜单名
     */
    private String name;

    /**
     * 链接地址
     */
    private String linkUrl;

    /**
     * 路由地址
     */
    private String path;

    /**
     * 显示优先级别
     */
    private Integer priority;

    /**
     * 图标
     */
    private String icon;

    /**
     * 描述
     */
    private String description;

    /**
     * 父级菜单编号
     */
    private Integer parentMenuId;

    /**
     * 层次级别
     */
    private Integer level;

    /**
     * 是否启用 0 禁用 1 启用
     */
    private Integer isEnable;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;



}
