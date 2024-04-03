package com.zeroone.star.project.vo.community.transactions.acceptHouseProperty;

import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/15
 */
@Data
@ApiModel("受理房产嵌套显示对象RoomAttrDtos")
public class RoomAttrDto extends PageVO {
    @ApiModelProperty(value = "属性Id",example = "Y")
    private String attrId;
    @ApiModelProperty(value = "房屋ID",example = "752022100950671054")
    private String roomId;
    @ApiModelProperty(value = "规格编号",example = "9035007248")
    private String specCd;
    @ApiModelProperty(value = "数据状态",example = "0")
    private String statusCd;

}
