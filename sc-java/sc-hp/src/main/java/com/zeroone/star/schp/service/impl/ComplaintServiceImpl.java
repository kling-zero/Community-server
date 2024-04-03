package com.zeroone.star.schp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.homepage.ComplaintCountVO;
import com.zeroone.star.schp.entity.Complaint;
import com.zeroone.star.schp.mapper.ComplaintMapper;
import com.zeroone.star.schp.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ComplaintServiceImpl extends ServiceImpl<ComplaintMapper, Complaint> implements ComplaintService {
    @Autowired
    private ComplaintService complaintService;

    @Override
    public JsonVO<ComplaintCountVO> getComplaintCount() {

        //拿到投诉的list集合
        List<Complaint> complaintList = complaintService.list();
        //对投诉的list进行过滤，统计投诉id的总数
        Set<String> complaintIds = complaintList.stream()
                .map(complaint -> complaint.getComplaintId())
                .collect(Collectors.toSet());
        int allComplaints = complaintIds.size();

        //对投诉的list进行过滤，统计正在处理的的总数
        LambdaQueryWrapper<Complaint> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Complaint::getStatusCd, 0); //0表示正在处理 1表示已经处理
        List<Complaint> incomplaints = list(lambdaQueryWrapper);
        int InProcessedCount = incomplaints.size();

        //得到已处理的数量
        int ProcessedCount=allComplaints-InProcessedCount;
        //封装ComplaintCountVO
        ComplaintCountVO complaintCountVO = new ComplaintCountVO();
        complaintCountVO.setAllComplaints(allComplaints);
        complaintCountVO.setInProcess(InProcessedCount);
        complaintCountVO.setProcessed(ProcessedCount);

        //返回ComplaintCountVO
        return JsonVO.success(complaintCountVO);

    }
}
