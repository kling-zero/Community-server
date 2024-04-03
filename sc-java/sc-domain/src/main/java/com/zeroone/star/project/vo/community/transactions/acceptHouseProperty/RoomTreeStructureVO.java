package com.zeroone.star.project.vo.community.transactions.acceptHouseProperty;

import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/16
 */
@Data
@ApiModel("房屋树状结构显示对象")
public class RoomTreeStructureVO extends PageVO {
    @ApiModelProperty(value = "楼ID", example ="732022100996851030")
    private String floorId;
    @ApiModelProperty(value = "楼编号", example ="1")
    private String floorNum;
    @ApiModelProperty(value = "层数",example = "1")
    private Integer layer;
    @ApiModelProperty(value = "联系人手机号",example = "16602905643")
    private String link;
    @ApiModelProperty(value = "业主ID",example = "772022100993004972")
    private String ownerId;
    @ApiModelProperty(value = "业主姓名",example = "")
    private String ownerName;
    @ApiModelProperty(value = "房屋ID",example = "752022100950671054")
    private String roomId;
    @ApiModelProperty(value = "房屋编号",example = "1")
    private String roomNum;
    @ApiModelProperty(value = "单元ID",example = "742022100941011053")
    private String unitId;
    @ApiModelProperty(value = "单元编号",example = "0")
    private String unitNum;
}
