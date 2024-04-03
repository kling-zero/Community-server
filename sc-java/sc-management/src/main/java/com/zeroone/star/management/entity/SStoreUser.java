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
 * @author jiemo
 * @since 2022-10-16
 */
@Getter
@Setter
@TableName("s_store_user")
public class SStoreUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 代理商用户ID
     */
    private String storeUserId;

    /**
     * 代理商ID
     */
    private String storeId;

    /**
     * 业务ID
     */
    private String bId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户和代理商关系 详情查看 agent_user_rel表
     */
    private String relCd;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 数据状态，详细参考c_status表，S 保存，0, 在用 1失效
     */
    private String statusCd;


}
