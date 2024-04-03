package com.zeroone.star.sccommunity.service.buildingfee;

import com.zeroone.star.project.query.community.transactions.buildingfee.MRQDataQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.MRQDataVO;
import com.zeroone.star.sccommunity.entity.buildingfee.MeterWater;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 今日运势大吉
 * @since 2022-10-21
 */
public interface IMeterWaterService extends IService<MeterWater> {

    /**
     * 查询上期度数
     * @param condition 查询条件
     * @return 上期度数和上期检查时间的vo
     */
    PageVO<MRQDataVO> getLastInfo(MRQDataQuery condition);
}
