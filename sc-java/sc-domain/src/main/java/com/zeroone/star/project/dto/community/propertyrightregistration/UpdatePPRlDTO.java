package com.zeroone.star.project.dto.community.propertyrightregistration;

import com.zeroone.star.project.vo.community.propertyrightregistration.FloorVO;
import com.zeroone.star.project.vo.community.propertyrightregistration.UnitVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.feedetails.RoomVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
@Data
@ApiModel("修改房屋产权信息")
public class UpdatePPRlDTO {
    @ApiModelProperty(value = "地址", example = "Shanghai")
    private String address;
    @ApiModelProperty(value = "社区id", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "楼层id", example = "732022100996851030")
    private String floorId;
    @ApiModelProperty(value = "身份证", example = "333333333333333333")
    private String idCard;
    @ApiModelProperty(value = "联系方式", example = "15549065730")
    private String link;
    @ApiModelProperty(value = "姓名", example = "丽丽了")
    private String name;
    @ApiModelProperty(value = "主键id", example = "102022101540201672")
    private String prrId;
    @ApiModelProperty(value = "房屋id", example = "752022101002411137")
    private String roomId;
    @ApiModelProperty(value = "单元id", example = "742022100941011053")
    private String unitId;
    @ApiModelProperty(value = "状态", example = "1")
    private String state;
    @ApiModelProperty(value = "备注",example = "null")
    private String remark;
    @ApiModelProperty(value = "楼层数组")
    private List<List<FloorVO>> floors ;
    @ApiModelProperty(value = "房屋数组")
    private List<RoomVO> rooms;
    @ApiModelProperty(value = "单元数组")
    private List<List<UnitVO>> units;

}
