package com.zeroone.star.sccommunity.service.complaintmanagement;

import com.zeroone.star.project.query.community.transactions.complaintmanagement.ComplaintManageQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.complaintmanagement.ComplaintManageVO;
import com.zeroone.star.sccommunity.entity.complaintmanagement.BusinessComplaint;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Gerins
 * @since 2022-10-15
 */
public interface IBusinessComplaintService extends IService<BusinessComplaint> {
    PageVO<ComplaintManageVO> listByCondition(ComplaintManageQuery condition);
}
