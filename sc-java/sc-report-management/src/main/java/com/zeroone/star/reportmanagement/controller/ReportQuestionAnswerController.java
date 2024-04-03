package com.zeroone.star.reportmanagement.controller;

import com.zeroone.star.project.query.reportmanagement.QuestionnaireDetailsQuery;
import com.zeroone.star.project.reportmanagement.ReportQuestionAnswerApi;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.reportmanagement.QuestionnaireDetailsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lht
 * @description
 * @date 2022/10/25
 */

@RestController
@RequestMapping("/reportmanagement/reportQuestionAnswer")
@Api(tags = "test")
public class ReportQuestionAnswerController implements ReportQuestionAnswerApi {

    @GetMapping("query-questionnaire-details")
    @ApiOperation(value = "查询问卷明细列表")
    @Override
    public JsonVO<PageVO<QuestionnaireDetailsVO>> queryQuestionnaireDetails(@RequestBody QuestionnaireDetailsQuery detailsQuery) {
        return null;
    }
}
