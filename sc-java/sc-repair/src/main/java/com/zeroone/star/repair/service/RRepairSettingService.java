package com.zeroone.star.repair.service;

import com.zeroone.star.project.dto.repair.repairsetting.RepairSettingDTO;
import com.zeroone.star.project.query.repair.repairsetting.RepairSettingQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.repair.repairsetting.RepairSettingVO;
import com.zeroone.star.repair.entity.RRepairSetting;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author iceberg-work
* @description 针对表【r_repair_setting】的数据库操作Service
* @createDate 2022-10-18 17:11:55
*/
public interface RRepairSettingService extends IService<RRepairSetting> {
    /**
     * 查询多条报修设置
     *
     * @param query
     * @return
     */
    JsonVO<PageVO<RepairSettingVO>> listRepairSetting(RepairSettingQuery query);

    /**
     * 修改单条报修设置
     *
     * @param dto
     * @return
     * @throws Exception
     */
    JsonVO<RepairSettingVO> updateRepairSetting(RepairSettingDTO dto) throws Exception;

    /**
     * 新增单条报修设置
     *
     * @param dto
     * @return
     * @throws Exception
     */
    JsonVO<RepairSettingVO> addRepairSetting(RepairSettingDTO dto) throws Exception;

    /**
     * 删除单条报修设置
     *
     * @param dto
     * @return
     * @throws Exception;
     */
    JsonVO<RepairSettingVO> deleteRepairSetting(RepairSettingDTO dto) throws Exception;
}
