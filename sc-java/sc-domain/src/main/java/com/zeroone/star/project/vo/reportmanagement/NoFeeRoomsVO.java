package com.zeroone.star.project.vo.reportmanagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lht
 * @description
 * @date 2022/10/25
 */
@Data
@ApiModel("未收费房屋显示对象")
public class NoFeeRoomsVO {

    @ApiModelProperty(value="楼编号",example = "D")
    private String floorNum;

    @ApiModelProperty(value="房屋id",example = "752022082030880010")
    private String roomId;

    @ApiModelProperty(value="房屋编号",example = "1001")
    private String roomNum;

    @ApiModelProperty(value="数据状态，0在用 1失效",example = "0")
    private String statusCd;

    @ApiModelProperty(value="单元编号",example = "1")
    private String unitNum;
}
