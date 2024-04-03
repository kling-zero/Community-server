package com.zeroone.star.project.dto.community.transactions.buildingfee;

import com.zeroone.star.project.vo.community.transactions.buildfee.feecombo.FeeComboMemberVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("创建费用套餐传输数据对象")
public class FeeComboDTO {
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "付款对象ID", example = "752022100910441032")
    private String payerObjId;
    @ApiModelProperty(value = "付费对象名称", example = "1栋1单元1室")
    private String payerObjName;
    @ApiModelProperty(value = "付费对象类型，3333房屋，6666车位", example = "3333")
    private String payerObjType;
    @ApiModelProperty(value = "套餐名称", example = "测试费用套餐")
    private String comboName;
    @ApiModelProperty(value = "备注", example = "费用套餐备注")
    private String remark;
    @ApiModelProperty(value = "费用套餐对象显示对象")
    private List<FeeComboMemberVO> feeComboMember;
}
