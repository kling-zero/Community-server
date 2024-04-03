package com.zeroone.star.project.dto.community.propertyrightregistration;

import com.zeroone.star.project.vo.community.propertyrightregistration.FloorVO;
import com.zeroone.star.project.vo.community.propertyrightregistration.UnitVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.feedetails.RoomVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("修改房屋产权详细信息")
public class UpdatePPRDetailDTO {
    @ApiModelProperty(value = "社区id", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "主键id", example = "102022101540201672")
    private String prrId;
    @ApiModelProperty(value = "主键id", example = "112022092225820132")
    private String prrdId;
    @ApiModelProperty(value = "是否缴费", example = "true")
    private String isTrue;
    @ApiModelProperty(value = "材料类型   001身份证   002购房合同   003维修基金   004契税", example = "001")
    private String securities;
    @ApiModelProperty(value = "契税照片url")
    private String deedTaxUrl;
    @ApiModelProperty(value = "身份证url")
    private String idCardUrl;
    @ApiModelProperty(value = "securitiesName", example = "身份证")
    private String securitiesName;
    @ApiModelProperty(value = "购房合同照片数组")
    private List<String> housePurchasePhotos;
    @ApiModelProperty(value = "购房合同url")
    private String housePurchaseUrl;
    @ApiModelProperty(value = "身份证照片数组")
    private List<String> idCardPhotos;
    @ApiModelProperty(value = "维修基金照片数组")
    private List<String> repairPhotos;
    @ApiModelProperty(value = "维修基金url")
    private String repairUrl;
    @ApiModelProperty(value = "契税照片数组")
    private List<String> deedTaxPhotos;

}
