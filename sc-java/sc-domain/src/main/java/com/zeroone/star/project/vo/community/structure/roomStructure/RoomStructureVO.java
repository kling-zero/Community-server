package com.zeroone.star.project.vo.community.structure.roomStructure;

import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/14
 */

@Data
@ApiModel("房屋结构显示对象")
public class RoomStructureVO{
    @ApiModelProperty(value = "户型", example ="10101")
    private String apartment;
    @ApiModelProperty(value = "建筑面积", example ="1.00")
    private Double builtUpArea;
    @ApiModelProperty(value = "小区ID", example ="2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "创建时间", example ="2022-10-09 14:39:45")
    private LocalDate createTime;
    @ApiModelProperty(value = "备注",example = "Null")
    private String remark;
    @ApiModelProperty(value = "算费系数", example ="1.00")
    private Double feeCoefficient;
    @ApiModelProperty(value = "楼ID", example ="732022100996851030")
    private String floorId;
    @ApiModelProperty(value = "楼编号", example ="1")
    private String floorNum;
    @ApiModelProperty(value = "身份证号码", example ="1")
    private String idCard;
    @ApiModelProperty(value = "层数",example = "1")
    private String layer;
    @ApiModelProperty(value = "联系人手机号",example = "16602905643")
    private String link;
    @ApiModelProperty(value = "欠费金额",example = "2420.00")
    private Double oweAmount;
    @ApiModelProperty(value = "业主ID",example = "772022100993004972")
    private String ownerId;
    @ApiModelProperty(value = "业主姓名",example = "")
    private String ownerName;
    @ApiModelProperty(value = "室内面积",example = "1.00")
    private Double roomArea;
    @ApiModelProperty(value = "房屋ID",example = "752022100950671054")
    private String roomId;
    @ApiModelProperty(value = "房屋编号",example = "1")
    private String roomNum;
    @ApiModelProperty(value = "租金",example = "1.00")
    private Double roomRent;
    @ApiModelProperty(value = "房屋类型",example = "110 住宅房屋，119 办公室 120 宿舍")
    private String roomSubType;
    @ApiModelProperty(value = "房屋类型",example = "2020602")
    private String roomType;
    @ApiModelProperty(value = "室",example = "1")
    private Integer section;
    @ApiModelProperty(value = "房屋状态",example = "2001,房屋状态，如房屋出售等，请查看state 表")
    private String state;
    @ApiModelProperty(value = "数据状态",example = "0,详细参考c_status表，0, 在用 1失效',")
    private String statusCd;
    @ApiModelProperty(value = "单元ID",example = "742022100941011053")
    private String unitId;
    @ApiModelProperty(value = "单元编号",example = "0")
    private String unitNum;
}
