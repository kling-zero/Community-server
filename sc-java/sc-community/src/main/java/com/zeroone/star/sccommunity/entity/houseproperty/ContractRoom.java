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
 * @since 2022-10-25
 */
@Getter
@Setter
@TableName("contract_room")
public class ContractRoom implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String crId;

    /**
     * 合同ID
     */
    private String contractId;

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
     * 商户ID
     */
    private String storeId;

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
