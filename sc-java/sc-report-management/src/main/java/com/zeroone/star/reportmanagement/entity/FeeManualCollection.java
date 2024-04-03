package com.zeroone.star.reportmanagement.entity;

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
 * @author j4
 * @since 2022-10-23
 */
@Getter
@Setter
@TableName("fee_manual_collection")
public class FeeManualCollection implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 托收ID
     */
    private String collectionId;

    /**
     * 房屋ID
     */
    private String roomId;

    /**
     * 房屋名称
     */
    private String roomName;

    /**
     * 业主ID
     */
    private String ownerId;

    /**
     * 业主名称
     */
    private String ownerName;

    /**
     * 业主手机号
     */
    private String link;

    /**
     * 房屋面积
     */
    private String roomArea;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 数据状态
     */
    private String statusCd;

    /**
     * 状态 1010 托收中 2020 托收结束，3030 托收失败
     */
    private String state;

    /**
     * 备注
     */
    private String remark;


}
