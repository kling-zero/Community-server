package com.zeroone.star.sccommunity.entity.structure;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 楼层属性
 */
@Data
@TableName("business_floor")
public class BusinessFloor {
    @TableField("floor_num")
    private String floorNum;
    private String name;
    private Integer seq;
}
