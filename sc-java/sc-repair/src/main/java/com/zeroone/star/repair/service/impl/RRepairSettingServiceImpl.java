package com.zeroone.star.repair.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.repair.repairsetting.RepairSettingDTO;
import com.zeroone.star.project.query.repair.repairsetting.RepairSettingQuery;
import com.zeroone.star.project.utils.po.ToObjUtils;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.repair.repairsetting.RepairSettingVO;
import com.zeroone.star.repair.entity.RRepairSetting;
import com.zeroone.star.repair.service.RRepairSettingService;
import com.zeroone.star.repair.mapper.RRepairSettingMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author iceberg-work
 * @description 针对表【r_repair_setting】的数据库操作Service实现
 * @createDate 2022-10-18 17:11:55
 */
@Service
public class RRepairSettingServiceImpl extends ServiceImpl<RRepairSettingMapper, RRepairSetting>
        implements RRepairSettingService{

    @Resource
    RRepairSettingMapper mapper;

    /**
     * 查询多条报修设置
     *
     * @param query
     * @return
     */
    @Override
    public JsonVO<PageVO<RepairSettingVO>> listRepairSetting(RepairSettingQuery query) {
        // 当前页码
        long current = query.getPageIndex();
        // 每页显示条数
        long size = query.getPageSize();
        // 构建分页对象
        Page<RRepairSetting> page = new Page<>(current,size);
        // 创建查询条件构建器
        QueryWrapper<RRepairSetting> wrapper = new QueryWrapper<>();
        // 设置条件
        if (query.getRepairTypeName() != null || query.getRepairWay() != null || query.getRepairType() != null) {
            wrapper.lambda().eq(query.getRepairTypeName() != null, RRepairSetting::getRepairTypeName, query.getRepairTypeName())
                    .eq(query.getRepairWay() != null, RRepairSetting::getRepairWay, query.getRepairWay())
                    .eq(query.getRepairType() != null, RRepairSetting::getRepairType, query.getRepairType());
        }
        wrapper.lambda().eq(RRepairSetting::getCommunityId, query.getCommunityId());
        // 查询并封装
        Page<RRepairSetting> pageResult = mapper.selectPage(page, wrapper);
        // 再度封装并返回
        PageVO<RepairSettingVO> vo = PageVO.create(pageResult, RepairSettingVO.class);
        return JsonVO.success(vo);
    }

    /**
     * 修改单条报修设置
     *
     * @param dto
     * @return
     * @throws Exception
     */
    @Override
    public JsonVO<RepairSettingVO> updateRepairSetting(RepairSettingDTO dto) throws Exception {
        // 将dto转换成entity
        RRepairSetting entity = new RRepairSetting();
        ToObjUtils.toEntity(RepairSettingDTO.class, dto, RRepairSetting.class, entity);
        // 创建查询条件构建器
        UpdateWrapper<RRepairSetting> wrapper = new UpdateWrapper<>();
        // 设置条件
        wrapper.lambda().eq(RRepairSetting::getCommunityId, dto.getCommunityId())
                .eq(RRepairSetting::getSettingId, dto.getSettingId());
        /*
         执行更新操作并根据数据库返回结果决定返回值，
         如果成功，返回填充了DTO中的数据的VO，
         如果失败，返回空白VO
         */
        RepairSettingVO vo = new RepairSettingVO();
        if (mapper.update(entity, wrapper) == 1) {
            ToObjUtils.toVO(RepairSettingDTO.class, dto, RepairSettingVO.class, vo);
        }
        return JsonVO.success(vo);
    }

    /**
     * 新增单条报修设置
     *
     * @param dto
     * @return
     * @throws Exception
     */
    @Override
    public JsonVO<RepairSettingVO> addRepairSetting(RepairSettingDTO dto) throws Exception {
        // 将dto转换成entity
        RRepairSetting entity = new RRepairSetting();
        ToObjUtils.toEntity(RepairSettingDTO.class, dto, RRepairSetting.class, entity);
        /*
         执行新增操作并根据数据库返回结果决定返回值，
         如果成功，返回填充了DTO中的数据的VO，
         如果失败，返回空白VO
         */
        RepairSettingVO vo = new RepairSettingVO();
        if (mapper.insert(entity) == 1) {
            ToObjUtils.toVO(RepairSettingDTO.class, dto, RepairSettingVO.class, vo);
        }
        return JsonVO.success(vo);
    }

    /**
     * 删除单条报修设置
     *
     * @param dto
     * @return
     * @throws Exception
     */
    @Override
    public JsonVO<RepairSettingVO> deleteRepairSetting(RepairSettingDTO dto) throws Exception {
        // 将dto转换成entity
        RRepairSetting entity = new RRepairSetting();
        ToObjUtils.toEntity(RepairSettingDTO.class, dto, RRepairSetting.class, entity);
        // 创建查询条件构建器
        QueryWrapper<RRepairSetting> wrapper = new QueryWrapper<>();
        // 设置条件
        wrapper.lambda().eq(RRepairSetting::getCommunityId, dto.getCommunityId())
                .eq(RRepairSetting::getSettingId, dto.getSettingId());
        /*
         执行删除操作并根据数据库返回结果决定返回值，
         如果成功更新，返回填充了DTO中的数据的VO，
         如果失败，返回空白VO
         */
        RepairSettingVO vo = new RepairSettingVO();
        if (mapper.delete(wrapper) == 1) {
            ToObjUtils.toVO(RepairSettingDTO.class, dto, RepairSettingVO.class, vo);
        }
        return JsonVO.success(vo);
    }
}




