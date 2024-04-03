package com.zeroone.star.sccommunity.entity.prrmanagement;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("building_room")
public class BuildingRoom {
    @TableField("room_id")
    private String roomId;
    @TableField("unit_id")
    private String unitId;
}
