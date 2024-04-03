package com.zeroone.star.project.dto.community.transactions.ownerContract;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RoomAttrDTO {
    @ApiModelProperty(value = "attrId", example = "112022101495641595")
    private String attrId;
    @ApiModelProperty(value = "listShow", example = "Y")
    private String listShow;
    @ApiModelProperty(value = "page", example = " -1,")
    private int page;
    @ApiModelProperty(value = "records", example = " 0,")
    private int records;
    @ApiModelProperty(value = "roomId", example = "752022101421841594")
    private String roomId;
    @ApiModelProperty(value = "row", example = " 0,")
    private int row;
    @ApiModelProperty(value = "specCd", example = "9035007248")
    private String specCd;
    @ApiModelProperty(value = "specName", example = "精装修")
    private String specName;
    @ApiModelProperty(value = "statusCd", example = "0")
    private String statusCd;
    @ApiModelProperty(value = "total", example = " 0,")
    private int total;
    @ApiModelProperty(value = "value", example = "1")
    private String value;
    @ApiModelProperty(value = "valueName", example = "是")
    private String valueName;

}
