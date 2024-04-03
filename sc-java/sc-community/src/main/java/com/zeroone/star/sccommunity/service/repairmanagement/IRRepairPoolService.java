package com.zeroone.star.sccommunity.service.repairmanagement;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.query.community.transactions.repairmanagement.OwnerRepairManageQuery;
import com.zeroone.star.project.query.community.transactions.repairmanagement.RepairStaffQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.repairmanagement.OwnerRepairManageVO;
import com.zeroone.star.project.vo.community.transactions.repairmanagement.RepairStaffVO;
import com.zeroone.star.sccommunity.entity.repairmanagement.RRepairPool;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Gerins
 * @since 2022-10-15
 */
public interface IRRepairPoolService extends IService<RRepairPool> {

    PageVO<OwnerRepairManageVO> listByCondition(OwnerRepairManageQuery condition);

}
