package com.zeroone.star.sccommunity.entity.carinfo;

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
 * @author night
 * @since 2022-10-20
 */
@Getter
@Setter
@TableName("parking_area")
public class ParkingArea implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 停车场ID
     */
    private String paId;

    /**
     * 业务ID
     */
    private String bId;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 停车场编号
     */
    private String num;

    /**
     * 停车场类型，1001 地上停车场 2001 地下停车场
     */
    private String typeCd;

    /**
     * 备注
     */
    private String remark;

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
