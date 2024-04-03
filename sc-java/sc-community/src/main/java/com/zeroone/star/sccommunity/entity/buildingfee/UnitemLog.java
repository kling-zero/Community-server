package com.zeroone.star.sccommunity.entity.buildingfee;

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
 * @author 今日运势大吉
 * @since 2022-10-25
 */
@Getter
@Setter
@TableName("unitem_log")
public class UnitemLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业务Id
     */
    private String bId;

    /**
     * 订单ID
     */
    private String oId;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 服务名称，事务失败时回滚调用微服务名称
     */
    private String serviceName;

    /**
     * 回滚内容
     */
    private String logText;

    /**
     * 数据状态，详细参考c_status表
     */
    private String statusCd;


}
