package com.zeroone.star.schp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.homepage.ComplaintCountVO;
import com.zeroone.star.schp.entity.Complaint;

public interface ComplaintService extends IService<Complaint> {
    JsonVO<ComplaintCountVO> getComplaintCount();
}
