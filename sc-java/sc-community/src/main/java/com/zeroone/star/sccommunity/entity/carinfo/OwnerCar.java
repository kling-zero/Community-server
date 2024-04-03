package com.zeroone.star.sccommunity.entity.carinfo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("owner_car")
public class OwnerCar implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 汽车ID
     */
    @TableId
    private String carId;

    /**
     * 业主ID
     */
    private String ownerId;

    /**
     * 业务Id
     */
    private String bId;

    /**
     * 车牌号
     */
    private String carNum;

    /**
     * 汽车品牌
     */
    private String carBrand;

    /**
     * 9901 家用小汽车，9902 客车，9903 货车
     */
    private String carType;

    /**
     * 颜色
     */
    private String carColor;

    /**
     * 车位ID
     */
    private String psId;

    /**
     * 用户ID
     */
    private String userId;

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
     * 数据状态，详细参考c_status表，0, 在用 1失效
     */
    private String statusCd;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 起租时间
     */
    private LocalDateTime startTime;

    /**
     * 结租时间
     */
    private LocalDateTime endTime;

    /**
     * 状态，1001 正常状态，2002 车位释放欠费状态  3003 车位释放
     */
    private String state;

    /**
     * 1001 主车辆 1002 成员车辆
     */
    private String carTypeCd;

    /**
     * 成员ID
     */
    private String memberId;

    @TableField(exist = false)
    private String parking;

    @TableField(exist = false)
    private String owner;
}
