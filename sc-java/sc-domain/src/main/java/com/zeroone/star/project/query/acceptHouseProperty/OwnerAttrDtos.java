package com.zeroone.star.project.query.acceptHouseProperty;

import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/15
 */
@Data
@ApiModel("受理房产嵌套显示对象OwnerAttrDtos")
public class OwnerAttrDtos extends PageVO {
    @ApiModelProperty(value = "属性Id",example = "112022081728940008")
    private String attrId;
    @ApiModelProperty(value = "小区地址",example = "天津省天津市河东区演示物业")
    private String communityId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间",example = "2022-10-10 01:35:15")
    private LocalDate createTime;
    @ApiModelProperty(value = "是否列表展示",example = "Y")
    private String listShow;
    @ApiModelProperty(value = "业主成员ID",example = "772022101005705404")
    private String memberId;
    @ApiModelProperty(value = "规格名称",example = "社区编码")
    private String specName;
    @ApiModelProperty(value = "规格ID",example = "9329000004")
    private String specCd;
    @ApiModelProperty(value = "数据状态",example = "0")
    private String statusCd;
}
