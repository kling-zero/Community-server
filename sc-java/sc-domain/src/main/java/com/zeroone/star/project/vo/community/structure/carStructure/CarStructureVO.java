package com.zeroone.star.project.vo.community.structure.carStructure;

import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/14
 */

@Data
@ApiModel("车位结构显示对象")
//为什么要extends PageVO？
public class CarStructureVO{
    @ApiModelProperty(value = "车牌号",example = "5566565")
    private String carNum;
    @ApiModelProperty(value = "楼编号",example = "1")
    private String floorNum;
    @ApiModelProperty(value = "身份证号码",example = "410527200105179866")
    private String idCard;
    @ApiModelProperty(value = "联系人手机号",example = "18985136859")
    private String link;
    @ApiModelProperty(value = "业主成员ID",example = "772022101005705404")
    private String memberId;
    @ApiModelProperty(value = "欠费金额",example = "0.00")
    private Double oweAmount;
    @ApiModelProperty(value = "业主ID",example = "772022101005705404")
    private String ownerId;
    @ApiModelProperty(value = "业主名称",example = "he71")
    private String ownerName;
    @ApiModelProperty(value = "房屋编号",example = "35679887thgsads")
    private String roomNum;
    @ApiModelProperty(value = "车位状态",example = "2001")//这个应该是车位状态
    private String state;
    @ApiModelProperty(value = "数据状态",example = "0")
    private String statusCd;
    @ApiModelProperty(value = "单元ID",example = "742022100941011053")
    private String unitId;
    @ApiModelProperty(value = "单元编号",example = "0")
    private String unitNum;
}
