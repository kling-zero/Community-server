package com.zeroone.star.project.dto.rolePrivilege.roleCommunity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pzi
 * @create 2022-10-15 23:56
 */
@ApiModel("小区信息数据对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunityDTO {

    @ApiModelProperty(value = "小区id", example = "1", required = true)
    private String communityId;

    @ApiModelProperty(value = "小区名字", example = "测试小区", required = true)
    private String communityName;


}
