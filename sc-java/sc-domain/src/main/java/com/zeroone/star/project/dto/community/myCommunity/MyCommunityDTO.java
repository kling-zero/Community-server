package com.zeroone.star.project.dto.community.myCommunity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/15
 */
@Data
@ApiModel("我的小区传输数据对象")
public class MyCommunityDTO {
    @ApiModelProperty(value = "联系方式",example = "15674123189111112")
    private String tel;
    @ApiModelProperty(value = "小区面积",example = "999991.00")
    private Double communityArea;
}
