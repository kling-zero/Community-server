package com.zeroone.star.repair.service.revisit;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.PageQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.repair.haddone.RepairStateVO;
import com.zeroone.star.project.vo.repair.haddone.RepairTypeVO;
import com.zeroone.star.project.vo.repair.haddone.RepairVO;
import com.zeroone.star.project.vo.repair.revisit.RepairRevisitStateVO;
import com.zeroone.star.project.vo.repair.revisit.RepairRevisitVO;


import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author awei
 * @since 2022-10-08
 */
public interface IRepairService extends IService<RepairRevisitVO> {
    /**
     * 分页条件查询所有数据，默认是待回访的
     * @return 查询结果
     */
    PageVO<RepairRevisitVO> listAll();

    /**
     * 查询所有报修的状态类型
     * @return
     */
    List<RepairStateVO> listAllRepairState();

    /**
     * 查询所有回访的状态
     * @return
     */
    List<RepairRevisitStateVO> listAllRevisitState();
}
