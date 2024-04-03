package com.zeroone.star.repair.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.dto.repair.ForceFinishDTO;
import com.zeroone.star.project.query.repair.demoquery.ForceFinishQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.repair.ForceFinishVO;
import com.zeroone.star.repair.entity.RepairPool;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author OvO
 * @since 2022-10-18
 */
public interface IRepairForceFinishService extends IService<RepairPool> {
    /**
     * 查询所有
     * @param query
     * @return 查询结果
     */
    PageVO<ForceFinishVO>  listAll(ForceFinishQuery query);

    /**
     * 强制回单方法
     * @param finishDTO 前端对象
     * @return
     */
    ForceFinishVO forceFinish(ForceFinishDTO finishDTO);

    /**
     * 获得工单详细内容
     * @param finishDTO 前端对象
     * @return
     */
    ForceFinishVO getDetail(ForceFinishDTO finishDTO);

    /**
     * 通过工单id获取对象
     * @param id
     * @return
     */
    ForceFinishVO getById(int id);
}
