package com.zeroone.star.project.dto.community.transactions.ownerContract;

import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("查询业主合同传输对象")
public class OwnerContractByObjDTO extends PageVO {
    @ApiModelProperty(value = "合同模糊名称", example = "xx")
    private String contractNameLike;
    @ApiModelProperty(value = "合同名称", example = "xx")
    private String contractName;
    @ApiModelProperty(value = "合同编码", example = "213")
    private String contractCode;
    @ApiModelProperty(value = "合同类型", example = "812020091861220002")
    private String contractType;
    @ApiModelProperty(value = "合同对象", example = "772022092347301548")
    private String objId;
}
