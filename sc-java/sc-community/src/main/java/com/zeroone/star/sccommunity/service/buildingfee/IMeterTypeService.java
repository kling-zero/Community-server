package com.zeroone.star.sccommunity.service.buildingfee;

import com.zeroone.star.project.query.community.transactions.buildingfee.MeterReadingQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.MeterTypesVO;
import com.zeroone.star.sccommunity.entity.buildingfee.MeterType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 今日运势大吉
 * @since 2022-10-21
 */
public interface IMeterTypeService extends IService<MeterType> {

    /**
     * 获取抄表类型
     * @param condition 查询条件
     * @return 抄表类型分页对象
     */
    PageVO<MeterTypesVO> queryAll(MeterReadingQuery condition);
}
