package com.zeroone.star.project.reportmanagement;

import com.zeroone.star.project.query.reportmanagement.FeeDetailQuery;
import com.zeroone.star.project.query.reportmanagement.FloorFeeQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.reportmanagement.FeeDetailVO;
import com.zeroone.star.project.vo.reportmanagement.FloorFeeVO;

import java.util.List;

/**
 * @InterfaceName: FloorFeeApi
 * @Author: Freasy
 * @Description: 楼栋费用表页面对应的接口
 * @Date: 2022/10/24 21:06
 * @Version: 1.0
 */

public interface FloorFeeApi {
    /**
     * 条件查询楼栋费用表，分页查询
     * @param condition 条件
     * @return 查询到的集合
     */
    List<JsonVO<PageVO<FloorFeeVO>>> queryByCondition(FloorFeeQuery condition);

    /**
     * 分页查询楼栋的费用详情
     * @param condition 查询条件
     * @return 查询到的集合
     */
    List<JsonVO<PageVO<FeeDetailVO>>> showDetail(FeeDetailQuery condition);
}
