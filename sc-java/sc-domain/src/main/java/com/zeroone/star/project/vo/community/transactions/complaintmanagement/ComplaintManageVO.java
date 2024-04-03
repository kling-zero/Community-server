package com.zeroone.star.project.vo.community.transactions.complaintmanagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("投诉单显示对象")
public class ComplaintManageVO {

    @ApiModelProperty(value = "小区id", example = "2022090665021542")
    private String communityId;

    @ApiModelProperty(value = "投诉id", example = "882022101572683486")
    private String complaintId;

    @ApiModelProperty(value = "投诉人", example = "Gerins")
    private String complaintName;

    @ApiModelProperty(value = "投诉内容", example = "Gerins的投诉")
    private String context;

    @ApiModelProperty(value = "处理开始时间", example = "2022-10-15 11:26:06")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "处理人编号", example = "")
    private String currentUserId;

    @ApiModelProperty(value = "处理人", example = "")
    private String currentUserName;

    @ApiModelProperty(value = "处理人电话", example = "")
    private String currentUserTel;

    @ApiModelProperty(value = "楼编号", example = "1")
    private String floorNum;

    @ApiModelProperty(value = "photos", example = "")
    private Object[] photos;

    @ApiModelProperty(value = "房间id", example = "752022100910441032")
    private String roomId;

    @ApiModelProperty(value = "房屋编号", example = "1")
    private String roomNum;

    @ApiModelProperty(value = "投诉人id", example = "302022090667451419")
    private String startUserId;

    @ApiModelProperty(value = "投诉处理状态，见 t_dict表", example = "10002")
    private String state;

    @ApiModelProperty(value = "投诉处理状态", example = "处理完成")
    private String stateName;

    @ApiModelProperty(value = "商户id", example = "102022090662291416")
    private String storeId;

    @ApiModelProperty(value = "投诉人联系方式", example = "18299998767")
    private String tel;

    @ApiModelProperty(value = "投诉类型，见t_dict表", example = "809001")
    private String typeCd;

    @ApiModelProperty(value = "投诉类型名称", example = "投诉")
    private String typeCdName;

    @ApiModelProperty(value = "单元编号", example = "1")
    private String unitNum;


}
