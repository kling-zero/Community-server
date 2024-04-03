package com.zeroone.star.sccommunity.entity.structure;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author：业峰
 * 单元对象，用于根据单元id查询
 */
@Data
@TableName("building_unit")
public class Unit {
    //单元编号
    private String unitNum;
    //用户id
    private String userId;
    //单元面积(类型decimal)
    //private Double unitArea;
    //单元状态
    private String statusCd;
    //楼ID
    private String floorId;
}
