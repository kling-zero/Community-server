package com.zeroone.star.project.reportmanagement;


import com.zeroone.star.project.query.reportmanagement.QuestionnaireDetailsQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.reportmanagement.QuestionnaireDetailsVO;

public interface ReportQuestionAnswerApi {
    /**
     * 查询问卷明细表 根据条件
     * @param detailsQuery 查询条件
     * @return
     */
    JsonVO<PageVO<QuestionnaireDetailsVO>> queryQuestionnaireDetails(QuestionnaireDetailsQuery detailsQuery);

}
