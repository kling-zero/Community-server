package com.zeroone.star.project.repair;

import com.zeroone.star.project.dto.repair.TelephoneDTO;
import com.zeroone.star.project.dto.repair.TelephoneModifyDTO;
import com.zeroone.star.project.query.repair.TelephoneQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.project.vo.repair.TelephoneVO;

/**
 * @ClassName TelephoneApis
 * @Description 电话报修API接口定义
 * @Author Colin
 * @Date 2022/10/13 20:15
 * @Version 1.0
 **/
public interface TelephoneApis {
    /**
     * 分页查询电话报修记录
     * @param condition 查询条件
     * @return 查询结果
     */
    JsonVO<PageVO<TelephoneVO>> quaryAll(TelephoneQuery condition);

    /**
     * 新增电话报修记录
     * @param record
     * @return 新增结果
     */
    JsonVO<ResultStatus> save(TelephoneDTO record);

    /**
     * 修改电话报修记录
     * @param record
     * @return 修改结果
     */
    JsonVO<ResultStatus> update(TelephoneModifyDTO record);

    /**
     * 删除电话报修记录
     * @param repairID
     * @return 删除结果
     */
    JsonVO<ResultStatus> remove(int repairID);

}
