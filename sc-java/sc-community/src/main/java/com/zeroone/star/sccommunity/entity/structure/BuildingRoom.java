package com.zeroone.star.sccommunity.entity.structure;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 根据用户id查询房屋编号
 */
@Data
@TableName("building_room")
public class BuildingRoom {
    //房屋编号
    private String roomNum;
    //单元id
    private String unitId;
    //租金
    private Double roomRent;
    //用户id
    private String userId;

    //小区id", example = "2022090665021542")
    private String communityId;
    //创建时间", example = " 2022-10-15 21:24:55")
    private Date createTime;
    //备注", example = "")
    private String remark;
    //", example = "0")
    private String statusCd;
}
