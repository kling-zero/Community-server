package com.zeroone.star.project.community.transactions.repairmanagemment;

import com.zeroone.star.project.dto.community.transactions.repairmanagement.OwnerRepairManageDTO;
import com.zeroone.star.project.query.community.transactions.repairmanagement.OwnerRepairManageQuery;
import com.zeroone.star.project.query.community.transactions.repairmanagement.RepairSettingQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.repairmanagement.OwnerRepairManageVO;
import com.zeroone.star.project.vo.community.transactions.repairmanagement.RepairSettingVO;
import io.swagger.annotations.ApiOperation;


/**
 * @Description 报修单配置信息模块API接口
 * @Author Gerins
 */
public interface RepairManagementApis {

    /**
     * 分页查询报修单信息
     * @param condition 查询条件
     * @return 查询结果
     */
    JsonVO<PageVO<OwnerRepairManageVO>> queryAll(OwnerRepairManageQuery condition);

    /**
     * 新增一条电话报修记录
     * @param ownerRepairManageDTO 新增内容
     * @return
     */
    JsonVO<String> addOwnerRepair(OwnerRepairManageDTO ownerRepairManageDTO);


}
