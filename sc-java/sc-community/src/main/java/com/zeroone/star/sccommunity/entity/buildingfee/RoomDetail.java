package com.zeroone.star.sccommunity.entity.buildingfee;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zeroone.star.project.vo.community.transactions.buildfee.feedetails.RoomAttrVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@TableName("building_room")
public class RoomDetail {
    //户型", example = "10101")
    private String apartment;
    //建筑面积", example = "1.00")
    private String builtUpArea;
    //算费系数", example = "1.00")
    private String feeCoefficient;
    //备注", example = "无")
    private String remark;
    //房屋Id", example = "752022101002411137")
    private String roomId;
    //编号", example = "1")
    private String roomNum;
    //租金", example = "0.00")
    private String roomRent;
    //房间面积", example = "1.00")
    private String roomArea;
    //房屋类型 110 住宅房屋，119 办公室 120 宿舍", example = "110")
    private String roomSubType;
    //室", example = "2")
    private String section;
    //状态", example = "2001")
    private String state;
    //单元ID", example = "742022100905171031")
    private String unitId;
    //层数", example = "1")
    private String layer;
    //房间类型", example = "1010301")
    private String roomType;
    //用户id，用于连表building_owner来查询信息
    private String userId;

    //身份证号")                --> building_owner表
    @TableField(exist = false)
    private String idCard;
    //手机号", example = "18985136859")
    @TableField(exist = false)
    private String link;
    //业主ID", example = "772022101005705404")
    @TableField(exist = false)
    private String ownerId;
    //业主名称", example = "张三")
    @TableField(exist = false, value = "name")
    private String ownerName;

    //单元号", example = "1")          -->building_unit根据unitId查询
    @TableField(exist = false)
    private String unitNum;
    //楼层ID", example = "732022100996851030")
    @TableField(exist = false)
    private String floorId;

    //楼编号", example = "1")           -->building_floor
    @TableField(exist = false)
    private String floorNum;

    //房屋类型名称", example = "住宅房屋")
    @TableField(exist = false)
    private String roomSubTypeName;
    //状态", example = "已入住")
    @TableField(exist = false)
    private String stateName;



    //户型名称", example = "两室一厅")
    @TableField(exist = false)
    private String apartmentName;
    //房间详细信息显示对象")
    @TableField(exist = false)
    private List<RoomAttrVO> roomAttr;
}
