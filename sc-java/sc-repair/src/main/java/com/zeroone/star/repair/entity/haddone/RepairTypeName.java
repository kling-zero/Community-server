package com.zeroone.star.repair.entity.haddone;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 查询对应id的类型名称
 */
@Data
@TableName("r_repair_setting")
public class RepairTypeName {
    @TableField("repair_type_name")
    private String name;
}
