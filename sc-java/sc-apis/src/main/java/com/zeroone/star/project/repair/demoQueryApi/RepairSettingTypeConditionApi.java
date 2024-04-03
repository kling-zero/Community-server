package com.zeroone.star.project.repair.demoQueryApi;

import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.repair.RepairSettingTypeVO;

/**
 * 工单池-报修设置类型api
 */
public interface RepairSettingTypeConditionApi {
    JsonVO<RepairSettingTypeVO> repairSettingTypeList();
}
