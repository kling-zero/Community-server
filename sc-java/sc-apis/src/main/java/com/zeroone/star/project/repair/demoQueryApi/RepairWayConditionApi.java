package com.zeroone.star.project.repair.demoQueryApi;

import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.repair.RepairWayVo;

/**
 * 报修设置-派单方式api
 */
public interface RepairWayConditionApi {

    JsonVO<RepairWayVo> repairWayList();
}
