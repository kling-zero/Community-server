package com.zeroone.star.project.vo.community.transactions.ownermember;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
@ApiModel("家庭成员默认首页信息")
public class OwnerMemberVO {
    @ApiModelProperty(value = "ID",example = "772022101005705404")
    private String memberId;
    @ApiModelProperty(value = "成员名字",example = "CESHI")
    private String name;
    @ApiModelProperty(value = "成员性别",example = "女")
    private String sex;
    @ApiModelProperty(value = "成员年龄",example = "30")
    private Integer age;
    @ApiModelProperty(value = "成员类型",example = "房屋租客")
    private String ownerTypeCd;
    @ApiModelProperty(value = "成员身份证",example = "120104199009128921")
    private String idCard;
    @ApiModelProperty(value = "成员联系方式",example = "18144556677")
    private String link;
    @ApiModelProperty(value = "创建员工",example = "18144556677")
    private String bId;
    @ApiModelProperty(value = "备注",example = "这是备注")
    private String remark;
//    @ApiModelProperty(value = "门禁钥匙",example = "门禁钥匙")
//    private String entranceGuardKey;
//    @ApiModelProperty(value = "成员QQ",example = "2814455667")
//    private String memberQQ;
}
