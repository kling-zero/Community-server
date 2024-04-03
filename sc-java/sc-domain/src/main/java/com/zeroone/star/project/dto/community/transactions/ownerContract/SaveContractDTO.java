package com.zeroone.star.project.dto.community.transactions.ownerContract;

import com.zeroone.star.project.vo.community.transactions.ownerContract.ContraTypeVO;
import com.zeroone.star.project.vo.community.transactions.ownerContract.ContractPartyaVO;
import com.zeroone.star.project.vo.community.transactions.ownerContract.RoomVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SaveContractDTO {
    @ApiModelProperty(value = "甲方联系人", example = "张三")
    private String aContacts;
    @ApiModelProperty(value = "甲方联系电话", example = "18888888888")
    private String aLink;
    @ApiModelProperty(value = "合同金额", example = "11111.00")
    private String amount;
    @ApiModelProperty(value = "乙方联系人", example = "lisi")
    private String bContacts;
    @ApiModelProperty(value = "乙方联系电话", example = "16602905643")
    private String bLink;
    @ApiModelProperty(value = "合同编码", example = "1212")
    private String contractCode;
    @ApiModelProperty(value = "合同类型", example = "812022100829630688")
    private String contractType;
    @ApiModelProperty(value = "是否需要审核", example = "是否需要审核，1001 需要审核 2002 不需要审核 3003 需要admin审核  4004 需要 代理商审核")
    private String audit;
    @ApiModelProperty(value = "小区ID", example = "812022100829630688")
    private String communityID;
    @ApiModelProperty(value = "合同名称", example = "测试合同")
    private String contractName;
    @ApiModelProperty(value = "父合同ID", example = "812022100829630688")
    private String contractParentId;
    @ApiModelProperty(value = "甲方合同数组")
    private List<ContractPartyaVO> contractPartyAs;
    @ApiModelProperty(value = "合同类型数组")
    private List<ContraTypeVO> contractTypes;
    @ApiModelProperty(value = "合同类型数组")
    private List<RoomVO> rooms;

}
