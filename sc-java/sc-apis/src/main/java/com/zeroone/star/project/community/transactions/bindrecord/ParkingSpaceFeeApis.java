package com.zeroone.star.project.community.transactions.bindrecord;

import com.zeroone.star.project.query.sample.communitymanage.busaccept.bindrecord.ParkingSpaceFeeQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.bindrecord.ParkingSpaceFeeVO;

/**
 * @author Tomcat
 * @Date 2022/10/16 16:09
 */
public interface ParkingSpaceFeeApis {
    /**
     *分页查询停车费
     * @param spaceFeeQuery 停车费查询数据对象
     * @return 返回查询结果
     */
    JsonVO<PageVO<ParkingSpaceFeeVO>> queryByCar(ParkingSpaceFeeQuery spaceFeeQuery);
}
