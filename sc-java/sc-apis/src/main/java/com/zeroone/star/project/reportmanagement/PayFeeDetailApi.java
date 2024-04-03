package com.zeroone.star.project.reportmanagement;

import com.zeroone.star.project.query.PageQuery;
import com.zeroone.star.project.query.reportmanagement.*;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.reportmanagement.*;

/**
 * @author: jiemo
 * @date: 2022/10/24 16:58
 * @description: 缴费明细表接口定义
 */
public interface PayFeeDetailApi {
    /**
     * 分页查询缴费明细
     * @param payFeeDetailQuery 查询条件
     * @return 查询结果
     */
    JsonVO<PageVO<PayFeeDetailVO>> queryPayFeeDetail(PayFeeDetailQuery payFeeDetailQuery);

    /**
     * 分页查询费用到期提醒
     * @param deadLineFeeQuery 查询条件
     * @return 查询结果
     */
    JsonVO<PageVO<DeanlineFeeVO>> queryDeadlineFee(DeadLineFeeQuery deadLineFeeQuery);

    /**
     * 分页查询预交费提醒
     * @param pageQuery 分页条件
     * @return 查询结果
     */
    JsonVO<PageVO<PrepaymentVO>> queryPrepayment(PageQuery pageQuery);

    /**
     * 分页根据小区id查询楼房
     * @param loadConditionQuery 小区id
     * @return 查询结果
     */
    JsonVO<PageVO<LoadFloorsVO>> queryFloorsByCommunityId(LoadConditionQuery loadConditionQuery);

    /**
     * 分页根据楼房号查询单元
     * @param loadConditionQuery 查询条件
     * @return 查询结果
     */
    JsonVO<PageVO<LoadUnitsVO>> queryUnitsByFloorId(LoadConditionQuery loadConditionQuery);

    /**
     * 分页根据费用类型查询费用项
     * @param loadConditionQuery 查询条件
     * @return 查询结果
     */
    JsonVO<PageVO<LoadPayFeeConfigVO>> queryPayFeeConfigByFeeTypeCd(LoadConditionQuery loadConditionQuery);

    /**
     * 查询字典
     * @param loadDictQuery 查询对象
     * @return 查询结果
     */
    JsonVO<LoadDictVO> queryDictByTableColumns(LoadDictQuery loadDictQuery);


}
