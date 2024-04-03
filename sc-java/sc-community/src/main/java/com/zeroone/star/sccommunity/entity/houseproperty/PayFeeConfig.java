package com.zeroone.star.sccommunity.entity.houseproperty;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author suqier
 * @since 2022-10-23
 */
@Getter
@Setter
@TableName("pay_fee_config")
public class PayFeeConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 费用ID
     */
    private String configId;

    /**
     * 业务ID
     */
    private String bId;

    /**
     * 小区ID
     */
    private String communityId;

    /**
     * 费用类型，物业费，停车费
     */
    private String feeTypeCd;

    /**
     * 每平米收取的单价
     */
    private BigDecimal squarePrice;

    /**
     * 附加费用
     */
    private BigDecimal additionalAmount;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 数据状态，详细参考c_status表，S 保存，0, 在用 1失效
     */
    private String statusCd;

    /**
     * 默认费用 只能修改 不能做删除 T 标识是默认 F 不是默认
     */
    private String isDefault;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    /**
     * 费用标识 1003006 为周期性费用 2006012 为一次性费用
     */
    private String feeFlag;

    /**
     * 费用项名称
     */
    @TableField("fee_name")
    private String description;

    /**
     * 计算公式 1001 面积*单价+附加费 2002 固定费用
     */
    private String computingFormula;

    /**
     * 出账类型
     */
    private String billType;

    /**
     * 缴费周期
     */
    private String paymentCycle;

    /**
     * 付费类型
     */
    private String paymentCd;

    /**
     * 自定义公式内容
     */
    private String computingFormulaText;

    /**
     * 是否账户抵扣, Y 默认,是 N 否
     */
    private String deductFrom;
    /**
     * 出账类型名
     */
    private String billTypeName;


}
