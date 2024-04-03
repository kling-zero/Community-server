package com.zeroone.star.project.vo.community.transactions.repairmanagement;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("报修单显示对象")
public class OwnerRepairManageVO {

    @ApiModelProperty(value = "afterPhotos", example = "")
    private Object[] afterPhotos;

    @ApiModelProperty(value = "预约时间", example = "2022-10-15 17:10:23")
    private LocalDateTime appointmentTime;

    @ApiModelProperty(value = "评价得分", example = "0")
    private Integer appraiseScore;

    @ApiModelProperty(value = "average", example = "0.0")
    private Double average;

    @ApiModelProperty(value = "业务id", example = "-1")
    private String bId;

    @ApiModelProperty(value = "beforePhotos", example = "")
    private Object[] beforePhotos;

    @ApiModelProperty(value = "小区id", example = "2022090665021542")
    private String communityId;

    @ApiModelProperty(value = "报修内容", example = "Gerins马桶维修")
    private String context;

    @ApiModelProperty(value = "上门速度评分", example = "0")
    private Integer doorSpeedScore;

    @ApiModelProperty(value = "page", example = "-1")
    private Integer page;

    @ApiModelProperty(value = "photos", example = "")
    private Object[] photos;

    @ApiModelProperty(value = "records", example = "0")
    private Integer records;

    @ApiModelProperty(value = "报修id", example = "822022101541831670")
    private String repairId;

    @ApiModelProperty(value = "报修人", example = "Gerins")
    private String repairName;

    @ApiModelProperty(value = "报修对象id", example = "752022100910441032")
    private String repairObjId;

    @ApiModelProperty(value = "位置（报修对象名称）", example = "1栋1单元1室")
    private String repairObjName;

    @ApiModelProperty(value = "报修对象类型 001 小区 002 楼栋 003 单元 004 房屋", example = "004")
    private String repairObjType;

    @ApiModelProperty(value = "repairPhotos", example = "")
    private Object[] repairPhotos;

    @ApiModelProperty(value = "报修设置类型", example = "200")
    private String repairSettingType;

    @ApiModelProperty(value = "repairSettingTypeName", example = "维修单")
    private String repairSettingTypeName;

    @ApiModelProperty(value = "报修类型", example = "102022091291911741")
    private String repairType;

    @ApiModelProperty(value = "报修类型名称", example = "马桶维修")
    private String repairTypeName;

    @ApiModelProperty(value = "派单方式 t_dict 100 抢单 200 指派 300 轮训", example = "200")
    private String repairWay;

    @ApiModelProperty(value = "维修员服务评分", example = "0")
    private Integer repairmanServiceScore;

    @ApiModelProperty(value = "returnVisitFlag", example = "003")
    private String returnVisitFlag;

    @ApiModelProperty(value = "row", example = "0")
    private Integer row;

    @ApiModelProperty(value = "报修状态", example = "1000")
    private String state;

    @ApiModelProperty(value = "状态", example = "未派单")
    private String stateName;

    @ApiModelProperty(value = "数据状态", example = "0")
    private String statusCd;

    @ApiModelProperty(value = "联系方式", example = "18299998767")
    private String tel;

    @ApiModelProperty(value = "total", example = "0")
    private Integer total;


}
