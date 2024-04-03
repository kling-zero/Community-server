package com.zeroone.star.project.repair.demoQueryApi;

import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.repair.RepairStateVO;

/**
 * 电话报修、工单池、报修待办、报修已办、报修回访-报修状态api
 */
public interface RepairStateConditionApi {
    JsonVO<RepairStateVO> repairStateList();
}
