package com.zeroone.star.project.repair;

import com.zeroone.star.project.dto.repair.repairsetting.RepairSettingDTO;
import com.zeroone.star.project.query.repair.repairsetting.RepairSettingQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.repair.repairsetting.RepairSettingVO;
import io.swagger.annotations.ApiOperation;

/**
 * @author iceberg-work
 */
public interface RepairSettingApis {

    /**
     * 查询多条报修设置
     *
     * @param query
     * @return
     */
    public JsonVO<PageVO<RepairSettingVO>> listRepairSetting(RepairSettingQuery query);

    /**
     * 修改单条报修设置
     *
     * @param dto
     * @return
     * @throws Exception
     */
    public JsonVO<RepairSettingVO> updateRepairSetting(RepairSettingDTO dto) throws Exception;

    /**
     * 新增单条报修设置
     *
     * @param dto
     * @return
     * @throws Exception
     */
    public JsonVO<RepairSettingVO> addRepairSetting(RepairSettingDTO dto) throws Exception;

    /**
     * 删除单条报修设置
     *
     * @param dto
     * @return
     * @throws Exception
     */
    public JsonVO<RepairSettingVO> deleteRepairSetting(RepairSettingDTO dto) throws Exception;
}
