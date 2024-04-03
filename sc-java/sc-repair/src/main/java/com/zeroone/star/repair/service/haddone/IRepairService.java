package com.zeroone.star.repair.service.haddone;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.PageQuery;
import com.zeroone.star.project.query.repair.handone.RepairQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.repair.haddone.RepairDetailVO;
import com.zeroone.star.project.vo.repair.haddone.RepairStateVO;
import com.zeroone.star.project.vo.repair.haddone.RepairVO;
import com.zeroone.star.repair.entity.haddone.Repair;
import com.zeroone.star.repair.entity.haddone.RepairType;


import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author awei
 * @since 2022-10-08
 */
public interface IRepairService extends IService<Repair> {
    /**
     * 分页条件查询所有数据
     * @param query 分页数据
     * @return 查询结果
     */
    PageVO<RepairVO> listAll(PageQuery query);

    /**
     * 根据条件分页查询
     * @param query 过滤条件
     * @return
     */
    PageVO<RepairVO> listAllConditions(RepairQuery query);

    /**
     * 查询所有报修的状态类型
     * @return
     */
    List<String> listAllRepairState();

    /**
     * 查询所有报修的类型
     * @return
     */
    List<String> listAllRepairType();

    /**
     * 报修已办工单详情
     * @return
     */
    RepairDetailVO getById(String id);
}
