package com.zeroone.star.sccommunity.entity.houseproperty;

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
 * @author suqier
 * @since 2022-10-22
 */
@Getter
@Setter
@TableName("m_menu_user")
public class MMenuUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String muId;

    /**
     * 菜单ID
     */
    private String mId;

    /**
     * 员工ID
     */
    private String staffId;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单组ID
     */
    private String icon;

    /**
     * 打开地址
     */
    private String url;

    /**
     * 列顺序
     */
    private Integer seq;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 数据状态，详细参考c_status表，0在用，1失效
     */
    private String statusCd;


}
