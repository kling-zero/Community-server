package com.zeroone.star.project.vo.community.myCommunity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/15
 */
@Data
@ApiModel("我的小区显示对象")
public class MyCommunityVO {
    @ApiModelProperty(value = "小区地址",example = "天津省天津市河东区演示物业")
    private String address;
    @ApiModelProperty(value = "小区名称",example = "河东区")
    private String areaName;
    @ApiModelProperty(value = "审核状态",example = "1100")
    private String auditStatusCd;
    @ApiModelProperty(value = "根据定位获取城市编码",example = "120102")
    private String cityCode;
    @ApiModelProperty(value = "城市名称",example = "天津市")
    private String cityName;
    @ApiModelProperty(value = "小区面积",example = "999991.00")
    private Double communityArea;
    @ApiModelProperty(value = "小区附带信息")
    private List<AttrDtosVO> communityAttrDtos;
    @ApiModelProperty(value = "小区ID",example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "截租时间",example = "2023-09-06 16:59:04")
    private LocalDate endTime;
    @ApiModelProperty(value = "地区 x坐标",example = "101.33")
    private String mapX;
    @ApiModelProperty(value = "地区 y坐标",example = "101.33")
    private String mapY;
    @ApiModelProperty(value = "成员ID",example = "102022090662291416")
    private String memberId;
    @ApiModelProperty(value = "小区名称",example = "演示物业（误删）")
    private String name;
    @ApiModelProperty(value = "地标，如王府井北60米",example = "演示物业")
    private String nearbyLandmarks;
    @ApiModelProperty(value = "父级城市名称",example = "天津省")
    private String provName;
    @ApiModelProperty(value = "截租时间",example = "2022-09-06 16:59:04")
    private LocalDate startTime;
    @ApiModelProperty(value = "数据状态",example = "0")
    private String statusCd;
    @ApiModelProperty(value = "联系方式",example = "15674123189111112")
    private String tel;
}
