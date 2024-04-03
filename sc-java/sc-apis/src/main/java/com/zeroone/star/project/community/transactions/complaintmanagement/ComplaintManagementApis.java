package com.zeroone.star.project.community.transactions.complaintmanagement;


import com.zeroone.star.project.dto.community.transactions.complaintmanagement.ComplaintManageDTO;
import com.zeroone.star.project.query.community.transactions.complaintmanagement.ComplaintManageQuery;
import com.zeroone.star.project.query.community.transactions.complaintmanagement.WorkflowAuditInfoQuery;
import com.zeroone.star.project.query.community.transactions.complaintmanagement.WorkflowImageQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.complaintmanagement.ComplaintManageVO;
import io.swagger.annotations.ApiOperation;

/**
 * @Description 投诉单模块接口
 * @Author Gerins
 */
public interface ComplaintManagementApis {

    /**
     * 分页查询报修单信息、工单详情
     * @param condition 查询条件
     * @return 查询结果
     */
    JsonVO<PageVO<ComplaintManageVO>> queryAll(ComplaintManageQuery condition);


    /**
     * 新增一条投诉记录
     * @param complaintManageDTO 投诉信息
     * @return 查询结果
     */
    JsonVO<String> addComplaintStepBinding(ComplaintManageDTO complaintManageDTO);



    JsonVO<String> queryWorkflowAuditInfo(WorkflowAuditInfoQuery workflowAuditInfoQuery);


    JsonVO<String> queryWorkflowImage(WorkflowImageQuery workflowImageQuery);
}
