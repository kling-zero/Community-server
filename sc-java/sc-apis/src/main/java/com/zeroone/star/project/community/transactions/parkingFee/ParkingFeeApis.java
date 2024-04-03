package com.zeroone.star.project.community.transactions.parkingFee;

import com.zeroone.star.project.dto.community.transactions.parkingfee.DeleteParkingFeeDTO;
import com.zeroone.star.project.dto.community.transactions.parkingfee.UpdateParkingFeeDTO;
import com.zeroone.star.project.query.community.transactions.parkingfee.ParkingCarQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.parkingfee.ParkingCarVO;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/17
 */
public interface ParkingFeeApis {

    /**
     * 分页查询停车费用
     * @param parkingCarQuery
     * @return
     */
    JsonVO<PageVO<ParkingCarVO>> queryAllParking (ParkingCarQuery parkingCarQuery);
    /**
     * 取消费用和手工结束停车费用
     * @param data 传输数据对象
     * @return 删除结果
     */
    JsonVO deleteOne(DeleteParkingFeeDTO data);

    /**
     * 变更停车费用
     * @param data 传输数据对象
     * @return 更新结果
     */
    JsonVO updateOne(UpdateParkingFeeDTO data);

    /**
     * 创建停车费用
     * @param data
     * @return
     */
    JsonVO<String> saveOne(UpdateParkingFeeDTO data);


}
