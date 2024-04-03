package com.zeroone.star.project.vo.community.transactions.acceptHouseProperty;

import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/15
 */
@Data
@ApiModel("受理房产嵌套显示对象Rooms")
public class Rooms extends PageVO {
    @ApiModelProperty(value = "户型", example ="10101")
    private String apartment;
    @ApiModelProperty(value = "建筑面积", example ="1.00")
    private BigDecimal builtUpArea;
    @ApiModelProperty(value = "小区地址",example = "天津省天津市河东区演示物业")
    private String communityId;
    @ApiModelProperty(value = "算费系数", example ="1.00")
    private BigDecimal feeCoefficient;
    @ApiModelProperty(value = "建筑面积",example = "1.00")
    private BigDecimal floorArea;
    @ApiModelProperty(value = "楼ID", example ="732022100996851030")
    private String floorId;
    @ApiModelProperty(value = "楼编号", example ="1")
    private String floorNum;
    @ApiModelProperty(value = "层数",example = "1")
    private String layer;
    @ApiModelProperty(value = "备注",example = "Null")
    private String remark;
    @ApiModelProperty(value = "室内面积",example = "1.00")
    private BigDecimal roomArea;
    @ApiModelProperty(value = "嵌套对象")
    private List<RoomAttrDto> roomAttrDto;
    @ApiModelProperty(value = "房屋ID",example = "752022100950671054")
    private String roomId;
    @ApiModelProperty(value = "房屋编号",example = "1")
    private String roomNum;
    @ApiModelProperty(value = "租金",example = "1.00")
    private BigDecimal roomRent;
    @ApiModelProperty(value = "房屋类型编号110 住宅房屋，119 办公室 120 宿舍",example = "120")
    private String roomSubType;
    @ApiModelProperty(value = "房屋类型",example = "2020602")
    private String roomType;
    @ApiModelProperty(value = "室",example = "1")
    private Integer section;
    @ApiModelProperty(value = "房屋状态",example = "2001")
    private String state;
    @ApiModelProperty(value = "数据状态",example = "0")
    private String statusCd;
    @ApiModelProperty(value = "单元面积", example ="1.00")
    private BigDecimal unitArea;
    @ApiModelProperty(value = "单元ID",example = "742022100941011053")
    private String unitId;
    @ApiModelProperty(value = "单元编号",example = "0")
    private String unitNum;
    @ApiModelProperty(value = "用户ID",example = "742022100905171031")
    private String userId;

}
