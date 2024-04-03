package com.zeroone.star.project.vo.community.transactions.buildfee.payfee;

import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
@ApiModel("缴费收据显示对象")
public class FeeReceiptVO extends PageVO {
    @ApiModelProperty(value = "金额", example = "-1.00")
    private String amount;
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "费用项名称", example = "物业缴费测试101")
    private String feeName;
    @ApiModelProperty(value = "费用类型", example = "888800010015")
    private String feeTypeCd;
    @ApiModelProperty(value = "数据状态，S保存 0在用 1失效", example = "0")
    private String statusCd;
    @ApiModelProperty(value = "车牌号", example = "-")
    private String carNum;
    @ApiModelProperty(value = "创建时间", example = "2022-10-16 14:00:16")
    private Date createTime;
    @ApiModelProperty(value = "对象ID", example = "752022100910441032")
    private String objId;
    @ApiModelProperty(value = "对象名称", example = "1-1-1")
    private String objName;
    @ApiModelProperty(value = "对象类型", example = "3333")
    private String objType;
    @ApiModelProperty(value = "支付对象ID", example = "772022101005705404")
    private String payObjId;
    @ApiModelProperty(value = "支付对象名称", example = "he71")
    private String payObjName;
    @ApiModelProperty(value = "收据ID", example = "832022101604427609")
    private String receiptId;
    @ApiModelProperty(value = "房间名称", example = "1-1-1")
    private String roomName;
    @ApiModelProperty(value = "商家名称", example = "演示物业")
    private String storeName;
}
