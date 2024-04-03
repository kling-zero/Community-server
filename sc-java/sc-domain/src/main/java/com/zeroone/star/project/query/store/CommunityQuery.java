package com.zeroone.star.project.query.store;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 商户管理员信息查询的查询条件
 * @Author j3小组-黑夜
 */
@ApiModel("查询隶属小区条件对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommunityQuery extends PageQuery {

    @ApiModelProperty(value = "物业ID", example = "102022081507340423")
    private String communityId;

    @ApiModelProperty(value = "小区名称", example = "测试小区")
    private String name;
}
