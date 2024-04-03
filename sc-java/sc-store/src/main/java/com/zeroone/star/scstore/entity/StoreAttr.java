package com.zeroone.star.scstore.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author night
 * @since 2022-10-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("s_store_attr")
public class StoreAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业务ID
     */
    private String bId;

    /**
     * 属性id
     */
    @TableId(value = "attr_id", type = IdType.ASSIGN_ID)
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
    @TableField("VALUE")
    private String VALUE;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 数据状态，详细参考c_status表，S 保存，0, 在用 1失效
     */
    private String statusCd;


}
