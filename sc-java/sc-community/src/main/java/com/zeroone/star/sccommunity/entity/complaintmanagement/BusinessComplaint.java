package com.zeroone.star.sccommunity.entity.complaintmanagement;

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
 * @author Gerins
 * @since 2022-10-15
 */
@Getter
@Setter
@TableName("business_complaint")
public class BusinessComplaint implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 投诉ID
     */
    private String complaintId;

    /**
     * 业务Id
     */
    private String bId;

    /**
     * 商户ID
     */
    private String storeId;

    /**
     * 投诉类型，见t_dict表
     */
    private String typeCd;

    /**
     * 房间ID
     */
    private String roomId;

    /**
     * 投诉人
     */
    private String complaintName;

    /**
     * 投诉人联系方式
     */
    private String tel;

    /**
     * 投诉内容
     */
    private String context;

    /**
     * 投诉处理状态，见 t_dict表
     */
    private String state;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 数据状态，添加ADD，修改MOD 删除DEL
     */
    private String operate;

    /**
     * 小区ID，分片键
     */
    private String communityId;

    /**
     * 投诉人ID
     */
    private String startUserId;


}
