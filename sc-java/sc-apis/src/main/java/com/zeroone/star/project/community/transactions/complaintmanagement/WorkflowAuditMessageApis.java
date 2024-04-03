package com.zeroone.star.project.community.transactions.complaintmanagement;

import com.zeroone.star.project.query.community.transactions.complaintmanagement.WorkflowAuditInfoQuery;
import com.zeroone.star.project.query.community.transactions.complaintmanagement.WorkflowImageQuery;
import com.zeroone.star.project.vo.JsonVO;

public interface WorkflowAuditMessageApis {

    /**
     * 展示投诉单详细信息
     * @param workflowAuditInfoQuery 详细信息查询参数
     * @return 查询结果
     */
    JsonVO<String> queryWorkflowAuditInfo(WorkflowAuditInfoQuery workflowAuditInfoQuery);


    /**
     * 展示投诉单信息流程图
     * @param workflowImageQuery 详细信息查询参数
     * @return 查询结果
     */
    JsonVO<String> queryWorkflowImage(WorkflowImageQuery workflowImageQuery);
}
