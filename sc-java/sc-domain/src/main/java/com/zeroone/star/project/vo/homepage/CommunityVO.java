package com.zeroone.star.project.vo.homepage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 首页-小区信息对象
 * @Author j3小组-子美
 */
@ApiModel("主页小区信息对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunityVO {
    @ApiModelProperty(value = "楼宇数量",example = "1")
    private Integer buildingsNumber;
    @ApiModelProperty(value = "房屋数量",example = "2")
    private Integer housesNumber;
    @ApiModelProperty(value = "商铺数量",example = "3")
    private Integer shopsNumber;
    @ApiModelProperty(value = "车位数量",example = "4")
    private Integer parkingSpacesNumber;
    @ApiModelProperty(value = "住户数量",example = "5")
    private Integer householdsNumber;
    @ApiModelProperty(value = "车辆数量",example = "6")
    private Integer vehiclesNumber;
}
