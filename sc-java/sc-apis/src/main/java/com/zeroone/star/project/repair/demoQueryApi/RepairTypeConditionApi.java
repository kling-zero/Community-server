package com.zeroone.star.project.repair.demoQueryApi;

import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.repair.RepairTypeVO;

/**
 * 工单池、报修回访、强制回单、报修已办、报修待办、电话报修-报修类型api
 */
public interface RepairTypeConditionApi {
    JsonVO<RepairTypeVO> repairTypeList();
}
