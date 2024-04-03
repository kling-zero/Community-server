package com.zeroone.star.project.community.transactions.buildingfee;

import com.zeroone.star.project.dto.community.transactions.buildingfee.*;
import com.zeroone.star.project.query.community.transactions.buildingfee.BuildingFeesQuery;
import com.zeroone.star.project.query.community.transactions.buildingfee.FeeConfigsQuery;
import com.zeroone.star.project.query.community.transactions.buildingfee.MeterReadingQuery;
import com.zeroone.star.project.query.community.transactions.buildingfee.MRQDataQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.*;

import java.util.List;

/**
 * 房屋费用接口
 */
public interface BuildingFeeApis {
    /**
     * 查询所有
     * @param condition 查询条件
     * @return 查询结果
     */
    JsonVO<PageVO<BuildingFeesVO>> queryAll(BuildingFeesQuery condition);

    /**
     * 根据费用类型查询收费项目
     * @param condition 查询条件
     * @return 查询结果
     */
    JsonVO<List<FeeConfigsVO>> queryConfigId(FeeConfigsQuery condition);

    /**
     * 临时收费
     * @param dto 请求数据
     * @return 返回结果
     */
    JsonVO<String> addTempFee(TempFeeDTO dto);

    /**
     * 代收费用
     * @param dto 请求数据
     * @return 返回结果
     */
    JsonVO<String> modifyCollectionFee(CollectionFeesDTO dto);

    /**
     * 根据抄表类型查询数据对象
     * @param condition 查询条件
     * @return 查询结果
     */
    JsonVO<PageVO<MRQDataVO>> queryObj(MRQDataQuery condition);

    /**
     * 查询抄表类型
     * @param condition 查询条件
     * @return 查询结果
     */
    JsonVO<List<MeterTypesVO>> queryMeterReading(MeterReadingQuery condition);

    /**
     * 水电抄表
     * @param dto 请求数据
     * @return 返回结果
     */
    JsonVO<String> addWEMeterReading(WEMeterReadingDTO dto);

    /**
     * 创建费用
     * @param dto 请求数据
     * @return 返回结果
     */
    JsonVO<String> addFee(FeeDTO dto);


    /**
     * 取消费用（通过id删除）
     * @param dto 请求数据
     * @return 返回结果
     */
    JsonVO<String> removeFeeById(FeeIdDTO dto);

    /**
     * 手工结束
     * @param dto 请求数据
     * @return 返回结果
     */
    JsonVO<String> finishFeeById(FeeIdDTO dto);

    /**
     * 费用变更
     * @param dto 请求数据
     * @return 返回结果
     */
    JsonVO<String> modifyFee(UpdateFeeDTO dto);
}
