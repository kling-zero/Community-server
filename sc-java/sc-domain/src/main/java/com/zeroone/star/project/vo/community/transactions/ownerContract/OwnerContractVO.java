package com.zeroone.star.project.vo.community.transactions.ownerContract;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OwnerContractVO {
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
    @ApiModelProperty(value = "合同ID", example = "812022100947920849")
    private String contractId;
    @ApiModelProperty(value = "合同名称", example = "测试合同")
    private String contractName;
    @ApiModelProperty(value = "父合同ID", example = "")
    private String contractParentId;
    @ApiModelProperty(value = "合同类型", example = "812022100829630688")
    private String contractType;
    @ApiModelProperty(value = "创建时间", example = " 2022-10-09 22")
    private LocalDateTime createTime;
    @ApiModelProperty(value = "合同结束时间", example = " 2023-03-16 10")
    private LocalDateTime endTime;
    @ApiModelProperty(value = "合同对象", example = "772022100993004972")
    private String objId;
    @ApiModelProperty(value = "合同对象名称", example = "")
    private String objName;
    @ApiModelProperty(value = "合同对象用户ID", example = "")
    private String objPersonId;
    @ApiModelProperty(value = "合同对象用户名称", example = "")
    private String objPersonName;
    @ApiModelProperty(value = "合同对象类型", example = "合同对象类型：3333 房屋 ，1111 没有合同对象")
    private String objType;
    @ApiModelProperty(value = "经办人", example = "测试")
    private String operator;
    @ApiModelProperty(value = "经办人电话", example = "12345789001")
    private String operatorLink;
    @ApiModelProperty(value = "甲方", example = "李四")
    private String partyA;
    @ApiModelProperty(value = "乙方", example = "lisi")
    private String partyB;

    @ApiModelProperty(value = "签订时间", example = " 2022-10-09 22")
    private LocalDateTime signingTime;
    @ApiModelProperty(value = "合同开始时间", example = " 2022-10-09 05")
    private LocalDateTime startTime;
    @ApiModelProperty(value = "提交用户", example = "302022090667451419")
    private String startUserId;
    @ApiModelProperty(value = "状态", example = "11 待审核 22 审核通过 33 审核失败 44 手工停止")
    private String state;
    @ApiModelProperty(value = "状态名称", example = "待审核")
    private String stateName;
    @ApiModelProperty(value = "数据状态", example = "数据状态，详细参考c_status表，S 保存，0, 在用 1失效")
    private String statusCd;
    @ApiModelProperty(value = "商户ID", example = "102022090662291416")
    private String storeId;

}
