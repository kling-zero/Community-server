package com.zeroone.star.project.vo.community.transactions.buildfee.feedetails;

import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("房间显示对象")
//public class RoomVO extends PageVO  不用继承pageVO吧？
public class RoomVO{
    @ApiModelProperty(value = "户型", example = "20101")
    private String apartment;
    @ApiModelProperty(value = "户型名称", example = "两室一厅")
    private String apartmentName;
    @ApiModelProperty(value = "建筑面积", example = "1.00")
    private String builtUpArea;
    @ApiModelProperty(value = "算费系数", example = "1.00")
    private String feeCoefficient;
    @ApiModelProperty(value = "楼层ID", example = "732022100996851030")
    private String floorId;
    @ApiModelProperty(value = "楼编号", example = "1")
    private String floorNum;
    @ApiModelProperty(value = "身份证号")
    private String idCard;
    @ApiModelProperty(value = "层数", example = "1")
    private String layer;
    @ApiModelProperty(value = "手机号", example = "18985136859")
    private String link;
    @ApiModelProperty(value = "业主ID", example = "772022101005705404")
    private String ownerId;
    @ApiModelProperty(value = "业主名称", example = "张三")
    private String ownerName;
    @ApiModelProperty(value = "备注", example = "无")
    private String remark;
    @ApiModelProperty(value = "房间面积", example = "1.00")
    private String roomArea;
    @ApiModelProperty(value = "房屋Id", example = "752022101002411138")
    private String roomId;
    @ApiModelProperty(value = "编号", example = "1")
    private String roomNum;
    @ApiModelProperty(value = "租金", example = "0.00")
    private String roomRent;
    @ApiModelProperty(value = "房屋类型 110 住宅房屋，119 办公室 120 宿舍", example = "110")
    private String roomSubType;
    @ApiModelProperty(value = "房屋类型名称", example = "住宅房屋")
    private String roomSubTypeName;
    @ApiModelProperty(value = "房间类型", example = "1010301")
    private String roomType;
    @ApiModelProperty(value = "室", example = "2")
    private String section;
    @ApiModelProperty(value = "状态", example = "2001")
    private String state;
    @ApiModelProperty(value = "状态", example = "已入住")
    private String stateName;
    @ApiModelProperty(value = "单元ID", example = "742022100905171031")
    private String unitId;
    @ApiModelProperty(value = "单元号", example = "1")
    private String unitNum;
    @ApiModelProperty(value = "房间详细信息显示对象")
    private List<RoomAttrVO> roomAttr;
}
