package com.zeroone.star.sccommunity.service.repairmanagement;

import com.zeroone.star.project.query.community.transactions.repairmanagement.RepairSettingQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.repairmanagement.RepairSettingVO;
import com.zeroone.star.sccommunity.entity.repairmanagement.RRepairSetting;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Gerins
 * @since 2022-10-16
 */
public interface IRRepairSettingService extends IService<RRepairSetting> {

    PageVO<RepairSettingVO> listAllRepairSetting(RepairSettingQuery condition);
}
