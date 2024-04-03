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
 * @author nmh
 * @since 2022-10-17
 */
@Getter
@Setter
@TableName("s_store_attr")
public class SStoreAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业务ID
     */
    private String bId;

    /**
     * 属性id
     */
    private String attrId;

    /**
     * 用户ID
     */
    private String storeId;

    /**
     * 规格id,参考spec表
     */
    private String specCd;

    /**
     * 属性值
     */
    private String value;

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
