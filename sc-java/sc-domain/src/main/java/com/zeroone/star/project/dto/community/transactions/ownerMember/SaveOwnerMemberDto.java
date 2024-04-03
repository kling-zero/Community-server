package com.zeroone.star.project.dto.community.transactions.ownerMember;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("添加家庭成员传输数据对象")
public class SaveOwnerMemberDto {
    @ApiModelProperty(value = "成员ID",example = "772022081789319011")
    private String memberId;
    @ApiModelProperty(value = "小区ID",example = "222330003")
    private String communityId;
    @ApiModelProperty(value = "业主ID",example = "772022100993004972")
    private String ownerId;
    @ApiModelProperty(value = "名称",example = "擦擦")
    private String name;
    @ApiModelProperty(value = "性别,0表示男,1表示女",example = "1")
    private String sex;
    @ApiModelProperty(value = "年龄",example = "12")
    private String age;
    @ApiModelProperty(value = "1001 业主本人 1002 家庭成员",example = "家庭成员")
    private String ownerTypeCd;
    @ApiModelProperty(value = "身份证号码", example ="322330200202022293")
    private String idCard;
    @ApiModelProperty(value = "联系人手机号",example = "16602905643")
    private String link;
    @ApiModelProperty(value = "备注",example = "这是备注")
    private String remark;
    @ApiModelProperty(value = "",example = "成员")
    private String componentTitle;
    @ApiModelProperty(value = "",example = "null")
    private String mediaStreamTrack;
    @ApiModelProperty(value = "",example = "")
    private String ownerPhoto;
    @ApiModelProperty(value = "",example = "false")
    private String videoPlaying;
}
