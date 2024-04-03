package com.zeroone.star.project.dto;

import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.PayFeeConfigVO;
import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.RoomCreateFeeAddVO;
import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.Rooms;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/16
 */

@Data
@ApiModel("交房付费传输数据对象")
public class SavaHandOverDTO {
    @ApiModelProperty(value = "业主名",example = "王大爷")
    private String name;
    @ApiModelProperty(value = "年龄",example = "32")
    private Integer age;
    @ApiModelProperty(value = "小区编号",example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "费用单")
    private List<RoomCreateFeeAddVO> fees;
    @ApiModelProperty(value = "身份证号",example = "410527200105179889")
    private String idCard;
    @ApiModelProperty(value = "联系方式",example = "15923365501")
    private String link;
    @ApiModelProperty(value = "用户类型",example = "1001 业主本人 1002 家庭成员")
    private String ownerTypeCd;
    @ApiModelProperty(value = "备注",example = "空")
    private String remark;
    @ApiModelProperty(value = "房间")
    private List<Rooms> rooms;
    @ApiModelProperty(value = "性别",example = "0表示男孩 1表示女孩")
    private Integer sex;

}
