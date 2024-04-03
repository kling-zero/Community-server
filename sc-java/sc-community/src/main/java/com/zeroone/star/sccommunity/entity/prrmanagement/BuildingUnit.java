package com.zeroone.star.sccommunity.entity.prrmanagement;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;






@Data
@TableName("building_unit")
public class BuildingUnit {
    @TableField("floor_id")
    private String floorId;
    @TableField("unit_id")
    private String unitId;
}
