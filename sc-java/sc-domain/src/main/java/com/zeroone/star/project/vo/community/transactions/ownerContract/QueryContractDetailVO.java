package com.zeroone.star.project.vo.community.transactions.ownerContract;

import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QueryContractDetailVO extends PageVO {

    @ApiModelProperty(value = "apartment", example = "20101")
    private String apartment;
    @ApiModelProperty(value = "apartmentName", example = "两室一厅")
    private String apartmentName;
    @ApiModelProperty(value = "builtUpArea", example = "12.00")
    private String builtUpArea;
    @ApiModelProperty(value = "communityId", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "contractId", example = "812022101666663683")
    private String contractId;
    @ApiModelProperty(value = "crId", example = "282022101654483684")
    private String crId;
    @ApiModelProperty(value = "feeCoefficient", example = "1.00")
    private String feeCoefficient;
    @ApiModelProperty(value = "floorArea", example = "111.00")
    private String floorArea;
    @ApiModelProperty(value = "floorId", example = "732022100996851030")
    private String floorId;
    @ApiModelProperty(value = "floorNum", example = "1")
    private String floorNum;
    @ApiModelProperty(value = "layer", example = "2")
    private String layer;
    @ApiModelProperty(value = "records", example = " 0,")
    private int records;
    @ApiModelProperty(value = "remark", example = "")
    private String remark;
    @ApiModelProperty(value = "roomArea", example = "12.00")
    private String roomArea;
    @ApiModelProperty(value = "roomId", example = "752022101421841594")
    private String roomId;
    @ApiModelProperty(value = "roomName", example = "1-1-发生")
    private String roomName;
    @ApiModelProperty(value = "roomNum", example = "发生")
    private String roomNum;
    @ApiModelProperty(value = "roomRent", example = "0.00")
    private String roomRent;
    @ApiModelProperty(value = "roomSubType", example = "110")
    private String roomSubType;
    @ApiModelProperty(value = "roomSubTypeName", example = "住宅")
    private String roomSubTypeName;
    @ApiModelProperty(value = "roomType", example = "1010301")
    private String roomType;
    @ApiModelProperty(value = "section", example = "2")
    private String section;
    @ApiModelProperty(value = "state", example = "2001")
    private String state;
    @ApiModelProperty(value = "stateName", example = "已入住")
    private String stateName;
    @ApiModelProperty(value = "statusCd", example = "0")
    private String statusCd;
    @ApiModelProperty(value = "storeId", example = "102022090662291416")
    private String storeId;

    @ApiModelProperty(value = "unitArea", example = "1.00")
    private String unitArea;
    @ApiModelProperty(value = "unitId", example = "742022100905171031")
    private String unitId;
    @ApiModelProperty(value = "unitNum", example = "1")
    private String unitNum;
    @ApiModelProperty(value = "userId", example = "-1")
    private String userId;

}
