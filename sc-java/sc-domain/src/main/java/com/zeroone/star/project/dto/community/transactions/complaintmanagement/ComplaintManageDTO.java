package com.zeroone.star.project.dto.community.transactions.complaintmanagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 新增投诉数据传输对象
 * @Author Gerins
 */
@Data
@ApiModel("电话报修数据传输对象")
public class ComplaintManageDTO {

    @ApiModelProperty(value = "flowComponent", example = "addComplainView")
    private String flowComponent;

    @ApiModelProperty(value = "投诉类型，见t_dict表", example = "809003")
    private String typeCd;

    @ApiModelProperty(value = "投诉人", example = "Gerins")
    private String complaintName;

    @ApiModelProperty(value = "投诉人联系方式", example = "18299998767")
    private String tel;

    @ApiModelProperty(value = "投诉内容", example = "Gerins咨询投诉测试")
    private String context;

    @ApiModelProperty(value = "房间id", example = "752022100910441032")
    private String roomId;

    @ApiModelProperty(value = "小区id", example = "2022090665021542")
    private String communityId;


}
