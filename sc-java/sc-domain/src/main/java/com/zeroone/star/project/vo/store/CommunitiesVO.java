package com.zeroone.star.project.vo.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 商户信息查询条件的商户分类对象
 * @Author j3小组-阿V
 */
@ApiModel("隶属小区对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommunitiesVO {

    @ApiModelProperty(value = "小区ID", example = "102022081507340423")
    private String communityId;

    @ApiModelProperty(value = "名称", example = "测试小区")
    private String name;

    @ApiModelProperty(value = "地址", example = "国投广场")
    private String address;

    @ApiModelProperty(value = "状态", example = "审核完成")
    private String state;
}
