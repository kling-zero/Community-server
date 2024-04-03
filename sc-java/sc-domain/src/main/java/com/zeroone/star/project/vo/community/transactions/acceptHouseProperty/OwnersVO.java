package com.zeroone.star.project.vo.community.transactions.acceptHouseProperty;

import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/16
 */
@Data
@ApiModel("用户显示对象")
public class OwnersVO extends PageVO {
    @ApiModelProperty(value = "年龄",example = "12")
    private String age;
    @ApiModelProperty(value = "创建时间", example ="2022-10-09 14:39:45")
    private LocalDate createTime;
    @ApiModelProperty(value = "身份证号码", example ="1")
    private String idCard;
    @ApiModelProperty(value = "联系人手机号",example = "16602905643")
    private String link;
    @ApiModelProperty(value = "成员ID",example = "102022090662291416")
    private String memberId;
    @ApiModelProperty(value = "小区名称",example = "演示物业（误删）")
    private String name;
    @ApiModelProperty(value = "嵌套对象")
    private List<OwnerAttrDtos> ownerAttrDtos;
    @ApiModelProperty(value = "业主ID",example = "772022100993004972")
    private String ownerId;
    @ApiModelProperty(value = "1001 业主本人 1002 家庭成员",example = "1001")
    private String ownerTypeCd;
    @ApiModelProperty(value = "ownerTypeCd对应的业主类型",example = "业主")
    private String ownerTypeName;
    @ApiModelProperty(value = "备注",example = "Null")
    private String remark;
    @ApiModelProperty(value = "性别,0表示男,1表示女",example = "1")
    private String sex;
    @ApiModelProperty(value = "用户名",example = "wuxw")
    private String userName;

}
