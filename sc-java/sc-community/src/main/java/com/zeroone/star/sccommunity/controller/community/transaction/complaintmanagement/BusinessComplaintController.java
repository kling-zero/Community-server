package com.zeroone.star.sccommunity.controller.community.transaction.complaintmanagement;


import com.zeroone.star.project.community.transactions.complaintmanagement.WorkflowAuditMessageApis;
import com.zeroone.star.project.dto.community.transactions.complaintmanagement.ComplaintManageDTO;
import com.zeroone.star.project.query.community.transactions.complaintmanagement.ComplaintManageQuery;
import com.zeroone.star.project.query.community.transactions.complaintmanagement.WorkflowAuditInfoQuery;
import com.zeroone.star.project.query.community.transactions.complaintmanagement.WorkflowImageQuery;
import com.zeroone.star.project.community.transactions.complaintmanagement.ComplaintManagementApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.complaintmanagement.ComplaintManageVO;
import com.zeroone.star.sccommunity.entity.complaintmanagement.BusinessComplaint;
import com.zeroone.star.sccommunity.service.complaintmanagement.IBusinessComplaintService;
import com.zeroone.star.sccommunity.service.complaintmanagement.IWorkflowAuditMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Gerins
 * @since 2022-10-15
 */
@RestController
@RequestMapping("/sccommunity/business-complaint")
@Api(tags = "投诉单")
@Validated
public class BusinessComplaintController implements ComplaintManagementApis, WorkflowAuditMessageApis {

    @Autowired
    IBusinessComplaintService businessComplaintService;

    @Autowired
    IWorkflowAuditMessageService workflowAuditMessageService;

    @GetMapping("query-all")
    @ApiOperation(value = "查询投诉单信息")
    @Override
    public JsonVO<PageVO<ComplaintManageVO>> queryAll(ComplaintManageQuery condition) {
        PageVO<ComplaintManageVO> complaintManageVOPageVO = businessComplaintService.listByCondition(condition);
        return JsonVO.success(complaintManageVOPageVO);
    }

    @PostMapping("add-complaint-step-binding")
    @ApiOperation(value = "新增一条投诉记录")
    @Override
    public JsonVO<String> addComplaintStepBinding(@RequestBody ComplaintManageDTO complaintManageDTO) {

        BusinessComplaint businessComplaint = new BusinessComplaint();
        BeanUtils.copyProperties(complaintManageDTO, businessComplaint);

        businessComplaint.setBId("-1");
        // storeId没设置
        businessComplaint.setOperate("ADD");
        businessComplaintService.save(businessComplaint);

        return JsonVO.success("成功");
    }


    /*
     * 下面两个接口不知道在干什么
     */

    @GetMapping("query-workflow-audit-info")
    @ApiOperation(value = "查询投诉单详细信息")
    @Override
    public JsonVO<String> queryWorkflowAuditInfo(WorkflowAuditInfoQuery workflowAuditInfoQuery) {
        /*
        communityId: 2022090665021542
        businessKey: 882022102500354317
         */
        return JsonVO.success("成功");
    }

    @GetMapping("query-workflow-image")
    @ApiOperation(value = "查询投诉单流程图")
    @Override
    public JsonVO<String> queryWorkflowImage(WorkflowImageQuery workflowImageQuery) {
        return JsonVO.success("成功");
    }

}

