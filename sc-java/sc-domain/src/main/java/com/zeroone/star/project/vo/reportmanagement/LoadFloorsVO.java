package com.zeroone.star.project.vo.reportmanagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: jiemo
 * @date: 2022/10/25 17:19
 * @description: 小区楼房视图对象
 */
@Data
@ApiModel("小区楼房视图对象")
public class LoadFloorsVO {
    @ApiModelProperty(value = "楼栋id", example = "732022083068440102")
    private String floorId;
    @ApiModelProperty(value = "楼栋名称", example = "1号楼")
    private String floorName;
    @ApiModelProperty(value = "楼栋号", example = "1")
    private String roomNum;
    @ApiModelProperty(value = "创建人", example = "wuxw")
    private String userName;
}
