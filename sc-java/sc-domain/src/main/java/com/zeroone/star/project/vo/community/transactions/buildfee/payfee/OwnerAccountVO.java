package com.zeroone.star.project.vo.community.transactions.buildfee.payfee;

import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("账户信息显示对象")
public class OwnerAccountVO extends PageVO {
    @ApiModelProperty(value ="账户ID", example = "312022101057640102")
    private String acctId;
    @ApiModelProperty(value ="账户名称", example = "he71")
    private String acctName;
    @ApiModelProperty(value ="账户类型，2003 现金账户 2004 积分账户 2005 优惠券账户", example = "2003")
    private String acctType;
    @ApiModelProperty(value ="账户类型名称", example = "现金账户")
    private String acctTypeName;
    @ApiModelProperty(value ="金额", example = "300.00")
    private String amount;
    @ApiModelProperty(value ="创建时间", example = "2022-10-11 00")
    private Date createTime;
    @ApiModelProperty(value ="对象ID", example = "772022101005705404")
    private String objId;
    @ApiModelProperty(value ="对象类型", example = "6006")
    private String objType;
    @ApiModelProperty(value ="局部ID", example = "2022090665021542")
    private String partId;
    @ApiModelProperty(value ="数据状态，S保存 0在用 1失效", example = "0")
    private String statusCd;
}
