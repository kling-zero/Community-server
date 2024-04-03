package com.zeroone.star.sccommunity.entity.structure;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 对应t_dict表的数据，用于查询状态码对应的状态信息
 * @业峰
 */
@Data
@TableName("t_dict")
public class TDict {
    //状态码
    private String status_cd;
    //状态名
    private String name;
    //状态描述
    private String description;
    //对应的表名
    private String tableName;
    //对应的表的字段
    private String tableColumns;
}
