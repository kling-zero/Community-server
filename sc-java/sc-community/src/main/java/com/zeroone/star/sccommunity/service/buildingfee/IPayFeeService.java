package com.zeroone.star.sccommunity.service.buildingfee;

import com.zeroone.star.project.dto.community.transactions.buildingfee.TempFeeDTO;
import com.zeroone.star.project.query.community.transactions.buildingfee.BuildingFeesQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.FeesVO;
import com.zeroone.star.sccommunity.entity.buildingfee.PayFee;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 今日运势大吉
 * @since 2022-10-21
 */
public interface IPayFeeService extends IService<PayFee> {
    /**
     * 分页查询房屋费用
     * @param condition
     * @return
     */
    PageVO<FeesVO> queryPayFee(BuildingFeesQuery condition);

    /**
     * 添加临时收费
     * @param dto
     * @return
     */
    void saveTempFee(TempFeeDTO dto);

}
