package com.zeroone.star.repair.entity.haddone;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 业峰
 * 小区对应的实体类
 */
@Data
@TableName("community_location")
public class Community implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("location_name")
    private String locationName;
}
