package com.zeroone.star.sccommunity.entity.buildingfee;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 费用详情
 */
@Data
@TableName("pay_fee_attrs")
public class FeeAttr{
    //小区ID", example = "2022090665021542")
    private String communityId;
    //属性Id", example = "112022101416137575")
    private String attrId;
    //费用Id", example = "902022101476217398")
    private String feeId;
    //数据状态，S保存 0在用 1失效", example = "0")
    private String statusCd;
    //班次规格ID", example = "390007")
    private String specCd;
    //值", example = "李四")
    private String value;

    //规格ID名称", example = "业主名称")
    @TableField(exist = false)
    private String specCdName;


}
