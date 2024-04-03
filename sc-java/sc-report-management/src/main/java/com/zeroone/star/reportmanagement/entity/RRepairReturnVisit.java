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
@TableName("r_repair_return_visit")
public class RRepairReturnVisit implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 回访ID
     */
    private String visitId;

    /**
     * 报修ID
     */
    private String repairId;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 回访人
     */
    private String visitPersonId;

    /**
     * 回访人
     */
    private String visitPersonName;

    /**
     * 回访类型，1001 满意 2002 不满意
     */
    private String visitType;

    /**
     * 回访内容
     */
    private String context;

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
