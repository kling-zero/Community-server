package com.zeroone.star.sccommunity.entity.houseproperty;

import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.OwnerAttrDtos;
import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.Rooms;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/24
 */
@Getter
@Setter
public class AcceptHouseProperty implements Serializable {
    @ApiModelProperty(value = "年龄",example = "12")
    private Integer age;
    @ApiModelProperty(value = "业务ID",example = "202022101058224709")
    private String bId;
    @ApiModelProperty(value = "小区ID", example ="2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "创建时间", example ="2022-10-09 14:39:45")
    private LocalDateTime createTime;
    @ApiModelProperty(value = "身份证号码", example ="1")
    private String idCard;
    @ApiModelProperty(value = "联系人手机号",example = "16602905643")
    private String link;
    @ApiModelProperty(value = "成员ID",example = "102022090662291416")
    private String memberId;
    @ApiModelProperty(value = "小区名称",example = "演示物业（误删）")
    private String name;
    @ApiModelProperty(value = "嵌套对象")
    private List<BuildingOwnerAttr> ownerAttrDtos;
    @ApiModelProperty(value = "业主标识 T是真实业主 F 是虚拟业主",example = "T")
    private String ownerFlag;
    @ApiModelProperty(value = "业主ID",example = "772022101005705404")
    private String ownerId;
    @ApiModelProperty(value = "1001 业主本人 1002 家庭成员",example = "1001")
    private String ownerTypeCd;
    @ApiModelProperty(value = "ownerTypeCd对应的业主类型",example = "业主")
    private String ownerTypeName;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "",example = "")
    private List<Rooms> rooms;
    @ApiModelProperty(value = "性别,0表示男,1表示女",example = "1")
    private String sex;
    @ApiModelProperty(value = "房屋状态",example = "2001,房屋状态，如房屋出售等，请查看state 表")
    private String state;
    @ApiModelProperty(value = "数据状态",example = "0,详细参考c_status表，0, 在用 1失效',")
    private String statusCd;
    @ApiModelProperty(value = "用户ID",example = "302022090667451419")
    private String userId;
    @ApiModelProperty(value = "用户名",example = "wuxw")
    private String userName;
}
