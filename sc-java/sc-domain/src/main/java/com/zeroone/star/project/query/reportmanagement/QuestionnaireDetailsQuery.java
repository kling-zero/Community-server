package com.zeroone.star.project.query.reportmanagement;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lht
 * @description
 * @date 2022/10/25
 */
@Data
@ApiModel("问卷明细查询对象")
public class QuestionnaireDetailsQuery extends PageQuery {

    @ApiModelProperty(value = "小区id", example = "2022090665021542")
    private String communityId;

    @ApiModelProperty(value = "问答类型", example = "1001")
    private String qaType;

    @ApiModelProperty(value = "开始时间", example = "2022-10-06")
    private String startTime;

    @ApiModelProperty(value = "结束时间", example = "2022-10-14")
    private String endTime;
}
