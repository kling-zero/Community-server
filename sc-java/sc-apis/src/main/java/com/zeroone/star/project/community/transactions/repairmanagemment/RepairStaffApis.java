package com.zeroone.star.project.community.transactions.repairmanagemment;

import com.zeroone.star.project.query.community.transactions.repairmanagement.RepairStaffQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.repairmanagement.RepairStaffVO;

/**
 * @Description 报修单详情API接口
 * @Author Gerins
 */
public interface RepairStaffApis {

    /**
     * 分页查询工单详情
     * @param condition 查询条件
     * @return 查询结果
     */
    JsonVO<PageVO<RepairStaffVO>> queryAll(RepairStaffQuery condition);

}
