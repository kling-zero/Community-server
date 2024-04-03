package com.zeroone.star.repair.entity.haddone;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 业峰
 * @since 2022-10-08
 * 报修状态对应的实体类
 */
@Data
@TableName("t_dict")
public class RepairState {
    @TableField("name")
    private String name;
}
