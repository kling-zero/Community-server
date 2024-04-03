package com.zeroone.star.sccommunity.entity.buildingfee;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 费用收入明细表
 * </p>
 *
 * @author 今日运势大吉
 * @since 2022-10-25
 */
@Getter
@Setter
@TableName("import_fee_detail")
public class ImportFeeDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 导入详情记录
     */
    private String ifdId;

    /**
     * 楼栋编号
     */
    private String floorNum;

    /**
     * 单元编号
     */
    private String unitNum;

    /**
     * 房屋编号
     */
    private String roomNum;

    /**
     * 费用名称
     */
    private String feeName;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 总金额
     */
    private BigDecimal amount;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 房屋ID
     */
    private String roomId;

    /**
     * 费用ID
     */
    private String feeId;

    /**
     * 1000 导入成功 2000 导入失败
     */
    private String state;

    /**
     * 数据状态，详细参考c_status表，S 保存，0, 在用 1失效
     */
    private String statusCd;

    /**
     * 小区ID分片键
     */
    private String communityId;

    /**
     * 导入费用ID
     */
    private String importFeeId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 对象ID
     */
    private String objId;

    /**
     * 对象名称
     */
    private String objName;

    /**
     * 对象类型 3333 房屋 6666 车位
     */
    private String objType;


}
