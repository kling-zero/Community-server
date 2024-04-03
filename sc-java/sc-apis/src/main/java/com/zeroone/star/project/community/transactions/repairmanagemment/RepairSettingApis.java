package com.zeroone.star.project.community.transactions.repairmanagemment;

import com.zeroone.star.project.query.community.transactions.repairmanagement.RepairSettingQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.repairmanagement.RepairSettingVO;

/**
 * @Description 报修单模块API接口
 * @Author Gerins
 */
public interface RepairSettingApis {

    /**
     * 分页查询报修设置信息
     * @param condition 查询条件
     * @return 查询结果
     */
    JsonVO<PageVO<RepairSettingVO>> queryAllRepairSetting(RepairSettingQuery condition);
}
