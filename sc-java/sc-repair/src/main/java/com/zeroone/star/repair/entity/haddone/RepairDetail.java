package com.zeroone.star.repair.entity.haddone;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 工单的详细数据，用于根据id查询某一id工单的详细信息
 */
@Data
@TableName("r_repair_pool")
public class RepairDetail extends Repair implements Serializable {

    //报修内容
    private String context;
}
