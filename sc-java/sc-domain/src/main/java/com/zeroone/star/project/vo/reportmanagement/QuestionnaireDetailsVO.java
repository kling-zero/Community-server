package com.zeroone.star.project.vo.reportmanagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author lht
 * @description
 * @date 2022/10/25
 */
@Data
@ApiModel("问卷明细显示对象")
public class QuestionnaireDetailsVO {

    @ApiModelProperty(value="问卷类型",example = "1001")
    private String qaTypeName;

    @ApiModelProperty(value="问卷名称",example = "测试名称")
    private String qaName;

    @ApiModelProperty(value="问卷题目",example = "测试题目")
    private String qaTitle;

    @ApiModelProperty(value="问卷人",example = "李大毛")
    private String userName;

    @ApiModelProperty(value="创建时间",example = "2021-02-05")
    private Date createTime;

    @ApiModelProperty(value="数据状态，0在用 1失效",example = "0")
    private String statusCd;

    @ApiModelProperty(value="问卷答案",example = "测试答案")
    private String qaValue;
}
