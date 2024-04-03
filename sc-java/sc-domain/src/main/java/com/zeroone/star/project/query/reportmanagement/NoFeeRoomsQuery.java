package com.zeroone.star.project.query.reportmanagement;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lht
 * @description
 * @date 2022/10/25
 */
@Data
@ApiModel("未收费房屋查询对象")
public class NoFeeRoomsQuery extends PageQuery {

    @ApiModelProperty(value = "小区id", example = "2022090665021542")
    private String communityId;

}
