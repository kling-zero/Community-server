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
 * @author jiemo、nmh
 * @since 2022-10-17
 */
@Getter
@Setter
@TableName("m_menu_group")
public class MMenuGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单组ID
     */
    private String gId;

    /**
     * 菜单组名称
     */
    private String name;

    /**
     * 菜单图片
     */
    private String icon;

    /**
     * 菜单标签
     */
    private String label;

    /**
     * 列顺序
     */
    private Integer seq;

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
     *  菜单类型
     */
    private String groupType;

    /**
     * 商户类型
     */
    private String storeType;


}
