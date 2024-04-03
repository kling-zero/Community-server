package com.zeroone.star.project.community.propertyrightregistration;

import com.zeroone.star.project.dto.community.propertyrightregistration.*;
import com.zeroone.star.project.dto.community.roomRenovation.DeleteBasicDTO;
import com.zeroone.star.project.query.community.propertyrightregistration.PRRDetailQuery;
import com.zeroone.star.project.query.community.propertyrightregistration.PRRQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.propertyrightregistration.CheckVO;
import com.zeroone.star.project.vo.community.propertyrightregistration.PRRDetailVO;
import com.zeroone.star.project.vo.community.propertyrightregistration.PRRVO;

/**
 * 产权登记接口
 */
public interface PRRApis {
    /**
     * 分页查询产权信息
     * @param condition
     * @return
     */
    JsonVO<PageVO<PRRVO>> queryProperty(PRRQuery condition);

    /**
     * 查询产权详细信息
     * @param condition
     * @return
     */
    JsonVO<PageVO<PRRDetailVO>> queryPropertyDetail(PRRDetailQuery condition);

    /**
     * 添加房屋产权
     * @param condition
     * @return
     */
    JsonVO<String> saveProperty(SavePRRDTO condition);

    /**
     * 删除房屋产权
     * @param condition
     * @return
     */
    JsonVO<String> deleteProperty(DeletePPRDTO condition);

    /**
     * 修改产权信息
     * @param condition
     * @return
     */
    JsonVO<String> updateProperty(UpdatePPRlDTO condition);

    /**
     * 修改产权详细信息
     * @param condition
     * @return
     */
    JsonVO<String> updatePropertyDetail(UpdatePPRDetailDTO condition);

    JsonVO<CheckVO> checkProperty(CheckDTO condition);

}
