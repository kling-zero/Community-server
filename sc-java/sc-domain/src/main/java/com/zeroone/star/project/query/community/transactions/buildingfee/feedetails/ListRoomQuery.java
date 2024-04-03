package com.zeroone.star.project.query.community.transactions.buildingfee.feedetails;

import com.zeroone.star.project.query.PageQuery;
import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("根据周期查询账户信息查询对象")
public class ListRoomQuery extends PageQuery {
    @NotBlank
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;

    @ApiModelProperty(value = "房间ID", example = "752022082030880010")
    private String roomId;
}
