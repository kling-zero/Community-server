package com.zeroone.star.management.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author jiemo、nmh、qingfeng
 * @since 2022-10-17
 */
@Getter
@Setter
@TableName("m_menu_group_community")
public class MMenuGroupCommunity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "gc_id", type = IdType.AUTO)
    private String gcId;

    /**
     * 菜单组ID
     */
    private String gId;

    /**
     * 菜单组名称
     */
    private String name;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 小区名称
     */
    private String communityName;

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
