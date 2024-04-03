package com.zeroone.star.project.vo.community.myCommunity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/15
 */
@Data
@ApiModel("我的小区嵌套显示对象")
public class AttrDtosVO {
    @ApiModelProperty(value = "小区地址",example = "天津省天津市河东区演示物业")
    private String communityId;
    @ApiModelProperty(value = "是否以列表形式展开",example = "Y")
    private String listShow;
    @ApiModelProperty(value = "规格ID",example = "9329000004")
    private String specCd;
    @ApiModelProperty(value = "规格名称",example = "社区编码")
    private String specName;
    @ApiModelProperty(value = "数据状态",example = "0")
    private String statusCd;
}
